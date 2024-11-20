public class Nodo {
    private int elem;
    private Nodo next; //cuerda que une a otro elemento
    private Nodo back;

    //set asignacion o coloca elemento de la caja
    //mas adelante se cambiaran el nombre de las variables
    public void setElem(int variable){
        elem = variable; //adaptar en unas 2 semanas
    }
    //get permite visualizar el contenido, regresa
    public int getElem(){
        return elem;
    }

    public void setNext(Nodo variable){
        next = variable;
    }
    public Nodo getNext(){
        return next;
    }
    public Nodo getBack() {
        return back;
    }
    public void setBack(Nodo variable) {
        this.back = variable;
    }
}