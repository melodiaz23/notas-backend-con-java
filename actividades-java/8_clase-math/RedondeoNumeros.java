
import java.util.Scanner;

public class RedondeoNumeros {
  public void iniciarActividad(Scanner scanner) {
    System.out.println("Indica un número decimal: ");
    float num = scanner.nextFloat();
    System.err.println("El número redondeado es: " + Math.round(num));
  }
}
