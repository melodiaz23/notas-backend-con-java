import java.util.Scanner;

public class TablaDeMultiplicar {

  public static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("\033\143"); // Limpia la consola
    imprimirTablaMultiplicar(pedirNumero());
  }

  public static int pedirNumero() {
    System.out.println("Indica un número a multiplicar");
    int num = scanner.nextInt();
    scanner.nextLine();
    return num;
  }

  public static void imprimirTablaMultiplicar(int num) {
    for (int i = 1; i <= 10; i++) {
      System.out.println(num + "x" + i + " = " + (i * num));
    }
  }

}
