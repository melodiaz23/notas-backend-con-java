import java.util.Scanner;

public class TablaDeMultiplica2 {

  public static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("\033\143"); // Limpia la consola
    imprimirTablaMultiplicar(pedirNumero());
  }

  public static int[] pedirNumero() {
    int[] numeros = new int[3];
    System.out.println("Indica 3 números para crear sus tablas de multiplicar");
    for (int i = 0; i < numeros.length; i++) {
      System.out.print("Indica el número " + (i + 1) + ": ");
      numeros[i] = scanner.nextInt();
    }
    scanner.nextLine();
    return numeros;
  }

  public static void imprimirTablaMultiplicar(int[] numeros) {
    for (int j = 0; j < numeros.length; j++) {
      System.out.println("-------");
      for (int i = 1; i <= 10; i++) {
        System.out.println(numeros[j] + "x" + i + " = " + (i * numeros[j]));
      }
    }
  }

}
