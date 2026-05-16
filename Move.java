package igrica;

public class Move {
    private int red;
    private int kolona;
    private boolean bioBezbjedan;

    public Move(int red, int kolona, boolean bioBezbjedan) {
        this.red = red;
        this.kolona = kolona;
        this.bioBezbjedan = bioBezbjedan;
    }

    public int getRed() { 
        return red; 
    }

    public int getKolona() { 
        return kolona; 
    }

    public boolean isBioBezbjedan() { 
        return bioBezbjedan; 
    }
}