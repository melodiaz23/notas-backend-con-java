
import java.util.Scanner;

public class LongitudCadena {
  public void iniciarActividad(Scanner scanner) {
    System.out.println("Indica una palabra para identificar su longitud:");
    String texto = scanner.nextLine();

    System.out.println("La longitud del texto es de: " + texto.length());

  }

}
