import java.util.Scanner;

public class ContieneLetras_Act3 {
  public void validarLetras(Scanner scanner) {
    System.out.println("Ingresa un texto para determinar si solo contiene letras:");
    String frase = scanner.nextLine();
    boolean contieneLetras = true;

    for (int idx = 0; idx < frase.length(); idx++) {

      System.out.println("letra: " + frase.charAt(idx));
      if (!Character.isLetter(frase.charAt(idx)) && !Character.isWhitespace(frase.charAt(idx))) {
        contieneLetras = false;
      }
    }

    System.out.println(
        contieneLetras ? "La frase ingresada contiene SÓLO LETRAS" : "La frase ingresada NO contiene sólo letras");
  }

}
