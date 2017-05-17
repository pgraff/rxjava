package com.paypal.rxjava.examples.intro;

import rx.Observable;

public class SimplestPossibleObservable {

	public static void main(String[] args) {
		getSimpleObservable().subscribe(System.out::println);
	}

	@SuppressWarnings("deprecation")
	private static Observable<String> getSimpleObservable() {
		return Observable.create((sub) -> {
			sub.onNext("Hello, world!");
			sub.onCompleted();
		});
	}
}
