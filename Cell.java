package igrica;

public class Cell {
	private boolean mine;
	private int adjacentMines;
	private CellState currentstate;
	
	
	public Cell(boolean mine) {
		this.mine = mine;
		this.adjacentMines = 0;
		this.currentstate = CellState.HIDDEN;
	}


	public boolean isMine() {
		return mine;
	}


	public void setMine(boolean mine) {
		this.mine = mine;
	}


	public int getAdjacentMines() {
		return adjacentMines;
	}


	public void setAdjacentMines(int adjacentMines) {
		this.adjacentMines = adjacentMines;
	}


	public CellState getCurrenstate() {
		return currentstate;
	}


	public void setCurrenstate(CellState currentstate) {
		this.currentstate = currentstate;
	}
	
	
	

}
