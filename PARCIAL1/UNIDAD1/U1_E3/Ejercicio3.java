/* Ejercicio 2: Programa que permite al usuario guardar un valor entero en un arreglo de 10 posiciones
y muestra los datos almacenados */

package UNIDAD1.U1_E3;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in); // leer entradas de usuario

        // declarar variables
        int[] a = new int[10];
        int arr[] = new int[10];
        int value;
        int pos;
        int again;

        //fori para mostrar las posiciones del arreglo
        for (int i = 0; i <= 9; i++) {
            System.out.println(i + "=" + a[i]);
        }
        do{ // preguntarle al usuario por un valor
            System.out.println("¿Qué valor deseas guardar?: ");
            value = leer.nextInt();
            System.out.println("¿En qué posición?: ");
            pos = leer.nextInt();

            // validar si la posición esta dentro del rango del arreglo
            if (a[pos] == 0){
                a[pos] = value;
            } else{
                System.out.println("Posición ocupada.");
            } System.out.println("¿Desea volver a intentarlo? 0/1: "); // preguntar al usuario si desea intentar de nuevo
            again = leer.nextInt(); // leer

            // almacenar valor en el arreglo original
            for (int i = 0; i < arr.length; i++) {
                arr[i] = a[i];
            }
        } while (again == 1);

        // arreglo actualizado
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + "=" + arr[i]);
        }

        leer.close();
    }
}
