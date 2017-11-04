package org.learnjava.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A CountDownLatch is a synchronization aid that allows one or more threads to
 * wait until a set of operations being performed in other threads completes.
 * 
 * @author psajja
 *
 */
public class CountDownLatchExample {

	public static void main(String[] args) throws InterruptedException {
		int NO_OF_WORKERS = 5;
		List<Integer> result = Collections.synchronizedList(new ArrayList<>());
		CountDownLatch latch = new CountDownLatch(NO_OF_WORKERS);
		System.out.println("Spawning " + NO_OF_WORKERS + " worker threads.");
		for (int i = 0; i < NO_OF_WORKERS; i++) {
			int start = i * 10 + 1;
			int end = (i + 1) * 10;
			Thread worker = new Thread(new RandomNumberRunnable(latch, result, i * 10 + 1, (i + 1) * 10));
			worker.setName("Thread (" + start + "-" + end + ")");
			worker.start();
		}

		latch.await();
		System.out.println("Main Thread starts finishing the job");
		System.out.println("List: " + result);
		System.out.println(result.get(ThreadLocalRandom.current().nextInt(0, result.size())));
	}

	/**
	 * Each thread generates a random number from the range.
	 * 
	 * @author psajja
	 *
	 */
	static class RandomNumberRunnable implements Runnable {
		private CountDownLatch latch;
		private List<Integer> result;
		private int start;
		private int end;

		public RandomNumberRunnable(CountDownLatch latch, List<Integer> result, int start, int end) {
			this.latch = latch;
			this.result = result;
			this.start = start;
			this.end = end;
		}

		@Override
		public void run() {
			String threadName = Thread.currentThread().getName();
			result.add(ThreadLocalRandom.current().nextInt(start, end + 1));
			latch.countDown();

			System.out.println(threadName + " job is done.");
		}
	}
}
