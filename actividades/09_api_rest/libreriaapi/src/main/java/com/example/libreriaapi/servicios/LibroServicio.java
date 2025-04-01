package com.example.libreriaapi.servicios;

import com.example.libreriaapi.entidades.Libro;
import com.example.libreriaapi.repositorios.LibroRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LibroServicio {

  private final LibroRepositorio libroRepositorio;


  @Transactional
  public Libro crearLibro(Libro libro) {
    libro.setLibroActivo(true);
    return libroRepositorio.save(libro);
  }

  @Transactional(readOnly = true)
  public List<Libro> obtenerTodosLibros() {
    return libroRepositorio.findAll();
  }

  @Transactional(readOnly = true)
  public List<Libro> obtenerLibrosActivos() {
    return libroRepositorio.findByLibroActivoTrue();
  }


  @Transactional(readOnly = true)
  public Optional<Libro> obtenerLibroPorIsbn(Long isbn) {
    return libroRepositorio.findById(isbn);
  }

  @Transactional
  public Libro actualizarLibro(Libro libro) {
    return libroRepositorio.save(libro);
  }


  @Transactional
  public void darBajaLibro(Long isbn) {
    Optional<Libro> libroOptional = libroRepositorio.findById(isbn);
    if (libroOptional.isPresent()) {
      Libro libro = libroOptional.get();
      libro.setLibroActivo(false);
      libroRepositorio.save(libro);
    }
  }

  @Transactional
  public void darAltaLibro(Long isbn) {
    Optional<Libro> libroOptional = libroRepositorio.findById(isbn);
    if (libroOptional.isPresent()) {
      Libro libro = libroOptional.get();
      libro.setLibroActivo(true);
      libroRepositorio.save(libro);
    }
  }

}