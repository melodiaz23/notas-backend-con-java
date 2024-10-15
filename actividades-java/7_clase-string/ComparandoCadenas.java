
import java.util.Scanner;

public class ComparandoCadenas {
  public void iniciarActividad(Scanner scanner) {
    System.out.println("Indica una palabra:");
    String texto = scanner.nextLine();
    System.out.println("Indica otra palabra para encontrar si son iguales:");
    String texto2 = scanner.nextLine();

    if (texto.equals(texto2)) {
      System.out.println("Las palabras son iguales");
    } else {
      System.out.println("Las palabras NO son iguales");

    }

  }

}
