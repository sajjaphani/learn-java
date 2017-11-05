package org.learnjava.concurrent.fizbuz;

/**
 * Implementation of FizBuz using multiple threads.
 * 
 * @author psajja
 *
 */
public class FizBuz {

	public static void main(String[] args) {
		int MAX = 100;
		new Thread(new FizzBuzzRunnable(true, true, MAX, "FizzBuzz")).start();
		new Thread(new FizzBuzzRunnable(true, false, MAX, "Fizz")).start();
		new Thread(new FizzBuzzRunnable(false, true, MAX, "Buzz")).start();
		new Thread(new NumberRunnable(false, false, MAX)).start();
	}

	static class FizzBuzzRunnable implements Runnable {
		private static Object lock = new Object();
		protected static int current = 1;
		private final int max;
		private boolean divBy3, divBy5;
		private String toPrint;

		public FizzBuzzRunnable(boolean divBy3, boolean divBy5, int max, String toPrint) {
			this.divBy3 = divBy3;
			this.divBy5 = divBy5;
			this.max = max;
			this.toPrint = toPrint;
		}

		public void print() {
			System.out.println(toPrint);
		}

		@Override
		public void run() {
			while (true) {
				synchronized (lock) {
					if (current > max)
						return;

					if ((current % 3 == 0) == divBy3 && (current % 5 == 0) == divBy5) {
						print();
						current++;
					}
				}
			}
		}
	}

	static class NumberRunnable extends FizzBuzzRunnable {
		public NumberRunnable(boolean divBy3, boolean divBy5, int max) {
			super(divBy3, divBy5, max, null);
		}

		@Override
		public void print() {
			System.out.println(current);
		}
	}
}
