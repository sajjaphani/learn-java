package org.learnjava.concurrent.fizbuz;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Implementation of FizBuz using multiple threads. Uses the Java 8 Feature
 * Functional Interface.
 * 
 * @author psajja
 *
 */
public class FizBuzJ8 {

	public static void main(String[] args) {
		int MAX = 100;
		new Thread(new FizzBuzzRunnable(i -> i % 3 == 0 && i % 5 == 0, i -> "FizzBuzz", MAX)).start();
		new Thread(new FizzBuzzRunnable(i -> i % 3 == 0 && i % 5 != 0, i -> "Fizz", MAX)).start();
		new Thread(new FizzBuzzRunnable(i -> i % 3 != 0 && i % 5 == 0, i -> "Buzz", MAX)).start();
		new Thread(new FizzBuzzRunnable(i -> i % 3 != 0 && i % 5 != 0, i -> Integer.toString(i), MAX)).start();
	}

	static class FizzBuzzRunnable implements Runnable {
		private static Object lock = new Object();
		protected static int current = 1;
		private int max;
		private Predicate<Integer> validate;
		private Function<Integer, String> printer;

		public FizzBuzzRunnable(Predicate<Integer> validate, Function<Integer, String> printer, int max) {
			this.validate = validate;
			this.printer = printer;
			this.max = max;
		}

		@Override
		public void run() {
			while (true) {
				synchronized (lock) {
					if (current > max)
						return;

					if (validate.test(current)) {
						System.out.println(printer.apply(current));
						current++;
					}
				}
			}
		}
	}
}
