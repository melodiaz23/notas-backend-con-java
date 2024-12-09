package biblioteca.modelos;

import java.util.ArrayList;

public class Persona {
  private String nombre;
  private String apellido;
  private static ArrayList<Libro> librosPrestados = new ArrayList<>();

  public Persona(String nombre, String apellido) {
    this.nombre = nombre;
    this.apellido = apellido;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public static ArrayList<Libro> getLibros() {
    return librosPrestados;
  }

  public static void setLibros(ArrayList<Libro> libros) {
    Persona.librosPrestados = libros;
  }

  public void adicionarLibro(Libro libroPrestado) {
    librosPrestados.add(libroPrestado);
  }

  public void mostrarInformacionPersona() {
    System.out.println("Nombre " + this.nombre);
    System.out.println("Apellido " + this.apellido);
    librosPrestados.forEach(libro -> System.out.println(libro.getTitulo()));
  }

}
