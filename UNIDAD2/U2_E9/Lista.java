import java.time.LocalDateTime;

public class Lista {
    private Nodo inicio;
    private Nodo fin;

    public Lista() {
        inicio = null;
        fin = null;
    }


    public void setInicio(Nodo variable) {
        inicio = variable;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setFin(Nodo variable) {
        fin = variable;
    }

    public Nodo getFin() {
        return fin;
    }

    // insertar paciente en la lista con su turno y hora de llegada
    public void insertar(String elem, int turno, LocalDateTime hora) {
        Nodo nuevo = new Nodo();
        nuevo.setElem(elem); // asignar nombre
        nuevo.setTurno(turno); // asignar turno
        nuevo.setHora(hora); // asignar hora de llegada
    
        if (inicio == null) { // si la lista está vacía
            inicio = fin = nuevo; // el nuevo nodo es el único nodo en la lista
        } else {
            fin.setNext(nuevo); // se agrega el nuevo nodo al final
            fin = nuevo; // actualizar el último nodo
        }
    }
    

    // eliminar paciente por su nombre
    public void borrar() {
        if (inicio == fin){
            inicio = fin = null;
        } else {
            Nodo aux = inicio.getNext();
            inicio.setNext(null);
            inicio = aux;
        }
    }

    // mostrar todos los pacientes
    public void mostrar() {
        Nodo i = inicio;
        while (i != null) {
            System.out.println(i);
            i = i.getNext();
        }
    }

    // buscar paciente por nombre
    public boolean buscar(String elem) {
        Nodo actual = inicio;
        while (actual != null) {
            if (elem.equals(actual.getElem())) {
                System.out.println("Paciente encontrado: " + actual);
                return true; // Element found
            }
            actual = actual.getNext();
        }
        return false; // Element not found
    }
    

    // se asume que ambas filas están acomodadas por hora
    public void combinar(Lista fila1, Lista fila2) {
        Nodo i1 = fila1.inicio;
        Nodo i2 = fila2.inicio;
        int turno = 1;
    
        // Combinar las listas en orden de llegada (hora)
        while (i1 != null && i2 != null) {
            if (i1.getHora().isBefore(i2.getHora())) { // verificar quien llego primero
                this.insertar(i1.getElem(), turno, i1.getHora()); // insertar de fila1
                i1 = i1.getNext(); // avanzar en fila1
            } else {
                this.insertar(i2.getElem(), turno, i2.getHora()); // insertar de fila2
                i2 = i2.getNext(); // avanzar en fila2
            }
            turno++; // incrementar turno
        }
    
        // agregar los elementos restantes de fila1 (si los hay)
        while (i1 != null) {
            this.insertar(i1.getElem(), turno, i1.getHora());
            turno++;
            i1 = i1.getNext();
        }
    
        // Agregar los elementos restantes de fila2 (si los hay)
        while (i2 != null) {
            this.insertar(i2.getElem(), turno, i2.getHora());
            turno++;
            i2 = i2.getNext();
        }
    }     
}