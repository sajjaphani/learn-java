package org.learnjava.j8;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * A stream is a sequence of elements supporting sequential and parallel
 * aggregate operations. Streams do not provide a means to directly access or
 * manipulate their elements. It simply conveys elements from a given source
 * source an array, or an I/O channel, through a pipeline of computational
 * operations. Streams are lazy in nature and evaluates code only when required.
 * 
 * @see <a href=
 *      "https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html">
 *      Streams</a>
 * 
 * @author psajja
 *
 */
public class StreamExample {

	/**
	 * Computes the sum of first 10 natural numbers
	 * 
	 * @return the sum
	 */
	private static int sumOfFirst10Numbers() {
		return IntStream.range(1, 10).sum();
	}

	/**
	 * Given a stream it computes the sum of the by multiplying by 2.
	 * 
	 * @param stream
	 *            given stream
	 * 
	 * @return the sum
	 */
	private static int multiplyNumbersBy2AndSum(Stream<Integer> stream) {
		return stream.map(number -> number * 2).reduce(0, (sum, number) -> sum + number);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Working with Streams...");
		System.out.println("Sum of first 10 numbers using stream: " + sumOfFirst10Numbers());

		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Stream<Integer> sequencialStream = Arrays.stream(numbers).boxed();

		System.out.println();
		System.out.println("Multiply Numbers By 2 And the add");
		System.out.println("Using Sequential Stream");
		int result = multiplyNumbersBy2AndSum(sequencialStream);
		System.out.println("Sum: " + result);

		Stream<Integer> parallelStream = Arrays.stream(numbers).boxed().parallel();

		System.out.println();
		System.out.println("Multiply Numbers By 2 And the add");
		System.out.println("Using Parallel Stream");
		result = multiplyNumbersBy2AndSum(parallelStream);
		System.out.println("Sum: " + result);
	}
}
