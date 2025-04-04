package com.example.libreriaapi.servicios;

import com.example.libreriaapi.entidades.Editorial;
import com.example.libreriaapi.modelos.EditoriaCreatelDTO;
import com.example.libreriaapi.modelos.EditorialDTO;
import com.example.libreriaapi.repositorios.EditorialRepositorio;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditorialServicio {

  private final EditorialRepositorio editorialRepositorio;

  @Transactional
  public void crearEditorial(EditoriaCreatelDTO editorialDTO) {
    Editorial editorial = new Editorial();
    editorial.setNombreEditorial(editorialDTO.getNombreEditorial());
    editorial.setEditorialActiva(true);
    editorialRepositorio.save(editorial);
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
  public List<Editorial> obtenerEditorialesInactivas() {
    return editorialRepositorio.findByEditorialActivaFalse();
  }

  @Transactional(readOnly = true)
  public Editorial obtenerEditorialPorId(UUID id) {
    Optional<Editorial> editorial = editorialRepositorio.findById(id);
    if (editorial.isPresent()) return editorial.get();
    else throw new NoSuchElementException("No se encontró el editorial con ID: " + id);
  }

  @Transactional
  public void modificarEditorial(String nombre, UUID id) {
    Optional<Editorial> respuesta = editorialRepositorio.findById(id);
    if (respuesta.isPresent()) {
      Editorial editorial = respuesta.get();
      editorial.setNombreEditorial(nombre);
      editorialRepositorio.save(editorial);
    } else {
      throw new NoSuchElementException("No se encontró el editorial con ID: " + id);
    }
  }

  @Transactional(readOnly = true)
  public EditorialDTO obtenerEditorial(UUID id){
    Optional<Editorial> optionalEditorial = editorialRepositorio.findById(id);
    Editorial editorial = null;
    if (optionalEditorial.isPresent()){
      editorial = optionalEditorial.get();
      return new EditorialDTO(editorial.getId(),
          editorial.getNombreEditorial(),
          editorial.getEditorialActiva());
    } else {
      throw new EntityNotFoundException();
    }
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