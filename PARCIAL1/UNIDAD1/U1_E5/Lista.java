package UNIDAD1.U1_E5;

import java.time.Duration;

public class Lista {
    private Nodo inicio; // nodo principal de la lista
    private Nodo fin; // nodo final de la lista

    public Lista(){
        inicio = null;
        fin = null;
    }

    public void setInicio(Nodo variable){
        inicio = variable;
    }

    public Nodo getInicio(){
        return inicio;
    }

    public Nodo getFin(){
        return fin;
    }

    // método similar al que usamos en el ejercicio 3 para obtener las direcciones de memoria
    public void direcciones(){
        System.out.println("Inicio: " + inicio);
        System.out.println("Fin: " + fin);
    }

    // insertar un elemento nuevo al final de la lista
    public void insertar(String elem){
        Nodo nuevo = new Nodo(); // crear
        nuevo.setElem(elem);
        System.out.println("Nuevo: " + nuevo.getElem() + " a las " + nuevo.getTimestamp());

        if (inicio == null && fin == null){ // si la lista esta vacía hay que iniciar en el primer elemento
            inicio = nuevo;
            fin = nuevo;
        } else { // pero si sí hay elem, hay que añadir el new elem al final
            fin.setNext(nuevo);
            fin = nuevo;
        }
    }

    // mostrar los elementos de la lista
    public void mostrar(){
        if (inicio != null){
            Nodo i = inicio; // iniciar desde el nodo principal
            while (i != null){
                System.out.println(i.getElem() + " agregado a las " + i.getTimestamp());
                i = i.getNext(); // siguiente nodo
            }
        } else {
            System.out.println("LISTA VACÍA: No hay elementos para mostrar!!");
        }
    }

    // insertar un elem al inicio de la lista
    public void InsertarInicio(String elem){
        Nodo nuevo = new Nodo();
        nuevo.setElem(elem); // nuevo elem
        Nodo aux = inicio; // nodo principal

        inicio = nuevo; // nuevo nodo es nuevo inicio
        nuevo.setNext(aux); // nuevo nodo al nodo viejito

        if (aux != null){
            Duration diff = Duration.between(aux.getTimestamp(), nuevo.getTimestamp());
            System.out.println("Diferencia de tiempo: " + diff.toSeconds() + " segundos");
        }
    }

    // insertar un elem en medio de la lista
    public void insertarEnmedio(String colado, String elem){
        Nodo ant = inicio; // Nodo anterior
        Nodo i = inicio; // nodo actual
        boolean estado = false; // indicar estado
        Nodo nuevo = new Nodo();
        nuevo.setElem(colado); // nuevo elem aka el colado

        while (i != null && !estado) {
            if (elem.equals(i.getElem())) {
                System.out.println("Nombre encontrado");
                estado = true;
                if (i == inicio) {
                    InsertarInicio(colado); // por si se quiere insertar en el inicio
                } else {
                    ant.setNext(nuevo); // enlazar el nuevo nodo
                    nuevo.setNext(i); // enlazar al nodo actual
                }
            } else {
                if (i != inicio) {
                    ant = ant.getNext(); // mover el nodo anterior
                }
                i = i.getNext(); // mover al siguiente nodo
            }
        }
        if (!estado) System.out.println("No se encuentra ese nombre.");
    }

   // buscar elem en lista
    public void Buscar(String elem){
        if (inicio != null){
            Nodo i = inicio;
            while (i != null){
                if (elem != null && elem.equals(i.getElem())){
                    System.out.println("====Nombre encontrado====");
                    return; // salir al encontrar el nombre
                } i = i.getNext();
            } System.out.println("Nombre no encontrado :( ");
        }
    }
    
    // borrar elem de la lista
    public void borrar(String elem){
        Nodo ant = inicio; // anterior
        Nodo i = inicio; // actual
        boolean estado = false; // estado

        while (i != null){
            if (elem.equals(i.getElem())){
                if (i == inicio){ // si es el 1er nodo
                    inicio = inicio.getNext(); // actualizar inicio
                } else{
                    ant.setNext(i.getNext()); // nodo ant --> nodo sig
                } System.out.println("====Nombre borrado====");
                estado = true; // se encontró el elem y se borró
                break; // salir
            } else {
                if (i != inicio){
                    ant = ant.getNext();
                } i = i.getNext();
            }
        } if (!estado){
            System.out.println("==El elemento no se encuentra en la lista==");
        }
    }

}
