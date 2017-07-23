package org.learnjava.j8;

import java.util.Arrays;
import java.util.List;

/**
 * In Java 8, we can use lambda expressions to create anonymous methods.
 * Sometimes lambda expressions does nothing but to call an existing method.
 * Method references enable us refer to the existing method by name; they are
 * compact, easy-to-read lambda expressions for methods that already have a
 * name.
 * 
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html">Method References</a>
 * 
 * @author psajja
 *
 */
public class MethodReferenceExample {

	/**
	 * Main Client
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String[] messages = new String[] { "Message 1", "Message 2", "Message 3", "Message 4" };
		System.out.println("Printing message method invocation in lambda expression");
		MessagePrinter printer = new MessagePrinter();
		List<String> list = Arrays.asList(messages);
		list.forEach(message -> printer.print(message));
		
		System.out.println();
		System.out.println("Printing message by passing a method reference..");
		list.forEach(printer::print);
	}

	/**
	 * A class which prints the message to the console.
	 * 
	 * @author psajja
	 *
	 */
	private static class MessagePrinter {
		
		/**
		 * Print the given message.
		 * 
		 * @param message
		 * 		the message
		 */
		public void print(String message) {
			System.out.println(message);
		}
	}
}
