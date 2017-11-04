package org.learnjava.concurrent;

/**
 * Creating and starting a thread.
 * 
 * @author psajja
 *
 */
public class Threads {

	public static void main(String[] args) {
		Thread customThread = new CustomThread();
		customThread.setName("Custom Thread");
		customThread.start();
		
		Thread customRunnable = new Thread(new CustomRunable());
		customRunnable.setName("Custom Runable");
		customRunnable.start();
	}

	/**
	 * Extends Thread.
	 * 
	 * @author psajja
	 *
	 */
	static class CustomThread extends Thread {
		
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " is Running");
		}
	}
	
	/**
	 * Implements Runnable.
	 * 
	 * @author psajja
	 *
	 */
	static class CustomRunable implements Runnable {
		
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " is Running");
		}
	}
}
