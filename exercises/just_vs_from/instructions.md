# Just vs. From

## Discussion

In this exercise we'll explore the difference between `just` and `from`.


## Starting code

```java
package com.paypal.rx.examples;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import rx.Observable;
import rx.observers.TestSubscriber;

public class JustVsFrom {

  @Test
  public void testFromCreatesAnObservableThatEmitsEachElementFromAnIterable() {
      List<String> sandwichIngredients = Arrays.asList("bread (one)", "bread (two)", "cheese", "mayo", "turkey", "lettuce", "pickles", "jalapenos", "Sriracha sauce");

      Observable<String> favoriteFoodsObservable = Observable.from(sandwichIngredients);
      TestSubscriber<Object> subscriber = new TestSubscriber<>();
      favoriteFoodsObservable.subscribe(subscriber);
;
      // TODO: Write two tests:
      // 1) check the number of events emitted
      // 2) Check that all the elements of the sandwichIngredients are accounted for

      subscriber = new TestSubscriber<>();
      Observable.just(sandwichIngredients).subscribe(subscriber);

      //TODO: Write two test
      // 1) check the number of events emitted
      // 2) Check that all the elements of the sandwichIngredients are accounted for
  }

}
```

Replace the todo's with the assert code.

Do you now see the difference between `just` and `from`?
