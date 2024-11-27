
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    System.out.println("\033\143");

    try (Scanner scanner = new Scanner(System.in)) {
      int conteo = 0;
      do {
        System.out.println("Indica un color");
        Color colorElegido = null;
        try {
          String color = scanner.nextLine().toUpperCase();
          colorElegido = Color.valueOf(color);
        } catch (IllegalArgumentException e) {
          System.out.println("Error en valor indicado.");
        }
        if (colorElegido == null) {
          System.out.println("No es una opción de color válida.");
        } else {
          if (colorElegido.name().equalsIgnoreCase("AMARILLO") || colorElegido.name().equalsIgnoreCase("AZUL")
              || colorElegido.name().equalsIgnoreCase("ROJO")) {
            System.out.println("Es primario");
          } else {
            System.out.println("No es primario");
          }
        }
        conteo++;
      } while (conteo < 5);

    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
