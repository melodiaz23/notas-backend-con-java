
import java.util.Arrays;
import java.util.Scanner;

public class FiguraGeometrica {
  static Rectangulo[] rectangulos = new Rectangulo[0];

  public static void main(String[] args) {
    System.out.println("\033\143");
    try (Scanner scanner = new Scanner(System.in)) {
      Menu(scanner);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void Menu(Scanner scanner) {
    int opcion, opcionMetodo;

    do {
      System.out.println("MENU");
      System.out.println("----------");
      System.out.println("1- Crear Rectángulo");
      System.out.println("2- Salir");
      opcion = scanner.nextInt();

      switch (opcion) {
        case 1 -> {
          Integer alto, ancho;
          rectangulos = Arrays.copyOf(rectangulos, Rectangulo.numTotal() + 1);
          System.out.println("CREACIÓN DEL RECTÁNGULO");
          System.out.println("----------");
          System.out.print("Indica el alto: ");
          alto = scanner.nextInt();
          System.out.print("Indica el ancho: ");
          ancho = scanner.nextInt();
          Rectangulo rectangulo = new Rectangulo();
          rectangulo.setAlto(alto);
          rectangulo.setAncho(ancho);
          rectangulos[Rectangulo.numTotal() - 1] = rectangulo;
          System.out.println(">> Rectángulo creado");
          do {
            System.out.println("\nMENU RECTÁNGULO");
            System.out.println("----------");
            System.out.println("¿Que deseas hacer?");
            System.out.println("1- Calcular área");
            System.out.println("2- Calcular perímetro");
            System.out.println("3- Cantidad de Rectángulos");
            System.out.println("4- Volver al menú anterior");
            opcionMetodo = scanner.nextInt();

            switch (opcionMetodo) {
              case 1 -> {
                rectangulo.imprimirArea();
              }
              case 2 -> {
                rectangulo.imprimirPerimetro();
              }
              case 3 -> {
                System.out.printf("Se han creado %d rectángulo/s \n", Rectangulo.numTotal());
              }
              case 4 -> {
                break;
              }
              default -> System.out.println(">> Selecciona una opción válida");
            }
          } while (opcionMetodo != 4);
        }
        case 4 -> {
          break;
        }
        default -> System.out.println("Ingresa una opción válida");
      }

    } while (opcion != 2);

  }
}
