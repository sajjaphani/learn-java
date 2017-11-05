package org.learnjava.concurrent.producerconsumer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Producer/Consumer problem using Semaphore. This example implements a custom
 * Queue which can hold more than one element.
 * 
 * @author psajja
 *
 */
public class ProducerConsumerSemaphoreExample2 {

	public static void main(String[] args) {
		Queue<String> queue = new Queue<>(5);

		new Thread(new Producer(queue)).start();
		new Thread(new Consumer(queue)).start();
	}

	/**
	 * A queue uses Semaphore.
	 * 
	 * @author psajja
	 *
	 * @param <E>
	 */
	static class Queue<E> {
		private List<E> elements;
		protected int size;

		private Semaphore mutex;
		// used when removing items
		private Semaphore emptySemaphore;
		// used when adding items
		private Semaphore fullSemaphore;

		public Queue(int size) {
			this.size = size;
			elements = new LinkedList<>();

			mutex = new Semaphore(1);
			emptySemaphore = new Semaphore(0);
			fullSemaphore = new Semaphore(size);
		}

		public void add(E elt) {
			try {
				fullSemaphore.acquire();
				mutex.acquire();
				elements.add(elt);
				mutex.release();
				emptySemaphore.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public E remove() {
			E element = null;
			try {
				emptySemaphore.acquire();
				mutex.acquire();
				element = elements.remove(0);
				mutex.release();
				fullSemaphore.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			return element;
		}
	}

	/**
	 * Producer thread.
	 * 
	 * @author psajja
	 *
	 */
	static class Producer implements Runnable {
		private Queue<String> queue;
		static int counter = 0;

		public Producer(Queue<String> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			// produce messages
			while (true) {
				String msg = "Item " + ++counter;
				try {
					Thread.sleep(100);
					queue.add(msg);
					System.out.println("Produced " + msg);
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
		private Queue<String> queue;

		public Consumer(Queue<String> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			try {
				while (true) {
					Thread.sleep(250);
					System.out.println("Consumed " + queue.remove());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}