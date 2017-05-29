package com.paypal.rxjava.examples.exceptionhandling;

import com.paypal.rxjava.utils.Data;
import com.paypal.rxjava.utils.Utilities;

import rx.Observable;
import rx.schedulers.Schedulers;


public class ExceptionExamples {

	private static final int CHAR_POS = 5;


	public static void main(String[] args) {
		excpetionExample1();
		excpetionExample2();
		excpetionExample3();
	}
	
	public static final Observable<Integer> pipeline = 	Observable
			.from(Data.DICKENS_TOTC)
			.doOnError(Utilities::printExceptionAndTread)
			.doOnCompleted(() -> Utilities.printMessageAndThread("Observable completed "))
//			.filter(s -> s.length() > CHAR_POS)
			.map(s -> s.charAt(CHAR_POS))
//			.onErrorResumeNext(t -> Observable.just(' '))
			.count()
			.doOnNext(count -> Utilities.printMessageAndThread("End of pipeline with count " + count));


	private static void excpetionExample1() {
		try {
			System.out.println("Start of example 1");
			pipeline.subscribe();
			System.out.println("End of example 1");
		}
		catch (Throwable t) {
			System.out.println("Exception in example 1: " + t.getMessage());
		}
	}
	private static void excpetionExample2() {
		try {
			System.out.println("Start of example 2");
			pipeline
				.subscribeOn(Schedulers.computation())
				.subscribe();
			Thread.sleep(1000);
			System.out.println("End of example 2");
		} catch (Throwable t) {
			System.out.println("Exception in example 2: " + t.getMessage());
		}
			
	}
	private static void excpetionExample3() {
		try {
			System.out.println("Start of example 3");
			pipeline
				.onErrorResumeNext(t -> Observable.just(0))
				.subscribe();
			System.out.println("End of example 3");
		}
		catch (Throwable t) {
			System.out.println("Exception in example 3: " + t.getMessage());
		}
	}

}
