# Concurrency and Latency

## Discussion

In this exercise we'll explore `observeOn`, `subscribeOn`, RxJava schedulers and the `RxNetty` client.

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

## Improving the country fetch by introducing parallelism

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

You can probably copy the serial implementation and modify it (the differences should not be all that extensive)/

Did it improve latency?