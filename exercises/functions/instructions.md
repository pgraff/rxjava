# Functions

## Discussion

In this exercise we'll play around with some of the most common functions in RxJava.

## Create another test class

Here is a simple code template for creating the tests where we play around with the functions:

```java
package com.paypal.rx.examples;

import rx.Observable;
import rx.functions.Func1;
import rx.observers.TestSubscriber;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Functions {

    private TestSubscriber<Object> testSubscriber;

    @Before
    public void setup() {
        this.testSubscriber = new TestSubscriber<>();
    }
}

```

## Copy the Data file from examples

Copy the class `com.paypal.rxjava.data.geo.Data` from the examples directory into the test project.

## Understand map

Create a test function as shown below:

```java
@Test
public void printAllCountryNamesUpcased() {
  //TODO: Use RxJava to extract the continent names from the data and upcase the names
//  testSubscriber.assertNoErrors();
//  testSubscriber.assertCompleted();
//  assertThat(testSubscriber.getOnNextEvents()).hasSize(6);
//  assertThat(testSubscriber.getOnNextEvents()).containsAll(Arrays.asList("ASIA", "EUROPE", "AUSTRALIA"));
}
```

Implement the test function starting with the list of continents obtainable from the `Data`. We want all the names upcased and printed using System.out.println.

## Understand flatmap

In the next exercise, we want to extract data from the same data set.

However, this time we want to print out all the country names sorted alphabetically.

Again, we've provided a template for the code. Comment out all the tests and see if you can define the pipeline.

```java
@Test
public void printAllCountryNamesSortecAlphabetically() {
//  testSubscriber.assertNoErrors();
//  testSubscriber.assertCompleted();
//  assertThat(testSubscriber.getOnNextEvents()).containsAll(Arrays.asList("Barbados", "Benin", "Colombia"));
//  assertThat(testSubscriber.getOnNextEvents()).containsSequence("Switzerland", "Syria", "Taiwan", "Tanzania");
//  assertThat(testSubscriber.getOnNextEvents()).hasSize(145);
}
```

## Another challenge

In this exercise, we'll extract all countries where the name is shorter than 6 characters and print out their country code.
The country codes should be alphabetically sorted in reverse order.

Here is a starting template with commented out assert statements.

```java
@Test
public void printCountryCodesOfCountriesWhichNameIsShorterThan6Characters() {
//  testSubscriber.assertNoErrors();
//  testSubscriber.assertCompleted();
//  assertThat(testSubscriber.getOnNextEvents()).containsAll(Arrays.asList("OMN", "TCD", "MLI"));
//  assertThat(testSubscriber.getOnNextEvents()).containsSequence("ITA", "IRQ", "IRN", "IND");
//  assertThat(testSubscriber.getOnNextEvents()).hasSize(30);
}
```

## Final challenge

In this final challenge we'll ask you to print out a set of data about each country by using a rest call.

There are some special designed http clients for RxJava (RxNetty), but for this exercise, we'll use a very simple class that can do http request.
The class is synchronous in the traditional way, but we can improve on it later.

What we want you to do is to read all the country codes of countries starting with the letter "A" and then go to a web based url to get a JSON object describing that country.

You can obtain the data by using the following URL:

  https://restcountries.eu/rest/v2/alpha/{COUNTRY_CODE}

Here is a simple class (copy and paste) that obtains a HTML response from a URL.

```java
package com.paypal.rx.utils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SimpleHtmlClient {
	public static String getHTML(String urlToRead) throws Exception {
		StringBuilder result = new StringBuilder();
		URL url = new URL(urlToRead);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		rd.close();
		return result.toString();
	}

}
```

To obtain the response to say the country code 'nor', you can make a request to:

  https://restcountries.eu/rest/v2/alpha/nor
