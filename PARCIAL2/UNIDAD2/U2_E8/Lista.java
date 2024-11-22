public class Lista {
    private Nodo inicio; // nodo inicial de la lista
    private Nodo fin;    // nodo final de la lista

    // constructor para inicializar la lista vacía
    public Lista() {
        inicio = null;
        fin = null;
    }

    // método para insertar un nuevo elemento al final
    public void insertar(String elem) {
        Nodo nuevo = new Nodo(); // crear nuevo nodo
        nuevo.setElem(elem);     // asignar el elemento al nodo

        if (inicio == null) {
            // si la lista está vacía, el nuevo nodo es inicio y fin
            inicio = nuevo;
            fin = nuevo;
        } else {
            // si no, conectar el nuevo nodo al final
            fin.setNext(nuevo);
            fin = nuevo; // actualizar el fin
        }
    }

    // método para borrar el primer elemento de la lista
    public void borrar() {
        if (inicio == null) {
            // verificar si la lista está vacía
            System.out.println("La lista está vacía, no hay elementos para borrar.");
        } else if (inicio == fin) {
            // si hay solo un elemento, reiniciar la lista
            inicio = null;
            fin = null;
        } else {
            // si hay más de un elemento, actualizar el inicio
            Nodo aux = inicio.getNext(); // guardar el siguiente nodo
            inicio.setNext(null); // desconectar el nodo actual
            inicio = aux; // actualizar inicio
        }
    }

    // método para mostrar todos los elementos de la lista
    public void mostrar() {
        if (inicio == null) {
            // verificar si la lista está vacía
            System.out.println("==== LISTA VACÍA ====");
        } else {
            // recorrer la lista y mostrar los elementos
            Nodo i = inicio;
            while (i != null) {
                System.out.println(i.getElem());
                i = i.getNext(); // avanzar al siguiente nodo
            }
            System.out.println("null"); // marcar el final de la lista
        }
    }
}