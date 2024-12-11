import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("\033\143"); // Limpia la consola
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Indica una posición para encontrar el número: ");
      int num = scanner.nextInt();

      System.out.println("El número en la secuencia es: " + fibonacciRecursivo(num));
      // int[] fibonacciArray = new int[num + 1];
      // fibonacci(fibonacciArray);
      // System.out.println("El número de la secuencia es: " + fibonacciArray[num]);
      // System.out.println(Arrays.toString(fibonacciArray));
    } catch (Exception e) {
      System.out.println(e);
    }

  }

  // public static void fibonacci(int[] secuencia) {
  // int i = 2;
  // secuencia[0] = 0;
  // secuencia[1] = 1;
  // while (i < secuencia.length) {
  // secuencia[i] = secuencia[i - 1] + secuencia[i - 2];
  // i++;
  // }
  // }

  public static int fibonacciRecursivo(int num) {
    int numSecuencia;
    if (num < 2) {
      if (num == 0) {
        numSecuencia = 0;
      } else {
        numSecuencia = 1;
      }
      return numSecuencia;
    } else {
      numSecuencia = fibonacciRecursivo(num - 1) + fibonacciRecursivo(num - 2);
      return numSecuencia;
    }

  }
}