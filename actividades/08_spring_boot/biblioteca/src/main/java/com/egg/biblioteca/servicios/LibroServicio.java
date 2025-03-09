package com.egg.biblioteca.servicios;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.egg.biblioteca.excepciones.MiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.entidades.Libro;
import com.egg.biblioteca.repositorios.AutorRepositorio;
import com.egg.biblioteca.repositorios.EditorialRepositorio;
import com.egg.biblioteca.repositorios.LibroRepositorio;

@Service
public class LibroServicio {

  @Autowired
  private AutorRepositorio autorRepositorio;
  @Autowired
  private EditorialRepositorio editorialRepositorio;
  @Autowired
  private LibroRepositorio libroRepositorio;

  @Transactional
  public void crearLibro(Long isbn, String titulo, Integer ejemplares, UUID idAutor, UUID idEditorial) throws MiException {
      validar(isbn, titulo, ejemplares, idAutor, idEditorial);
      Optional<Autor> respAutor = autorRepositorio.findById(idAutor);
      Optional<Editorial> resEditorial = editorialRepositorio.findById(idEditorial);

      if (respAutor.isPresent() && resEditorial.isPresent()){
      Libro libro = new Libro();
      libro.setIsbn(isbn);
      libro.setTitulo(titulo);
      libro.setEjemplares(ejemplares);
      libro.setAlta(new Date(0));
      libro.setAutor(respAutor.get());
      libro.setEditorial(resEditorial.get());
      libroRepositorio.save(libro);
      }
  }

  @Transactional(readOnly = true)
  public List<Libro> listarLibros() {
    return libroRepositorio.findAll();
  }

  @Transactional
  public void modificarLibro(Long isbn, String titulo, Integer ejemplares, UUID idAutor, UUID idEditorial) throws MiException {
    validar(isbn, titulo, ejemplares, idAutor, idEditorial);
    Optional<Libro> respLibro = libroRepositorio.findById(isbn);
    Optional<Autor> respAutor = autorRepositorio.findById(idAutor);
    Optional<Editorial> respEditorial = editorialRepositorio.findById(idEditorial);

    if(respLibro.isPresent() && respAutor.isPresent() && respEditorial.isPresent()){
      Libro libro = respLibro.get();
      libro.setTitulo(titulo);
      libro.setEjemplares(ejemplares);
      libro.setAutor(respAutor.get());
      libro.setEditorial(respEditorial.get());
      libroRepositorio.save(libro);
    }
  }

  @Transactional(readOnly = true)
  public Libro getOne(Long isbn){
    return libroRepositorio.getReferenceById(isbn);
  }

  private void validar(Long isbn, String titulo, Integer ejemplares, UUID idAutor, UUID idEditorial) throws MiException {
    if (isbn == null) {
      throw new MiException("El ISBN no puede ser nulo.");
    }
    if (titulo == null || titulo.trim().isEmpty()) {
      throw new MiException("El título no puede ser nulo o estar vacío.");
    }
    if (ejemplares == null) {
      throw new MiException("La cantidad de ejemplares no puede ser nula.");
    }
    if (idAutor == null) {
      throw new MiException("El ID del autor no puede ser nulo o estar vacío.");
    }
    if (idEditorial == null) {
      throw new MiException("El ID de la editorial no puede ser nulo o estar vacío.");
    }
  }
}
