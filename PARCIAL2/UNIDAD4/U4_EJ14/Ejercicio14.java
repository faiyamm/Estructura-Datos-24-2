/* Programa que implementa un árbol binario de búsqueda que
permite insertar elementos, recorrerlo de varias maneras
(preorden, inorden, postorden y de mayor a menor), buscar un elem y eliminar nodos. */

import java.util.Scanner;

public class ejercicio14 {
    public static void main(String[] args) {
        System.out.println("Arboles");
        Scanner leer = new Scanner(System.in);
        int opc = 0;
        Tree nums = new Tree();

        int array[] = {15, 10, 20, 18, 30};

        do{
            menu();
            System.out.println("Opción: ");
            opc = Integer.parseInt(leer.nextLine());

            switch (opc) {
                case 1: 
                    System.out.println("Ingrese el número de elementos: ");
                    int n = Integer.parseInt(leer.nextLine());
                    for (int i = 0; i < n; i++) {
                        System.out.println("Ingrese el elemento " + (i+1) + ": ");
                        nums.insertar(Integer.parseInt(leer.nextLine()));
                    }
                    break;
            
                case 2: 
                    System.out.println("Pre-Orden:");
                    if (!nums.vacio()){
                        nums.mostrarPreorden(nums.getRoot());
                        System.out.println();
                    } else {
                        System.out.println("El árbol está vacío");
                    }
                    
                    break;
            
                case 3: 
                    System.out.println("Inorden:");
                    if (!nums.vacio()){
                        nums.mostrarInorden(nums.getRoot());
                        System.out.println();
                    } else {
                        System.out.println("El árbol está vacío");
                    }
                    break;
            
                case 4:
                    System.out.println("Post-Orden:");
                    if (!nums.vacio()){
                        nums.mostrarPostorden(nums.getRoot());
                        System.out.println();
                    } else {
                        System.out.println("El árbol está vacío");
                    }
                    break;
            
                case 5:
                    System.out.println("Mayor a Menor:");
                    nums.mostrarInordenInverso(nums.getRoot());
                    System.out.println();
                    break;
            
                case 6:
                    System.out.println("Buscar elemento:");
                    System.out.println("Ingrese el número a buscar: ");
                    int numBuscar = Integer.parseInt(leer.nextLine());
                    if (nums.buscar(numBuscar)) {
                        System.out.println("El número " + numBuscar + " se encuentra en el árbol");
                    } else {
                        System.out.println("El número " + numBuscar + " no se encuentra en el árbol");
                    }
                    break;
            
                case 7:
                    int[] arr = {15, 10, 20, 18, 30}; // 3, 8, 10, 2, 1, 4, 7, 12, 6, 20
                    for (int i = 0; i < arr.length; i++) {
                        nums.insertar(arr[i]);
                    }
                    break;

                case 8:
                    System.out.println("Buscar elemento en arreglo:");
                    System.out.println("Ingrese el número a buscar: ");
                    int numArr = Integer.parseInt(leer.nextLine());
                    buscarEnArr(array, numArr);
                    break;
            
                case 9: // eliminar elemento
                    System.out.println("Ingrese el número a eliminar: ");
                    int numEliminar = Integer.parseInt(leer.nextLine());
                    if (nums.buscar(numEliminar)) {
                        nums.deleteNode(null, opc);
                        System.out.println("El número " + numEliminar + " ha sido eliminado");
                    } else {
                        System.out.println("El número " + numEliminar + " no se encuentra en el árbol");
                    }
                    break;
            
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
            
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
            

        } while (opc != 0);
        leer.close();
    }

    public static void buscarEnArr(int[] arr, int num){
        int cont = 0;
        boolean encontrado = false;
        for (int i = 0; i < arr.length; i++) {
            cont++;
            if (arr[i] == num) {
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            System.out.println("El número " + num + " se encuentra en el arreglo en la posición " + cont); // más las comparaciones
            
        } else {
            System.out.println("El número " + num + " no se encuentra en el arreglo");
        }
    }

    public static void menu() {
        System.out.println("\n-----------------Menú-----------------");
        System.out.println("1. Insertar árbol: Usuario");
        System.out.println("2. Mostrar Pre-Orden");
        System.out.println("3. Mostrar In-Orden");
        System.out.println("4. Mostrar Post-Orden");
        System.out.println("5. Mostrar Mayor a Menor");
        System.out.println("6. Buscar elemento");
        System.out.println("7. Insertar árbol: Arreglo");
        System.out.println("8. Buscar elemento en arreglo");
        System.out.println("9. Eliminar elemento");
        System.out.println("0. Salir");
        System.out.println("--------------------------------------\n");
    }
}
