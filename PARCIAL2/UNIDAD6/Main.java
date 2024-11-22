import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String dato;
        ArregloHash alumnos = new ArregloHash(10);  // tamaño aumentado para mejor dispersión
        int opc = 0;

        do {
            menu();
            System.out.print("Opción: ");
            opc = Integer.parseInt(leer.nextLine());

            switch (opc) {
                case 1:
                    System.out.print("Ingresar nombre: ");
                    dato = leer.nextLine();
                    alumnos.asignaHash(dato);
                    break;
                case 2:
                    System.out.print("Ingresar nombre a buscar: ");
                    dato = leer.nextLine();
                    alumnos.buscar(dato);
                    break;
                case 3:
                    System.out.println("Lista de alumnos:");
                    alumnos.mostrar();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opc != 4);
        leer.close();
    }

    // menú
    public static void menu() {
        System.out.println("\n----------------------------------");
        System.out.println("1. Ingresar nombre");
        System.out.println("2. Buscar nombre");
        System.out.println("3. Mostrar lista de alumnos");
        System.out.println("4. Salir");
        System.out.println("----------------------------------\n");
    }
}
