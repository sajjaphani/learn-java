package org.learnjava.design.tictactoe;

/**
 * Tic-tac-toe board.
 * 
 * @author psajja
 *
 */
public class Board {

	public static final int ROWS = 3;
	public static final int COLS = 3;

	private Cell[][] cells;
	private Cell currentPlayer;

	public Board() {
		initBoard();
		currentPlayer = Cell.Cross;
	}

	/**
	 * Initialize the board with empty cells
	 */
	private void initBoard() {
		cells = new Cell[ROWS][COLS];
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				cells[row][col] = Cell.Empty;
			}
		}
	}

	/**
	 * Check if there is a winner at the given location.
	 * 
	 * @param row
	 * 		the current row
	 * @param column
	 * 		the current column
	 * 
	 * @return
	 * 		the winner or empty cell if not
	 */
	public Cell findWinner(int row, int column) {
		Cell piece = cells[row][column];
		if (piece == Cell.Empty)
			return Cell.Empty;

		if (hasWonByRow(row) || hasWonByColumn(column))
			return piece;

		if (row == column && hasWonByDiagonal(1))
			return piece;

		if (row == (cells.length - column - 1) && hasWonByDiagonal(-1))
			return piece;

		return Cell.Empty;
	}

	/**
	 * Check whether there is a winner in the given row.
	 * 
	 * @param row
	 * 		row to check
	 * 
	 * @return
	 * 		true if there is a winner, false otherwise
	 */
	protected boolean hasWonByRow(int row) {
		for (int col = 1; col < cells[row].length; col++)
			if (cells[row][col] != cells[row][0])
				return false;

		return true;
	}

	/**
	 * Check whether there is a winner in the given column.
	 * 
	 * @param column
	 * 		row to check
	 * 
	 * @return
	 * 		true if there is a winner, false otherwise
	 */
	protected boolean hasWonByColumn(int column) {
		for (int row = 1; row < cells.length; row++)
			if (cells[row][column] != cells[0][column])
				return false;

		return true;
	}

	/**
	 * Check if there is a winner diagonally.
	 * 
	 * @param direction
	 * 		given direction
	 * 
	 * @return
	 * 		true if there is a winner, false otherwise
	 */
	protected boolean hasWonByDiagonal(int direction) {
		int row = 0;
		int column = direction == 1 ? 0 : cells.length - 1;
		Cell first = cells[0][column];
		for (int i = 0; i < cells.length; i++) {
			if (cells[row][column] != first)
				return false;

			row += 1;
			column += direction;
		}

		return true;
	}

	/**
	 * Change the current player
	 */
	protected void changePlayer() {
		if (currentPlayer == Cell.Cross)
			currentPlayer = Cell.Circle;
		else
			currentPlayer = Cell.Cross;
	}

	/**
	 * Place the move at the current position if empty. This will further turn
	 * the player.
	 * 
	 * @param row
	 *            current row
	 * @param col
	 *            current column
	 * 
	 * @return if updated successfully, false otherwise
	 */
	public boolean placeMove(int row, int col) {
		if (row >= 0 && row < 3 && col >= 0 && col < 3) {
			if (cells[row][col] == Cell.Empty) {
				cells[row][col] = currentPlayer;
				changePlayer();

				return true;
			}
		}

		return false;
	}
}