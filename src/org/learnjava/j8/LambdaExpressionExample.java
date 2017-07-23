package org.learnjava.j8;

import org.learnjava.j8.model.ICommand;

/**
 * Lambda expressions enable us to treat functionality as method argument, or
 * code as data. Java language provide supports for using lambda expressions
 * with functional interfaces only. Lambda expressions are lexically scoped,
 * means they do not inherit any names from a super-type or introduce a new
 * level of scoping. To determine the type of a lambda expression, the Java
 * compiler uses the target type of the context or situation in which the lambda
 * expression was found.
 * 
 * @see <a href=
 *      "https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html">
 *      Lambda Expressions</a>
 * 
 * @author psajja
 *
 */
public class LambdaExpressionExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Using Ananymous Class");
		ICommand command = new ICommand() {

			@Override
			public void execute(String command) {
				System.out.println(command);
			}
		};

		command.execute("Printing a message with anaymous class");

		System.out.println();
		System.out.println("Using Lambda Expression");
		ICommand command1 = (commandString) -> System.out.println(commandString);

		command1.execute("Printing a message with lambda expression");
	}
}
