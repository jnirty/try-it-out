package com.example.threadlocal;

public class ThreadLocalExample extends Thread {

	@Override
	public void run() {
		// sample code to simulate transaction id
		Context context = new Context();
		context.setTransactionId(getName());

		// Be aware of thread pools in application servers. The ThreadLocale
		// must always be reset. Do the following on every system boundary (fe
		// WebService)
		try {
			// set the context object in thread local to access it somewhere
			// else
			MyThreadLocal.set(context);

			/* note that we are not explicitly passing the transaction id */
			new BusinessService().businessMethod();
		} finally {
			MyThreadLocal.unset();
		}
	}

	public static void main(String[] args) {
		Thread threadOne = new ThreadLocalExample();
		threadOne.start();
		Thread threadTwo = new ThreadLocalExample();
		threadTwo.start();
	}
}

class Context {
	private String transactionId = null;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

}

class BusinessService {
	/**
	 * though we are not explicitly passing the transaction id, the value can be
	 * accessed from the business method and printed on the console thank to
	 * ThreadLocal
	 */
	public void businessMethod() {
		// get the context from thread local
		Context context = MyThreadLocal.get();
		System.out.println(context.getTransactionId());
	}
}

/**
 * this class acts as a container to our thread local variables.
 */
class MyThreadLocal {
	private static final ThreadLocal<Context> userThreadLocal = new ThreadLocal<Context>();

	public static void set(Context user) {
		userThreadLocal.set(user);
	}

	public static void unset() {
		userThreadLocal.remove();
	}

	public static Context get() {
		return userThreadLocal.get();
	}
}