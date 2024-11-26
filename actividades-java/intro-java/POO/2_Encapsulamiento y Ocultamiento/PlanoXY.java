import java.util.Arrays;
import java.util.Scanner;

public class PlanoXY {
  static Punto[] puntos = new Punto[0];

  public static void main(String[] args) {
    System.out.println("\033\143");
    try (Scanner scanner = new Scanner(System.in)) {
      int opcion;
      do {
        System.out.println("---------------------");
        System.out.println("CREACIÓN DE PUNTOS");
        System.out.println("---------------------");
        System.out.println("1- Crear un punto");
        System.out.println("2- Calcular distancia desde Origen (0,0)");
        System.out.println("3- Calcular distancia entre dos puntos");
        System.out.println("4- Determinar si tres puntos están alineados");
        System.out.println("5- Salir");
        opcion = scanner.nextInt();

        switch (opcion) {
          case 1 -> {
            System.out.println("Indica el valor de x");
            int x = scanner.nextInt();
            System.out.println("Indica el valor de y");
            int y = scanner.nextInt();
            puntos = Arrays.copyOf(puntos, puntos.length + 1);
            // Crear una nueva instancia
            Punto punto = new Punto();
            punto.setX(x);
            punto.setY(y);
            puntos[puntos.length - 1] = punto;
            System.out.println("Punto creado en le posición: " + (puntos.length - 1));
          }
          case 2 -> {
            if (puntos.length < 1) {
              System.out.println("Debes crear al menos un punto para poder realizar el cálculo");
            } else {
              System.out.println("De qué elemento quieres calcular la distancia desde su origen?");
              System.out.println("(Indica el index)");
              int index = scanner.nextInt();
              System.out.printf("La distancia desde el punto (0,0), hasta el punto (%d,%d) es %.2f \n",
                  puntos[index].getX(),
                  puntos[index].getY(), puntos[index].distanciaDesdeOrigen());
            }

          }
          case 3 -> {
            if (puntos.length <= 1) {
              System.out.println("Has ingreado menos de 2 puntos para comparar, deberás ingresar un nuevo punto");
            } else {
              System.out.println("Indica el indice de los dos puntos a comparar");
              System.out.print("Index 1: ");
              int index1 = scanner.nextInt();
              System.out.print("Index 2: ");
              int index2 = scanner.nextInt();
              System.out.printf("La distancia desde el punto (%d,%d), hasta el punto (%d,%d) es %.2f \n",
                  puntos[index1].getX(), puntos[index1].getY(),
                  puntos[index2].getX(),
                  puntos[index2].getY(), Punto.calcularDistancia(puntos[index1], puntos[index2]));
            }
          }
          case 4 -> {
            if (puntos.length <= 2) {
              System.out.println("Tienes menos de 3 puntos a comparar, adiciona los puntos faltantes");
            } else {
              System.out.println("Indica el indice de los tres puntos a comparar");
              System.out.print("Index 1: ");
              int index1 = scanner.nextInt();
              System.out.print("Index 2: ");
              int index2 = scanner.nextInt();
              System.out.print("Index 3: ");
              int index3 = scanner.nextInt();

              boolean estanAlineados = Punto.estanAlineados(puntos[index1], puntos[index2], puntos[index3]);

              System.out.println("Los puntos indicados " + (estanAlineados ? "están alineados" : "no están alineados"));

            }
          }
        }
      } while (opcion != 5);

    } catch (Exception e) {
      System.out.println("Errror inesperado: " + e);
    }
  }
}
