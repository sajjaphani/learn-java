package org.learnjava.concurrent;

import java.util.concurrent.Exchanger;

/**
 * An Exchanger is a synchronization point at which threads can pair and swap
 * elements within pairs. Each thread presents some object on entry to the
 * exchange method and receives its partner's object on return. An Exchanger may
 * be viewed as a bidirectional form of a SynchronousQueue.
 * 
 * @author psajja
 *
 */
public class ExchangerExample {

	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<>();

		new Thread(new ExchangerRunnable(exchanger, "Hello")).start();
		new Thread(new ExchangerRunnable(exchanger, "Bonjour")).start();
	}

	/**
	 * Exchanger thread.
	 * 
	 * @author psajja
	 *
	 */
	static class ExchangerRunnable implements Runnable {
		private Exchanger<String> exchanger = null;
		private String message = null;

		public ExchangerRunnable(Exchanger<String> exchanger, String message) {
			this.exchanger = exchanger;
			this.message = message;
		}

		public void run() {
			try {
				while (true) {
					String prevMessage = message;
					message = exchanger.exchange(message);
					System.out.println(
							Thread.currentThread().getName() + " exchanged " + prevMessage + " for " + message);
					Thread.sleep(500);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
