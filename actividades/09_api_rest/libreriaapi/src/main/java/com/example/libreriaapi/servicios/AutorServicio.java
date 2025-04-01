package com.example.libreriaapi.servicios;

import com.example.libreriaapi.entidades.Autor;
import com.example.libreriaapi.repositorios.AutorRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
  public Optional<Autor> obtenerAutorPorId(UUID id) {
    return autorRepositorio.findById(id);
  }

  @Transactional
  public Autor actualizarAutor(Autor autor) {
    return autorRepositorio.save(autor);
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