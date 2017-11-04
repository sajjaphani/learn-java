package org.learnjava.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A CyclicBarrier is a synchronizer that allows a set of threads to wait for
 * each other to reach a common execution point, also called a barrier. The
 * barrier is called cyclic because it can be re-used after the waiting threads
 * are released.
 * 
 * <p>
 * Generates a random number from 1 to 50 by spanning 5 threads. Just for
 * demonstrations purpose only. Once a thread finishes its task nothing can stop
 * from it to exit.
 * </p>
 * 
 * @author psajja
 *
 */
public class CyclicBarrierExample {

	public static void main(String[] args) {
		int NO_OF_WORKERS = 5;
		List<Integer> result = Collections.synchronizedList(new ArrayList<>());
		CyclicBarrier barrier = new CyclicBarrier(NO_OF_WORKERS, new RandomNumberAggregatorThread(result));
		System.out.println("Spawning " + NO_OF_WORKERS + " worker threads.");
		for (int i = 0; i < NO_OF_WORKERS; i++) {
			int start = i * 10 + 1;
			int end = (i + 1) * 10;
			Thread worker = new Thread(new RandomNumberRunnable(barrier, result, i * 10 + 1, (i + 1) * 10));
			worker.setName("Thread (" + start + "-" + end + ")");
			worker.start();
		}
	}

	/**
	 * Each thread generates a random number from the range.
	 * 
	 * @author psajja
	 *
	 */
	static class RandomNumberRunnable implements Runnable {
		private CyclicBarrier barrier;
		private List<Integer> result;
		private int start;
		private int end;

		public RandomNumberRunnable(CyclicBarrier barrier, List<Integer> result, int start, int end) {
			this.barrier = barrier;
			this.result = result;
			this.start = start;
			this.end = end;
		}

		@Override
		public void run() {
			String thisThreadName = Thread.currentThread().getName();
			result.add(ThreadLocalRandom.current().nextInt(start, end + 1));
			try {
				System.out.println(thisThreadName + " waiting for others to reach the barrier.");
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Aggregator prints the random number from the final list.
	 * 
	 * @author psajja
	 *
	 */
	static class RandomNumberAggregatorThread implements Runnable {
		private List<Integer> partialResult;

		public RandomNumberAggregatorThread(List<Integer> partialResult) {
			this.partialResult = partialResult;
		}

		@Override
		public void run() {
			System.out.println("Final Random number by the aggregator");
			System.out.println("List: " + partialResult);
			System.out.println(partialResult.get(ThreadLocalRandom.current().nextInt(0, partialResult.size())));
		}
	}
}
