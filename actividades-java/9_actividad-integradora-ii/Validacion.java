
import java.util.Scanner;

public class Validacion {
  public void iniciarActividad(Scanner scanner) {
    String password;
    Boolean esSegura = false;
    System.out.println("----------");
    System.out.println("VERIFICACIÓN DE CONTRASEÑAS");
    System.out.println("----------");

    while (!esSegura) {
      System.out.println("Ingresa una contraseña: ");
      password = scanner.nextLine();
      esSegura = validarPassword(password);

      if (esSegura) {
        System.out.println("¡Contraseña segura! Cumple con todos los criterios.");
      } else {
        System.out.println(
            "Contraseña no segura. Debe tener al menos una letra mayúscula, una minúscula y un carácter especial.");
      }
    }

  }

  private boolean validarPassword(String password) {
    boolean tieneMayus = false;
    boolean tieneMinus = false;
    boolean tieneNum = false;
    boolean tieneCaracterEspecial = false;

    if (password.length() < 8) {
      return false;
    } else {

      for (int i = 0; i < password.length(); i++) {
        if (Character.isUpperCase(password.charAt(i))) {
          System.out.println("TIENE MAYÚSCULA!");
          tieneMayus = true;
        } else if (Character.isLowerCase(password.charAt(i))) {
          System.out.println("TIENE MINÚSCULA!");
          tieneMinus = true;
        } else if (Character.isDigit(password.charAt(i))) {
          System.out.println("TIENE NÚMERO!");
          tieneNum = true;
        } else if (!Character.isLetterOrDigit(password.charAt(i))) {
          System.out.println("TIENE CARACTER ESPECIAL!");
          tieneCaracterEspecial = true;
        }
      }
      return (tieneMayus && tieneMinus && tieneNum && tieneCaracterEspecial);

      // Otra forma, con Regular Expressions
      // regex101.com

      // tieneMayus = password.matches(".*[A-Z].*");
      // tieneMinus = password.matches(".*[a-z].*");
      // tieneNum = password.matches(".*[0-9].*");
      // tieneCaracterEspecial = password.matches(".*[^a-zA-Z0-9].*");
      // return (tieneMayus && tieneMinus && tieneNum && tieneCaracterEspecial);
    }

  }
}
