package org.learnjava.concurrent.producerconsumer;

/**
 * Producer/Consumer example using volatile modifier.
 * 
 * @author psajja
 *
 */
public class ProducerConsumerVolatileExample {

	public static void main(String[] args) {
		Queue<String> queue = new Queue<>();
		new Thread(new Producer(queue)).start();
		new Thread(new Consumer(queue)).start();
	}

	/**
	 * Single element queue using volatile modifier.
	 * 
	 * @author psajja
	 *
	 * @param <E>
	 */
	static class Queue<E> {

		private E elt = null;
		private volatile boolean hasNewObject;

		public void add(E elt) {
			while (hasNewObject) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.elt = elt;
			hasNewObject = true;
		}

		public Object remove() {
			while (!hasNewObject) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			hasNewObject = false;
			
			return elt;
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
