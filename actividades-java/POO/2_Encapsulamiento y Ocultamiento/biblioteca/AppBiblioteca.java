package biblioteca;

public class AppBiblioteca {

  public static void main(String[] args) {
    System.out.println("\033\143");

    Libro.libros[0] = new Libro("1984", "George Orwell", 328);
    Libro.libros[1] = new Libro("Hábitos atómicos", "James Clear", 320);
    Libro.libros[2] = new Libro("La casa de los espíritus", "Isabel Allende", 496);
    Libro.libros[3] = new Libro("Cien años de soledad", "Gabo", 471);

    Libro.ingresoInfo();
    Libro.imprimirTodosLosLibros();

   for (Libro libro : Libro.libros){
     libro.imprimirDetalles();
   }

  }
}
