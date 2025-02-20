package com.egg.servicios;

import java.util.List;

import com.egg.entidades.Autor;
import com.egg.entidades.Editorial;
import com.egg.entidades.Libro;
import com.egg.persistencia.AutorDAO;
import com.egg.persistencia.EditorialDAO;
import com.egg.persistencia.LibroDAO;

public class LibroServicio implements AutoCloseable {
  private final LibroDAO libroDAO = new LibroDAO();
  private final AutorDAO autorDAO = new AutorDAO();
  private final EditorialDAO editorialDAO = new EditorialDAO();

  public void registrarLibro(Libro libro) throws Exception {

    if (libro.getIsbn() == null || libro.getTitulo() == null || libro.getTitulo().trim().isEmpty() || libro.getAnio() <= 0 || libro.getEjemplares() <= 0) {
      throw new IllegalArgumentException("Todos los campos son obligatorios y deben tener valores válidos.");
    }

    if (libroDAO.buscarLibro(libro.getIsbn()) != null) {
      Libro libro2 = libroDAO.buscarLibro(libro.getIsbn());
      if (!libro2.getAlta()){
        libro2.setAlta(true);
        libroDAO.actualizarLibro(libro2);
        throw new Exception("Ya existe un libro con el ISBN, se actualizará el estado: " + libro.getIsbn());
      } else {
        throw new Exception("Ya existe un libro con el ISBN" + libro.getIsbn());

      }

    }

    Autor autorRegistrar = autorDAO.buscarAutor(libro.getAutor().getId());
    if (autorRegistrar == null) {
      throw new Exception("El autor con ID " + libro.getAutor().getId() + " no existe.");
    }

    Editorial editorialRegistrar = editorialDAO.buscarEditorial(libro.getEditorial().getId());
    if (editorialRegistrar == null) {
      throw new Exception("La editorial con ID " + libro.getEditorial().getId() + " no existe.");
    }

    if (libroDAO.buscarLibroPorTitulo(libro.getTitulo()) != null) {
      throw new Exception("Ya existe un libro con el título " + libro.getTitulo());
    }
    Libro libroACrear = new Libro();
    libroACrear.setIsbn(libro.getIsbn());
    libroACrear.setTitulo(libro.getTitulo());
    libroACrear.setAnio(libro.getAnio());
    libroACrear.setEjemplares(libro.getEjemplares());
    libroACrear.setAlta(libro.getAlta());
    libroACrear.setAutor(autorRegistrar);
    libroACrear.setEditorial(editorialRegistrar);
    libroDAO.adicionarLibro(libroACrear);
  }

  // Obtener un libro por ISBN
  public Libro obtenerLibroPorIsbn(Long isbn) {
    return libroDAO.buscarLibro(isbn);
  }

  // Obtener todos los libros
  public List<Libro> listarLibros() {
    return libroDAO.listarTodosLosLibros();
  }

  // Buscar libros por título
  public Libro buscarLibrosPorTitulo(String titulo) {
    return libroDAO.buscarLibroPorTitulo(titulo);
  }


  // Dar de baja libro
  public void darBajaLibro(Long isbn) {
    Libro libro = libroDAO.buscarLibro(isbn);
    if (libro != null) {
      libro.setAlta(false);
      libroDAO.actualizarLibro(libro);
    }
  }

  // Buscar libros por nombre del autor
//  public List<Libro> buscarLibrosPorAutor(String nombreAutor) {
//    return libroDAO.buscarLibroPorAutor(nombreAutor);
//  }
//
//  // Buscar libros por nombre de la editorial
//  public List<Libro> buscarLibrosPorEditorial(String nombreEditorial) {
//    return libroDAO.buscarLibroPorEditorial(nombreEditorial);
//  }

  // Actualizar libro
  public void actualizarLibro(Libro libro) throws Exception {
    if (libro == null || libro.getIsbn() == null) {
      throw new IllegalArgumentException("El libro y su ISBN no pueden ser nulos.");
    }
    Libro libroExistente = libroDAO.buscarLibro(libro.getIsbn());
    if (libroExistente == null) {
      throw new Exception("El libro con ISBN " + libro.getIsbn() + " no existe.");
    }

    libroExistente.setTitulo(libro.getTitulo());
    libroExistente.setAnio(libro.getAnio());
    libroExistente.setEjemplares(libro.getEjemplares());
    libroExistente.setAlta(libro.getAlta());
    libroExistente.setAutor(libro.getAutor());
    libroExistente.setEditorial(libro.getEditorial());

    libroDAO.actualizarLibro(libroExistente);
  }

  @Override
  public void close() throws Exception {
    libroDAO.cerrarEntidades();
  }
}