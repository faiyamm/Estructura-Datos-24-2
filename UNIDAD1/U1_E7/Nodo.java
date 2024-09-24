package UNIDAD1.U1_E7;

public class Nodo {
    private String elem;
    private Nodo next; // cuerda que une a otro elemento
    private Nodo back;

    // Constructor to initialize elem
    public Nodo(String elem) {
        this.elem = elem;
        this.next = null;
        this.back = null;
    }

    // Default constructor
    public Nodo() {
        this(null);
    }

    // Set asignacion o coloca elemento de la caja
    public void setElem(String variable) {
        elem = variable; // adaptar en unas 2 semanas
    }

    // Get permite visualizar el contenido, regresa
    public String getElem() {
        return elem;
    }

    public void setNext(Nodo variable) {
        next = variable;
    }

    public Nodo getNext() {
        return next;
    }

    public void setBack(Nodo variable) {
        back = variable;
    }

    public Nodo getBack() {
        return back;
    }
    
}
