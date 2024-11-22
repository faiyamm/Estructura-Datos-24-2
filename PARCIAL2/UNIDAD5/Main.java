/* Programa que implementa una cola de prioridad (PriorityQueue)
 * para gestionar tareas, donde cada tarea tiene una prioridad asociada.
 */

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // Colas con prioridad: Crear una cola de tareas donde se ordenarán según su prioridad
        PriorityQueue<Tarea> colaPrioridad = new PriorityQueue<>();

        // agregar tareas con diferentes prioridades: Se agregan varias tareas con prioridades asignadas
        colaPrioridad.add(new Tarea(10, "Matematicas"));
        colaPrioridad.add(new Tarea(5, "Historia"));
        colaPrioridad.add(new Tarea(3, "Estructuras de datos"));
        colaPrioridad.add(new Tarea(1, "Paradigmas de la programación"));

        // extraer tareas en orden de prioridad: La cola automáticamente ordena las tareas
        // de acuerdo con su prioridad (menor prioridad -> mayor prioridad)
        System.out.println("Tareas extraídas en orden de prioridad:\n");
        while (!colaPrioridad.isEmpty()) {
            Tarea tarea = colaPrioridad.poll(); // extraer la tarea con mayor prioridad
            System.out.println(tarea.toString()); // mostrar la tarea extraída
        }

        // eliminar tareas con una prioridad específica (prioridad 10)
        // verificar si la tarea tiene prioridad 10
        colaPrioridad.removeIf(tarea -> tarea.getPrioridad() == 10);

        // eliminar tarea con descripción "Redaccion"
        // verificar si la tarea tiene la descripción "Redaccion"
        colaPrioridad.removeIf(tarea -> tarea.getDescripcion().equals("Redaccion"));
    }
}