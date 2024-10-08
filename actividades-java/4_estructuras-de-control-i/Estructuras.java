import java.util.Scanner;

public class Estructuras {
  public static void main(String[] args) {
    // Actividad 1
    Calificacion calificacion = new Calificacion();
    // Actividad 2
    Clasificacion clasificacion = new Clasificacion();
    // Actividad 3
    Divisibilidad divisibilidad = new Divisibilidad();
    // Complementarios
    Complementarias complementarias = new Complementarias();

    // try-with-resources statement
    try (Scanner readNum = new Scanner(System.in)) {
      System.out.print("Indica un número para determinar si es positivo, negativo o cero: ");
      int num = readNum.nextInt();
      clasificacion.clasificarNum(num);

      System.out.print("Indica un número entre 0 y 100: ");
      num = readNum.nextInt();
      calificacion.mostrarCalificacion(num);

      System.out.print("Indica un número para determinar si es divisible por 5 o por 3: ");
      num = readNum.nextInt();
      divisibilidad.calcularDivisibilidad(num);
      // nextInt() ignora el carácter de salto de línea pendiente (\n), que queda en
      // el buffer y sólo lee el número.
      readNum.nextLine(); // Limpia el salto de línea pendiente

      System.out.print("Escribe la contraseña: ");
      String password = readNum.nextLine();
      complementarias.reviewPassword(password);

      System.out.println("¿Cual es el precio del producto?");
      double price = readNum.nextInt();
      complementarias.calcularDescuento(price);

      System.out.println("¿Cual es tu edad?");
      int edad = readNum.nextInt();
      complementarias.determinarCategoria(edad);

    }
  }
}