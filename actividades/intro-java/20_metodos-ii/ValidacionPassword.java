
import java.util.Scanner;

public class ValidacionPassword {
  public static void main(String[] args) {
    System.out.println("\033\143"); // Limpia la consola
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Ingresa una contraseña");
      String password = scanner.nextLine();
      if (esSegura(password)) {
        System.out.println("Contraseña Segura");
      } else {
        System.out.println("Contraseña insegura :(");
      }

    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static boolean esSegura(String password) {
    return tieneLongitudCorrecta(password) && tieneMayus(password) && tieneMinus(password) && tieneNum(password)
        && tieneCaracterEspecial(password);
  }

  public static boolean tieneLongitudCorrecta(String password) {
    if (password.length() < 8) {
      System.out.println("Contraseña debe ser mayor a 8 caracteres");
    }
    return password.length() > 8;
  }

  public static boolean tieneMayus(String password) {
    for (char ch : password.toCharArray()) {
      if (Character.isUpperCase(ch))
        return true;
    }
    System.out.println("Debe tener Mayúsculas");
    return false;
  }

  public static boolean tieneMinus(String password) {
    for (char ch : password.toCharArray()) {
      if (Character.isLowerCase(ch))
        return true;
    }
    System.out.println("Debe tener Minúsculas");
    return false;
  }

  public static boolean tieneNum(String password) {
    for (char ch : password.toCharArray()) {
      if (Character.isDigit(ch))
        return true;
    }
    System.out.println("Debe tener al menos un número");
    return false;
  }

  public static boolean tieneCaracterEspecial(String password) {
    String caracteresEspeciales = "!@#$%^&*()_+-=[]{};:'\"\\|,.<>/?";
    for (char ch : password.toCharArray()) {
      if (caracteresEspeciales.indexOf(ch) != -1)
        return true;
    }
    System.out.println("Debe tener caracteres especiales");
    return false;
  }
}