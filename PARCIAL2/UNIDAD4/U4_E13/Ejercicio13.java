/* Este programa implementa un árbol binario de búsqueda,´
una estructura de datos en la que cada nodo tiene un valor, un hijo
izquierdo y un hijo derecho */

import java.util.Random;
import java.util.Scanner;

public class ejercicio13 {
    public static void main(String[] args) {
        // imprimir título del programa
        System.out.println("Árboles binarios de búsqueda");
        Scanner leer = new Scanner(System.in);

        // declarar e inicializar variables
        int opc = 0; // opción seleccionada por el usuario
        Tree nums = new Tree(); // crear un árbol vacío

        // iniciar menú interactivo
        do {
            menu(); // mostrar el menú
            System.out.print("Opción: ");
            opc = Integer.parseInt(leer.nextLine()); // leer opción seleccionada

            switch (opc) {
                case 0: // salir del programa
                    System.out.println("Saliendo...");
                    break;
                case 1: // insertar elementos ingresados por el usuario
                    System.out.print("Ingrese el número de elementos: ");
                    int n = Integer.parseInt(leer.nextLine()); // leer cantidad de elementos
                    for (int i = 0; i < n; i++) { // iterar para cada elemento
                        System.out.print("Ingrese el elemento " + (i + 1) + ": ");
                        nums.insertar(Integer.parseInt(leer.nextLine())); // insertar elemento
                    }
                    break;

                case 2: // mostrar en preorden
                    System.out.println("Preorden:");
                    nums.mostrarPreorden(nums.getRoot()); // recorrer en preorden
                    System.out.println();
                    break;

                case 3: // mostrar en inorden
                    System.out.println("Inorden:");
                    nums.mostrarInorden(nums.getRoot()); // recorrer en inorden
                    System.out.println();
                    break;

                case 4: // mostrar en postorden
                    System.out.println("Postorden:");
                    nums.mostrarPostorden(nums.getRoot()); // recorrer en postorden
                    System.out.println();
                    break;

                case 5: // mostrar de mayor a menor
                    System.out.println("Mayor a Menor:");
                    nums.mostrarInordenInverso(nums.getRoot()); // recorrer en orden inverso
                    System.out.println();
                    break;

                case 8: // generar un árbol aleatorio
                    System.out.print("Ingrese el número de elementos: ");
                    int n2 = Integer.parseInt(leer.nextLine()); // leer cantidad de elementos
                    Random r = new Random(); // crear objeto Random
                    for (int i = 0; i < n2; i++) { // generar números aleatorios
                        nums.insertar(r.nextInt(100) + 1); // insertar número aleatorio
                    }
                    break;

                case 9: // buscar un número en el árbol
                    System.out.print("Ingrese el número a buscar: ");
                    int num = Integer.parseInt(leer.nextLine()); // leer número a buscar
                    if (nums.buscar(num)) { // verificar si el número está en el árbol
                        System.out.println("El número " + num + " se encuentra en el árbol");
                    } else {
                        System.out.println("El número " + num + " no se encuentra en el árbol");
                    }
                    break;

                default: // manejar opciones inválidas
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opc != 0); // salir cuando la opción sea 0
        leer.close(); // cerrar Scanner
    }

    // método para mostrar el menú
    public static void menu() {
        System.out.println("\n--------------- Menú ---------------");
        System.out.println("1. Insertar árbol: Usuario");
        System.out.println("2. Mostrar Preorden");
        System.out.println("3. Mostrar Inorden");
        System.out.println("4. Mostrar Postorden");
        System.out.println("5. Mostrar Mayor a Menor");
        System.out.println("8. Insertar árbol: Randoms");
        System.out.println("9. Buscar");
        System.out.println("0. Salir");
        System.out.println("-----------------------------------\n");
    }
}