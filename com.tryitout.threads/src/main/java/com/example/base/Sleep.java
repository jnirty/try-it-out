package com.example.base;

public class Sleep {
	public static void main(String[] args) {
		System.out.println(" -- main --");
		Thread t = new Thread(new SleepingThread(), "SleepingThread");
		t.start();
		// uncomment this code to see the effect of join method (effect guaranted):
//		try {
//			t.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// yield is much more like join, but it's behavior is not guaranted - in most cases will not work
		///Thread.yield();
		
		System.out.println(" -- end main --");
	}
}

class SleepingThread implements Runnable {

	public void run() {
		System.out.println("Sleeping thread " + Thread.currentThread().getName() + ", " + System.currentTimeMillis());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Wake up " + Thread.currentThread().getName() + ", " + System.currentTimeMillis());
	}

}
