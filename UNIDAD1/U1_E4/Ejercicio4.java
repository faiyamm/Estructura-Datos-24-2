

package UNIDAD1.U1_E4;

public class Ejercicio4 {
    public static void main(String[] args) {
        // declarar variables
        // int variable = 24;
        Nodo caja = new Nodo(); // 1er nodo para la lista enlazada

        // 1er elemento
        System.out.println("Primer elemento");
        caja.mascota = "Firulais"; // nombre del perrito
        System.out.println(caja.mascota); // imprimir firulais
        System.out.println(caja.siguiente); // siguiente nodo = nulo

        // 2do elemento
        System.out.println("Segundo elemento");
        Nodo cajota = new Nodo(); // 2do nodo para la lista enlazada
        cajota.mascota = "Oso panda"; // nombre de la mascota
        caja.siguiente = cajota; // enlazar 1er nodo con el 2do e.j firulais -> oso panda

        System.out.println(cajota.mascota); // imprimir oso panda
        System.out.println(cajota.siguiente); // siguiente nodo = nulo
        System.out.println(caja.siguiente); // imprimir el nodo que sigue del 1er nodo

        // imprimir cajota, memoria
        System.out.println(cajota);
    }
    
}
