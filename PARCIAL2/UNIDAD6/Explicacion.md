# Explicación del Programa: Hashing con Método de División y Número Primo

Este programa implementa una tabla hash con el **método de división** utilizando un **número primo** cercano al tamaño de la tabla para calcular las posiciones de los elementos. Además, utiliza **sondeo lineal** para manejar las colisiones.

## Estructura del Programa

El programa está dividido en dos clases principales:

### 1. **ArregloHash.java**

Esta clase implementa la lógica para almacenar y manipular los datos en la tabla hash.

- **Atributos:**
  - `arreglo[]`: Un arreglo de cadenas que representa la tabla hash.
  - `size`: El tamaño de la tabla hash.
  - `primeNumber`: Un número primo mayor al tamaño de la tabla, utilizado para calcular el hash.

- **Métodos principales:**
  - `asignaHash(String dato)`: Calcula el valor hash de un dato (nombre) y lo asigna a una posición en el arreglo utilizando el método de división. Si la posición está ocupada, se usa sondeo lineal para encontrar una posición libre.
  - `mostrar()`: Muestra todo el contenido de la tabla hash, indicando las posiciones ocupadas y vacías.
  - `buscar(String dato)`: Busca un nombre en la tabla hash. Si el nombre se encuentra en la posición calculada, lo muestra; de lo contrario, busca en las siguientes posiciones usando sondeo lineal.

- **Algoritmo de Hash:**
  - Se suman los valores ASCII de los caracteres del nombre y luego se calcula la posición utilizando el módulo del número primo.
  - Si hay una colisión (la posición ya está ocupada), se realiza sondeo lineal para encontrar la siguiente posición libre.

### 2. **Principal.java**

Esta clase es el punto de entrada al programa. Contiene un menú de opciones para interactuar con la tabla hash.

- **Opciones del menú:**
  1. **Ingresar nombre**: Permite al usuario ingresar un nombre y lo asigna a la tabla hash.
  2. **Buscar nombre**: Permite al usuario buscar un nombre en la tabla hash.
  3. **Mostrar lista de alumnos**: Muestra el contenido de la tabla hash.
  4. **Salir**: Termina el programa.

### Explicación Detallada del Proceso

1. **Inicialización:**
   Al inicio, se crea una tabla hash con un tamaño específico. El programa encuentra el número primo más cercano al tamaño de la tabla para usarlo en los cálculos de hash.

2. **Asignación de elementos:**
   Cuando se ingresa un nombre, el programa calcula su valor hash utilizando la suma de los valores ASCII de sus caracteres. Luego, se asigna a la posición correspondiente en el arreglo usando el número primo y el tamaño de la tabla.

3. **Manejo de colisiones:**
   Si la posición calculada ya está ocupada (es decir, hay una colisión), se aplica sondeo lineal. Esto significa que el programa buscará las siguientes posiciones de manera secuencial hasta encontrar una vacía.

4. **Búsqueda de elementos:**
   Si se desea buscar un nombre, el programa calcula su valor hash nuevamente y busca en la posición correspondiente. Si no se encuentra allí, utiliza el sondeo lineal para verificar las posiciones siguientes.

## Funcionamiento del Hashing con Método de División

El algoritmo de hashing que utiliza el programa es el **Método de División**, que se basa en dividir la suma de los valores ASCII del nombre por un número primo cercano al tamaño de la tabla. El resultado de esta operación se utiliza como índice para colocar el nombre en el arreglo.

### Ejemplo de Funcionamiento:

Supongamos que ingresamos el nombre "sofia":

1. Calculamos la suma de los valores ASCII de "sofia".
   - `s = 115`, `o = 111`, `f = 102`, `i = 105`, `a = 97`
   - Suma total = 115 + 111 + 102 + 105 + 97 = 530.

2. Aplicamos el hash utilizando el número primo más cercano al tamaño de la tabla (por ejemplo, 11):
   - `pos = 530 % 11 = 2`.

3. El programa verifica si la posición 2 está vacía. Si lo está, coloca "sofia" en esa posición. Si no está vacía, realiza sondeo lineal para buscar una nueva posición libre.

