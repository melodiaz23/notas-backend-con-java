
import java.util.Scanner;

public class CalculandoRaiz {
  public void iniciarActividad(Scanner scanner) {
    float num;
    do {
      System.out.println("Indica un número positivo: ");
      num = scanner.nextFloat();
      if (num < 0) {
        System.out.println("Número debe ser positivo");
      }
    } while (num < 0);

    System.out.println("La raiz cuadrada del número ingresado es: " + Math.sqrt(num));
  }
}
