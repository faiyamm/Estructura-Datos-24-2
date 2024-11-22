import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Lista {
    private Nodo inicio;
    private Nodo fin;

    public Lista() {
        inicio = null;  // inicializar el inicio de la lista como null
        fin = null;     // inicializar el fin de la lista como null
    }

    // Setter and getter for inicio and fin
    public void setInicio(Nodo variable) {
        inicio = variable;  // establecer el inicio de la lista
    }

    public Nodo getInicio() {
        return inicio;  // devolver el inicio de la lista
    }

    public void setFin(Nodo variable) {
        fin = variable;  // establecer el fin de la lista
    }

    public Nodo getFin() {
        return fin;  // devolver el fin de la lista
    }

    // insertar datos
    public void insertar(String elem) {
        Nodo nuevo = new Nodo();  // crear un nuevo nodo
        nuevo.setElem(elem);      // asignar el valor al nodo

        if (inicio == null) {  // verificar si la lista está vacía
            inicio = nuevo;    // si está vacía, establecer el nuevo nodo como inicio
            fin = nuevo;       // y también como fin
        } else {
            fin.setNext(nuevo);  // si no está vacía, enlazar el nodo nuevo al final
            fin = nuevo;         // actualizar el fin de la lista
        }
    }

    // mostrar datos
    public void mostrar() {
        if (inicio == null) {  // verificar si la lista está vacía
            System.out.println("La lista está vacía.");  // mensaje si está vacía
            return;  // salir del método
        }
        Nodo i = inicio;  // iniciar desde el primer nodo
        while (i != null) {  // recorrer todos los nodos de la lista
            if (i.getElem().equals("\n")) {
                System.out.println();  // imprimir salto de línea si se encuentra un salto de línea
            } else {
                System.out.print(i.getElem() + " ");  // imprimir cada elemento con un espacio
            }
            i = i.getNext();  // mover al siguiente nodo
        }
    }

    // reiniciar la lista
    public void reiniciar() {
        inicio = fin = null;  // reiniciar inicio y fin a null
    }

    // Cargar datos desde un archivo
    public void cargarArchivo(String archivo) throws Exception {
        InputStream ins = new FileInputStream(archivo);  // abrir el archivo de entrada
        Scanner obj = new Scanner(ins);  // crear un objeto Scanner para leer el archivo

        if (!obj.hasNextLine()) {  // verificar si el archivo está vacío
            throw new Exception("El archivo está vacío.");  // lanzar excepción si está vacío
        }

        System.out.println("Cargando datos desde el archivo: " + archivo);  // mensaje de carga
        while (obj.hasNextLine()) {  // leer línea por línea
            String linea = obj.nextLine();
            // Limpiar signos de puntuación y dividir en palabras
            String[] palabras = linea.replaceAll("[^a-zA-Z0-9 ]", "").split("\\s+");

            // Insertar cada palabra en la lista como un nodo separado
            for (String palabra : palabras) {
                insertar(palabra);  // insertar cada palabra como un nodo
            }

            insertar("\n");  // insertar un salto de línea como marcador de fin de línea
        }
        obj.close();  // cerrar el Scanner
    }

    // Guardar los datos invertidos en un archivo
    public void guardarArchivoInvertido() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("/workspaces/Estructura-Datos-24-2/EXAMEN/invertido.txt"));  // abrir el archivo para escritura
        Nodo aux = inicio;  // iniciar desde el primer nodo

        boolean firstLine = true;  // para evitar el salto de línea al principio
        while (aux != null) {  // recorrer todos los nodos de la lista
            if (aux.getElem().equals("\n")) {  // verificar si es un salto de línea
                if (!firstLine) {
                    bw.newLine();  // agregar salto de línea después de la primera
                }
            } else {
                bw.write(aux.getElem() + " ");  // escribir el contenido en el archivo
                firstLine = false;  // después de la primera línea, ya no se ignora el salto
            }
            aux = aux.getNext();  // mover al siguiente nodo
        }
        bw.close();  // cerrar el BufferedWriter
    }

    // Limpiar el contenido de un archivo
    public void limpiarArchivo(String path) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {  // abrir el archivo en modo escritura
            writer.write("");  // escribir una cadena vacía para limpiar el archivo
        }
    }

    // Invertir los elementos de la lista
    public void invertir() {
        Nodo actual = inicio;  // asegurar que 'inicio' es la cabeza de la lista
        Nodo anterior = null;
        Nodo siguiente = null;

        while (actual != null) {  // recorrer todos los nodos de la lista
            siguiente = actual.getNext();  // guardar el siguiente nodo
            actual.setNext(anterior);      // invertir el enlace del nodo
            anterior = actual;             // mover 'anterior' hacia adelante
            actual = siguiente;            // mover 'actual' hacia adelante
        }

        inicio = anterior;  // 'anterior' ahora es la nueva cabeza de la lista
    }
}