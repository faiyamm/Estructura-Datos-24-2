public class Stack {
    private Nodo head = null;
    private Nodo tail = null;
    private int cont = 0;
    
    public Nodo getHead() {
        return head;
    }
    public void setHead(Nodo head) {
        this.head = head;
    }
    public Nodo getTail() {
        return tail;
    }
    public void setTail(Nodo tail) {
        this.tail = tail;
    }

    // método vacía
    public boolean vacia(){
        return head == null;
    }

    // método limpiar (reiniciar)
    public void limpiar(){
        head = tail = null;
    }

    // método de insertar
    public void insertar(int Elem){
        Nodo nuevo = new Nodo();
        nuevo.setElem(Elem);
        if(head == null && head == tail){
            head = tail = nuevo;
        } else {
            head.setNext(nuevo);
            head = nuevo;
        }
    }

    // método de mostrar
    public void mostrar(){
        if (!vacia()){
            Stack aux = new Stack();
            while(head != null){
                System.out.println(head.getElem());
                aux.insertar(head.getElem());
                this.borrar();
            }
            while(aux.head != null){
                this.insertar(aux.head.getElem());
                aux.borrar();
            }
        }
    }

    // método borrar
    public void borrar(){
        if(head == tail){
            head = tail = null;
        } else {
            Nodo i = tail;
            while(i.getNext() != head){
                i = i.getNext();
            } i.setNext(null);
            head = i;
        }
    }

    // método para validar si el jugador ya ganó
    // status de ganador de las torres de hanoi
    public boolean validarGanador() {
        int cont = 0;
        if (!vacia()) {
            Stack aux = new Stack();
            while (head != null) {
                aux.insertar(head.getElem());
                this.borrar();
                cont++;
            } 
            while (aux.head != null) {
                this.insertar(aux.head.getElem());
                aux.borrar();
            }
            if (cont == 5) {
                System.out.println("¡Felicidades! Has completado el juego.");
                return true;
            }
        }
        return false;
    }
}