
import java.util.Scanner;

public class ContantoDigitos_Act6 {
  public void contarDigitos(Scanner scanner) {
    int conteo = 0;
    System.out.println("Introduce un número");
    int num = scanner.nextInt();
    String numString = Integer.toString(num);

    for (int i = 0; i < numString.length(); i++) {
      if (Character.isDigit(numString.charAt(i))) {
        conteo++;
      }
    }

    System.out.printf("El número tiene %d %s. \n", conteo, (conteo == 1 ? "dígito" : "dígitos"));
  }
}
