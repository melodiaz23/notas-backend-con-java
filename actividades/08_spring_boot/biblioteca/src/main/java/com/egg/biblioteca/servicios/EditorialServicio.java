package com.egg.biblioteca.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.EditorialRepositorio;



@Service
public class EditorialServicio {

  @Autowired
  private EditorialRepositorio editorialRepositorio;

  @Transactional
  public void crearEditorial(String nombre) throws MiException{
    validar(nombre);
    Editorial editorial = new Editorial();
    editorial.setNombre(nombre);
    editorialRepositorio.save(editorial);
  }

  @Transactional(readOnly = true)
  public List<Editorial> listarEditoriales() {
    List<Editorial> editoriales = new ArrayList<>();
    editoriales = editorialRepositorio.findAll();
    return editoriales;
  }

  @Transactional
  public void modificarEditorial(String nombre, UUID id) throws MiException{
    validar(nombre);
    Optional<Editorial> respuesta = editorialRepositorio.findById(id);
    if(respuesta.isPresent()) {
      Editorial editorial = respuesta.get();
      editorial.setNombre(nombre);
      editorialRepositorio.save(editorial);
    }
  }

  public void validar(String nombre) throws MiException {
    if(nombre.isEmpty() || nombre == null) {
      throw new MiException("El nombre no puede ser nullo o estar vacío");
    }
  }
}