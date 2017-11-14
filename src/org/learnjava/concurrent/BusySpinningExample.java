package org.learnjava.concurrent;

/**
 * Busy spinning/waiting is a technique where one thread waits for a result from
 * another thread and use an empty loop to wait for that result often
 * periodically calling 'Thread.sleep' within the loop while waiting for a
 * condition to be satisfied. We should avoid this technique as it wastes CPU
 * cycles, wastes a lot of system resources and cause noticeable performance
 * problems.
 * <p>
 * Communication between threads can be improved by using either of the
 * following solutions:
 * <ul>
 * <li>The 'java.util.concurrent' library</li>
 * <li>The 'Object.wait' and Object.notify/Object.notifyAll</li>
 * </ul>
 * </p>
 * 
 * @author psajja
 *
 */
public class BusySpinningExample {

	public static void main(String[] args) {
		Message message = new Message();
		new Thread(new Producer(message)).start();
		new Thread(new Consumer(message)).start();
	}

	static class Message {
		private String text = "";

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
	}

	/**
	 * Producer thread.
	 * 
	 * @author psajja
	 *
	 */
	static class Producer implements Runnable {
		private Message message;
		static int counter = 0;

		public Producer(Message message) {
			this.message = message;
		}

		@Override
		public void run() {
			String msg = "Hello Busy Spin!";
			message.setText("Hello Busy Spin!");
			System.out.println("Produced " + msg);
		}
	}

	/**
	 * Consumer thread.
	 * 
	 * @author psajja
	 *
	 */
	static class Consumer implements Runnable {
		private Message message;

		public Consumer(Message message) {
			this.message = message;
		}

		@Override
		public void run() {
			while (message.getText().isEmpty()) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Consumed " + message.getText());
		}
	}
}
