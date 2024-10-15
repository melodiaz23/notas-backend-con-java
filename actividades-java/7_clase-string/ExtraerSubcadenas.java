
import java.util.Scanner;

public class ExtraerSubcadenas {
  public void iniciarActividad(Scanner scanner) {
    int num1, num2;
    String frase;
    System.out.println("Escribe una frase");
    frase = scanner.nextLine();

    System.out.println("La cantidad de caracteres de la frase es: " + frase.length());
    do {
      System.out.println("Indica 2 números que sean menores a la cantidad de caracteres de la frase:");
      num1 = scanner.nextInt();
      num2 = scanner.nextInt();
      if (num1 > num2) {
        System.out.println("El primer número debe ser menor al segundo");
      }
    } while ((num1 > frase.length()) | (num2 > frase.length() | num1 > num2));

    String resultado = frase.substring(num1, num2);
    System.out.println("La cadena de caracteres resultante es " + "\"" + resultado + "\"");

  }
}
