package org.learnjava.concurrent;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * A TransferQueue is a blocking queue in which producers may wait for consumers
 * to consume elements. A TransferQueue may be useful for example in message
 * passing applications in which producers sometimes await receipt of elements
 * by consumers, while at other times enqueue elements without waiting for
 * receipt. Non-blocking and time-out versions of tryTransfer are also
 * available. A TransferQueue may also be queried, via hasWaitingConsumer(),
 * whether there are any threads waiting for items, which is a converse analogy
 * to a peek operation.
 * 
 * @author psajja
 *
 */
public class TransferQueueExample {

	public static void main(String[] args) {
		final TransferQueue<String> queue = new LinkedTransferQueue<String>();

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
		protected TransferQueue<String> queue;
		static int count;

		public Producer(TransferQueue<String> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				try {
					// Assume the producer can produce 5 items rapidly, at the
					// end of 5th item it will wait for the consumer to consume
					for (int i = 0; i < 4; i++) {
						System.out.println("Putting Item " + ++count);
						queue.put("Item " + count);
					}
					System.out.println("Transferring ITem " + ++count);
					queue.transfer("Item " + count);
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
		protected TransferQueue<String> queue;

		public Consumer(TransferQueue<String> queue) {
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
