
import java.util.Scanner;

public class NumerosPrimos {
  public static void main(String[] args) {
    System.out.println("\033\143"); // Limpia la consola

    try (Scanner scanner = new Scanner(System.in)) {
      int num;
      boolean esPrimo;

      do {
        esPrimo = true;
        System.out.println("Introduce un número para verificar si es primo (0 para salir)");
        num = scanner.nextInt();

        for (int i = 2; i <= Math.sqrt(num); i++) {
          if (num % i == 0) {
            esPrimo = false;
            break;
          }
        }

        if (!esPrimo || num == 1) {
          System.out.println("No es primo.");
        } else if (esPrimo && num != 0) {
          System.out.println("Es primo.");
        }

      } while (!esPrimo || num != 0);

    } catch (Exception e) {
      System.out.println(e);
    }

  }
}
