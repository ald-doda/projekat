package igrica;

public class Player {
    private MyLinkedList istorijaPoteza; 
    private Board tabla;              

    public Player(Board tabla) {
        this.tabla = tabla;
        this.istorijaPoteza = new MyLinkedList();
    }

    public GameOutcome playTurn() {
        int velicina = tabla.getSize(); 
        int red, kolona;

        do {
            red = (int) (Math.random() * velicina);
            kolona = (int) (Math.random() * velicina);
        } while (tabla.getCellState(red, kolona) != CellState.HIDDEN);

        tabla.revealCell(red, kolona);
        
        GameOutcome ishod = tabla.getGameState();
        
        boolean bioBezbjedan = (ishod != GameOutcome.DEFEAT);

        Move trenutniPotez = new Move(red, kolona, bioBezbjedan);
        istorijaPoteza.insert(trenutniPotez);

        return ishod; 
    }

    public MyLinkedList getMoveHistory() {
        return istorijaPoteza;
    }
}