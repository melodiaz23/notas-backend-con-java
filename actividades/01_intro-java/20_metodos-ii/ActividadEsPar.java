import java.util.Scanner;

public class ActividadEsPar {
  public static Scanner pepe = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("\033\143"); // Limpia la consola
    try {
      int num = solicitarNumero();
      System.out.println(esPar(num) ? "Número es par" : "Número es impar");
    } catch (Exception e) {
      System.out.println("Algo salio mal. El error es el siguiente >> " + e);
    } finally {
      pepe.close();
    }
  }

  public static int solicitarNumero() {
    Integer numero = null;
    System.out.println("Por favor ingrese un número:");
    do {
      try {
        numero = pepe.nextInt();
      } catch (Exception e) {
        pepe.nextLine();
        System.out.println("No ingresó un número, intente nuevamente:");
      }
    } while (numero == null);

    return numero;
  }

  public static boolean esPar(int num) {
    return num % 2 == 0;
  }

}
