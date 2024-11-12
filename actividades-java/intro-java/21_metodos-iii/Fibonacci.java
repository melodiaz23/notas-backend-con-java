import java.util.Scanner;

public class Fibonacci {
  public static void main(String[] args) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.println("Ingrese la posicion en fibonacci: ");
      int num = scan.nextInt();
      // int[] fibonacciArray = new int[num + 1];

      // fibonacci(num, fibonacciArray);
      System.out.println("El número en la secuencia es: " + recursividadFibonacci(num));

      // System.out.println("El numero en la posicion " + num + " es: " +
      // fibonacciArray[num]);
      // System.out.println(Arrays.toString(fibonacciArray));
    }
  }

  public static void fibonacci(int num, int[] fibonacciArray) {
    // 1, 1, 2, 3, 5, 8, 13, 21, 34,
    // Fn = fn-1 + fn-2
    fibonacciArray[0] = 0;
    fibonacciArray[1] = 1;
    for (int i = 2; i < num + 1; i++)
      fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
  }

  public static int recursividadFibonacci(int num) {
    int numSecuencia;
    if (num <= 2) {
      if (num <= 0) {
        numSecuencia = 0;
      } else {
        numSecuencia = 1; // Posición 1 o 2 el valor de la secuencia es 1
      }
      System.out.printf("| %d ", numSecuencia);
      return numSecuencia;
    } else {
      numSecuencia = recursividadFibonacci(num - 1) + recursividadFibonacci(num - 2);
      System.out.printf("| %d ", numSecuencia);
      return numSecuencia;
    }

  }
}

// Funcion fibonacc <- calcularSecuencia (num)
// definir fibonacc, calculoNum Como Entero

// Si num <= 1 Entonces
// si num = 0 Entonces
// fibonacc = 0
// SiNo
// fibonacc = 1
// FinSi
// SiNo
// fibonacc = calcularSecuencia(num-1) + calcularSecuencia(num-2)
// FinSi

// FinFuncion
