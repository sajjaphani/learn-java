package org.learnjava.concurrent;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Demonstrates usage of UncaughtExceptionHandler introduced in Java 5.
 * <p>
 * When a thread is about to terminate due to an uncaught exception the JVM will
 * query the thread for its UncaughtExceptionHandler using
 * Thread.getUncaughtExceptionHandler() and will invoke the handler's
 * uncaughtException method, passing the thread and the exception as arguments.
 * If a thread has not had its UncaughtExceptionHandler explicitly set, then its
 * ThreadGroup object acts as its UncaughtExceptionHandler. If the ThreadGroup
 * object has no special requirements for dealing with the exception, it can
 * forward the invocation to the default uncaught exception handler.
 * </p>
 * 
 * @author psajja
 *
 */
public class UncaughtExceptionHandlerTest {

	public static void main(String[] args) {

		// Default UncaughtExceptionHandler
		Thread.setDefaultUncaughtExceptionHandler(new CustomUncaughtExceptionHandler("Main Thread"));

		BlockingQueue<String> queue = new LinkedBlockingQueue<>();

		// Create producer and consumer threads
		Thread producerThread = new Thread(new Producer(queue));
		Thread consumerThread = new Thread(new Consumer(queue));

		// Start threads
		producerThread.start();
		consumerThread.start();

		// for a ThreadGroup, override ThreadGroup.uncaughtException
	}

	/**
	 * Producer thread.
	 * 
	 * @author psajja
	 *
	 */
	private static class Producer implements Runnable {
		private BlockingQueue<String> queue;

		public Producer(BlockingQueue<String> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				try {
					int random = ThreadLocalRandom.current().nextInt(0, 6);
					if (random == 5)
						queue.put("Hi");
					else
						queue.put(Integer.toString(random));
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	/**
	 * Consumer thread.
	 * 
	 * @author psajja
	 *
	 */
	private static class Consumer implements Runnable {
		private BlockingQueue<String> queue;

		public Consumer(BlockingQueue<String> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {

			// UncaughtExceptionHandler for Consumer thread
			// Thread.currentThread().setUncaughtExceptionHandler(new CustomUncaughtExceptionHandler("Consumer Thread"));

			while (true) {
				try {
					String number = queue.take();
					System.out.println("Consumes: " + Integer.parseInt(number));
					// Wait for some time once consumed
					Thread.sleep(500);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	/**
	 * Custom uncaught exception handler.
	 * 
	 * @author psajja
	 *
	 */
	private static class CustomUncaughtExceptionHandler implements UncaughtExceptionHandler {
		private final String name;

		public CustomUncaughtExceptionHandler(String name) {
			this.name = name;
		}

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println("Current Thread: " + name);
			e.printStackTrace();

			// Do useful stuff, may start a new thread here
		}
	}
}