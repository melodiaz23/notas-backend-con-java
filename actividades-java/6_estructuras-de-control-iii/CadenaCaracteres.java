
import java.util.Scanner;

public class CadenaCaracteres {
  public void IniciarActividad(Scanner scanner) {

    try {
      System.out.print("Indica un número: ");
      String dato = scanner.nextLine();
      int conversion = Integer.parseInt(dato);
      System.out.println("El valor ingresado es: " + conversion);
    } catch (NumberFormatException e) {
      System.out.println("Dato no corresponde a un número.");
    } catch (Exception e) {
      // e.printStackTrace();
      System.err.println("Error: " + e.getMessage());
    }
  }
}
