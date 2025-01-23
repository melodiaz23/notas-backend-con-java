
import java.util.Scanner;

public class GeneradorPassword {
  public static void main(String[] args) {
    System.out.println("\033\143"); // Limpia la consola
    System.out.println("GENERADOR DE CONTRASEÑAS");
    try (Scanner scanner = new Scanner(System.in)) {
      boolean tieneMayus, tieneMinus, tieneNum;
      int sizePassword;
      do {
        System.out.print("Indica la longitud para la contraseña (superior a 3 caracteres): ");
        sizePassword = scanner.nextInt();
      } while (sizePassword < 4);

      char[] passwordArray = new char[sizePassword];

      for (int idx = 0; idx < passwordArray.length; idx++) {
        passwordArray[idx] = generateChar();
      }

      do {
        tieneMayus = tieneMinus = tieneNum = false;
        for (char ch : passwordArray) {
          if (Character.isUpperCase(ch))
            tieneMayus = true;
          else if (Character.isLowerCase(ch))
            tieneMinus = true;
          else if (Character.isDigit(ch))
            tieneNum = true;
        }

        if (!tieneMayus) {
          int opcion = (int) (Math.random() * passwordArray.length);
          do {
            passwordArray[opcion] = generateChar();
          } while (!Character.isUpperCase(passwordArray[opcion]));
        }

        if (!tieneMinus) {
          int opcion = (int) (Math.random() * passwordArray.length);
          do {
            passwordArray[opcion] = generateChar();
          } while (!Character.isUpperCase(passwordArray[opcion]));
        }
        if (!tieneNum) {
          int opcion = (int) (Math.random() * passwordArray.length);
          do {
            passwordArray[opcion] = generateChar();
          } while (!Character.isDigit(passwordArray[opcion]));
        }
      } while (!tieneMayus && !tieneMinus && !tieneNum);

      System.out.println("Contraseña generada");

      String password = "";
      for (int idx = 0; idx < passwordArray.length; idx++) {
        password = password.concat(Character.toString(passwordArray[idx]));

      }

      System.out.println("La contraseña generada es: " + password);

    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static char generateChar() {
    // Caracteres a incluir:
    // 48-57 -> 0-9
    // 65-90 A-Z
    // 97-122 a-z
    char randomChar;
    int opcion = (int) (Math.random() * 3); // 3 excluido

    switch (opcion) {
      case 0 -> randomChar = (char) (48 + Math.random() * (57 - 48 + 1));
      case 1 -> randomChar = (char) (65 + Math.random() * (90 - 65 + 1));
      default -> randomChar = (char) (97 + Math.random() * (122 - 97 + 1));

    }

    return randomChar;
  }
}