import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {
  public static void main(String[] args) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.println("Ingrese la posicion en fibonacci: ");
      int num = scan.nextInt();

      // 1 2 3 4 5
      // Fn = fn-1 + fn-2
      int[] fibonacci = new int[num + 1];
      fibonacci[0] = 0;
      fibonacci[1] = 1;
      for (int i = 2; i < num + 1; i++)
        fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];

      System.out.println("El numero en la posicion " + num + " es: " + fibonacci[num]);
      System.out.println(Arrays.toString(fibonacci));
    }
  }
}

// import java.util.Scanner;

// // 1, 1, 2, 3, 5, 8, 13, 21, 34, ... donde cada número se calcula sumando los
// dos anteriores.Por ejemplo:

// // Posición 0: 0
// // Posición 1: 1
// // Posición 2: 1
// // Posición 3: 2
// // Posición 4: 3
// public class Fibonacci {
// public static void main(String[] args) {
// System.out.println("\033\143"); // Limpia la consola
// try (Scanner scanner = new Scanner(System.in)) {
// System.out.println("Indica un número para encontrar la posición en la serie
// fibonacci");
// int posicion = scanner.nextInt();
// int numSecuencia = 0;

// if (posicion < 3) {
// if (posicion == 0) {
// numSecuencia = 0;
// } else {
// numSecuencia = 1; // Posición 1 o 2 el valor de la secuencia es 1
// }
// } else {
// int prev = 1; // Primer número
// int valorActual = 1; // Segundo número de la secuencia
// System.out.printf("Secuencia: %d | %d ", prev, valorActual);
// // El conteo empieza en 3 porque ya conocemos los valores de 1 y 2;
// for (int i = 3; i <= posicion; i++) {
// numSecuencia = prev + valorActual;
// System.out.printf("| %d ", numSecuencia);
// // Actualiza los valores para la siguiente iteración
// prev = valorActual;
// valorActual = numSecuencia;
// }
// }
// System.out.println();
// System.out.println("Posición: " + posicion);
// System.out.println("Numero correspondiente: " + numSecuencia);

// } catch (Exception e) {
// System.out.println(e);
// }

// }

// }