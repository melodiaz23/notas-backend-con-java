import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numero;

    do {
      System.out.println("Ingrese un número para verificar si es primo:");
      while (!sc.hasNextInt()) {
        System.out.println("Entrada inválida. Por favor, introduzca un número entero.");
        sc.next();
      }

      numero = sc.nextInt();

      if (esPrimo(numero)) {
        System.out.println("¡Correcto! " + numero + " es un número primo.");
      } else {
        System.out.println(numero + " no es primo. Inténtelo de nuevo.");
      }

    } while (!esPrimo(numero));

    sc.close();
  }


  public static boolean esPrimo(int numero) {
    if (numero <= 1) return false;
    for (int i = 2; i <= Math.sqrt(numero); i++) {
      if (numero % i == 0) {
        return false;
      }
    }
    return true;
  }
}
