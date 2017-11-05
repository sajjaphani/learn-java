package org.learnjava.concurrent.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Producer/Consumer implementation without using a blocking queue. It relies on
 * wait/notify to implement.
 * 
 * @author psajja
 *
 */
public class ProducerConsumerSynchronizedExample {

	public static void main(String args[]) {
		int MAX_SIZE = 10;
		Queue<Integer> queue = new LinkedList<>();

		new Thread(new Producer(queue, MAX_SIZE)).start();
		new Thread(new Consumer(queue)).start();
	}

	/**
	 * Producer thread.
	 * 
	 * @author psajja
	 *
	 */
	static class Producer implements Runnable {
		private final Queue<Integer> queue;
		private final int maxSize;
		static int count;
		
		public Producer(Queue<Integer> queue, int maxSize) {
			this.queue = queue;
			this.maxSize = maxSize;
		}

		@Override
		public void run() {
			while (true) {
				synchronized (queue) {
					// wait when Queue is full
					while (queue.size() == maxSize) {
						try {
							System.out.println("Queue is full, waiting");
							queue.wait();
						} catch (InterruptedException ex) {
							ex.printStackTrace();
						}
					}

					System.out.println("Producing Item " + ++count);
					queue.add(count);
					queue.notifyAll();
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
		private final Queue<Integer> queue;

		public Consumer(Queue<Integer> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				synchronized (queue) {
					// wait when Queue is empty
					while (queue.isEmpty()) {
						try {
							System.out.println("Queue is empty, waiting");
							queue.wait();
						} catch (InterruptedException ex) {
							ex.printStackTrace();
						}
					}

					System.out.println("Consuming Item " + queue.poll());
					queue.notifyAll();
				}
			}
		}
	}
}