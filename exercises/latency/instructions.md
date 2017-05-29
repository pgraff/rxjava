# Latency

## Discussions

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

## Step 1: Run the example

TODO: Create an example that runs actions sequentially but using RxJava.

## Step 2: Improve the example by introducing parallelism

TODO: Based on the example, have everyone try to parallelize a couple of things...
