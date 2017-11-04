package org.learnjava.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This example demonstrates the use of locking in Java with Lock API. See
 * {@link SynchronizedCounterExample Synchronized Counter Example} which
 * demonstrates using synchronized keyword.
 * <p>
 * Differences between synchronization and Locks in Java.
 * <ul>
 * <li>With 'synchronized' a thread might end up waiting indefinitely for the
 * lock. Java Lock API provides more visibility and options for locking. We can
 * use try for the lock without blocking and set timeout while trying for the
 * lock and can acquire interruptible lock.</li>
 * <li>Code with 'synchronized' methods or blocks is much cleaner and easy to
 * maintain whereas with Locks we are forced to have try-finally block to make
 * sure to release the lock as the critical section may throw exceptions.</li>
 * <li>Synchronized blocks or methods can only cover a single method. Locks API
 * can be used to span the critical section code into multiple methods.</li>
 * <li>Synchronized keyword doesn’t provide any fairness whereas creating a Lock
 * with ReentrantLock object we can set fairness to true.</li>
 * </ul>
 * </p>
 * 
 * @author psajja
 *
 */
public class LockCounterExample {

	public static void main(String[] args) {
		System.out.println("Starting 5 Threads");

		ReentrantCounter counter = new ReentrantCounter();
		for (int i = 0; i < 5; i++)
			new Thread(new ReentrantCounterRunnable(counter, i + 1)).start();
	}

	/**
	 * Reentrant runnable.
	 * 
	 * @author psajja
	 *
	 */
	static class ReentrantCounterRunnable implements Runnable {
		private ReentrantCounter counter;
		private int id;

		public ReentrantCounterRunnable(ReentrantCounter counter, int id) {
			this.counter = counter;
			this.id = id;
		}

		@Override
		public void run() {
			System.out.println("Thread " + id + " got " + counter.next());
		}
	}

	/**
	 * Counter uses ReentrantLock.
	 * 
	 * @author psajja
	 *
	 */
	static class ReentrantCounter {
		private Lock lock;
		private int count;

		public ReentrantCounter() {
			this.lock = new ReentrantLock();
		}

		public int next() {
			lock.lock();
			try {
				return ++count;
			} finally {
				lock.unlock();
			}
		}
	}
}
