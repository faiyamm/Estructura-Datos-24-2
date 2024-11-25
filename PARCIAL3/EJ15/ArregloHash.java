public class ArregloHash {
    private String[] arreglo;
    private int size;
    private int primeNumber;

    public ArregloHash(int size) {
        this.size = size;
        this.primeNumber = encontrarPrimo(size); // Número primo cercano al tamaño de la tabla
        arreglo = new String[size];

        // Inicializar todos los elementos a "Vacío"
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = "Vacío";
        }
    }

    // Método para mostrar el arreglo
    public void mostrar() {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(i + ": " + arreglo[i]);
        }
    }

    // Método para asignar un hash con el método de división y número primo
    public void asignaHash(String dato) {
        int pos = 0;
        int sumaAscii = 0;

        // Sumar los valores ASCII de los caracteres del nombre
        for (int i = 0; i < dato.length(); i++) {
            sumaAscii += dato.codePointAt(i);
        }

        // Función hash utilizando el número primo y el tamaño del arreglo
        pos = sumaAscii % primeNumber;  // Dividimos por el número primo encontrado

        // Asegurarse que el índice esté dentro de los límites del arreglo
        pos = pos % size;

        System.out.println(dato + " va a la posición " + pos);

        // Verificar si la posición está vacía
        if (arreglo[pos].equals("Vacío")) {
            arreglo[pos] = dato;
        } else {
            // Si la posición está ocupada, aplicar sondeo lineal
            int i = 1; // Intentos de colisión
            while (!arreglo[pos].equals("Vacío")) {
                // Buscar nueva posición
                pos = (pos + i) % size;
                i++;
            }
            arreglo[pos] = dato;
            System.out.println(dato + " reasignado en " + pos);
        }
    }

    // Método para buscar un dato
    public void buscar(String dato) {
        int pos = 0;
        int sumaAscii = 0;

        // Sumar los valores ASCII de los caracteres del nombre
        for (int i = 0; i < dato.length(); i++) {
            sumaAscii += dato.codePointAt(i);
        }

        // Función hash utilizando el número primo y el tamaño del arreglo
        pos = sumaAscii % primeNumber;

        // Asegurarse que el índice esté dentro de los límites del arreglo
        pos = pos % size;

        // Buscar en la posición calculada
        if (arreglo[pos].equals(dato)) {
            System.out.println("Elemento encontrado en la posición " + pos);
        } else {
            // Si la posición no es la correcta, buscar linealmente
            int i = 1; // Intentos de colisión
            while (!arreglo[pos].equals(dato)) {
                pos = (pos + i) % size;
                i++;
                if (arreglo[pos].equals("Vacío")) {
                    System.out.println("Elemento no encontrado");
                    return;
                }
            }
            System.out.println("Elemento encontrado en la posición " + pos);
        }
    }

    // Método para encontrar el siguiente número primo mayor que el tamaño de la tabla
    private int encontrarPrimo(int size) {
        int prime = size;
        boolean found = false;

        while (!found) {
            prime++;
            if (isPrime(prime)) {
                found = true;
            }
        }
        return prime;
    }

    // Método para verificar si un número es primo
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}