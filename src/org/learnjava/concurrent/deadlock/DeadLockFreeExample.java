package org.learnjava.concurrent.deadlock;

/**
 * The {@link DeadLockExample example} demonstrates the occurrence of a dead lock when two threads are
 * trying to use two shared resources.
 * <p>
 * This example eliminates the deadlock by acquiring the locks in the same order
 * in both the threads.
 * </p>
 * 
 * @author psajja
 *
 */
public class DeadLockFreeExample {

	public static void main(String[] args) {
		final Object sharedResource1 = new Object();
		final Object sharedResource2 = new Object();

		new Thread(new Task1(sharedResource1, sharedResource2)).start();
		new Thread(new Task2(sharedResource1, sharedResource2)).start();
	}

	/**
	 * First task.
	 * 
	 * @author psajja
	 *
	 */
	static class Task1 implements Runnable {
		private Object sharedResource1;
		private Object sharedResource2;

		Task1(Object sharedResource1, Object sharedResource2) {
			this.sharedResource1 = sharedResource1;
			this.sharedResource2 = sharedResource2;
		}

		@Override
		public void run() {
			synchronized (sharedResource1) {
				System.out.println("Task 1 Acquired lock on Shared Resource 1");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Task 1 Tries to acquire lock on Shared Resource 2");
				synchronized (sharedResource2) {
					System.out.println("Task 1 Tries acquired locks and performing the task...");
				}
			}
		}
	}

	/**
	 * Second task.
	 * 
	 * @author psajja
	 *
	 */
	static class Task2 implements Runnable {
		private Object sharedResource1;
		private Object sharedResource2;

		Task2(Object sharedResource1, Object sharedResource2) {
			this.sharedResource1 = sharedResource1;
			this.sharedResource2 = sharedResource2;
		}

		@Override
		public void run() {
			synchronized (sharedResource1) {
				System.out.println("Task 2 Acquired lock on Shared Resource 1");
				System.out.println("Task 2 Tries to acquire lock on Shared Resource 2");
				synchronized (sharedResource2) {
					System.out.println("Task 2 Tries acquired locks and performing the task...");
				}
			}
		}
	}
}
