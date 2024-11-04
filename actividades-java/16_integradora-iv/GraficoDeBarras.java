import java.util.Scanner;

public class GraficoDeBarras {
  public static void main(String[] args) {
    System.out.println("\033\143");
    try (Scanner scanner = new Scanner(System.in)) {
      int[] numeros = new int[4];

      for (int i = 0; i < numeros.length; i++) {
        do {
          System.out.print("Introduce un número entre 1 y 20 para la barra " + (i + 1) + ": ");
          numeros[i] = scanner.nextInt();
          if (numeros[i] < 1 || numeros[i] > 20) {
            System.out.println("Has ingresado un número fuera del rango. Introduce un número entre 1 y 20.");

          }
        } while (numeros[i] < 1 || numeros[i] > 20);
      }

      for (int num : numeros) {
        System.out.print(num + " ");
        for (int j = 0; j < num; j++) {
          System.out.print("*");
        }

        System.out.println();
      }
    }
  }
}
