package igrica;

import java.util.Random;

public class Board {
	Cell[][] mat;

	public Board(int duzina, int brojMina) {
		if(duzina <= 0 || brojMina < 0 || brojMina >= duzina*duzina) {
			throw new IllegalArgumentException("...");
		}
		this.mat = new Cell[duzina][duzina];
		for(int i = 0; i < duzina; i++) {
			for(int j = 0; j < duzina; j++) {
				mat[i][j] = new Cell(false);
			}
		}
		Random rand = new Random();
		int postavljeno = 0;
		while(postavljeno < brojMina) {
		    int red = rand.nextInt(duzina);
		    int kolona = rand.nextInt(duzina);
		    if(!mat[red][kolona].isMine()) {
		        mat[red][kolona].setMine(true);
		        postavljeno++;
		    }
		}
	
		calculateAdjacentMines();
	}
	
	private void calculateAdjacentMines() {
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[i].length; j++) {
				if(!mat[i][j].isMine()) {
				    int brojac = 0;
				    int[] dx = {-1, -1, -1,  0, 0,  1, 1, 1};
				    int[] dy = {-1,  0,  1, -1, 1, -1, 0, 1};
				    
				    for(int k = 0; k < 8; k++) {
				        int noviRed = i + dx[k];
				        int novaKolona = j + dy[k];
				        if(noviRed >= 0 && noviRed < mat.length && novaKolona >= 0 && novaKolona < mat[0].length) {
				            if(mat[noviRed][novaKolona].isMine()) {
				                brojac++;
				            }
				        }
				    }
				    mat[i][j].setAdjacentMines(brojac);
				}
			}
		}
		
	}
	
	public void revealCell(int red, int kolona) {
	    if(mat[red][kolona].getCurrenstate() != CellState.HIDDEN) return;
	    mat[red][kolona].setCurrenstate(CellState.REVEALED);
	    if(mat[red][kolona].isMine()) return;
	    if(mat[red][kolona].getAdjacentMines() == 0) {
	        CoordinateQueue queue = new CoordinateQueue();
	        queue.enqueue(red, kolona);
	        
	        int[] dx = {-1, -1, -1,  0, 0,  1, 1, 1};
	        int[] dy = {-1,  0,  1, -1, 1, -1, 0, 1};
	        
	        while(!queue.isEmpty()) {
	            int[] trenutni = queue.dequeue();
	            int r = trenutni[0];
	            int k = trenutni[1];
	            
	            for(int i = 0; i < 8; i++) {
	                int noviR = r + dx[i];
	                int noviK = k + dy[i];
	                
	                if(noviR >= 0 && noviR < mat.length && noviK >= 0 && noviK < mat[0].length) {
	                    if(mat[noviR][noviK].getCurrenstate() == CellState.HIDDEN && !mat[noviR][noviK].isMine()) {
	                        mat[noviR][noviK].setCurrenstate(CellState.REVEALED);
	                        if(mat[noviR][noviK].getAdjacentMines() == 0) {
	                            queue.enqueue(noviR, noviK);
	                        }
	                    }
	                }
	            }
	        }
	    }
	}
	
	public GameOutcome getGameState() {
	    for(int i = 0; i < mat.length; i++) {
	        for(int j = 0; j < mat[i].length; j++) {
	            if(mat[i][j].isMine() && mat[i][j].getCurrenstate() == CellState.REVEALED) {
	                return GameOutcome.DEFEAT;
	            }
	            if(!mat[i][j].isMine() && mat[i][j].getCurrenstate() == CellState.HIDDEN) {
	                return GameOutcome.IN_PROGRESS;
	            }
	        }
	    }
	    return GameOutcome.VICTORY;
	}
	
	
}