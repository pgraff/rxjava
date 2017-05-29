package com.paypal.rxjava.examples.functions;

import com.paypal.rxjava.utils.Data;
import com.paypal.rxjava.utils.Utilities;

import rx.Observable;
import rx.schedulers.Schedulers;

/*
 * This is a contrived example, but it illustrates how the groupBy operator works.
 * In the example we take a stream of words and group them by their first letter.
 * Then we process the groups using flatMap and ensures that each group is processed
 * by the same thread.
 * The end result is that we're guaraneed that all words is processed on the same thread.
 */
public class GroupBy {

	public static void main(String[] args) {
		Observable
			// start with the sentences
			.from(Data.DICKENS_TOTC)
			// convert all to lower case
			.map(String::toLowerCase)
			// convert the sentences to words
			.flatMap( s -> Observable.from(s.split(" ")))
			// group by the first character of the word
			.groupBy(w -> w.charAt(0))
			// for each observable/stream
			.flatMap( grouped -> grouped
				// Make sure that each letter is processed by the same thread
				.observeOn(Schedulers.computation())
				// just print out the words...
				.doOnNext(Utilities::printObjAndTread)
			)
			.subscribe();
	}
}
