import java.util.Scanner;

public class Calculadora {
  static Scanner scanner = new Scanner(System.in);
  static int[] nums = new int[2];

  public static void main(String[] args) {
    System.out.println("\033\143"); // Limpia la consola
    menu();
  }

  public static void menu() {
    int operacion;
    System.out.println("CALCULADORA");
    for (int i = 0; i < nums.length; i++) {
      System.out.println("Ingresa número " + (i + 1));
      nums[i] = scanner.nextInt();
    }
    System.out.println("----------");
    System.out.println("¿Qué deseas hacer?");
    System.out.println("1 - Sumar");
    System.out.println("2 - Restar");
    System.out.println("3 - Multiplicar");
    System.out.println("4 - Dividir");
    System.out.println("5 - Salir");
    System.out.println("----------");
    do {
      System.out.print("Ingresa el número de opción de acuerdo al cálculo a realizar: ");
      operacion = scanner.nextInt();
      if (operacion < 1 || operacion > 5) {
        System.out.println("Opción inválida");
      } else if (operacion == 4 && nums[0] == 0) {
        System.out.println("No se puede dividir por cero, intenta otra opción");
      } else if (operacion != 5) {
        System.out.println("El resultado es: " + realizarOperacion(operacion));
      }
    } while ((operacion != 5) || (operacion == 4 && nums[0] == 0));

  }

  public static float realizarOperacion(int operacion) {
    float result = 0;
    switch (operacion) {
      case 1 -> result = nums[0] + nums[1];
      case 2 -> result = nums[0] - nums[1];
      case 3 -> result = nums[0] * nums[1];
      case 4 -> result = (float) nums[0] / (float) nums[1];
    }
    return result;
  }

}
