/* Porgrama similar al del ejercicio 5, con diferencias */
package UNIDAD1.U1_E6;

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in); // leer entradas de usuario
        
        // declarar variables 
        String nombre;
        int opc;
        // lista
        Lista grupo = new Lista();

        do{
            menu();
            System.out.println("Opción: ");
            opc = Integer.parseInt(leer.nextLine());

            switch (opc) {
                case 1: // insertar elem al final
                    System.out.println("Ingresar nombre: ");
                    nombre = leer.nextLine(); // leer nombre
                    grupo.insertar(nombre);
                    break;
                
                case 2: // mostrar lista elems
                    if (!grupo.vacia())
                        grupo.mostrar();
                    else
                        System.out.println("No hay elementos :(");
                    break;

                case 3: // insertar elem al inicio
                    System.out.println("Nombre al inicio: ");
                    nombre = leer.nextLine(); // leer nombre
                    if (grupo.vacia())
                        grupo.insertar(nombre);
                    else
                        grupo.InsertarInicio(nombre);
                    break;

                case 4: // borrar elem
                    if (!grupo.vacia()){
                        System.out.println("Nombre que desea borrar: ");
                        nombre = leer.nextLine(); // leer nombre
                        if (grupo.borrar(nombre)) System.out.println("BORRADO");
                        else System.out.println("El elemento no está en la lista.");
                    } else System.out.println("No hay elementos para borrar :/");
                    break;
                
                case 5: // insertar elem en una posición
                    System.out.println("Nombre a insertar: ");
                    String colado = leer.nextLine(); // leer nombre colado
                    System.out.println("Antes de quién: ");
                    nombre = leer.nextLine(); // leer nombre
                    grupo.insertarEnmedio(colado, nombre);
                    break;

                case 6: // reiniciar elem
                    grupo.limpiar();
                    System.out.println("Lista reiniciada :D");
                    break;
                
                case 9: // salir
                    System.out.println("Saliendo....");
                    break;
                
                default: System.out.println("Opción invalida!!");
                
            
            }

        } while (opc != 9); // seguir mientras el usuario no eliga 9

        leer.close();
    }

    public static void menu(){
        System.out.println("=======Lista simple========");
        System.out.println("1. Insertar\n2. Mostrar\n3. Insertar al inicio\n4. Borrar nombre\n5. Insertar nombre en medio\n6. Reiniciar\n9. Salir");
    }
    
}
