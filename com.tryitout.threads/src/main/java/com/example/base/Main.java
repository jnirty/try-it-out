package com.example.base;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

	private static Object semaphore = new Object();
	private static List<String> resources = new ArrayList<String>();

	public static void main(String[] args) {
		Main main = new Main();

		Thread t = new Thread(new MyTask(semaphore, resources));
		for (int i = 0; i < 10; i++) {
			main.doSth();
		}

		t.start();

		for (int i = 0; i < 100000; i++) {
		}

		for (int i = 0; i < 10; i++) {
			main.doSth();
		}

	}

	void doSth() {

		synchronized (semaphore) {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			resources.add(sdf.format(new Date()));
			semaphore.notifyAll();
			System.out.println("semaphore.notifyAll();");
		}

	}

}

class MyTask implements Runnable {
	private Object semaphore = null;
	private List<String> resources = null;

	public MyTask(Object semaphore, List<String> resources) {
		this.semaphore = semaphore;
		this.resources = resources;
	}

	public void run() {
		synchronized (semaphore) {
			while (true) {
				if (!resources.isEmpty()) {
					System.out.println(resources.remove(0));
				} else {
					try {
						System.out.println("waiting for resources...");
						semaphore.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}

	}
}