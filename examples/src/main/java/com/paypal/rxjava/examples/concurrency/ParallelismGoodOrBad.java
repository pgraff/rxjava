package com.paypal.rxjava.examples.concurrency;

import com.paypal.rxjava.utils.Utilities;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class ParallelismGoodOrBad {

	public static void main(String[] args) {
		try {
			getSimpleObservable()
				.doOnNext(s -> Utilities.printMessageAndThread("doOnNext part 1 action"))
				.observeOn(Schedulers.computation())
				.doOnNext(s -> Utilities.printMessageAndThread("doOnNext part 2 action"))
				.subscribe(s -> Utilities.printMessageAndThread("Subscription action "));
			Thread.sleep(100);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	private static Observable<String> getSimpleObservable() {
		return Observable.create((Subscriber<? super String> sub) -> {
			Utilities.printMessageAndThread("Executing Observable");
			sub.onNext("Hello, world!");
			sub.onCompleted();
		}).subscribeOn(Schedulers.io());
	}
}
