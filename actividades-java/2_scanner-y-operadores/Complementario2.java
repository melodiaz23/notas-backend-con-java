
import java.util.Scanner;

public class Complementario2 {
  int baseRectangulo;
  int alturaRectangulo;

  public void solicitarDatos(Scanner read) {
    System.out.println("Ingresa la base");
    baseRectangulo = read.nextInt();
    System.out.println("Ingresa la altura");
    alturaRectangulo = read.nextInt();
  }

  public void calculaPerimetro() {
    int perimetro = (2 * baseRectangulo) + (2 * alturaRectangulo);
    System.out.println("El perimetro del rectánculo es: " + perimetro);

  }

  public void calculaArea() {
    int area = baseRectangulo * alturaRectangulo;
    System.out.println("El área del rectangulo es: " + area);

  }
}
