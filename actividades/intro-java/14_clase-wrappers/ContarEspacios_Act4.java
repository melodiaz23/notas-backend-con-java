
import java.util.Scanner;

public class ContarEspacios_Act4 {
  public void contarEspacio(Scanner scanner) {
    int conteo = 0;
    System.out.println("Ingresa una frase para contar espacios en blancos:");
    String frase = scanner.nextLine();

    for (int i = 0; i < frase.length(); i++) {
      if (Character.isWhitespace(frase.charAt(i)))
        conteo++;
    }

    System.out
        .println(conteo > 0 ? "La cantidad de espacios en blancos es de " + conteo : "No hay espacios en blancos");

  }
}
