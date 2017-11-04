package org.learnjava.concurrent;

/**
 * This example demonstrates the use of synchronized keyword.
 * 
 * @author psajja
 *
 */
public class SynchronizedCounterExample {

	public static void main(String[] args) {
		System.out.println("Starting 5 Threads");
		
		SynchronizedCounter counter = new SynchronizedCounter();
		for (int i = 0; i < 5; i++)
			new Thread(new SynchronizedCounterRunnable(counter, i + 1)).start();
	}

	/**
	 * Synchronized counter thread.
	 * 
	 * @author psajja
	 *
	 */
	static class SynchronizedCounterRunnable implements Runnable {
		private SynchronizedCounter counter;
		private int id;

		public SynchronizedCounterRunnable(SynchronizedCounter counter, int id) {
			this.counter = counter;
			this.id = id;
		}

		@Override
		public void run() {
			System.out.println("Thread " + id + " got " + counter.next());
		}
	}

	/**
	 * Synchronized counter to increment and get the current value.
	 * 
	 * @author psajja
	 *
	 */
	static class SynchronizedCounter {
		private int count;

		public synchronized int next() {
			return ++count;
		}
	}
}
