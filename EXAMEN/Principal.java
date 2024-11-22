import java.util.Scanner;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String origen = "/workspaces/Estructura-Datos-24-2/EXAMEN/archivo.txt"; // declarar archivo de origen
        int opc;

        Lista elems = new Lista(); // declarar lista para almacenar los elementos

        do {
            menu(); // mostrar el menú de opciones
            System.out.print("Opción: ");
            opc = Integer.parseInt(leer.nextLine()); // leer la opción seleccionada

            switch (opc) {
                case 1: System.out.println("Cargando archivo...");
                    try {
                        elems.cargarArchivo(origen);
                    } catch (Exception e) {
                        System.out.println("Error al cargar el archivo: " + e.getMessage()); // manejar error de carga
                    }
                    break;
                case 2: System.out.println("Invirtiendo...");
                    elems.invertir(); // invertir el contenido de la lista
                    break;
                case 3: System.out.println("Guardando archivo invertido...");
                    try {
                        elems.guardarArchivoInvertido();
                    } catch (Exception e) {
                        System.out.println("Error al guardar el archivo: " + e.getMessage()); // manejar error de guardado
                    }
                    break;
                case 4: System.out.println("Mostrando archivo invertido...");
                    elems.mostrar(); // mostrar el contenido invertido
                    break;
                case 5: System.out.println("Limpiando 'invertido.txt'...");
                    try {
                        elems.limpiarArchivo("/workspaces/Estructura-Datos-24-2/EXAMEN/invertido.txt");
                    } catch (IOException e) {
                        System.out.println("Error al limpiar el archivo: " + e.getMessage());
                    }
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while(opc != 9); // continuar hasta que el usuario seleccione salir


        public static void menu() {
            System.out.println("1. Cargar archivo");
            System.out.println("2. Invertir archivo");
            System.out.println("3. Guardar archivo");
            System.out.println("4. Mostrar archivo invertido");
            System.out.println("5. Limpiar invertido.txt");
            System.out.println("9. Salir");
        }
    }
}