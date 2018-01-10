package org.learnjava.j8;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.learnjava.j8.model.ICommand;

/**
 * The example demonstrates the functional interfaces in Java 8. Functional
 * interfaces are also called as Single Abstract Method interfaces. The benefit
 * of functional interfaces is that we can use lambda expressions to instantiate
 * them, which eliminates boilerplate code which is unnecessary.
 * <ul>
 * <li>It is not mandatory to declare the annotation. It is a hint to the
 * compiler and will flag it as an error where it fails.</li>
 * <li>We can have default and static methods.</li>
 * <li>We can declare the {@link java.lang.Object} public methods inside a
 * functional interface.</li>
 * <li></li>
 * </ul>
 * 
 * @see <a href=
 *      "https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html">
 *      Functional Interfaces</a>
 * 
 * @see {@link LambdaExpressionExample}
 * 
 * @author psajja
 *
 */
public class FunctionalInterfaceExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String commandString = "Print this on to the console.";
		ICommand command = new PrintCommand();
		command.execute(commandString);

		System.out.println("Functions");
		functionInJava();

		System.out.println("Composing Functions");
		functionCompositionInJava();
	}

	/**
	 * Using function in java
	 */
	private static void functionInJava() {
		BiFunction<Integer, Integer, Integer> add = FunctionalInterfaceExample::add;
		int result = add.apply(10, 20);
		System.out.println("Result: " + result);
	}

	/**
	 * Composing the functions.
	 * 
	 */
	private static void functionCompositionInJava() {
		BiFunction<Integer, Integer, Integer> add = FunctionalInterfaceExample::add;
		Function<Integer, String> toJson = FunctionalInterfaceExample::toJsonString;

		BiFunction<Integer, Integer, String> composed = add.andThen(toJson);
		String jsonString = composed.apply(10, 20);
		System.out.println(jsonString);
	}

	private static String toJsonString(int data) {
		return "{ result:" + data + " }";
	}

	/**
	 * Add two integers
	 * 
	 * @param a
	 *            first integer
	 * @param b
	 *            second integer
	 * 
	 * @return result of addition
	 */
	private static int add(int a, int b) {
		return a + b;
	}

	/**
	 * An implementation of the command interface where it prints out the given
	 * command to the console. This is just a plain concrete implementation of
	 * the interface.
	 * 
	 * @author psajja
	 *
	 */
	private static class PrintCommand implements ICommand {

		@Override
		public void execute(String command) {
			System.out.println(command);
		}
	}
}
