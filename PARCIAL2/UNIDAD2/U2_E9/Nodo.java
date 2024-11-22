import java.time.LocalDateTime;

public class Nodo {
    private String elem; // nombre del paciente
    private Nodo next;   // siguiente nodo en la lista
    private int turno;   // turno del paciente
    private LocalDateTime hora;   // hora de llegada del paciente

    // Constructor to initialize a node with all attributes
    public Nodo(String elem, int turno, LocalDateTime hora) {
        this.elem = elem;
        this.turno = turno;
        this.hora = hora;
        this.next = null; // by default, the next node is null
    }

    // Empty constructor
    public Nodo() {}

    // Setters and Getters
    public void setElem(String variable) {
        elem = variable;
    }

    public String getElem() {
        return elem;
    }

    public void setNext(Nodo variable) {
        next = variable;
    }

    public Nodo getNext() {
        return next;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    // Override toString to display patient info
    @Override
    public String toString() {
        return "Paciente [Nombre: " + elem + ", Turno: " + turno + ", Hora: " + hora + "]";
    }
}
