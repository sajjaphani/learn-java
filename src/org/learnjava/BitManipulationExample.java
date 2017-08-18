package org.learnjava;

/**
 * Bit Manipulation
 * 
 * @author psajja
 *
 */
public class BitManipulationExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int number = -75;
		System.out.println("Given number: " + number);

		// In an arithmetic right shift, the sign bit is extended to preserve
		// the sign
		// of the number.
		System.out.println("Arithmatic Right Shift (divides by 2): " + (number >> 1));

		// Logical right shift simply moves everything to the right and fills in
		// from the left with 0s
		System.out.println("Logical Right Shift: " + (number >>> 1));

		System.out.println();
		// Bits are shifted towards the left
		System.out.println("Arithmatic/Logical left shift: " + (number << 1));
		int value = -75;
		System.out.println(Integer.toBinaryString(value));

		int b1 = value << 1;
		System.out.println(Integer.toBinaryString(b1));

		System.out.println();
		System.out.println("5th bit in 32 is set: " + hasBitSet(32, 5));
		System.out.println("Set 6th bit in 32: " + setBit(32, 6));
		System.out.println("Clear 6th bit in 96: " + clearBit(96, 6));
	}

	/**
	 * Given a number and a position, this method checks whether the bit is set
	 * in the given number.
	 * 
	 * @param number
	 *            given number
	 * @param pos
	 *            position to check
	 * 
	 * @return true if the bit set, false otherwise
	 */
	static boolean hasBitSet(int number, int pos) {
		return ((number & (1 << pos)) != 0);
	}

	/**
	 * Given a number and a position, this method sets the bit at the given
	 * position.
	 * 
	 * @param number
	 *            given number
	 * @param pos
	 *            position to check
	 * 
	 * @return number after setting the bit
	 */
	static int setBit(int number, int pos) {
		return number | (1 << pos);
	}

	/**
	 * This method clears the bit at the given position.
	 * 
	 * @param number
	 *            given number
	 * @param pos
	 *            positioin to clear
	 * 
	 * @return the number after clearing the bit
	 */
	static int clearBit(int number, int pos) {
		int mask = ~(1 << pos);

		return number & mask;
	}

	/**
	 * This method clears the bits from MSB to the position.
	 * 
	 * @param number
	 *            given number
	 * @param pos
	 *            given position
	 * 
	 * @return the number after clearing the bits
	 */
	static int clearBitsFromMsbToPos(int number, int pos) {
		int mask = (1 << pos) - 1;

		return number & mask;
	}
	
	/**
	 * This method clears the bits from the position to LSB.
	 * 
	 * @param number
	 *            given number
	 * @param pos
	 *            given position
	 * 
	 * @return the number after clearing the bits
	 */
	static int clearBitsFromPosToLSB(int number, int pos) {
		int mask = (-1 << (pos + 1));

		return number & mask;
	}
	
	/**
	 * Update the bit at the given position
	 * 
	 * @param number
	 * 		given number
	 * @param pos
	 * 		given position
	 * @param isOne
	 * 		true for 1, false for 0
	 * 
	 * @return
	 * 		updated value
	 */
	static int updateBit(int number, int pos, boolean isOne) {
		int value = isOne ? 1 : 0;
		int mask = ~(1 << pos);

		return (number & mask) | (value << pos);
	}
}
