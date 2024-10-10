import java.util.Scanner;

public class Actividades {

  public static void main(String[] args) {

    try (Scanner readData = new Scanner(System.in)) {
      // Dias de semana
      DiasSemana diasSemana = new DiasSemana();
      int dia;
      diasSemana.SolicitarDias();
      dia = readData.nextInt();
      diasSemana.mostrarDia(dia);

      // // Calificaciones
      Calificaciones calificaciones = new Calificaciones();
      int calificacion;
      System.out.println("Indica una calificación numérica del 1 al 5:");
      calificacion = readData.nextInt();
      calificaciones.MostrarCalificación(calificacion);

      // // Menu opciones
      Menu menu = new Menu();
      int opcion;
      menu.mostrarMenu();
      opcion = readData.nextInt();
      menu.selecionarMenu(opcion);

      // // Figuras geométricas
      Figuras figuras = new Figuras();
      int opcionFiguras;
      figuras.mostrarOpciones();
      opcionFiguras = readData.nextInt();

      switch (opcionFiguras) {
        case 1 -> {
          System.out.println("Indica el RADIO, para calcular el área del CÍRCULO");
          float radio = readData.nextFloat();
          figuras.realizarCalculo(opcionFiguras, radio);
        }
        case 2 -> {
          System.out.println("Indica el LADO, para calcular el área del CUADRADO");
          float lado = readData.nextFloat();
          figuras.realizarCalculo(opcionFiguras, lado);
        }
        case 3 -> {
          System.out.println("Para calcular el área del TRÍANGULO.");
          System.out.println("Indica base:");
          float base = readData.nextFloat();
          System.out.println("Indica altura:");
          float altura = readData.nextFloat();
          figuras.realizarCalculo(opcionFiguras, base, altura);
        }
        default -> {
          System.out.println("No es posible realizar la operación, programa finaliza.");
        }
      }

      // Complementario figuras geométricas
      CalculadoraGeometrica calculadora = new CalculadoraGeometrica();
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
          calculadora.medidasCirculo(areaOPerimetro, radio);
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
          calculadora.medidasRectangulo(areaOPerimetro, base, alturaRectangulo);
        }
        default -> System.out.println("Opción inválida");
      }

    }

  }
}
