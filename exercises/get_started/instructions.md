# Getting started

## Do you have everything?

We assume that you have the following tools installed on your machine:

* Maven
* Java 8
* Some IDE (IntelliJ, Eclipse, or if you are so inclined VI/Emacs)

## Open your IDE

We'll assume that you already know your IDE.
If you don't, pair up with someone to make your life easier :)

## Import the examples

In the slides we show some examples.
These examples have been compiled into a project that you can find under the root of this git repo called `examples`.

Import this project into your IDE if you want to play with them

## Create a project

We'll use Maven to create an empty project

```bash
  mvn archetype:generate -B  -DarchetypeGroupId=pl.org.miki -DarchetypeArtifactId=java8-quickstart-archetype -DarchetypeVersion=1.0.0  -DgroupId=com.paypal -DartifactId=rxworkshop -Dversion=1.0 -Dpaage=com.paypal.workshop

```

This should create a new directory called `rxworkshop` with an empty project.

Enter the project `cd rxworkshop` and run:

```bash
mvn package
```

## Import the project

Import the project into your IDE.

## Update the dependencies

Open the `pom.xml` file and add this to the dependencies:

```xml
<dependency>
  <groupId>io.reactivex</groupId>
  <artifactId>rxjava</artifactId>
  <version>1.3.0</version>
</dependency>
<dependency>
  <groupId>org.assertj</groupId>
  <artifactId>assertj-core</artifactId>
  <version>1.7.1</version>
  <scope>test</scope>
</dependency>
```

## End result

You should now have two projects imported into your workspace.

* `examples` contains the examples from the slides
* `rxworkshop` is an empty project where we can do some development
