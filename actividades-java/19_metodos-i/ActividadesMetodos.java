import java.util.Scanner;

public class ActividadesMetodos {
  public static void main(String[] args) {
    System.out.println("\033\143"); // Limpia la consola

    try (Scanner scanner = new Scanner(System.in)) {
      imprimirNombre(obtenerNombre(scanner), obtenerEdad(scanner));
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void imprimirNombre(String nombre) {
    System.out.println("Mi nombre es " + nombre);
  }

  public static void imprimirNombre(String nombre, int edad) { // Sobrecarga del método
    System.out.printf("Me llamo %s y tengo %d años \n", nombre, edad);
  }

  public static String obtenerNombre(Scanner scanner) {
    System.out.println("Indica tu nombre: ");
    String nombre = scanner.nextLine();
    return nombre;
  }

  public static int obtenerEdad(Scanner scanner) {
    System.out.println("Cual es tu edad?");
    int edad = scanner.nextInt();
    return edad;

  }
}
