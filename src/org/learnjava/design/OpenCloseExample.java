package org.learnjava.design;

/**
 * Software entities like classes, modules and functions should be open for
 * extension but closed for modifications.
 * <p>
 * The Open Closed Principle is all about allowing change, but doing without
 * requiring you to modify existing code.. When referring to the classes Open
 * Close Principle can be ensured by use of Abstract Classes and concrete
 * classes for implementing their behavior. This will enforce having Concrete
 * Classes extending Abstract Classes instead of changing them. Some particular
 * cases of this are Template Pattern and Strategy Pattern.
 * </p>
 * 
 * @author psajja
 *
 */
public class OpenCloseExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Print Nothing");
	}

	/*********************************************************************************
	 * Bad example, which is open for modification
	 *********************************************************************************/
	/**
	 * This class takes care of drawing different shapes. We need to modify this
	 * class to support a different shape.
	 * 
	 */
	static class GraphicEditorBad {
		public void drawShape(ShapeBad s) {
			if (s.type == 1)
				drawRectangle((RectangleBad) s);
			else if (s.type == 2)
				drawCircle((CircleBad) s);
		}

		private void drawRectangle(RectangleBad r) {
			System.out.println("I am drawing a rectangle");
		}

		private void drawCircle(CircleBad r) {
			System.out.println("I am drawing a circle");
		}
	}

	/**
	 * Shape interface.
	 * 
	 */
	static class ShapeBad {
		int type;
	}

	/**
	 * A rectangle.
	 * 
	 */
	static class RectangleBad extends ShapeBad {
		// Rectangle state (width & height)
		public RectangleBad() {
			super.type = 1;
		}
	}

	/**
	 * A circle
	 * 
	 */
	static class CircleBad extends ShapeBad {
		// Circle state (radius)
		public CircleBad() {
			super.type = 2;
		}
	}

	/*********************************************************************************
	 * Modified example, which is open for extension but closed for modification
	 *********************************************************************************/
	
	/**
	 * This class takes care of drawing different shapes. It delegates the
	 * drawing to the shape object by passing a graphics object, which is
	 * commented for simplicity.
	 * 
	 */
	static class GraphicEditor {
		/* Graphics g = ...*/
		public void drawShape(Shape s) {
			s.draw(/* g */);
		}
	}

	/**
	 * Shape interface.
	 * 
	 */
	static interface Shape {
		public void draw(/* Graphics g */);
	}

	/**
	 * A rectangle.
	 * 
	 */
	static class Rectangle implements Shape {
		// Rectangle state (width & height)

		@Override
		public void draw(/* Graphics g */) {
			System.out.println("I know how to draw rectangle...");
		}

	}

	/**
	 * A circle
	 * 
	 */
	static class Circle implements Shape {
		// Circle state (radius)

		@Override
		public void draw(/* Graphics g */) {
			System.out.println("I know how to draw circle...");
		}
	}
}
