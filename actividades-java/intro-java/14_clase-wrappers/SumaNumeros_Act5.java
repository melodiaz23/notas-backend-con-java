
import java.util.Scanner;

public class SumaNumeros_Act5 {
  public void sumar(Scanner scanner) {
    System.out.println("Escribe un número entero");
    String numEntero = scanner.nextLine();
    System.out.println("Ahora escribe un número decimal");
    String numDecimal = scanner.nextLine();

    float suma = Integer.valueOf(numEntero) + Float.valueOf(numDecimal);
    System.out.println("La suma de los números es: " + suma);
  }
}
