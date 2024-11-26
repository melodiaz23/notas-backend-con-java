import java.util.ArrayList;

/**
 * Crea la clase “Biblioteca” que contenga un arreglo de objetos “Libro” para
 * mantener un catálogo de libros disponibles en la biblioteca. La biblioteca
 * también debe tener un método para agregar libros al catálogo.
 */

public class Biblioteca {
    public ArrayList<Libro> libros = new ArrayList<Libro>();

    public void agregarLibro(Libro l) {
        libros.add(l);
    }

    public void eliminarLibro(Libro l) {
        libros.remove(l);
    }

    public void getLibros() {
        for (Libro l : this.libros) {
            System.out.println(l.getAutor());
        }
        ;
    }

}
