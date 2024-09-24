package UNIDAD1.U1_E6;

public class Nodo {
    private String elem; // almacenar elemento
    private Nodo next; // nodo siguiente
    private Nodo back; // nodo anterior

    public void setElem(String variable){
        elem = variable; // establecer elem
    }

    public String getElem(){ // obtener elem guardado
        return elem;
    }

    public void setNext(Nodo variable){
        next = variable; // asignar al nodo siguiente
    }

    public Nodo getNext(){ // obtener nodo siguiente
        return next; // retornar el nodo siguiente
    }

    public void setBack(Nodo variable) {
        back = variable; // Asignar el nodo anterior
    }
    public Nodo getBack() { // obtener el nodo anterior en la lista
        return back; // Devolver el nodo anterior
    }
    
}
