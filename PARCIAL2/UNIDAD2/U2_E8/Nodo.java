public class Nodo {
    private String elem; // valor almacenado en el nodo
    private Nodo next;   // referencia al siguiente nodo

    // asignar el valor al nodo
    public void setElem(String variable) {
        elem = variable;
    }

    // obtener el valor del nodo
    public String getElem() {
        return elem;
    }

    // asignar el siguiente nodo
    public void setNext(Nodo variable) {
        next = variable;
    }

    // obtener el siguiente nodo
    public Nodo getNext() {
        return next;
    }
}