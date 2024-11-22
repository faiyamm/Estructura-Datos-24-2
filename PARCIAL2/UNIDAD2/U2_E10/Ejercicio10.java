/* Juego de serpientes y escaleras implementando listas */

import java.util.Scanner;

public class ejercicio10 {
    private static Board tablero = new Board();

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        Lista jug1 = new Lista();
        Lista jug2 = new Lista();
        Lista jug3 = new Lista();

        int turno = 1;
        int dado = 0;
        int opc = 0;
        String resp;

        do {
            menu();
            tablero.actualizarPosiciones(jug1, jug2, jug3);
            tablero.dibujarTablero();
            System.out.print("\nOpción: ");
            opc = Integer.parseInt(leer.nextLine());

            switch (opc) {
                case 1:
                    nuevoJuego(jug1, jug2, jug3);
                    break;
                case 2:
                    // Mostrar de quién es el turno
                    System.out.println("\nTurno del Jugador " + turno);
                    
                    // Tirar el dado
                    dado = (int)(Math.random() * 6) + 1;
                    System.out.println("Dado: " + dado);

                    // Manejar las reglas especiales del dado
                    if (dado == 5) {
                        System.out.print("¿Avanzar o quedarte? (A/Q): ");
                        resp = leer.nextLine().toUpperCase();
                        if (resp.equals("A")) {
                            turno = avanza(turno, dado, jug1, jug2, jug3);
                        } else {
                            turno = cambiarTurno(turno);
                            System.out.println("Te quedas en la misma posición");
                        }
                    } else if (dado == 6) {
                        System.out.print("¿Avanzar o regresar a la última posición? (A/R): ");
                        resp = leer.nextLine().toUpperCase();
                        if (resp.equals("A")) {
                            turno = avanza(turno, dado, jug1, jug2, jug3);
                        } else {
                            turno = regresa(turno, jug1, jug2, jug3);
                        }
                    } else { // dado del 1 al 4
                        turno = avanza(turno, dado, jug1, jug2, jug3);
                    }

                    // Mostrar posiciones actuales
                    mostrarPosiciones(jug1, jug2, jug3);
                    break;
                case 3:
                    mostrarPosiciones(jug1, jug2, jug3);
                    break;
                case 9:
                    System.out.println("¡Gracias por jugar!");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (!meta(jug1, jug2, jug3) && opc != 9);

        // Mostrar el ganador
        if (meta(jug1, jug2, jug3)) {
            String msg = (jug1.getFin() != null && jug1.getFin().getElem() == 25) ? "¡El Jugador 1 ganó!" :
                        (jug2.getFin() != null && jug2.getFin().getElem() == 25) ? "¡El Jugador 2 ganó!" :
                        (jug3.getFin() != null && jug3.getFin().getElem() == 25) ? "¡El Jugador 3 ganó!" : 
                        "Empate";
            System.out.println("\n" + msg);
        }

        leer.close();
    }

    public static void mostrarPosiciones(Lista jug1, Lista jug2, Lista jug3) {
        System.out.println("\nPosiciones actuales:");
        System.out.println("Jugador 1: " + (jug1.getFin() != null ? jug1.getFin().getElem() : 0));
        System.out.println("Jugador 2: " + (jug2.getFin() != null ? jug2.getFin().getElem() : 0));
        System.out.println("Jugador 3: " + (jug3.getFin() != null ? jug3.getFin().getElem() : 0));
    }

    public static int regresa(int turno, Lista j1, Lista j2, Lista j3) {
        switch (turno) {
            case 1:
                if (j1.getFin() != null) {
                    j1.borrarUltimo();
                }
                turno = 2;
                break;
            case 2:
                if (j2.getFin() != null) {
                    j2.borrarUltimo();
                }
                turno = 3;
                break;
            case 3:
                if (j3.getFin() != null) {
                    j3.borrarUltimo();
                }
                turno = 1;
                break;
        }
        return turno;
    }

    public static int avanza(int turno, int num, Lista j1, Lista j2, Lista j3) {
        switch (turno) {
            case 1:
                if (j1.getInicio() == null) {
                    j1.insertar(num);
                } else {
                    int nuevaPos = j1.getFin().getElem() + num;
                    if (nuevaPos <= 25) {
                        nuevaPos = ladder(nuevaPos);
                        nuevaPos = snake(nuevaPos);
                        j1.insertar(nuevaPos);
                    } else {
                        System.out.println("¡Te pasaste! Te quedas donde estabas");
                    }
                }
                System.out.println("Jugador 1 está en la posición: " + j1.getFin().getElem());
                turno = 2;
                break;
            case 2:
                if (j2.getInicio() == null) {
                    j2.insertar(num);
                } else {
                    int nuevaPos = j2.getFin().getElem() + num;
                    if (nuevaPos <= 25) {
                        nuevaPos = ladder(nuevaPos);
                        nuevaPos = snake(nuevaPos);
                        j2.insertar(nuevaPos);
                    } else {
                        System.out.println("¡Te pasaste! Te quedas donde estabas");
                    }
                }
                System.out.println("Jugador 2 está en la posición: " + j2.getFin().getElem());
                turno = 3;
                break;
            case 3:
                if (j3.getInicio() == null) {
                    j3.insertar(num);
                } else {
                    int nuevaPos = j3.getFin().getElem() + num;
                    if (nuevaPos <= 25) {
                        nuevaPos = ladder(nuevaPos);
                        nuevaPos = snake(nuevaPos);
                        j3.insertar(nuevaPos);
                    } else {
                        System.out.println("¡Te pasaste! Te quedas donde estabas");
                    }
                }
                System.out.println("Jugador 3 está en la posición: " + j3.getFin().getElem());
                turno = 1;
                break;
        }
        return turno;
    }

    // Simplificado para usar el mapa del tablero
    public static int ladder(int posicion) {
        return Board.getEscalera().getOrDefault(posicion, posicion);
    }

    // Simplificado para usar el mapa del tablero
    public static int snake(int posicion) {
        return Board.getSerpiente().getOrDefault(posicion, posicion);
    }

    public static void menu() {
        System.out.println("\n=== SERPIENTES Y ESCALERAS ===");
        System.out.println("1. Nuevo Juego");
        System.out.println("2. Tirar dado");
        System.out.println("3. Ver posiciones");
        System.out.println("9. Salir\n");
    }

    public static void nuevoJuego(Lista jug1, Lista jug2, Lista jug3) {
        jug1.reiniciar();
        jug2.reiniciar();
        jug3.reiniciar();
        jug1.insertar(0);
        jug2.insertar(0);
        jug3.insertar(0);
        System.out.println("¡Nuevo juego iniciado! Todos los jugadores están en la posición 0.");
    }

    public static int cambiarTurno(int turno) {
        return turno == 1 ? 2 : (turno == 2 ? 3 : 1);
    }

    public static boolean meta(Lista jug1, Lista jug2, Lista jug3) {
        return (jug1.getFin() != null && jug1.getFin().getElem() == 25) ||
               (jug2.getFin() != null && jug2.getFin().getElem() == 25) ||
               (jug3.getFin() != null && jug3.getFin().getElem() == 25);
    }
}