# Infinite Series

## Description

In this exercise we'll explore the creation of infinite series.

We'll create a series of Fibonacci numbers.

If you don't know what Fibonacci numbers are, Wikipedia has an excellent entry on the topic [here](https://en.wikipedia.org/wiki/Fibonacci_number).

The number series is created by adding the previous two numbers starting with (1,1) or in some more modern incarnations (0,1).

E.g.:

```
  1, 1, 2, 3, 5, 8, ...
```

## Step 1: Create the series

We want to create an observable sequence of these numbers.

That is, I should be able to do something like this:

```java
Observable<Integer> obs = getFibonacciSeries();

obs
  .take(10)
  .subscribe(System.out::println);
```

## Hints

* When creating an infinite series, it is important to stop pushing data when the Observer unsubscribes!

## Step 2: Which Thread?

In this case, it is hard to justify producing the numbers on a separate thread, but let's assume there is a use case for this (e.g., say we had an infinite stream subscribing to a twitter feed, we would not want to use the client thread for this).

Change your implementation so that the Observable produces the Fibonacci numbers on a thread of their own choosing.
