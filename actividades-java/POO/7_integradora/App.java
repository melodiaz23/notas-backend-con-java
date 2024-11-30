
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    System.out.println("\033\143");

    Biblioteca.agregarLibros("Cien años de soledad", "Gabo", 350);
    Biblioteca.agregarLibros("Hábitos Atómicos", "James", 250);
    Biblioteca.agregarLibros("La casa de los espíritus", "Isabel Allende", 350);

    try (Scanner scanner = new Scanner(System.in)) {
      String opcion;

      do {
        System.out.println("Indica el nombre del libro");
        String nombreLibro = scanner.nextLine();
        System.out.println("¿Quien es el autor?");
        String autor = scanner.nextLine();
        System.out.println("Indica el número de páginas");
        int paginas = scanner.nextInt();
        scanner.nextLine();
        Biblioteca.agregarLibros(nombreLibro, autor, paginas);

        System.out.println("Deseas añadir otro libro? S/N");
        opcion = scanner.nextLine();

      } while (opcion.equalsIgnoreCase("S"));

      // do {
      System.out.println("Para prestar un libro");
      System.out.println("Ingresa el nombre");
      String nombre = scanner.nextLine();
      System.out.println("Ingresa el apellido");
      String apellido = scanner.nextLine();
      Persona persona = new Persona(nombre, apellido);

      System.out.println("Que libro deseas prestar?");
      for (int i = 0; i < Biblioteca.libros.size(); i++) {
        System.out.println((i + 1) + "-" + Biblioteca.libros.get(i).getTitulo());
      }
      int opcionLibro = scanner.nextInt();
      Biblioteca.gestionarPrestamo(Biblioteca.libros.get(opcionLibro - 1).getTitulo()); // Libro fue prestado, se
                                                                                        // marca true
      persona.adicionarLibro(Biblioteca.libros.get(opcionLibro - 1));

      // } while (false);

      System.out.println("El libro fue prestado");
      persona.mostrarInformacionPersona();

    } catch (Exception e) {
      System.out.println("Error inesperado: " + e);
    }

    // Revista[] revistas = new Revista[3];

    // revistas[0] = new Revista(1, 50, "Ciencia Hoy");
    // revistas[1] = new Revista(2, 0, "Tecnología Moderna");
    // revistas[2] = new Revista(3, 20, "Historia y Cultura");

    // try (Scanner scanner = new Scanner(System.in)) {
    // for (Revista revista : revistas) {
    // revista.obtenerInformacion();
    // revista.prestar();
    // System.out.println("- DESPUES DE PRESTAR -");
    // revista.obtenerInformacion();

    // System.out.println("Deseas devolver el ejemplar?, indica el id");
    // String idEjemplar = scanner.nextLine();
    // revista.devolver(idEjemplar);
    // System.out.println("- DESPUES DE DEVOLVER -");
    // revista.obtenerInformacion();
    // System.out.println();
    // System.out.println("-----------");
    // System.out.println();
    // }
    // } catch (Exception e) {
    // System.out.println("Error inesperado: " + e);
    // }

  }
}