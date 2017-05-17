package com.paypal.rxjava.examples.intro;

import com.paypal.rxjava.utils.Data;

import rx.Observable;

public class SimplePipeline {

	public static void main(String[] args) {
		Observable
		  .from(Data.DICKENS_TOTC)
		  .flatMap(word -> Observable.from(word.split(" ")))
		  .zipWith(
		    Observable.range(1, Integer.MAX_VALUE),
			 (string, count) -> String.format("%2d. %s", count, string))
		  .subscribe(System.out::println);

	}

}
