import java.util.Scanner;

public class CalcularParOImpar {

  public void calcularValor() {
    int num;

    try (Scanner readValue = new Scanner(System.in)) {
      // String result;

      System.out.println("Ingresa un número para saber si es par o impar:");
      num = readValue.nextInt();

      // result = (num % 2) == 0 ? "PAR" : "IMPAR";

      System.out.println((num % 2 == 0 ? "El numero ingresado es par." : "El numero ingresado es impar."));
      // System.out.println("El número es: " + result);
    }

  }
}

// public class ValidarParOImpar {
// public static void main(String[] args) {
// Scanner miScanner = new Scanner(System.in);
// System.out.println("Ingresar numero:");
// int num = miScanner.nextInt();
// System.out.println((num % 2 == 0 ? "El numero ingresado es par." : "El
// numero
// ingresado es impar."));
// miScanner.close();
// }
// }
