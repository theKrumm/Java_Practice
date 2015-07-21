package gameboard;

public class Cell {
	// room with nothing in it.
	public final static int EMPTY_ROOM = 0;
	// room with part of the snake in it.
	public final static int BODY_ROOM = 1;
	// room with snake food in it.
	public final static int TARGET_ROOM = 2;
	// row of the cell.
	private final int row;
	//column of the cell.
	private final int col;
	// which kind of cell it is (empty, body room, or target room).
	private int cellType;

	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
		cellType = EMPTY_ROOM;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public int getType() {
		return cellType;
	}
	
	public void setType(int type) {
		cellType = type;
	}

}