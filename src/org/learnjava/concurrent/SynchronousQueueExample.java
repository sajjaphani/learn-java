package org.learnjava.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * A SynchronousQueue is a blocking queue in which each insert operation must
 * wait for a corresponding remove operation by another thread, and vice versa.
 * A synchronous queue does not have any internal capacity. They are well suited
 * for handoff designs, in which an object running in one thread must sync up
 * with an object running in another thread in order to hand it some
 * information, event, or task.
 * 
 * @author psajja
 *
 */
public class SynchronousQueueExample {

	public static void main(String[] args) {
		final BlockingQueue<String> queue = new SynchronousQueue<String>();

		// One producer and one consumer
		new Thread(new Producer(queue)).start();
		new Thread(new Consumer(queue)).start();
	}

	/**
	 * Producer thread.
	 * 
	 * @author psajja
	 *
	 */
	static class Producer implements Runnable {
		protected BlockingQueue<String> queue;
		static int count;

		public Producer(BlockingQueue<String> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				try {
					System.out.println("Putting Item " + ++count);
					queue.put("Item " + count);
					Thread.sleep(250);
				} catch (InterruptedException e) {
					e.printStackTrace();
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
	static class Consumer implements Runnable {
		protected BlockingQueue<String> queue;

		public Consumer(BlockingQueue<String> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				try {
					System.out.println("Taking " + queue.take());
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
