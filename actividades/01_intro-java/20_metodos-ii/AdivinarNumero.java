
import java.util.Scanner;

public class AdivinarNumero {
  public static void main(String[] args) {
    System.out.println("\033\143");
    int numUsuario, numMax, numMin;
    try (Scanner scanner = new Scanner(System.in)) {
      do {
        System.out.println("Indica un número minimo");
        numMin = scanner.nextInt();
        System.out.println("Indica un número maximo");
        numMax = scanner.nextInt();
        if (numMin > numMax) {
          System.out.println("Numero mínimo debe ser menor al segundo número");
        }
      } while (numMin > numMax);
      int numAleatorio = generaAleatorio(numMin, numMax);
      do {
        System.out.println("Adivina el número entre el rango especificado: ");
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

  private static int generaAleatorio(int max, int min) {
    int num = (int) (min + Math.random() * (max - min + 1));
    System.out.println("Número aleatorio generado: " + num);
    return num;
  }

}
