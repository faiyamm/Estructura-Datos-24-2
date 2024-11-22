/* Ejercicio 1: Programa que permite al usuario guardar un valor entero en un arreglo de 10 posiciones */

import java.util.Scanner;

class Ejercicio2 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in); // leer entradas de usuario
        
        // declarar variables
        int[] a = new int[10];
        int value; // valor ingresado por el usuario
        int pos; // posición
        int again; //repetir o no

        // fori para mostrar las posiciones del arreglo
        for (int i = 0; i<=9; i++)
                System.out.println(i + "=" + a[i]); // imprimir todas las posiciones 
        do{
            // preguntarle al usuario por un valor
            System.out.println("¿Qué valor desea guardar?: "); // preguntar al usaurio el valor que quiere almacenar
            value = leer.nextInt(); // leer
            System.out.println("¿En qué posición?: "); // preguntar en qué posición
            pos = leer.nextInt(); // leer

            //validar si la posición esta dentro del rango del arreglo
            if (a[pos] == 0) { // checar que la posición este vacía
                a[pos] = value;}  // almacenar valor en la posición seleccionada
            else {
            System.out.println("Posición ocupada."); // advertir si la posición ya esta tomada
            }
            System.out.println("¿Desea volver a intentarlo? 0/1: "); // preguntar al usuario si desea intentar de nuevo
            again = leer.nextInt(); // leer

            }
        
        while(again == 1); // repetir mientrass el usuario eliga 1

        leer.close();
    }
}

