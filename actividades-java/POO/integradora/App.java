
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    System.out.println("\033\143");

    Revista[] revistas = new Revista[3];

    revistas[0] = new Revista(1, 50, "Ciencia Hoy");
    revistas[1] = new Revista(2, 0, "Tecnología Moderna");
    revistas[2] = new Revista(3, 20, "Historia y Cultura");

    try (Scanner scanner = new Scanner(System.in)) {
      for (Revista revista : revistas) {
        revista.obtenerInformacion();
        revista.prestar();
        System.out.println("- DESPUES DE PRESTAR -");
        revista.obtenerInformacion();

        System.out.println("Deseas devolver el ejemplar?, indica el id");
        String idEjemplar = scanner.nextLine();
        revista.devolver(idEjemplar);
        System.out.println("- DESPUES DE DEVOLVER -");
        revista.obtenerInformacion();
        System.out.println();
        System.out.println("-----------");
        System.out.println();
      }
    } catch (Exception e) {
      System.out.println("Error inesperado: " + e);
    }

  }
}