package biblioteca;
import java.util.Arrays;
import java.util.Scanner;

public class Libro {
  private String titulo;
  private String autor;
  private int paginas;

  public Libro(String titulo, String autor, int paginas) {
    this.titulo = titulo;
    this.autor = autor;
    this.paginas = paginas;
  }

  public Libro() {
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public void imprimirDetalles() {
    System.out.println("-----------");
    System.out.println("Detalles del libro");
    System.out.println("-----------");
    System.out.println("Título: " + this.titulo);
    System.out.println("Autor: " + this.autor);
    System.out.println("No. de Páginas: " + this.paginas);
  }

  // Almacena todas las instancias de los libros creados, inicia en 4 para efectos
  // de visualización de información.
  static Libro[] libros = new Libro[4];

  public static int determinarPaginas(int num) {
    return num * 7;
  }

  public static void imprimirMenuUsuario() {
    try (Scanner scanner = new Scanner(System.in)) {
      int opcion;
      do {
        System.out.println("----------");
        System.out.println("MENÚ");
        System.out.println("----------");
        System.out.println("1- Ingresar Info");
        System.out.println("2- Imprimir todos los libros");
        System.out.println("3- Imprimir detalles de un libro");
        System.out.println("4- Salir");
        opcion = scanner.nextInt();

        switch (opcion) {
          case 1 -> ingresoInfo();
          case 2 -> imprimirTodosLosLibros();
          case 3 -> System.out.println();
        }

      } while (opcion != 4);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void ingresoInfo() {
    try (Scanner scanner = new Scanner(System.in)) {
      String opcion;
      do {
        System.out.println("Ingresa los datos del libro");
        System.out.println("¿Cual es el título?");
        System.out.print(">> ");
        String titulo = scanner.nextLine();
        System.out.println("¿Cual es el autor?");
        System.out.print(">> ");
        String autor = scanner.nextLine();
        System.out.println("¿Indica un número para determinar las páginas?");
        System.out.print(">> ");
        int pagina = scanner.nextInt();
        scanner.nextLine();
        libros = Arrays.copyOf(libros, libros.length + 1);
        libros[libros.length - 1] = new Libro(titulo, autor, determinarPaginas(pagina));
        System.out.println("¿Deseas ingresar otro libro? (s/n)");
        opcion = scanner.nextLine();
      } while (opcion.equalsIgnoreCase("S"));

    } catch (Exception e) {
      System.out.println("Error inesperado: " + e);
    }
  }

  public static void imprimirTodosLosLibros() {
    System.out.println("-----------");
    System.out.println("LISTADO DE LIBROS");
    System.out.println("-----------");

    for (int i = 0; i < libros.length; i++) {
      System.out.printf("%d- %s \n", i + 1, libros[i].titulo);
    }

  }
}
