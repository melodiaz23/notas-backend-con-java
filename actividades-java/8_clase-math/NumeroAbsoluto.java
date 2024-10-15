
import java.util.Scanner;

public class NumeroAbsoluto {
  public void iniciarActividad(Scanner scanner) {
    System.out.println("Indica cualquier número entero positivo o negativo");
    int num = scanner.nextInt();
    System.out.println("El valor absoluto es: " + Math.abs(num));
  }
}
