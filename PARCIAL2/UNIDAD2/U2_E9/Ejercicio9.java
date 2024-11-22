import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ejercicio9 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in); // leer entradas de usuario
    
        String nombre;
        Lista fila1 = new Lista(); // lista para fila 1
        Lista fila2 = new Lista(); // lista para fila 2
        Lista unifila = new Lista(); // lista para la unifila
        int opc = 0;
    
        // cargar datos automáticamente desde archivos
        try {
            cargarDatos("C:/Users/kokow/OneDrive/Documentos/java/data_structure/UNIDAD2/ejercicio9/fila1.txt", fila1);
            cargarDatos("C:/Users/kokow/OneDrive/Documentos/java/data_structure/UNIDAD2/ejercicio9/fila2.txt", fila2);
            System.out.println("Datos cargados de Fila 1:");
            fila1.mostrar();
            System.out.println("Datos cargados de Fila 2:");
            fila2.mostrar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    
        do {
            menu();
            System.out.print("Opción: ");
            opc = Integer.parseInt(leer.nextLine());
        
            switch (opc) {
                case 1: // insertar en fila 1
                    System.out.print("Nombre para agregar: ");
                    // leer nombre y convertirlo a mayúsculas
                    nombre = leer.nextLine().toUpperCase();
                    fila1.insertar(nombre, 0, LocalDateTime.now()); // Add patient with turno and current time
                    break;
                case 2: // mostrar filas separadas
                    System.out.println("Fila 1: \n");
                    fila1.mostrar(); // mostrar fila 1
                    System.out.println("===================================");
                    System.out.println("Fila 2: \n");
                    fila2.mostrar(); // mostrar fila 2
                    break; 
                case 3: // buscar paciente
                    System.out.println("Nombre que desea buscar: ");
                    nombre = leer.nextLine().toUpperCase();
                    if (!fila1.buscar(nombre)) { // verificar si no está en fila 1
                        fila2.buscar(nombre); // buscar en fila 2
                    }
                    break;
                case 4: // borrar primer elemento de fila 1
                    fila1.borrar();
                    System.out.println("Primer elemento: BORRADO");
                    break;
                case 5: // unificar filas
                    System.out.println("Unifila: \n");
                    unifila.combinar(fila1, fila2); // combinar filas en una sola
                    unifila.mostrar(); // mostrar unifila
                    break;
                case 6:
                    System.out.println("Saliendo.....");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opc != 6);
        
        leer.close();
    }
    

    // cargar datos desde un archivo local .txt
    public static void cargarDatos(String archivo, Lista fila) throws Exception {
        InputStream ins = new FileInputStream(archivo); // abrir archivo
        Scanner obj = new Scanner(ins); // leer archivo línea por línea
        int turno = 1; // iniciar contador de turnos
    
        System.out.println("Cargando datos desde el archivo: " + archivo);
    
        while (obj.hasNextLine()) {
            String linea = obj.nextLine();
            if (!linea.contains(",")) { // verificar formato de línea
                // Usar la hora actual
                fila.insertar(linea, turno, LocalDateTime.now());
                System.out.println("Insertando: " + linea + " con hora actual");
                turno++;
            } else {
                System.out.println("Línea con formato incorrecto: " + linea);
            }
        }
        obj.close();
    }
    
    public static void menu() {
        System.out.println("\n-------------- Listas simples --------------");
        System.out.println("1. Insertar");
        System.out.println("2. Mostrar separadas");
        System.out.println("3. Buscar");
        System.out.println("4. Borrar de fila 1");
        System.out.println("5. Unificar");
        System.out.println("6. Salir");
    }
}