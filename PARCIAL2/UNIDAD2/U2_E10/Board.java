import java.util.HashMap;
import java.util.Map;

public class Board {
    private static final int TABLERO_TAM = 25;
    private static Map<Integer, Integer> serpiente = new HashMap<>();
    private static Map<Integer, Integer> escalera = new HashMap<>();
    private String[][] posiciones;

    public Board() {
        // Inicializar el array de posiciones
        posiciones = new String[5][5];
        
        // Inicializar serpientes y escaleras
        serpiente.put(24, 17);
        serpiente.put(21, 10);
        serpiente.put(9, 2);

        escalera.put(6, 11);
        escalera.put(15, 18);
        escalera.put(8, 20);
    }

    public void actualizarPosiciones(Lista jug1, Lista jug2, Lista jug3) {
        // Limpiar el tablero
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                posiciones[i][j] = " ";
            }
        }

        // Colocar jugadores en sus posiciones
        if (jug1.getFin() != null) {
            colocarJugador(jug1.getFin().getElem(), "J1");
        }
        if (jug2.getFin() != null) {
            colocarJugador(jug2.getFin().getElem(), "J2");
        }
        if (jug3.getFin() != null) {
            colocarJugador(jug3.getFin().getElem(), "J3");
        }
    }

    private void colocarJugador(int posicion, String jugador) {
        if (posicion > 0 && posicion <= 25) {
            int fila = 4 - ((posicion - 1) / 5);
            int col = (posicion - 1) % 5;
            posiciones[fila][col] = jugador;
        }
    }

    public void dibujarTablero() {
        // Borde superior
        for (int i = 0; i < 5; i++) {
            System.out.print("+----");
        }
        System.out.println("+");

        // Dibujar tablero
        for (int fila = 0; fila < 5; fila++) {
            for (int col = 0; col < 5; col++) {
                int num = (4 - fila) * 5 + col + 1;
                
                System.out.print("| ");
                if (posiciones[fila][col] != " ") {
                    System.out.print(posiciones[fila][col] + " ");
                } else if (serpiente.containsKey(num)) {
                    System.out.print("S ");
                } else if (escalera.containsKey(num)) {
                    System.out.print("E ");
                } else {
                    System.out.print(String.format("%2d", num));
                }
            }
            System.out.println("|");
            
            // Línea horizontal después de cada fila
            for (int i = 0; i < 5; i++) {
                System.out.print("+----");
            }
            System.out.println("+");
        }
    }

    public static Map<Integer, Integer> getSerpiente() {
        return serpiente;
    }

    public static Map<Integer, Integer> getEscalera() {
        return escalera;
    }
}