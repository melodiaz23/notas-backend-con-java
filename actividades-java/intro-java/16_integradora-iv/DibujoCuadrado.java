
import java.util.Scanner;

public class DibujoCuadrado {
  public static void main(String[] args) {
    System.out.println("\033\143"); // Limpia la consola
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Indica el tamaño del cuadrado a dibujar (: ");
      int size = scanner.nextInt();

      for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
          if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
            System.out.print("* ");
          } else {
            System.out.print("  ");
          }
        }
        System.out.println();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
