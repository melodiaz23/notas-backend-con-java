package com.example.libreriaapi.servicios;

import com.example.libreriaapi.entidades.Autor;
import com.example.libreriaapi.repositorios.AutorRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AutorServicio {

  private final AutorRepositorio autorRepositorio;

  @Transactional
  public Autor crearAutor(Autor autor) {
    autor.setAutorActivo(true);
    return autorRepositorio.save(autor);
  }

  @Transactional(readOnly = true)
  public List<Autor> obtenerTodosAutores() {
    return autorRepositorio.findAll();
  }

  @Transactional(readOnly = true)
  public List<Autor> obtenerAutoresActivos() {
    return autorRepositorio.findByAutorActivoTrue();
  }

  @Transactional(readOnly = true)
  public Autor obtenerAutorPorId(UUID id) {
    Optional<Autor> respuesta = autorRepositorio.findById(id);
    if(respuesta.isPresent()){
      return respuesta.get();
    } else {
      throw new NoSuchElementException("No se encontró el autor con ID: " + id);
    }
  }

  @Transactional
  public void modificarAutor(String nombre, UUID id) {
    Optional<Autor> respuesta = autorRepositorio.findById(id);
    if (respuesta.isPresent()) {
      Autor autor = respuesta.get();
      autor.setNombreAutor(nombre);
      autorRepositorio.save(autor);
    } else {
      throw new NoSuchElementException("No se encontró el autor con ID: " + id);
    }
  }

  @Transactional
  public void darBajaAutor(UUID id) {
    Optional<Autor> autorOptional = autorRepositorio.findById(id);
    if (autorOptional.isPresent()) {
      Autor autor = autorOptional.get();
      autor.setAutorActivo(false);
      autorRepositorio.save(autor);
    }
  }

  @Transactional
  public void darAltaAutor(UUID id) {
    Optional<Autor> autorOptional = autorRepositorio.findById(id);
    if (autorOptional.isPresent()) {
      Autor autor = autorOptional.get();
      autor.setAutorActivo(true);
      autorRepositorio.save(autor);
    }
  }
}