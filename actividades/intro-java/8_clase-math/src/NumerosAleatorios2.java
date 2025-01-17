package src;

import java.util.Scanner;

public class NumerosAleatorios2 {
  public void iniciarActividad(Scanner scanner) {
    System.out.println("Indica dos números para establecer un rango.");
    int num1, num2;
    do {
      System.out.println("Límite inferior: ");
      num1 = scanner.nextInt();
      System.out.println("Límite superior: ");
      num2 = scanner.nextInt();
      if (num1 > num2) {
        System.out.println("El límite inferior debe ser menor o igual al límite superior.");
      }
    } while (num1 > num2);

    // (máx - mín + 1) + mín

    // int numAleatorio = (int) Math.floor(Math.random() * (num2 - num1 + 1) +
    // num1);
    // Sería igual:
    int numAleatorio = (int) (num1 + Math.random() * (num2 - num1 + 1));
    double numAleatorio2 = (num1 + Math.random() * (num2 - num1 + 1));

    System.out.printf("El número aleatorio es: %.2f%n", numAleatorio2);
    System.out.println("El número aleatorio es: " + numAleatorio);
  }
}
