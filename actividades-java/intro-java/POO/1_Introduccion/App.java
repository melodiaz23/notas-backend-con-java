
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    System.out.println("\033\143");
    // System.out.println("ACTIVIDAD 1");
    // System.out.println("-----------");
    // Persona persona = new Persona();
    // persona.nombre = "Melissa";
    // persona.edad = 30;
    // persona.imprimirDatos();
    // Persona persona2 = new Persona();
    // persona2.nombre = "Jane";
    // persona2.edad = 24;
    // System.out.printf("Los datos de la persona 2 son: \nNombre: %s\n Edad: %d
    // \n", persona2.nombre, persona2.edad);

    System.out.println("ACTIVIDAD 2");
    System.out.println("-----------");
    Auto auto1 = new Auto("Mazda", "3", 2024);
    Auto auto2 = new Auto("Mazda", "3");
    Auto auto3 = new Auto("Mazda");
    Auto auto4 = new Auto();

    System.out.println("Auto 1");
    auto1.imprimirDatos();
    System.out.println("-----------");
    System.out.println("Auto 2");
    auto2.imprimirDatos();
    System.out.println("-----------");
    System.out.println("Auto 3");
    auto3.imprimirDatos();
    System.out.println("-----------");
    System.out.println("Auto 4");
    auto4.imprimirDatos();
    System.out.println("-----------");

    System.out.println("COMPLEMENTARIO");

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Crea un nuevo auto");
      System.out.println("Indica la arca del auto o 'N' para dejar en blanco:");
      String marca = scanner.nextLine();
      if (marca.equalsIgnoreCase("N")) {
        System.out.println("No se indicó marca");
        marca = null;
      }
      System.out.println("Indica Modelo del auto o 'N' para dejar en blanco:");
      String modelo = scanner.nextLine();
      if (modelo.equalsIgnoreCase("N")) {
        System.out.println("No se indicó modelo");
        modelo = null;
      }
      System.out.println("Indica Año del auto o '0' para dejar en blanco:");
      Integer year = scanner.nextInt();
      if (year == 0) {
        System.out.println("No se indicó año");
        year = null;
      }

      Auto autoUsuario;
      if (marca != null && modelo != null && year != null) {
        autoUsuario = new Auto(marca, modelo, year);
      } else if (marca != null && modelo != null) {
        autoUsuario = new Auto(marca, modelo);
      } else if (marca != null) {
        autoUsuario = new Auto(marca);
      } else {
        autoUsuario = new Auto();
      }
      System.out.println("----------");
      autoUsuario.imprimirDatos();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}