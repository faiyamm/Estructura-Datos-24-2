public class Tree {
    Nodo Root;

    public Nodo getRoot() {
        return Root;
    }

    public void setRoot(Nodo root) {
        Root = root;
    }

    public Tree() {
        Root = null;
    }

    public boolean vacio() {
        // Verificar si el árbol está vacío
        return Root == null;
    }

    public void insertar(int elem) {
        Nodo nuevo = new Nodo();
        nuevo.setElem(elem); // Crear un nuevo nodo con el elemento

        if (vacio()) { // Si el árbol está vacío, el nuevo nodo será la raíz
            Root = nuevo;
        } else {
            Nodo i = Root;
            while (i != null) {
                if (elem > i.getElem()) { // Si el elemento es mayor, ir al subárbol derecho
                    if (i.getRight() == null) { // Si no hay nodo a la derecha, insertar
                        i.setRight(nuevo);
                        break;
                    } else {
                        i = i.getRight(); // Continuar hacia el subárbol derecho
                    }
                } else { // Si el elemento es menor o igual, ir al subárbol izquierdo
                    if (i.getLeft() == null) { // Si no hay nodo a la izquierda, insertar
                        i.setLeft(nuevo);
                        break;
                    } else {
                        i = i.getLeft(); // Continuar hacia el subárbol izquierdo
                    }
                }
            }
        }
    }

    public void mostrarPreorden(Nodo aux) {
        if (aux != null) {
            System.out.print(aux.getElem() + " - ");
            mostrarPreorden(aux.getLeft()); // Recursión hacia el subárbol izquierdo
            mostrarPreorden(aux.getRight()); // Recursión hacia el subárbol derecho
        }
    }

    public void mostrarInorden(Nodo aux) {
        if (aux != null) {
            mostrarInorden(aux.getLeft()); // Recursión hacia el subárbol izquierdo
            System.out.print(aux.getElem() + " - ");
            mostrarInorden(aux.getRight()); // Recursión hacia el subárbol derecho
        }
    }

    public void mostrarPostorden(Nodo aux) {
        if (aux != null) {
            mostrarPostorden(aux.getLeft()); // Recursión hacia el subárbol izquierdo
            mostrarPostorden(aux.getRight()); // Recursión hacia el subárbol derecho
            System.out.print(aux.getElem() + " - ");
        }
    }

    public void eliminarArbol() {
        Root = null; // Eliminar todo el árbol
    }

    // Mostrar los elementos en orden inverso (Mayor a Menor)
    public void mostrarInordenInverso(Nodo aux) {
        if (aux != null) {
            mostrarInordenInverso(aux.getRight()); // Recursión hacia el subárbol derecho
            System.out.print(aux.getElem() + " - ");
            mostrarInordenInverso(aux.getLeft()); // Recursión hacia el subárbol izquierdo
        }
    }

    public boolean buscar(int elem) {
        Nodo i = Root;
        boolean encontrado = false;
        while (i != null && !encontrado) { // Buscar mientras no se haya encontrado
            if (elem < i.getElem()) {
                i = i.getLeft(); // Si el elemento es menor, ir al subárbol izquierdo
            } else if (elem > i.getElem()) {
                i = i.getRight(); // Si el elemento es mayor, ir al subárbol derecho
            } else {
                encontrado = true; // Si el elemento es igual, se ha encontrado
            }
        }
        return encontrado; // Retornar si el elemento fue encontrado
    }

    public Nodo deleteNode(Nodo root, int key) {
        // Eliminar un nodo en el árbol binario de búsqueda
        Nodo parent = null;
        Nodo curr = root;

        // Buscar el nodo a eliminar
        while (curr != null && curr.getElem() != key) {
            parent = curr;
            if (key < curr.getElem()) {
                curr = curr.getLeft(); // Ir al subárbol izquierdo
            } else {
                curr = curr.getRight(); // Ir al subárbol derecho
            }
        }

        // Si no se encuentra el nodo
        if (curr == null) {
            return root;
        }

        // Caso 1: El nodo a eliminar es una hoja (no tiene hijos)
        if (curr.getLeft() == null && curr.getRight() == null) {
            if (curr != root) {
                if (parent.getLeft() == curr) {
                    parent.setLeft(null); // Eliminar el nodo del padre
                } else {
                    parent.setRight(null); // Eliminar el nodo del padre
                }
            } else {
                root = null; // Si el nodo es la raíz, el árbol queda vacío
            }
        }

        // Caso 2: El nodo tiene dos hijos
        else if (curr.getLeft() != null && curr.getRight() != null) {
            // Encontrar el sucesor inorden (el menor en el subárbol derecho)
            Nodo successor = getMinimumKey(curr.getRight());

            int val = successor.getElem(); // Almacenar el valor del sucesor

            // Eliminar el sucesor
            deleteNode(root, successor.getElem());

            // Copiar el valor del sucesor al nodo actual
            curr.setElem(val);
        }

        // Caso 3: El nodo tiene un solo hijo
        else {
            Nodo child = (curr.getLeft() != null) ? curr.getLeft() : curr.getRight(); // Elegir el hijo

            // Si el nodo no es la raíz, establecer el padre del nodo al hijo
            if (curr != root) {
                if (curr == parent.getLeft()) {
                    parent.setLeft(child);
                } else {
                    parent.setRight(child);
                }
            } else {
                root = child; // Si el nodo es la raíz, el hijo se convierte en la nueva raíz
            }
        }

        return root; // Retornar la raíz actualizada
    }

    private Nodo getMinimumKey(Nodo node) {
        // Obtener el nodo con el valor mínimo (más a la izquierda)
        Nodo current = node;
        while (current != null && current.getLeft() != null) {
            current = current.getLeft();
        }
        return current; // Retornar el nodo con el valor mínimo
    }
}
