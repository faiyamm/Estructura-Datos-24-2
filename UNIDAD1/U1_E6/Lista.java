package UNIDAD1.U1_E6;

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

    public void setFin(Nodo variable) {
        fin = variable;
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
        System.out.println("Nuevo: " + nuevo.getElem());

        if (inicio == null && fin == null){ // si la lista esta vacía hay que iniciar en el primer elemento
            inicio = nuevo;
            fin = nuevo;
        } else { // pero si sí hay elem, hay que añadir el new elem al final
            fin.setNext(nuevo);
            nuevo.setBack(fin);
            fin = nuevo; // actualizar nodo final
        }
    }

    // mostrar los elementos de la lista
    public void mostrar(){
        if (inicio != null){
            Nodo i = inicio; // iniciar desde el nodo principal
            while (i != null){
                System.out.println(i.getElem()); // mostrar el elem actual
                i = i.getNext(); // siguiente nodo
            }
        } else System.out.println("Lista vacía!!");
    }

    // insertar un elem al inicio de la lista
    public void InsertarInicio(String elem){
        Nodo nuevo = new Nodo();
        nuevo.setElem(elem);

        if (inicio == null) {
            inicio = fin = nuevo;
        } else {
            nuevo.setNext(inicio);
            inicio.setBack(nuevo);
            inicio = nuevo;
        }

    }

    // insertar un elem en medio de la lista
    public void insertarEnmedio(String colado, String elem){
        Nodo i = inicio; // nodo actual
        Nodo nuevo = new Nodo();
        nuevo.setElem(colado); // nuevo elem aka el colado
        boolean estado = false; // indicar estado

        while (i != null) {
            if (elem.equals(i.getElem())) {
                estado = true;
                System.out.println("Encontrado!");

                if (i == inicio) {
                    InsertarInicio(colado); // por si se quiere insertar en el inicio
                } else {
                    i.getBack().setNext(nuevo);
                    nuevo.setNext(i); // enlazar al nodo actual
                    nuevo.setBack(i.getBack());
                    i.setBack(nuevo);
                } break;
            }  i = i.getNext(); // mover al siguiente nodo   
        } if (!estado){
            System.out.println("El elemento " + elem + " no se encontró ");
        }
    }

    
    // borrar elem de la lista
    public boolean borrar(String elem){
        Nodo i = inicio; // actual
        boolean estado = false; // estado

        while (i != null){
            if (elem.equals(i.getElem())){
                estado = true; // elem encontrado

                if (inicio == fin) { // solo tiene un elem
                    inicio = fin = null;
                }
                else if (i == inicio){
                    inicio = inicio.getNext();
                    if (inicio != null) inicio.setBack(null);
                } else if (i == fin) {
                    fin = fin.getBack();
                    if (fin != null){
                        fin.setNext(null);
                    }
                } else{
                    i.getBack().setNext(i.getNext());
                    if (i.getNext() != null) i.getNext().setBack(i.getBack());  
                } System.out.println("Elemento " +elem+ " eliminado");
                return true; 
            } i = i.getNext();
        } 
        System.out.println("El elemento '" + elem + "' no se encuentra.");
        return false;
    }

    // limpiar buffer
    public void limpiar() {
        inicio = fin = null; // Reiniciar los punteros de inicio y fin
    }

    // verificar si lista esta vacía o no
    public boolean vacia() {
        return inicio == null; // La lista está vacía si el puntero es null
    }

    
}
