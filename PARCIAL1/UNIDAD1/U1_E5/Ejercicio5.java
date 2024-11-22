/* Ejercicio 5: Programa que implementa una lista simple enlazada que realiza varias acciones para manejarla */

package UNIDAD1.U1_E5;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in); // leer entradas de usuario
        
        // declarar variables 
        String nombre, colado;
        int opc = 0;
        // lista
        Lista grupo = new Lista();

        do{
            menu();
            System.out.println("Opción: ");
            opc = Integer.parseInt(leer.nextLine());

            switch (opc) {
                case 1: // insertar elem al final
                    System.out.println("Nombre para agregar: ");
                    nombre = leer.nextLine(); // leer nombre
                    grupo.insertar(nombre);
                    break;
                
                case 2: // mostrar lista elems
                    System.out.println("====LISTA====");
                    grupo.mostrar();
                    break;

                case 3: // insertar elem al inicio
                    System.out.println("Nombre al inicio: ");
                    nombre = leer.nextLine(); // leer nombre
                    grupo.InsertarInicio(nombre);
                    break;

                case 4: // buscar elem 
                    System.out.println("Buscar el nombre: ");
                    nombre = leer.nextLine(); // leer nombre
                    grupo.Buscar(nombre);
                    break;
                
                case 5: // insertar elem en una posición
                    System.out.println("Nombre a insertar: ");
                    colado = leer.nextLine(); // leer nombre colado
                    System.out.println("Antes de quién: ");
                    nombre = leer.nextLine(); // leer nombre
                    grupo.insertarEnmedio(colado, nombre);
                    break;

                case 6: // borrar elem
                    System.out.println("Nombre que desea borrar: ");
                    nombre = leer.nextLine(); // leer nombre
                    grupo.borrar(nombre);
                    break;
            
            }

        } while (opc != 9); // seguir mientras el usuario no eliga 9

        leer.close();
    }

    public static void menu(){
        System.out.println("=======Lista simple========");
        System.out.println("1. Insertar\n2. Mostrar\n3. Insertar al inicio\n4. Encontrar nombre\n5. Insertar nombre en medio\n6. Borrar\n9. Salir");
    }
    
}
