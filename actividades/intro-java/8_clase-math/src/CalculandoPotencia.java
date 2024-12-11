package src;

import java.util.Scanner;

public class CalculandoPotencia {
  public void iniciarActividad(Scanner scanner) {
    System.out.println("Deberás indicar dos números enteros para calcular el exponente.");
    System.out.println("Primero indica la base:");
    int base = scanner.nextInt();
    System.out.println("Ahora indica el exponente");
    int exponente = scanner.nextInt();

    System.out.println("El resultado es: " + (int) Math.pow(base, exponente));
  }
}
