import java.util.Scanner;

public class Calculadora {
  int result;
  int num1, num2;

  public void solicitarDatos() {

    try (Scanner readNum = new Scanner(System.in)) {
      System.out.println("Ingresa un número");
      num1 = readNum.nextInt();
      System.out.println("Ingresa otro número");
      num2 = readNum.nextInt();

      System.out.println("----------");
      System.out.println("¿Qué deseas hacer?");
      System.out.println("1 - Sumar");
      System.out.println("2 - Restar");
      System.out.println("3 - Multiplicar");
      System.out.println("4 - Dividir");
      System.out.println("----------");
      System.out.print("Ingresa el número de opción de acuerdo al cálculo a realizar: ");
      int operacion = readNum.nextInt();
      realizarOperacion(operacion);
    }
  }

  private void realizarOperacion(int operacion) {
    if (operacion == 4) {
      if (num2 == 0) {
        System.out.println("No se puede dividir por cero");
        return;
      }
      System.out.println("El resultado es: " + ((float) num1 / num2));
    } else {
      result = operacion == 1 ? num1 + num2 : operacion == 2 ? num1 - num2 : num1 * num2;
      System.out.println("El resultado es: " + result);
    }
  }
}
