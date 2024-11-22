/* Programa que maneja una lista doble enlazada en el que se puede realizar difentes manupulaciones a una lista */
package UNIDAD1.U1_E7;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String nombre;
        String colado;

        Lista grupo = new Lista();
        int opcion;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insertar nombre");
            System.out.println("2. Mostrar nombres");
            System.out.println("3. Insertar al inicio");
            System.out.println("4. Borrar nombre");
            System.out.println("5. Insertar en medio");
            System.out.println("6. Buscar nombre");
            //System.out.println("7. Reiniciar");
            System.out.println("7. Mostrar inverso");
            System.out.println("8. Cargar datos");
            System.out.println("9. Guardar datos en archivo");
            System.out.println("10. Salir");
            System.out.print("Elige una opción: ");
            opcion = leer.nextInt();
            leer.nextLine(); // consume newline

            switch (opcion) {
                case 1:
                    System.out.print("Introduce un nombre: ");
                    nombre = leer.nextLine();
                    grupo.insertar(nombre);
                    break;

                case 2: // hacer validacion
                    if (!grupo.vacia()) {
                        grupo.mostrar();
                    } else {
                        System.out.println("No hay elementos");
                    }
                    break;

                case 3:
                    System.out.println("Nombre al inicio: ");
                    nombre = leer.nextLine();
                    grupo.insertarInicio(nombre); // Insertar nombre al inicio de la lista
                    break;

                case 4:
                    if (grupo.vacia()) {
                        System.out.println("No hay elementos para borrar");
                    } else {
                        System.out.print("Introduce el nombre a borrar: ");
                        nombre = leer.nextLine();
                        if (grupo.borrar(nombre)) {
                            System.out.println("Borrado");
                        } else {
                            System.out.println("El elemento no está en la lista");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Nombre a insertar en medio: ");
                    colado = leer.nextLine();
                    System.out.println("Antes de quien: ");
                    nombre = leer.nextLine();
                    grupo.insertarEnmedio(colado, nombre);
                    break;

                case 6: if (!grupo.vacia()){
                    System.out.println("Nombre a borrar: ");
                    nombre = leer.nextLine();
                    if (grupo.borrar(nombre)== true)
                        System.out.println("Nombre borrado...");
                    else
                        System.out.println("El elemento no se encuentra en la lista.");
                    }
                    
                    break;

                case 7: System.out.println("Lista Invertida");
                        if (!grupo.vacia()){
                            grupo.mostrarInverso();
                        } else System.out.println("No hay elementos");
                    break;

                case 8:
                    try (InputStream ins = new FileInputStream("U1_E7/datos.txt");
                        Scanner obj = new Scanner(ins)) {
                        while (obj.hasNextLine()) {
                            grupo.insertar(obj.nextLine());
                        }
                    } catch (Exception e) {
                        System.out.println("Error al cargar datos: " + e.getMessage());
                    }
                    break;
                
                case 9: // guardar datos en archivo Datos.txt
                        if (!grupo.vacia()){
                            grupo.guardarEnArchivo("U1_E7/prueba.txt");
                            System.out.println("==Datos guardados==");
                        } else System.out.println("No hay datos para guardar.");
                        break;
                        
                case 10:
                    System.out.println("Saliendo...");
                    break;
                    
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 10);

        leer.close();
    }
    
    
}
