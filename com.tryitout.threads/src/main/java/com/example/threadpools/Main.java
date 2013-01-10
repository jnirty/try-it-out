package com.example.threadpools;

public class Main {
//ExecutorService executor = Executors.
}

class MyRunnable implements Runnable {
	private int countUntil = 0;

	MyRunnable(int countUntil) {
		this.countUntil = countUntil;
	}

	public void run() {
		int sum = 0;
		for (int i = 0; i < countUntil; i++) {
			sum += i;
		}
		System.out.println("sum = " + sum);

	}
}
