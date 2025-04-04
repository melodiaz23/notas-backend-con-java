package com.example.libreriaapi.servicios;

import com.example.libreriaapi.entidades.Autor;
import com.example.libreriaapi.entidades.Editorial;
import com.example.libreriaapi.entidades.Libro;
import com.example.libreriaapi.modelos.EditorialDTO;
import com.example.libreriaapi.modelos.LibroCreateDTO;
import com.example.libreriaapi.modelos.LibroDTO;
import com.example.libreriaapi.modelos.LibroListarActivosDTO;
import com.example.libreriaapi.repositorios.LibroRepositorio;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LibroServicio {

  private final LibroRepositorio libroRepositorio;
  private final AutorServicio autorServicio;
  private final EditorialServicio editorialServicio;

  @Transactional
  public void crearLibro(LibroCreateDTO libroCreateDTO) {
    Libro libroNvo = new Libro();
    libroNvo.setIsbn(libroCreateDTO.getIsbn());
    libroNvo.setTitulo(libroCreateDTO.getTitulo());
    libroNvo.setEjemplares(libroCreateDTO.getEjemplares());
    libroNvo.setLibroActivo(libroCreateDTO.isLibroActivo());
    Autor autor = autorServicio.obtenerAutorPorId(libroCreateDTO.getIdAutor());
    libroNvo.setAutor(autor);
    Editorial editorial = editorialServicio.obtenerEditorialPorId(libroCreateDTO.getIdEditorial());
    libroNvo.setEditorial(editorial);
    libroRepositorio.save(libroNvo);
  }

  @Transactional(readOnly = true)
  public List<Libro> obtenerTodosLibros() {
    return libroRepositorio.findAll();
  }

  @Transactional(readOnly = true)
  public List<LibroListarActivosDTO> obtenerLibrosActivos() {
    return libroRepositorio.encontrarActivos();
  }

  @Transactional(readOnly = true)
  public LibroDTO obtenerLibroPorIsbn(Long isbn) {
    Optional<Libro> libro = libroRepositorio.findById(isbn);
    LibroDTO libroDTO;
    if (libro.isPresent()){
      EditorialDTO editorial = editorialServicio.obtenerEditorial(libro.get().getEditorial().getId());
      Autor autor = autorServicio.obtenerAutorPorId(libro.get().getAutor().getId());
      libroDTO = new LibroDTO(libro.get().getIsbn(),
          libro.get().getTitulo(),
          libro.get().getEjemplares(),
          libro.get().getLibroActivo(),
          autor.getNombreAutor(),
          editorial.getNombre());
    } else {
      throw new EntityNotFoundException();
    }
    return libroDTO;
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