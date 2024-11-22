public class Nodo {
    private Nodo next;
    private int Elem;

    public Nodo(){
    }

    public Nodo getNext() {
        return this.next;
    }

    public void setNext(Nodo var) {
        this.next = var;
    }

    public int getElem() {
        return this.Elem;
    }

    public void setElem(int var) {
        this.Elem = var;
    }
}