package org.learnjava.design;

/**
 * Derived types must be completely substitutable for their base types. This
 * principle is just an extension of the Open Close Principle in terms of
 * behavior meaning that we must make sure that new derived classes are
 * extending the base classes without changing their behavior. The new derived
 * classes should be able to replace the base classes without any change in the
 * code.
 * <p>
 * There is a strong relationship between the LSP and the concept of Design by
 * Contract. Using design by contract scheme, methods of classes declare
 * preconditions and postconditions. The preconditions must be true in order for
 * the method to execute. Upon completion, the method guarantees that the
 * postcondition will be true.
 * </p>
 * <p>
 * In other words, when using an object through its base class interface, the
 * user knows only the preconditions and postconditions of the base class. Thus,
 * derived objects must not expect such users to obey preconditions that are
 * stronger then those required by the base class. That is, they must accept
 * anything that the base class could accept. Also, derived classes must conform
 * to all the postconditions of the base. Their behaviors and outputs must not
 * violate any of the constraints established for the base class. Users of the
 * base class must not be confused by the output of the derived class.
 * </p>
 * 
 * @author psajja
 *
 */
public class LiskovSubstitutionExample {

	/**
	 * Validates the invariants after setting the width and height.
	 * <p>
	 * An invariant is a condition that can be relied upon to be true during
	 * execution of a program, or during some portion of it. It is a logical
	 * assertion that is held to always be true during a certain phase of
	 * execution.
	 * </p>
	 * <p>
	 * The invariants violates if we receive a square here.
	 * </p>
	 * 
	 * @param rectangle
	 *            given rectangle
	 */
	private static void checkInvariants(Rectangle rectangle) {
		rectangle.setHeight(200);
		rectangle.setWidth(100);
		assert (rectangle.getHeight() == 200 && rectangle.getWidth() == 100);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Print Nothing");
		Rectangle rectangle = new Square();
		checkInvariants(rectangle);
	}

	/*********************************************************************************
	 * An example that violates the principle
	 *********************************************************************************/

	/**
	 * We have a class rectangle.
	 * 
	 */
	static class Rectangle {
		private int width;
		private int height;

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}
	}

	/**
	 * A square is a special case of rectangle where the height and width of the
	 * shape are equal.
	 * 
	 */
	static class Square extends Rectangle {

		@Override
		public void setHeight(int height) {
			super.setHeight(height);
			super.setWidth(height);
		}

		@Override
		public void setWidth(int width) {
			super.setWidth(width);
			super.setHeight(width);
		}
	}

	/*********************************************************************************
	 * Below are few alternative approaches to solve this problem
	 *********************************************************************************/
	/*
	 * 1. First solution to the problem is to remove the inheritance relationship. 
	 * 2. Have a base Shape interface, which defines only the contract. Then Rectangle and Square are the concrete classes of the Shape interface.
	 */
}
