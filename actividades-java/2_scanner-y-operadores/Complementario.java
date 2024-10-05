import java.util.Scanner;

public class Complementario {
  public void verificaEdad(Scanner read) {
    int year;
    final int CURRENT_YEAR = 2024;

    System.out.println("Indica el año de nacimiento:");
    year = read.nextInt();
    int calculoEdad = CURRENT_YEAR - year;
    String esMayor = calculoEdad > 18 ? "Es mayor de edad." : "Es menor de edad.";
    System.out.println(esMayor);
  }

}
