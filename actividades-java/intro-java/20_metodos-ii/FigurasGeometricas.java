import java.util.Scanner;

public class FigurasGeometricas {
  // POR REVISAR
  public static void main(String[] args) {

    try (Scanner readData = new Scanner(System.in)) {

      int opcionFiguras;
      mostrarOpciones();
      opcionFiguras = readData.nextInt();

      switch (opcionFiguras) {
        case 1 -> {
          System.out.println("Indica el RADIO, para calcular el área del CÍRCULO");
          float radio = readData.nextFloat();
          realizarCalculo(opcionFiguras, radio);
        }
        case 2 -> {
          System.out.println("Indica el LADO, para calcular el área del CUADRADO");
          float lado = readData.nextFloat();
          realizarCalculo(opcionFiguras, lado);
        }
        case 3 -> {
          System.out.println("Para calcular el área del TRÍANGULO.");
          System.out.println("Indica base:");
          float base = readData.nextFloat();
          System.out.println("Indica altura:");
          float altura = readData.nextFloat();
          realizarCalculo(opcionFiguras, base, altura);
        }
        default -> {
          System.out.println("No es posible realizar la operación, programa finaliza.");
        }
      }

      // Complementario figuras geométricas

      System.out.println("Elige una de las siguientes figuras geométricas");
      System.out.println("1. Circulo");
      System.out.println("2. Rectángulo");
      int figuraSeleccionada = readData.nextInt();

      switch (figuraSeleccionada) {
        case 1 -> {
          System.out.println("Indica el radio del círculo");
          double radio = readData.nextDouble();
          System.out.println("¿Deseas conocer el área o el perímetro?");
          System.out.println("1- Area");
          System.out.println("2- Perímetro");
          int areaOPerimetro = readData.nextInt();
          medidasCirculo(areaOPerimetro, radio);
        }
        case 2 -> {
          System.out.println("Indica la BASE del rectángulo:");
          int base = readData.nextInt();
          System.out.println("Indica la ALTURA del rectángulo:");
          int alturaRectangulo = readData.nextInt();
          System.out.println("¿Deseas conocer el área o el perímetro?");
          System.out.println("1- Area");
          System.out.println("2- Perímetro");
          int areaOPerimetro = readData.nextInt();
          medidasRectangulo(areaOPerimetro, base, alturaRectangulo);
        }
        default -> System.out.println("Opción inválida");
      }

    }

  }

  public static void mostrarOpciones() {
    System.out.println("------------");
    System.out.println("Ingresa un número de acuerdo a las siguientes opciones");
    System.out.println("1- Circulo");
    System.out.println("2- Cuadrado");
    System.out.println("3- Triangulo");
    System.out.println("------------");
  }

  public static void realizarCalculo(int opcion, float medida, float... altura) {
    switch (opcion) {
      case 1 -> {
        float area = (float) (Math.PI * (medida * medida));
        System.out.println("El área del círculo es: " + area);
      }
      case 2 -> {
        float area = medida * medida;
        System.out.println("El área del cuadrado es: " + area);
      }
      case 3 -> {
        float area = (medida * altura[0]) / 2;
        System.out.println("El área del tríangulo es: " + area);

      }
      default -> System.out.println("Opción seleccionada no es válida");
    }
  }

  public static void medidasCirculo(int opcion, double medida) {
    switch (opcion) {
      case 1 -> {
        double area = Math.PI * (medida * medida);
        System.out.println("El área es: " + area);
      }
      case 2 -> {
        double perimetro = 2 * medida * Math.PI;
        System.out.println("El perimetro es: " + perimetro);
      }
      default -> System.out.println("Opción inválida");
    }
  }

  public static void medidasRectangulo(int opcion, int base, int altura) {
    switch (opcion) {
      case 1 -> {
        double area = base * altura;
        System.out.println("El área es: " + area);
      }
      case 2 -> {
        double perimetro = (2 * base) + (2 * altura);
        System.out.println("El perimetro es: " + perimetro);
      }
      default -> System.out.println("Opción inválida");
    }

  }

}
