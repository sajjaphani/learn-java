package org.learnjava.design.tictactoe;

/**
 * A single cell.
 * 
 * @author psajja
 *
 */
public enum Cell {
	Empty, Circle, Cross;

	@Override
	public String toString() {
		if (this == Circle)
			return "O";
		
		if (this == Cross)
			return "X";

		return " ";
	}
}
