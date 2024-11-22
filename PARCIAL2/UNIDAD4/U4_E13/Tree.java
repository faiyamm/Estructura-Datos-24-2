// clase que representa un árbol binario de búsqueda
public class Tree {
    private Nodo Root; // raíz del árbol

    // obtener raíz del árbol
    public Nodo getRoot() {
        return Root;
    }

    // establecer raíz del árbol
    public void setRoot(Nodo root) {
        Root = root;
    }

    // constructor del árbol
    public Tree() {
        Root = null; // inicializar árbol vacío
    }

    // verificar si el árbol está vacío
    public boolean vacio() {
        return Root == null; // el árbol está vacío si la raíz es nula
    }

    // insertar un elemento en el árbol
    public void insertar(int elem) {
        Nodo nuevo = new Nodo(); // crear un nuevo nodo
        nuevo.setElem(elem); // establecer valor del nodo
        if (vacio()) { // si el árbol está vacío
            Root = nuevo; // establecer como raíz
        } else {
            Nodo i = Root; // recorrer desde la raíz
            while (i != null) {
                if (elem > i.getElem()) { // si el valor es mayor, ir a la derecha
                    if (i.getRight() == null) { // verificar si hay espacio
                        i.setRight(nuevo); // insertar nodo
                        break; // terminar recorrido
                    } else {
                        i = i.getRight(); // continuar a la derecha
                    }
                } else { // si el valor es menor o igual, ir a la izquierda
                    if (i.getLeft() == null) { // verificar si hay espacio
                        i.setLeft(nuevo); // insertar nodo
                        break; // terminar recorrido
                    } else {
                        i = i.getLeft(); // continuar a la izquierda
                    }
                }
            }
        }
    }

    // mostrar elementos en preorden
    public void mostrarPreorden(Nodo aux) {
        if (aux != null) {
            System.out.print(aux.getElem() + " ");
            mostrarPreorden(aux.getLeft());
            mostrarPreorden(aux.getRight());
        }
    }

    // mostrar elementos en inorden
    public void mostrarInorden(Nodo aux) {
        if (aux != null) {
            mostrarInorden(aux.getLeft());
            System.out.print(aux.getElem() + " ");
            mostrarInorden(aux.getRight());
        }
    }

    // mostrar elementos en postorden
    public void mostrarPostorden(Nodo aux) {
        if (aux != null) {
            mostrarPostorden(aux.getLeft());
            mostrarPostorden(aux.getRight());
            System.out.print(aux.getElem() + " ");
        }
    }

    // mostrar elementos en orden inverso (de mayor a menor)
    public void mostrarInordenInverso(Nodo aux) {
        if (aux != null) {
            mostrarInordenInverso(aux.getRight());
            System.out.print(aux.getElem() + " ");
            mostrarInordenInverso(aux.getLeft());
        }
    }

    // buscar un elemento en el árbol
    public boolean buscar(int elem) {
        Nodo i = Root; // iniciar desde la raíz
        while (i != null) { // recorrer el árbol
            if (elem < i.getElem()) { // ir a la izquierda si el valor es menor
                i = i.getLeft();
            } else if (elem > i.getElem()) { // ir a la derecha si el valor es mayor
                i = i.getRight();
            } else { // el valor fue encontrado
                return true;
            }
        }
        return false; // el valor no está en el árbol
    }
}