package UNIDAD1.U1_E7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Lista {
    private Nodo inicio;
    private Nodo fin;

    // valores iniciales
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

    // truco no correcto, para imprimir direcciones de memoria
    public void direcciones() {
        System.out.println("inicio " + inicio);
        System.out.println("fin " + fin);
    }

    public void insertar(String elem) {
        Nodo nuevo = new Nodo();
        nuevo.setElem(elem);
        System.out.println("Nuevo: " + nuevo.getElem());

        // lista vacía coloca el primer elemento
        if (inicio == null && fin == null) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            Nodo i = inicio;
            while (i.getNext() != null) {
                i = i.getNext();
            }
            i.setNext(nuevo);
            nuevo.setBack(i);
            fin = nuevo;
        }
    } // fin de insertar

    public void mostrar() {
        if (inicio != null) {
            Nodo i = inicio;
            while (i != null) {
                System.out.println(i.getElem());
                i = i.getNext();
            }
        } 
    } // fin mostrar

    public boolean borrar(String elem) {
        Nodo i = inicio;
        boolean estado = false;
        while (i != null) {
            if (elem.equals(i.getElem())) {
                estado = true;
                if (inicio == fin) {
                    inicio = fin = null;
                } else if (i == inicio) {
                    inicio = inicio.getNext();
                    inicio.setBack(null);
                } else if (i == fin) { //ultimo elemento
                    fin = fin.getBack();
                    fin.setNext(null);
                } else { // enmedio
                    i.getNext().setBack(i.getBack());
                    i.getBack().setNext(i.getNext());
                    i.setNext(null);
                    i.setBack(null);
                }
                break;
            }
            i = i.getNext();
        }
        return estado;
    } // fin borrar

    public void limpiar() {
        inicio = fin = null;
    }// fin de reiniciar lista

    public boolean vacia() {
        return inicio == null;
    }

    public void insertarInicio(String elem){
        Nodo nuevo = new Nodo();
        nuevo.setElem(elem);
        Nodo aux = inicio;
        inicio = nuevo;
        nuevo.setNext(aux);
        if (aux != null) {
            aux.setBack(inicio);
        } else {
            fin = nuevo;
        }
    }

    public void insertarEnmedio(String colado, String elem) {
        Nodo i = inicio; 
        Nodo nuevo = new Nodo(colado); 
        boolean estado = false;
    
        while (i != null && !estado) {
            if (elem.equals(i.getElem())) {
                System.out.println("Encontrado...");
                estado = true;
                if (i == inicio) {
                    insertarInicio(colado);
                } else {
                    i.getBack().setNext(nuevo);
                    nuevo.setNext(i);
                    nuevo.setBack(i.getBack());
                    i.setBack(nuevo);
                }
                break;
            } 
            i = i.getNext();
            
        }
    }

    public void guardarEnArchivo(String nombreArchivo) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo))) {
            Nodo actual = inicio; // comenzar desde el nodo inicial
            while (actual != null) {
                escritor.write(actual.getElem()); // escribir el dato del nodo en el archivo
                escritor.newLine(); // new line para cada dato
                actual = actual.getNext(); // mover al siguiente nodo
            }
            System.out.println("Lista guardada exitosamente en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar la lista en el archivo.");
            e.printStackTrace();
        }
    }

    public void mostrarInverso() {
        if (fin != null) { // empezar desde el último nodo
            Nodo i = fin;
            while (i != null) {
                System.out.println(i.getElem());
                i = i.getBack(); // regresar al nodo anterior
            }
        } else {
            System.out.println("No hay elementos para mostrar");
        }
    }
}
