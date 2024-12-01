package biblioteca;

import biblioteca.modelos.Libro;
import biblioteca.modelos.Pelicula;
import biblioteca.modelos.Persona;
import biblioteca.modelos.Revista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Biblioteca {
  static List<Libro> libros = new ArrayList<>();
  static List<Revista> revistas = new ArrayList<>();
  static List<Pelicula> peliculas = new ArrayList<>();
  static List<Persona> personas = new ArrayList<>();

  public void agregarLibro(String titulo, String autor, int paginas) {
    libros.add(new Libro(titulo, autor, paginas));
  }

  public void eliminarLibro(Libro libro) {
    libros.remove(libro);
  }

  public void agregarRevista(int nroEdicion, int ejemplares, String nombreRevista) {
    revistas.add(new Revista(nroEdicion, ejemplares, nombreRevista));
  }

  public void agregarPelicula(String titulo, String autor, int paginas) {
    // pendiente
  }

  public static void gestionarPrestamoLibro(Scanner scanner, Libro libro) {
    scanner.nextLine();
    System.out.println("Ingresa el nombre de la persona que prestará " + libro.getTitulo());
    System.out.print(">> ");
    String nombre = scanner.nextLine().trim().toUpperCase();
    System.out.println("Ingresa el apellido");
    System.out.print(">> ");
    String apellido = scanner.nextLine().trim().toUpperCase();
    Boolean personaExiste = false;
    for (Persona persona : personas){
      if (persona.getNombre().equalsIgnoreCase(nombre) && persona.getApellido().equalsIgnoreCase(apellido)){
        persona.adicionarLibro(libro);
        personaExiste = true;
        libro.prestar();
        break;
      }
    }
    if (!personaExiste) {
    Persona persona = new Persona(nombre, apellido);
    persona.adicionarLibro(libro);
    libro.prestar();
    personas.add(persona);
    }
  }

  public static void listarLibros(){
    libros.forEach(libro -> {
      System.out.println((libros.indexOf(libro)+1) + "- " + libro.getTitulo());
    });
  }

  public static void listarLibrosPrestados(){
    AtomicInteger contador = new AtomicInteger(1); // Contador externo para imprimir numeración.
    Biblioteca.libros.forEach(libro -> {
      if (libro.isPrestado()){
        System.out.println(contador.getAndIncrement() + "- " + libro.getTitulo());
      }
    });
  }

  public static void listarLibrosDisponibles(){
    AtomicInteger contador = new AtomicInteger(1);
    Biblioteca.libros.forEach(libro -> {
      if (!libro.isPrestado()){
        System.out.println(contador.getAndIncrement() + "- " + libro.getTitulo());
      }
    });
  }



}
