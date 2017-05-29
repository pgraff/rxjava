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

[comment]: <> (assertThat(data).hasSize(2);)
[comment]: <> (assertThat(data).containsOnlyOnce("Foo");)
[comment]: <> (assertThat(data).containsOnlyOnce("Bar");)
