public class Lista {
    private Nodo inicio;
    private Nodo fin;

    // Constructor: inicializa los valores
    public Lista() {
        inicio = null;
        fin = null;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public Nodo getFin() {
        return fin;
    }

    // Reiniciar la lista
    public void reiniciar() {
        inicio = fin = null;
    }

    // Insertar un nuevo elemento en la lista
    public void insertar(int elem) {
        Nodo nuevo = new Nodo();
        nuevo.setElem(elem);

        if (inicio == null && fin == null) { // Si la lista está vacía
            inicio = fin = nuevo;
        } else { // Insertar al final directamente usando `fin`
            fin.setNext(nuevo);
            nuevo.setBack(fin);
            fin = nuevo; // Actualizar la referencia de `fin`
        }
    }

    // Borrar el primer nodo
    public void borrar() {
        if (inicio == fin) { // Si solo hay un elemento
            inicio = fin = null;
        } else {
            Nodo aux = inicio.getNext();
            inicio.setNext(null);
            inicio = aux;
        }
    }

    // Mostrar todos los elementos de la lista
    public void mostrar() {
        Nodo i = inicio;
        while (i != null) {
            System.out.println(i.getElem());
            i = i.getNext();
        }
    }

    // Buscar un elemento en la lista
    public void buscar(int elem) {
        Nodo i = inicio;
        boolean estado = false;
        while (i != null) {
            if (elem == i.getElem()) {
                System.out.println("Encontrado");
                estado = true;
                break;
            }
            i = i.getNext();
        }
        if (!estado) {
            System.out.println("No encontrado");
        }
    }

    // Borrar el último nodo de la lista
    public void borrarUltimo() {
        if (inicio == null) { // Lista vacía
            System.out.println("La lista está vacía.");
        } else if (inicio == fin) { // Si solo hay un nodo
            System.out.println("Regresa a posición " + fin.getElem());
            inicio = fin = null; // Reiniciar la lista
        } else { // Más de un nodo
            System.out.println("Regresa a posición " + fin.getElem());
            fin = fin.getBack(); // Actualizar `fin` al nodo anterior
            fin.setNext(null); // Eliminar la referencia al último nodo
        }
    }
}