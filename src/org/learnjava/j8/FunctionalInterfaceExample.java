package org.learnjava.j8;

import org.learnjava.j8.model.ICommand;

/**
 * The example demonstrates the functional interfaces in Java 8. Functional
 * interfaces are also called as Single Abstract Method interfaces. The benefit
 * of functional interfaces is that we can use lambda expressions to instantiate
 * them, which eliminates boilerplate code which is unnecessary.
 * <ul>
 * <li>It is not mandatory to declare the annotation. It is a hint to the compiler and will flag it as an error where it fails.</li>
 * <li>We can have default and static methods.</li>
 * <li>We can declare the {@link java.lang.Object} public methods inside a functional interface.</li>
 * <li></li>
 * </ul>
 * 
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html">Functional Interfaces</a>
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
	}

	/**
	 * An implementation of the command interface where it prints out the given
	 * command to the console.
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
