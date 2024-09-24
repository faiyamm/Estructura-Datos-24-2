package UNIDAD1.U1_E5;

import java.time.LocalDateTime;

public class Nodo {
    private String elem; // almacenar elemento
    private LocalDateTime timestamp; // guardar tiempo
    private Nodo next; // nodo siguiente

    public void setElem(String variable){
        elem = variable; // establecer elem
        timestamp = LocalDateTime.now(); // guardar tiempo actual
    }

    public String getElem(){ // obtener elem guardado
        return elem;
    }

    public LocalDateTime getTimestamp(){ // obtener tiempo real
        return timestamp; 
    }

    public void setNext(Nodo variable){
        next = variable; // asignar al nodo siguiente
    }

    public Nodo getNext(){ // obtener nodo siguiente
        return next; // retornar el nodo siguiente
    }
    
}
