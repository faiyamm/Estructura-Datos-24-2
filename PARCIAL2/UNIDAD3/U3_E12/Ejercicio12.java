import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        // declarar pilas para las tres torres
        Stack Torre1 = new Stack();
        Stack Torre2 = new Stack();
        Stack Torre3 = new Stack();

        int opc = 0; // declarar opción del menú
        int movimientos = 0; // contador de movimientos
        int fallos = 0; // contador de movimientos inválidos

        inicializar(Torre1); // inicializar la primera torre con discos

        do {
            System.out.println("---------------------------------");
            imprimirTorres(Torre1, Torre2, Torre3); // mostrar las torres
            System.out.println("---------------------------------");
            menu(); // mostrar menú de opciones
            System.out.print("Opción: ");
            opc = Integer.parseInt(leer.nextLine());

            switch (opc) {
                case 1:
                    System.out.println("Mover de 1 a 2 | -->");
                    if (!Torre1.vacia()) {
                        if (validarMov(Torre1, Torre2)) movimientos++;
                        else fallos++;
                    }
                    break;

                case 2:
                    System.out.println("Mover de 1 a 3 | -->");
                    if (!Torre1.vacia()) {
                        if (validarMov(Torre1, Torre3)) movimientos++;
                        else fallos++;
                    }
                    break;

                case 3:
                    System.out.println("Mover de 2 a 3 | -->");
                    if (!Torre2.vacia()) {
                        if (validarMov(Torre2, Torre3)) movimientos++;
                        else fallos++;
                    }
                    break;

                case 4:
                    System.out.println("Mover de 3 a 1 | <--");
                    if (!Torre3.vacia()) {
                        if (validarMov(Torre3, Torre1)) movimientos++;
                        else fallos++;
                    }
                    break;

                case 5:
                    System.out.println("Mover de 3 a 2 | <--");
                    if (!Torre3.vacia()) {
                        if (validarMov(Torre3, Torre2)) movimientos++;
                        else fallos++;
                    }
                    break;

                case 6:
                    System.out.println("Mover de 2 a 1 | <--");
                    if (!Torre2.vacia()) {
                        if (validarMov(Torre2, Torre1)) movimientos++;
                        else fallos++;
                    }
                    break;

                case 8:
                    System.out.println("Reiniciando juego...");
                    Torre1 = new Stack();
                    Torre2 = new Stack();
                    Torre3 = new Stack();
                    inicializar(Torre1); // reiniciar juego
                    movimientos = 0; // reiniciar contador de movimientos
                    fallos = 0; // reiniciar contador de fallos
                    System.out.println("El juego se ha reiniciado.");
                    break;

                case 9:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

            // verificar si se ha ganado el juego
            if (validarGanador(Torre1, Torre2, Torre3)) {
                System.out.println("¡Felicidades! Has ganado el juego.");
                System.out.println("Total de movimientos: " + movimientos);
                System.out.println("Total de fallos: " + fallos);
            } 

        } while (opc != 9);

        leer.close(); // cerrar el scanner
    }

    // inicializar la torre 1 con discos
    public static void inicializar(Stack Torre1) {
        for (int i = 3; i >= 1; i--) {
            Torre1.insertar(i); // insertar discos en orden
        }
    }

    // validar movimientos entre torres
    public static boolean validarMov(Stack Origen, Stack Destino) {
        if (Destino.getHead() == null || Destino.getHead().getElem() > Origen.getHead().getElem()) {
            Destino.insertar(Origen.getHead().getElem());
            Origen.borrar();
            return true; // movimiento válido
        } else {
            System.out.println("WARNING: Movimiento inválido...");
            return false; // movimiento inválido
        }
    }


    // verificar si el jugador ha ganado
    public static boolean validarGanador(Stack Torre1, Stack Torre2, Stack Torre3) {
        // verificar si Torre1 y Torre2 están vacías
        if (Torre1.vacia() && Torre2.vacia()) {
            // contar los discos en Torre3
            Nodo actual = Torre3.getTail(); // empezar desde el nodo base
            int contador = 0;
            while (actual != null) { // recorrer todos los nodos de Torre3
                contador++;
                actual = actual.getNext(); // avanzar al siguiente nodo
            }
            if (contador == 3) { // verificar si Torre3 tiene los 3 discos
                return true; // el jugador ha ganado
            }
        }
        return false; // el jugador aún no ha ganado
    }


    // mostrar menú de opciones
    public static void menu() {
        System.out.println("\n1) Mover --> 1 a 2");
        System.out.println("2) Mover --> 1 a 3");
        System.out.println("3) Mover --> 2 a 3");
        System.out.println("4) Mover <-- 3 a 1");
        System.out.println("5) Mover <-- 3 a 2");
        System.out.println("6) Mover <-- 2 a 1");
        System.out.println("8) Nuevo juego");
        System.out.println("9) Salir\n");
    }

    // imprimir estado de las torres
    public static void imprimirTorres(Stack Torre1, Stack Torre2, Stack Torre3) {
        int max_height = 5; // definir altura máxima
        Stack[] torres = { Torre1, Torre2, Torre3 };

        System.out.println("  1  |  2  |  3 ");
        System.out.println("---------------");

        for (int i = max_height - 1; i >= 0; i--) {
            for (Stack torre : torres) {
                Nodo actual = torre.getTail();
                int cont = 0;
                boolean encontrado = false;

                while (actual != null) {
                    if (cont == i) {
                        System.out.printf(" %s |", crearAro(actual.getElem()));
                        encontrado = true;
                        break;
                    }
                    actual = actual.getNext();
                    cont++;
                }
                if (!encontrado) System.out.print("     |");
            }
            System.out.println();
        }
    }

    // crear representación del aro con asteriscos
    public static String crearAro(int disco) {
        String aro = "*".repeat(disco);
        return String.format("%5s", aro);
    }
}
