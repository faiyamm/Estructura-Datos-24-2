/* Este ejercicio implementa una pila de estructura LIFO (last in, first out)
para almacenar y gestionar nombres. */

import java.util.Scanner;

public class ej11 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        Stack pila = new Stack(); // pila para almacenar los nombres
        int opc;
        String name = ""; // variable para almacenar el nombre

        do {
            menu();
            System.out.print("Opción: ");
            opc = Integer.parseInt(leer.nextLine());

            switch (opc) {
                case 1: 
                    System.out.print("Nombre para agregar: ");
                    name = leer.nextLine();
                    pila.insertar(name); // insertar nombre a la pila
                    break;
                case 2:
                    if (!pila.vacia()) {
                        System.out.println("Elementos de la pila: ");
                        pila.mostrar(); // mostrar todos los elementos de la pila
                    } else {
                        System.out.println("Pila vacía, no hay elementos para mostrar.");
                    }
                    break;
                case 3: // solo se elimina el primer elemento de la pila
                    if (!pila.vacia()) { // verificar si la pila no está vacía
                        pila.borrar(); // eliminar el elemento superior
                        System.out.println("Primer elemento eliminado");
                    } else {
                        System.out.println("La pila está vacía, no hay elementos para borrar.");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo.....");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opc != 4);
        leer.close();
    }

    public static void menu() {
        System.out.println("\n-------------------------------------");
        System.out.println("1.- Insertar");
        System.out.println("2.- Mostrar");
        System.out.println("3.- Borrar");
        System.out.println("4.- Salir");
        System.out.println("-------------------------------------\n");
    }
}