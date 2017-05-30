# Simple Tests of Observable

## Create a simple test class

Copy and paste this simple class as a frame for the upcoming exercises.

Place the code in `src/main/test`.

```java
package com.paypal.rx.examples;

import org.junit.Before;
import org.junit.Test;
import rx.Observable;
import rx.observers.TestSubscriber;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateObservables {

  private TestSubscriber<Object> testSubscriber;

  @Before
  public void setup() {
      this.testSubscriber = new TestSubscriber<>();
  }

}

```

## Simple Stream test

Let's create a simple test method that setups a stream and subscribes with the test subscriber from setup.

```java
@Test
public void testAnObservableStreamOfEventsEmitsEachItemInOrder() {
    Observable<String> stream = Observable.just("Foo", "Bar");
    stream.subscribe(this.testSubscriber);
    List<Object> data = testSubscriber.getOnNextEvents();
}
```

## Test the stream

using the `assertThat` (statically imported), test the following:

* That the observable pushed exactly two strings
* That the observable pushed "Foo" and "Bar" only once

### Possible solution

Here is a possible solution for the above exercise step if you're lost...

```java
assertThat(data).hasSize(2);
assertThat(data).containsOnlyOnce("Foo");
assertThat(data).containsOnlyOnce("Bar");
```

## Let's try another one...

Let's create a similar stream and see if you can test it properly with the assertThat (this time, we'll give you no solutions).

```java
@Test
public void testJustCreatesAnObservableEmittingItsArguments() {

    String stoogeOne = "Larry";
    String stoogeTwo = "Moe";
    String stoogeThree = "Curly";
    Integer stoogeAge = 38;

    Observable<Object> stoogeDataObservable = Observable.just(stoogeOne, stoogeTwo, stoogeThree, stoogeAge);
}
```

Here are some suggested steps:

1. Subscribe to the stream using a test subscriber
2. Use the test subscriber to obtain a list of all that the stream has emitted
3. Use assert to check the list
