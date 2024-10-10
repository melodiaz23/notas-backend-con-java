import java.util.InputMismatchException;
import java.util.Scanner;

public class Resta {
  public void IniciarActividad(Scanner scanner) {
    try {
      System.out.println("Para realizar una resta...");
      System.out.print("Indica número 1: ");
      int num1 = scanner.nextInt();
      System.out.print("Indica número 2: ");
      int num2 = scanner.nextInt();
      System.out.println("El resultado de la resta es: " + (num1 - num2));
    } catch (InputMismatchException e) {
      System.err.println("El número ingresado es inválido.");
    } catch (Exception e) {
      System.out.println("Tipo de error: " + e);
    }

  }
}
