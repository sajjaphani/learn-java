package org.learnjava.concurrent;

import java.util.concurrent.Semaphore;

/**
 * A Semaphore is a thread synchronization aid that can be used either to send
 * signals between threads to avoid missed signals, or to guard a critical
 * section like we would with a lock.
 * <p>
 * Semaphores are used in guarding the resources. If available grants the access
 * to the resource otherwise asks the processes to wait.
 * <ul>
 * <li>When the resource count is arbitrary then this is called counting
 * semaphore.</li>
 * <li>If resource count is only one then it is called binary semaphore.</li>
 * </ul>
 * </p>
 * 
 * @author psajja
 *
 */
public class SemaphoreExample {

	public static void main(String[] args) {
		final int NO_OF_PROCESSES = 5;
		final int NO_OF_PERMITS = 2;

		Semaphore semaphore = new Semaphore(NO_OF_PERMITS, true);
		for (int i = 0; i < NO_OF_PROCESSES; i++)
			new Thread(new ProcessRunnable(semaphore)).start();
	}

	/**
	 * Uses semaphore to acquire the resource.
	 * 
	 * @author psajja
	 *
	 */
	static class ProcessRunnable implements Runnable {
		private Semaphore semaphore;

		public ProcessRunnable(Semaphore semaphore) {
			this.semaphore = semaphore;
		}

		private void execyteCriticalSectionCode() {
			System.out.println(Thread.currentThread().getName() + " Executing critical section code...");
		}

		@Override
		public void run() {
			try {
				semaphore.acquire();
				execyteCriticalSectionCode();
				semaphore.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Resource pool example from Javadoc.
	 * 
	 * @author psajja
	 *
	 */
	static class ResourcePool {
		protected Object[] resources = new Object[MAX_AVAILABLE];
		protected boolean[] used = new boolean[MAX_AVAILABLE];

		private static final int MAX_AVAILABLE = 100;
		private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

		public Object getItem() throws InterruptedException {
			available.acquire();
			return getNextAvailableItem();
		}

		public void putItem(Object resource) {
			if (markAsUnused(resource))
				available.release();
		}

		protected synchronized Object getNextAvailableItem() {
			for (int i = 0; i < MAX_AVAILABLE; ++i) {
				if (!used[i]) {
					used[i] = true;
					return resources[i];
				}
			}

			return null; // not reached
		}

		protected synchronized boolean markAsUnused(Object item) {
			for (int i = 0; i < MAX_AVAILABLE; ++i) {
				if (item == resources[i]) {
					if (used[i]) {
						used[i] = false;
						return true;
					} else
						return false;
				}
			}

			return false;
		}
	}
}
