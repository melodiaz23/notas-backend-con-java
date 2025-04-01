package com.example.libreriaapi.servicios;

import com.example.libreriaapi.entidades.Editorial;
import com.example.libreriaapi.repositorios.EditorialRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditorialServicio {

  private final EditorialRepositorio editorialRepositorio;

  @Transactional
  public Editorial crearEditorial(Editorial editorial) {
    editorial.setEditorialActiva(true);
    return editorialRepositorio.save(editorial);
  }

  @Transactional(readOnly = true)
  public List<Editorial> obtenerTodasEditoriales() {
    return editorialRepositorio.findAll();
  }

  @Transactional(readOnly = true)
  public List<Editorial> obtenerEditorialesActivas() {
    return editorialRepositorio.findByEditorialActivaTrue();
  }

  @Transactional(readOnly = true)
  public Optional<Editorial> obtenerEditorialPorId(UUID id) {
    return editorialRepositorio.findById(id);
  }

  @Transactional
  public Editorial actualizarEditorial(Editorial editorial) {
    return editorialRepositorio.save(editorial);
  }


  @Transactional
  public void darBajaEditorial(UUID id) {
    Optional<Editorial> editorialOptional = editorialRepositorio.findById(id);
    if (editorialOptional.isPresent()) {
      Editorial editorial = editorialOptional.get();
      editorial.setEditorialActiva(false);
      editorialRepositorio.save(editorial);
    }
  }

  @Transactional
  public void darAltaEditorial(UUID id) {
    Optional<Editorial> editorialOptional = editorialRepositorio.findById(id);
    if (editorialOptional.isPresent()) {
      Editorial editorial = editorialOptional.get();
      editorial.setEditorialActiva(true);
      editorialRepositorio.save(editorial);
    }
  }
}