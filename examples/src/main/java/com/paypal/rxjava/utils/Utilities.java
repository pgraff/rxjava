package com.paypal.rxjava.utils;

public class Utilities {
	final public static <T> T printThread(T obj) {
		System.out.println("Executing on thread named: " + Thread.currentThread().getName());
		return obj;
	}
	final public static <T> T printObjAndTread(T obj) {
		System.out.println("Received " + obj + " on thread named " + Thread.currentThread().getName());
		return obj;
	}
	final public static <T extends Throwable> void printExceptionAndTread(T e) {
		System.out.println("Exception " + e.getMessage() + " on thread named " + Thread.currentThread().getName());
	}
	final public static void printMessageAndThread(String msg) {
		System.out.println("Message: " + msg + " from thread named " + Thread.currentThread().getName());
	}
}
