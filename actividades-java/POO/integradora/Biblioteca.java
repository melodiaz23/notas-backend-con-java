
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
  // static Libro[] libros = new Libro[0];

  // public static void agregarLibros(String titulo, String autor, int paginas) {
  // libros = Arrays.copyOf(libros, libros.length + 1);
  // libros[libros.length - 1] = new Libro(titulo, autor, paginas);
  // }

  static List<Libro> libros = new ArrayList<>();

  public static void agregarLibros(String titulo, String autor, int paginas) {
    libros.add(new Libro(titulo, autor, paginas));
    // libros.forEach(x -> System.out.println());
  }

  public static void gestionarPrestamo(String titulo) {
    for (Libro libro : libros) {
      if (libro.getTitulo().equalsIgnoreCase(titulo)) {
        libro.setPrestado(!libro.isPrestado());
      }
    }
  }

}
