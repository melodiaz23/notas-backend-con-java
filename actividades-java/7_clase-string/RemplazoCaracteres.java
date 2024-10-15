
import java.util.Scanner;

public class RemplazoCaracteres {
  public void iniciarActividad(Scanner scanner) {
    System.out.println("Ingresa una frase");
    String frase = scanner.nextLine();
    System.out.println("Ingresa un caracter que esté en la frase");
    String car1 = scanner.nextLine();
    System.out.println("Ingresa otro caracter");
    String car2 = scanner.nextLine();

    String nuevaFrase = frase.replace(car1, car2);

    System.out.println("Tu nueva frase es: " + nuevaFrase);
  }
}
