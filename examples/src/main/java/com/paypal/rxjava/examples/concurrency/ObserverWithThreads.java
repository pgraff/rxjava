package com.paypal.rxjava.examples.concurrency;

import com.paypal.rxjava.utils.Data;
import com.paypal.rxjava.utils.Utilities;

import rx.Observable;
import rx.schedulers.Schedulers;

public class ObserverWithThreads {

	public static void main(String[] args) throws InterruptedException {
		doesntWork();
		worksAndCompletesOnMainThread();
		worksAndCompletesOnArbitraryThread();
		worksAndCompletesOnSpecificThread();	
	}

	private static void doesntWork() throws InterruptedException {
		Observable
			.from(Data.DICKENS_TOTC)
			.observeOn(Schedulers.computation())
			.map(String::toUpperCase)
			.doOnNext(Utilities::printMessageAndThread)
			.subscribe();
		Thread.sleep(1000);
	}

	private static void worksAndCompletesOnMainThread()  {
		Observable
			.from(Data.DICKENS_TOTC)
			.flatMap( s -> 
				Observable
					.just(s)
					.subscribeOn(Schedulers.computation())
					.map(String::toUpperCase)
					.doOnNext(Utilities::printMessageAndThread))
			.toList()
			.toBlocking()
			.subscribe((s) -> Utilities.printMessageAndThread("Subscription complete for " + s));
	}

	private static void worksAndCompletesOnSpecificThread() throws InterruptedException  {
		Observable
			.from(Data.DICKENS_TOTC)
			.flatMap( s -> 
				Observable
					.just(s)
					.subscribeOn(Schedulers.computation())
					.map(String::toUpperCase)
					.doOnNext(Utilities::printMessageAndThread))
			.toList()
			.observeOn(Schedulers.io())
			.subscribe((s) -> Utilities.printMessageAndThread("Subscription complete for " + s));
		Thread.sleep(1000);
	}


	private static void worksAndCompletesOnArbitraryThread() throws InterruptedException  {
		Observable
			.from(Data.DICKENS_TOTC)
			.flatMap( s -> 
				Observable
					.just(s)
					.subscribeOn(Schedulers.computation())
					.map(String::toUpperCase)
					.doOnNext(Utilities::printMessageAndThread))
			.toList()
			.subscribe((s) -> Utilities.printMessageAndThread("Subscription complete for " + s));
		Thread.sleep(1000);
	}


}
