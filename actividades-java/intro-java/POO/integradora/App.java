
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class App {
  public static void main(String[] args) {
    System.out.println("\033\143");
    Random random = new Random();

    try (Scanner scanner = new Scanner(System.in)) {
      Biblioteca biblioteca = new Biblioteca();

      for (Integer i = 0; i < 10; i++) {
        Libro libro = new Libro("Libro " + (i + 1), "Autor " + (i + 1), random.nextInt(200) + 300);
        biblioteca.agregarLibro(libro);
      }
      int opcion = 0;
      do {
        System.out.println("------------");
        System.out.println("Bienvenido a la biblioteca");
        System.out.println("1- Mostrar informacion de un libro");
        System.out.println("2- Cargar nuevo Libro");
        System.out.println("3- Salir");
        System.out.println("------------");
        System.out.print("Opcion selecionada: ");
        opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion) {
          case 1 -> {
            System.out.println("De que libro queres ver los datos? ");
            System.out.println("Nº -- Título");
            for (int i = 1; i < biblioteca.libros.size() + 1; i++) {
              System.out.printf("%d: %s\n", i, biblioteca.libros.get(i - 1).getTitulo());
              ;
            }
            Integer libroSeleccionado = scanner.nextInt();
            biblioteca.libros.get(libroSeleccionado - 1).mostrarInformacion();

          }
          case 2 -> {
            System.out.println("Opción de menú CARGAR, seleccionada.");
            System.out.println("Ingrese el titulo del libro: ");
            String titulo = scanner.nextLine();
            System.out.println("Ingrese el autor del libro: ");
            String autor = scanner.nextLine();
            System.out.println("Ingrese el numero de paginas del libro: ");
            Integer numeroPaginas = scanner.nextInt();
            Libro libro = new Libro(titulo, autor, numeroPaginas);
            biblioteca.agregarLibro(libro);
          }
          case 3 -> System.out.println("Saliendo del programa");
          default -> System.out.println("Opción seleccionada NO es válida.");
        }
      } while (opcion != 3);

    } catch (InputMismatchException e) {
      System.out.println("NO INGRESASTE UN NUMEROOOOO  " + e);
    } catch (Exception e) {
      System.out.println("Error inesperado: " + e);
    }

  }

}