package igrica;

public class CoordinateQueue {
	
	private static class CoordinateNode{
		int red;
		int kolona;
		CoordinateNode sljedeci;
		
	}
	private CoordinateNode glava;
	private CoordinateNode rep;

	private static class Coordinate{
		private int red;
		private int kolona;
		
		
		public Coordinate(int red, int kolona) {
			this.red = red;
			this.kolona = kolona;
		}
		public int getRed() {
			return red;
		}
		
		public int getKolona() {
			return kolona;
		}
	}
	public void enqueue(int red, int kolona) {
		CoordinateNode novi = new CoordinateNode();
		novi.red = red;
		novi.kolona = kolona;
		if(rep == null) {
			glava = novi;
			rep = novi;
		} else {
			rep.sljedeci = novi;;
			rep = novi;
		}
		
	}
	public int[] dequeue() {
		if(glava == null) {
			return null;
		}
		CoordinateNode temp = glava;
		
		glava = glava.sljedeci;
		if(glava == null) {
			rep = null;
		}
		return new int[] {temp.red, temp.kolona};
	}
	
	public boolean isEmpty() {
		if(glava == null) return true;
		else return false;
		
	}

}
