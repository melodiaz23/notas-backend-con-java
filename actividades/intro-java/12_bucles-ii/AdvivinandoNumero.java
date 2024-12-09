
import java.util.Scanner;

public class AdvivinandoNumero {
  public void adivinar(Scanner scanner) {
    scanner.nextLine();
    int numUsuario;
    int numAleatorio = generaAleatorio();

    try {
      do {
        System.out.println("Adivina el número (entre 1 y 20): ");
        numUsuario = scanner.nextInt();
        if (numUsuario < numAleatorio) {
          System.out.println("El número ingresado es menor.");
        } else if (numUsuario > numAleatorio) {
          System.out.println("El número ingresado es mayor.");
        }
      } while (numUsuario != numAleatorio);
      System.out.println("Haz adivinado, el número es: " + numAleatorio);
    } catch (Exception e) {
      System.out.println(e);
    }

  }

  private int generaAleatorio() {
    int num = (int) (1 + Math.random() * 20);
    System.out.println("Número aleatorio generado: " + num);
    return num;
  }
}
