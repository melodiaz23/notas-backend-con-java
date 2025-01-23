import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Indica dos números para establecer un rango.");
      int num1, num2;
      do {
        System.out.println("Límite inferior: ");
        num1 = scanner.nextInt();
        System.out.println("Límite superior: ");
        num2 = scanner.nextInt();
        if (num1 > num2) {
          System.out.println("El límite inferior debe ser menor o igual al límite superior.");
        }
      } while (num1 > num2);

      Integer numAleatorio = GestionDeNumero.numeroAleatorio(num1, num2);
      int numAdivinado;
      do {
        System.out.println("Ahora adivina el número de ese rango!");
        numAdivinado = scanner.nextInt();
        System.out.println(GestionDeNumero.encontrarNumero(numAleatorio, numAdivinado));
      } while (numAleatorio!=numAdivinado);

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}