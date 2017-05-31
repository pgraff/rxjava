# Exception Handling

## Discussion

In this exercise we'll explore exception handling.


## Starting point

Here is a good starting point for this exercise.

package com.paypal.rx.examples;

```java
import org.junit.Before;
import org.junit.Test;

import rx.Observable;
import rx.observers.TestSubscriber;

public class Exceptions {

    private TestSubscriber<Object> testSubscriber;

    @Before
    public void setup() {
        this.testSubscriber = new TestSubscriber<>();
    }

}
```

## Simple example of error

Below is a simple test function that processes a sequence and causes that causes an error.

```java
@Test
public void testException() {
   Observable.just(1, 5, 6, 10, 0, 4)
    .map(i -> 100/i)
    .subscribe(this.testSubscriber);
   testSubscriber.assertNoErrors();
}
```

Run the test and see that the test fails.

Let's first change this test to be a passing test by changing our asserts to say we expect an error.

Sometimes we want to test that the pipeline do cause an error.
The one above throws an ArithmeticException.

Let's use the TestSubscriber to verify that the correct exception was thrown.

## Print out the error

Let's say we want to print out the exception when it occurs as part of our handling of the error.

Modify the below test to print out the stack trace in the processing pipeline.

```java
@Test
public void testException_addPrintStackTrace() {
   Observable.just(1, 5, 6, 10, 0, 4, 11, 45)
    .map(i -> 100/i)
    .subscribe(this.testSubscriber);
   testSubscriber.assertError(ArithmeticException.class);
}
```

## Handle the error by returning a good value and stop

The following example fails.

```java
@Test
public void testException_handleTheErrorWithReturn() {
   Observable.just(1, 5, 6, 10, 0, 4, 11, 45)
    .map(i -> 100/i)
    .subscribe(this.testSubscriber);
   testSubscriber.assertNoErrors();
}
```

Modify the test above so that when it encounters an error, it replaces the exception with the value 0 and terminates.

## Handle the error by switching to new stream

In this exercise we'll handle the error a little differently.
This time, we'll switch to a new stream when we encounter the error.

Whenever we encounter the exception, we'll tell the processing pipeline to continue to process a different stream.

The new stream will be a sequence from 1 to 100 (which you can create with the function `Observable.range`).

Here is the failing code...

```java
@Test
public void testException_handleTheErrorWithNewSequence() {
   Observable.just(1, 5, 6, 10, 0, 4, 11, 45)
    .map(i -> 100/i)
    .subscribe(this.testSubscriber);
   testSubscriber.assertNoErrors();
   assertThat(testSubscriber.getOnNextEvents()).containsSubsequence(88,89,90,91);
}
```

Make it not fail :)
