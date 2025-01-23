
import java.util.Scanner;

public class App {
  public static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    try {
      solicitarNombre(scanner);
    } catch (MiExcepcion e) {
      System.out.println("Error: " + e.getMessage());
    } catch (Exception e) {
      System.out.println("Error inesperado: " + e);
    } finally {
      System.out.println("Bloque finally");
      scanner.close();
    }
  }

  public static void solicitarNombre(Scanner scanner) throws MiExcepcion {
    System.out.println("Por favor, indica tu nombre: ");
    String nombre = scanner.nextLine();
    if (nombre.length() < 2) {
      throw new MiExcepcion("El nombre ingresado debe ser mayor a 2 caracteres");
    }
    System.out.println("Hola, " + nombre);
  }
}