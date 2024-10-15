
import java.util.Scanner;

public class CalculandoLongitud {
  public void iniciarActividad(Scanner scanner) {
    System.out.println("Ingresan una frase para calcular su longitud sin espacios");
    String frase = scanner.nextLine();
    int conteo = 0;

    for (int i = 0; i < frase.length(); i++) {
      if (frase.charAt(i) != ' ') {
        conteo++;
      }
    }

    System.out.println("El total de caracteres, sin espacios es de: " + conteo);

  }
}
