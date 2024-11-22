public class Stack {
    private Nodo head = null;
    private Nodo tail = null;

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

    // método limpiar (reiniciar)
    public void limpiar(){
        head = tail = null;
    }

    // método vacía
    public boolean vacia(){
        return head == null;
    }

    // método de insertar
    public void insertar(String Elem){
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
}
