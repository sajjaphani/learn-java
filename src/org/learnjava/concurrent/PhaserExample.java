package org.learnjava.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 * Added in Java 7, A Phaser is a reusable synchronization barrier, similar in
 * functionality to CyclicBarrier and CountDownLatch but supporting more
 * flexible usage.
 * 
 * @author psajja
 *
 */
public class PhaserExample {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Phaser phaser = new Phaser();
		phaser.register(); // register self
		System.out.println("Current Phase: " + phaser.getPhase());

		executorService.submit(new PhaserRunnable(phaser, "Thread 1"));
		executorService.submit(new PhaserRunnable(phaser, "Thread 2"));
		executorService.submit(new PhaserRunnable(phaser, "Thread 3"));

		phaser.arriveAndAwaitAdvance();
		System.out.println();
		System.out.println("Current Phase: " + phaser.getPhase());

		executorService.submit(new PhaserRunnable(phaser, "Thread 4"));
		executorService.submit(new PhaserRunnable(phaser, "Thread 5"));
		phaser.arriveAndAwaitAdvance();

		System.out.println();
		System.out.println("Current Phase: " + phaser.getPhase());
		System.out.println("Current Registered Parties " + phaser.getRegisteredParties());
		phaser.arriveAndDeregister();
	}

	/**
	 * Phaser Runnable.
	 * 
	 * @author psajja
	 *
	 */
	static class PhaserRunnable implements Runnable {
		private String name;
		private Phaser phaser;

		PhaserRunnable(Phaser phaser, String name) {
			this.phaser = phaser;
			this.name = name;
			phaser.register();
		}

		@Override
		public void run() {
			System.out.println(name + " is now about to run and is in Phase " + phaser.getPhase());
			phaser.arriveAndAwaitAdvance();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				phaser.arriveAndDeregister();
			}
		}
	}
}
