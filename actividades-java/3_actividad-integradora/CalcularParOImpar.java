import java.util.Scanner;

public class CalcularParOImpar {

  public void calcularValor() {
    int num;

    try (Scanner readValue = new Scanner(System.in)) {
      String result;

      System.out.println("Ingresa un número para saber si es par o impar:");
      num = readValue.nextInt();

      result = (num % 2) == 0 ? "PAR" : "IMPAR";

      System.out.println("El número es: " + result);
    }

  }
}
