
import java.util.Scanner;

public class ValidandoPassword {
  private String passwordUser;
  private final String PASSWORD = "secreto";

  public void validarPassword(Scanner scanner) {
    scanner.nextLine();
    do {
      System.out.println("Ingresa la contraseña:");
      passwordUser = scanner.nextLine();
      if (!PASSWORD.equals(passwordUser)) {
        System.out.println("Contraseña incorrecta.");
      }
    } while (!PASSWORD.equals(passwordUser));
    System.out.println("Contraseña correcta.");

  }
}
