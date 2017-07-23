package org.learnjava.j7;

/**
 * In Java SE 7, the integral types (byte, short, int, and long) can also be
 * expressed using the binary number system. To specify a binary literal, add
 * the prefix 0b or 0B to the number.
 * 
 * @author psajja
 *
 */
public class BinaryLiteralExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Binary Literals...");
		byte binaryByte = 0b1011011;
		System.out.println("Binary Byte: " + binaryByte);
		
		int binaryInt = 0b0000011111100001;
		System.out.println("Binary Int: " + binaryInt);
		
		byte byt = 91;
		System.out.println("Binary byte and byte are equal: " + (binaryByte == byt));
	}
}
