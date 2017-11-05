package org.learnjava.concurrent.producerconsumer;

import java.util.concurrent.Semaphore;

/**
 * Producer/Consumer problem using Semaphore.
 * 
 * @author psajja
 *
 */
public class ProducerConsumerSemaphoreExample {

	public static void main(String[] args) {
		Queue<String> queue = new Queue<>();

		new Thread(new Producer(queue)).start();
		new Thread(new Consumer(queue)).start();
	}

	/**
	 * A single element queue uses Semaphore.
	 * 
	 * @author psajja
	 *
	 * @param <E>
	 */
	static class Queue<E> {
		private E elt;

		private Semaphore producerSem;
		private Semaphore consumerSem;

		public Queue() {
			producerSem = new Semaphore(1);
			consumerSem = new Semaphore(0);
		}

		public void add(E elt) {
			try {
				producerSem.acquire();
				this.elt = elt;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				consumerSem.release();
			}
		}

		public E remove() {
			E element = null;
			try {
				consumerSem.acquire();
				element = elt;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				producerSem.release();
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
					Thread.sleep(250);
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