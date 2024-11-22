public class Tarea implements Comparable<Tarea> {
    private int prioridad;
    String descripcion;

    public Tarea(int prioridad, String descripcion) {
        this.prioridad = prioridad;
        this.descripcion = descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Implementación del método compareTo para definir el orden de prioridad en la cola
    @Override
    public int compareTo(Tarea otra) {
        return Integer.compare(this.prioridad, otra.prioridad);
    }

    @Override // Método toString para representar la tarea como un String
    public String toString() {
        return "Prioridad: " + prioridad + ", Descripción: " + descripcion;
    }
}
