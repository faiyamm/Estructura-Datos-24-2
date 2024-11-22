public class Nodo {
    private String elem;  // variable que almacena el valor del nodo
    private Nodo next;    // variable que almacena la referencia al siguiente nodo
    
    // Obtener el valor del nodo
    public String getElem() {
        return elem;  // devolver el valor del nodo
    }
    
    // Establecer el valor del nodo
    public void setElem(String elem) {
        this.elem = elem;  // asignar el valor al nodo
    }
    
    // Obtener el siguiente nodo
    public Nodo getNext() {
        return next;  // devolver la referencia al siguiente nodo
    }
    
    // Establecer el siguiente nodo
    public void setNext(Nodo next) {
        this.next = next;  // asignar la referencia al siguiente nodo
    }
}