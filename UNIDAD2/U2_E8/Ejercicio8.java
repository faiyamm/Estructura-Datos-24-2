/* 
Ejercicio 8: Programa que permite al usuario interactuar con una lista enlazada simple.
El usuario puede:
1. Insertar elementos al final de la lista.
2. Eliminar el primer elemento de la lista.
3. Mostrar todos los elementos de la lista.
La lista se gestiona mediante nodos enlazados.
*/

import java.util.Scanner;

public class ejercicio8 {
    public static void main(String[] args) {
        // declarar el lector de entradas
        Scanner leer = new Scanner(System.in);

        // declarar variables
        String nombre;
        Lista grupo = new Lista();
        int opc = 0;

        do {
            menu();
            System.out.println("Opción: ");
            opc = Integer.parseInt(leer.nextLine());

            switch (opc) {
                case 1:
                    System.out.println("Nombre para agregar: ");
                    // leer el nombre e insertar en la lista
                    nombre = leer.nextLine();
                    grupo.insertar(nombre);
                    break;

                case 2:
                    // solo se elimina el primer elemento
                    grupo.borrar();
                    break;

                case 3:
                    // mostrar los elementos de la lista
                    grupo.mostrar();
                    break;

                case 4:
                    System.out.println("Saliendo.....");
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }

        } while (opc != 4); // verificar condición de salida
        leer.close();
    }

    public static void menu() {
        System.out.println("\n-----------------Listas simples---------------------");
        System.out.println("1. Insertar");
        System.out.println("2. Borrar primer elemento");
        System.out.println("3. Mostrar");
        System.out.println("4. Salir");
        System.out.println("----------------------------------------------------\n");
    }
}
