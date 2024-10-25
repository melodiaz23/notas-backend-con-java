
import java.util.Scanner;

public class CadenaANumero_Act2 {
  public void conversion(Scanner scanner) {
    try {
      System.out.println("Indica un número entero");
      String cadena = scanner.nextLine();

      int value = Integer.parseInt(cadena);

      System.out.println("El dato ingresado como entero es: " + value);

    } catch (NumberFormatException e) {
      System.out.println(e);
    }

  }
}
