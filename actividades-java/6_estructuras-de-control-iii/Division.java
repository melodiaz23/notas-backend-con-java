import java.util.InputMismatchException;

public class Division {

  public void IniciarActividad(java.util.Scanner scanner) {
    int num1, num2;

    try {
      System.out.println("Para realizar una división...");
      System.out.print("Indica número 1: ");
      num1 = scanner.nextInt();
      System.out.print("Indica número 2: ");
      num2 = scanner.nextInt();
      float resultado = (float) num1 / num2;
      // Los números enteros lanzan una excepción cuando se divide por cero, los
      // números flotantes producen un resultado de "Infinity".
      System.out.println("El resultado de la división es: " + resultado);

    } catch (ArithmeticException e) {
      System.out.println("No se puede dividir por cero: " + e.getMessage());
    } catch (InputMismatchException e) {
      System.out.println("Dato ingresado es inválido: " + e.getMessage());
    }

  }

}
