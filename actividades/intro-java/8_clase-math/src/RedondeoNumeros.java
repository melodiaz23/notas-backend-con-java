package src;

import java.util.Scanner;

public class RedondeoNumeros {
  public void iniciarActividad(Scanner scanner) {
    System.out.println("Indica un número decimal: ");
    float num = scanner.nextFloat();
    System.err.println("El número redondeado es: " + Math.round(num));
    System.out.println("El valor hacia abajo es " + Math.floor(num));
    System.out.println("El valor hacia arriba es " + Math.ceil(num));
  }
}
