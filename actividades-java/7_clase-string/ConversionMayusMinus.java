
import java.util.Scanner;

public class ConversionMayusMinus {
  public void iniciarActividad(Scanner scanner) {
    System.out.println("Indica una frase: ");
    String frase = scanner.nextLine();
    System.out.println("¿La deseas en mayúscula (1) o minúscula (2) ?: ");
    int respuesta = scanner.nextInt();

    switch (respuesta) {
      case 1 -> System.out.println(frase.toUpperCase());
      case 2 -> System.out.println(frase.toLowerCase());
      default -> System.out.println("No indicaste una opción válida");
    }
  }
}
