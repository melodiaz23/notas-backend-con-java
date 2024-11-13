
import java.util.Arrays;
import java.util.Scanner;

public class FiguraGeometrica {
  static Rectangulo[] rectangulos = new Rectangulo[0];
  static Circulo[] circulos = new Circulo[0];
  static Triangulo[] triangulos = new Triangulo[0];

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
      System.out.println("2- Crear Circulo");
      System.out.println("3- Crear Triangulo");
      System.out.println("4- Salir");
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
        case 2 -> {
          Integer radio;
          circulos = Arrays.copyOf(circulos, Circulo.numTotal() + 1);
          System.out.println("CREACIÓN DEL CIRCULO");
          System.out.println("----------");
          System.out.print("Indica el radio: ");
          radio = scanner.nextInt();
          Circulo circulo = new Circulo();
          circulo.setRadio(radio);
          circulos[Circulo.numTotal() - 1] = circulo;
          System.out.println(">> Circulo creado");
          do {
            System.out.println("\nMENU CÍRCULO");
            System.out.println("----------");
            System.out.println("¿Que deseas hacer?");
            System.out.println("1- Calcular area");
            System.out.println("2- Calcular perímetro");
            System.out.println("3- Cantidad de Círculos");
            System.out.println("4- Volver al menú anterior");
            opcionMetodo = scanner.nextInt();

            switch (opcionMetodo) {
              case 1 -> {
                circulo.imprimirArea();
              }
              case 2 -> {
                circulo.imprimirPerimetro();
              }
              case 3 -> {
                System.out.printf("Se han creado %d cirulos/s \n", Circulo.numTotal());
              }
              case 4 -> {
                break;
              }
              default -> System.out.println(">> Selecciona una opción válida");
            }
          } while (opcionMetodo != 4);

        }
        case 3 -> {
          Integer base, altura;
          triangulos = Arrays.copyOf(triangulos, Triangulo.numTotal() + 1);
          System.out.println("CREACIÓN DEL TRÍANGULO");
          System.out.println("----------");
          System.out.print("Indica la base: ");
          base = scanner.nextInt();
          System.out.print("Indica la altura: ");
          altura = scanner.nextInt();
          Triangulo triangulo = new Triangulo();
          triangulo.setBase(base);
          triangulo.setAltura(altura);
          triangulos[Triangulo.numTotal() - 1] = triangulo;
          System.out.println(">> Triangulo creado");
          do {
            System.out.println("\nMENU TRIANGULO");
            System.out.println("----------");
            System.out.println("¿Que deseas hacer?");
            System.out.println("1- Calcular área");
            System.out.println("2- Cantidad de triángulos");
            System.out.println("3- Volver al menú anterior");
            opcionMetodo = scanner.nextInt();

            switch (opcionMetodo) {
              case 1 -> {
                triangulo.imprimirDatos();
              }
              case 2 -> {
                System.out.printf("Se han creado %d triangulos/s \n", Triangulo.numTotal());
              }
              case 3 -> {
                break;
              }
              default -> System.out.println(">> Selecciona una opción válida");
            }
          } while (opcionMetodo != 3);

        }
        case 4 -> {
          break;
        }
        default -> System.out.println("Ingresa una opción válida");
      }

    } while (opcion != 4);

  }
}
