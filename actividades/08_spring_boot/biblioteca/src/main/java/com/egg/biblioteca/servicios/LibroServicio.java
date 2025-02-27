package com.egg.biblioteca.servicios;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
  public void crearLibro(Long isbn, String titulo, Integer ejemplares, UUID idAutor, UUID idEditorial) {
    try {
      Autor autor = autorRepositorio.findById(idAutor).get();
      Editorial editorial = editorialRepositorio.findById(idEditorial).get();

      Libro libro = new Libro();
      libro.setIsbn(isbn);
      libro.setTitulo(titulo);
      libro.setEjemplares(ejemplares);
      libro.setAlta(new Date(0));
      libro.setAutor(autor);
      libro.setEditorial(editorial);
      libroRepositorio.save(libro);

    } catch (Exception e) {
      System.out.println("Error al crear el libro");
    }
  }

  @Transactional(readOnly = true)
  public List<Libro> listarLibros() {
    return libroRepositorio.findAll();
  }

  @Transactional
  public void modificarLibro(Long isbn, String titulo, Integer ejemplares, UUID idAutor, UUID idEditorial){
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
}
