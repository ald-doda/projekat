package igrica;

public class MyLinkedList {
    private NodeMove glava; 

    public MyLinkedList() {
        this.glava = null;
    }

    public void insert(Move noviPotez) {
        NodeMove noviCvor = new NodeMove(noviPotez);
        noviCvor.setSledeci(glava);
        glava = noviCvor;
    }

    public NodeMove getHead() {
        return glava;
    }
}