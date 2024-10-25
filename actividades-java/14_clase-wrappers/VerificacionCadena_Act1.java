
import java.util.Scanner;

public class VerificacionCadena_Act1 {
  public void verificar(Scanner scanner) {
    try {
      String cadena;
      System.out.println("Indica un número:");
      cadena = scanner.nextLine();
      double temp = (double) Double.valueOf(cadena);
      System.out.println("El valor ingresado es: " + temp);
    } catch (NumberFormatException e) {
      System.out.println("Error: La entrada no es un número válido");
    }

  }
}
