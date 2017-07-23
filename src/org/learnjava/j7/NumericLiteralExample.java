package org.learnjava.j7;

/**
 * From Java SE version 7, any number of underscore characters (_) can appear
 * anywhere between digits in a numerical literal. This feature enables you to
 * separate groups of digits in numeric literals, which can improve the
 * readability of your code.
 * 
 * 
 * @author psajja
 *
 */
public class NumericLiteralExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Numerical Literals...");
		long creditCardNumber = 1234_5678_9012_3456L;
		System.out.println("Credit Card: " + creditCardNumber);
		
		int bytes = 0b01010010_01101001_00010100_00010010;
		System.out.println("Int in binary (4 bytes): " + bytes);
		
		float pi = 	3.14_15F;
		System.out.println("Pi: " + pi);
	}
}
