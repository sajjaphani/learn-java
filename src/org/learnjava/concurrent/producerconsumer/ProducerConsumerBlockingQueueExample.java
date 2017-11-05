package org.learnjava.concurrent.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Producer/Consumer problem using BlockingQueue.
 * 
 * @author psajja
 *
 */
public class ProducerConsumerBlockingQueueExample {

	public static void main(String[] args) {
		BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		// starting producer thread
		new Thread(producer).start();
		// starting consumer thread
		new Thread(consumer).start();
		System.out.println("Producer and Consumer has been started");
	}
	
	static class Message {
		private final String message;

		public Message(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}
	}
	
	/**
	 * Producer thread.
	 * 
	 * @author psajja
	 *
	 */
	static class Producer implements Runnable {
		private BlockingQueue<Message> queue;
		static int counter = 0;

		public Producer(BlockingQueue<Message> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			// produce messages
			while (true) {
				Message msg = new Message("Item " + ++counter);
				try {
					Thread.sleep(100);
					queue.put(msg);
					System.out.println("Produced " + msg.getMessage());
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
		private BlockingQueue<Message> queue;

		public Consumer(BlockingQueue<Message> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			try {
				while (true) {
					Thread.sleep(250);
					System.out.println("Consumed " + queue.take().getMessage());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
