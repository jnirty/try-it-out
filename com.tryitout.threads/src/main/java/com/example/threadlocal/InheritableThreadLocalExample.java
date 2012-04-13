package com.example.threadlocal;

public class InheritableThreadLocalExample {
	final ThreadLocal<String> inheritable = new InheritableThreadLocal<String>();

	public static void main(String[] args) throws Exception {
		new InheritableThreadLocalExample().testIt();
	}

	public void testIt() throws Exception {
		inheritable.set("foo");

		Thread t = new Thread() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + " " + inheritable.get());
			}
		};

		t.start();
		t.join();

		System.out.println(Thread.currentThread().getName() + " " + inheritable.get());
	}
}
