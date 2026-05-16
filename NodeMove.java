package igrica;

public class NodeMove {
    private Move podatak;       
    private NodeMove sledeci;   

    public NodeMove(Move podatak) {
        this.podatak = podatak;
        this.sledeci = null;
    }

    public Move getPodatak() { 
        return podatak; 
    }

    public void setPodatak(Move podatak) { 
        this.podatak = podatak; 
    }

    public NodeMove getSledeci() { 
        return sledeci; 
    }

    public void setSledeci(NodeMove sledeci) { 
        this.sledeci = sledeci; 
    }
}

