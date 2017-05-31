# Concurrency and Latency

## Discussion

One trivial optimization that we often run across at PayPal is improving the latency by introducing parallelism in a service downstream calls.

Temporal logic can be expressed in different ways, but let me introduce a simple textual syntax to make it possible to formalize some of our ideas.

I'll introduce the following operators:

* `A ; B`: Means that `A` has to be completed before `B` (or `B` can not happen before `A` is completed. There is a subtle difference between the two, but for this workshop, the difference is not essential)
* 'A || B': Means `A` and `B` can happen in parallelism

So for example, making tea could be expressed as:

```
(heatWater || openTeaBag);putTeaBagIntoWater;removeBag;drink
```

In plain English that would read something like this:

  First you heat the water and open the team package in any order or at the same time. Then you put the tea bag into the water. Next, you remove the teabag and then drink.

Sometime we also have to express some cardinality.
E.g., say we want to say you can put in any number of sugar cubes and milk in the tea, we may express that as:

```
(heatWater; ( openTeaBag ; putTeaBagIntoWater ) || addSugarCube* || addMilk? ) ; removeBag ; drink
```

Now I say, first heat the water, then in parallel, you can perform the following 3 task:

* Open tea bag and put the tea bag in water
* Add any number of sugar cubes
* Add milk (optional)

Next, remove the bag and finally drink the tea.

That is a long winded introduction to the exercise.
What we want to show in this exercise is that if we have a set of actions we have to perform, if we define a temporal logic statement, we often will improve the latency by executing the action that can be executed in parallel in parallel.

E.g., say I have 3 actions a1, a2, a3.

Let's also say that the time it takes to execute and action a can be expressed as T(a).

Now, the time it takes to perform the 3 actions sequentially would be:

```
    T = T(a1) + T(a2) + T(a3)
```

Whereas if we were able to execute the actions in parallel with now loss of T(a), the total time would be:

```
  T = Max(T(a1), T(a2), T(a3 ))
```

We'll look at a few of these scenarios and build some software that takes advantage of the (relatively) easy way that RxJava allows you to run functions in parallel.

In this exercise we'll explore `observeOn`, `subscribeOn`, RxJava schedulers and the `RxNetty` client to control latency and parallelism in RxJava.

## Starting point

```java
package com.paypal.rx.examples;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;

import com.paypal.rxjava.data.geo.Data;
import com.paypal.rxjava.data.geo.Data.Country;

import io.reactivex.netty.RxNetty;
import rx.Observable;
import rx.observers.TestSubscriber;

public class Concurrency {

	private TestSubscriber<Object> testSubscriber;

	@Before
	public void setup() {
		this.testSubscriber = new TestSubscriber<>();
	}

}

```

## Switching threads

Before we dive into the latency issues, let's make sure we understand how we can
swithc processing threads in the pipeline.

In this exercise we have a simple test case:

```java
@Test
public void differenceBetweenSubscribeOnAndObserveOn() {
    Observable
    .from(Data.continents)
    .doOnNext((continent) -> System.out.println("Observed on " + Thread.currentThread().getName() + " and received " + continent.getName()))
    .map(Continent::getName)
    .subscribe ((name) -> System.out.println("Subscribed on " + Thread.currentThread().getName() + " and received " + name));
}
```

We want to change the pipeline so that the `subscribe` function runs on a thread from the  `computation` thread pool and the `doOnNext` runs on a thread from the `io` pool.

Modify the pipeline to make it happen :)

Hints:
* `subscribeOn` will not work
* You may encounter that the application exits before you complete the run...
  You may perhaps be best off adding a simple sleep to prevent this from happening

## Improving the country fetch by introducing parallelism

Now that we know how to switch threads, let's see if we can take advantage of
our knowledge to improve the latency of our previous exercise where we fetched
country data from the web.

Here is a synchronous test that fetch country data...

```java
@Test
  public void serial() throws InterruptedException {
    Observable
  .from(Data.continents)
  .flatMap( c -> Observable.from(c.getCountries()))
  .map(Country::getCountryCode)
  .map((cc) -> {
    String retVal = null;
    try {
      retVal = SimpleHtmlClient.getHTML("http://restcountries.eu/rest/v2/alpha/" + cc);
    }
    catch (Throwable t) {
      retVal = "{\"countryCode\": \"" + cc + "\", \"status\": \"NOT FOUND\"}";
    }
    return retVal;
  })
    .subscribe(System.out::println);
  }
```

Copy this test into your code so that you can run it.

Create another test called parallel where you maximize the parallelism.

Ask yourself:

* Which scheduler should I use?
* What operators should I use?

You can probably copy the serial implementation and modify it to introduce parallelism.

Did it improve latency?
