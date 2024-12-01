package biblioteca.modelos;

import biblioteca.Biblioteca;
import biblioteca.Catalogable;
import biblioteca.ItemBiblioteca;
import biblioteca.utils.GenerarID;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.Scanner;

public class Libro extends ItemBiblioteca implements Catalogable {
  private String titulo;
  private String autor;
  private Integer numeroDePaginas;
  private LocalDate fechaPrestamo;
  private String idPrestamo;
  private Boolean prestado = false;


  public Libro(String titulo, String autor, int nroPaginas) {
    this.titulo = titulo;
    this.autor = autor;
    this.numeroDePaginas = nroPaginas;
  }

  public String getTitulo() {
    return titulo;
  }

  public boolean isPrestado() {
    return prestado;
  }

  public void setPrestado(boolean prestado) {
    this.prestado = prestado;
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

  public Integer getNumeroDePaginas() {
    return numeroDePaginas;
  }

  public void setNumeroDePaginas(Integer numeroDePaginas) {
    this.numeroDePaginas = numeroDePaginas;
  }

  @Override
  public void prestar() {
    this.prestado = true;
    this.idPrestamo = GenerarID.crear();
    System.out.println("Libro prestado");
    System.out.println("Id de préstamo: " + this.idPrestamo);
  }

  @Override
  public void devolver(String idPrestamo) {
    this.idPrestamo=null;
    this.prestado = false;
    System.out.println("Libro devuelto, ahora se encuentra disponible para préstamo");
  }

  @Override
  public void calcularMultas(LocalDate fechaPrestamo) {
  }

  @Override
  public void obtenerInformacion() {
    // Text blocks - Java 15
    System.out.printf("""
        -- Información del libro --
        Titulo: %s
        Autor: %s
        Numero de paginas: %d
        A la fecha, este libro %s
        """,
            this.titulo,
            this.autor,
            this.numeroDePaginas,
				    this.prestado ? "se encuentra prestado." : "está disponible para ser prestado."
        );
  }

  @Override
  public void gestionarInfo(Scanner scanner){
    int opcion;
    do {
    System.out.println("¿Deseas gestionar información de este libro?");
    System.out.println("1- Modificar nombre del título");
    System.out.println("2- Modificar nombre del autor");
    System.out.println("3- Modificar cantidad de páginas");
    System.out.println("4- " + (!this.prestado ? "Prestar" : "Devolver") + " libro");
    System.out.println("5- Regresar al menú anterior");
    opcion=scanner.nextInt();
    switch (opcion){
      case 1 -> {
        String nuevoNombreTitulo;
        System.out.println("Indica el núevo nombre del libro");
        nuevoNombreTitulo = scanner.nextLine();
        this.titulo = nuevoNombreTitulo;
        System.out.println("Se ha modificado el nombre exitosamente.");
      }
      case 2 -> {
        String nuevoNombreAutor;
        System.out.println("Indica el núevo nombre del autor");
        nuevoNombreAutor = scanner.nextLine();
        this.autor = nuevoNombreAutor;
        System.out.println("Se ha modificado el nombre del autor exitosamente.");

      }
      case 3 -> {
        int nuevaCantidad;
        System.out.println("Indica el núevo nombre del autor");
        nuevaCantidad = scanner.nextInt();
        this.numeroDePaginas = nuevaCantidad;
        System.out.println("Se ha modificado la cantidad de páginas exitosamente.");
      }
      case 4 -> {
        if (prestado) devolver(this.idPrestamo);
        else {
          Biblioteca.gestionarPrestamo(scanner,this);
        }
      }
      case 5 -> {}
        default-> {
          System.out.println("Has ingresado una opción inválida");
        }
    }
    } while (opcion>5);



  }


}
