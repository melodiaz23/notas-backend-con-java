package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AutorServicio {

  @Autowired
  private AutorRepositorio autorRepositorio;

  @Transactional
  public void crearAutor(String nombre) throws MiException{
    validar(nombre);
    Autor autor = new Autor();
    autor.setNombre(nombre);
    autorRepositorio.save(autor);
  }

  @Transactional(readOnly = true)
  public List<Autor> listarAutores(){
    return autorRepositorio.findAll();
  }

  @Transactional
  public void modificarAutor(String nombre, UUID id) throws MiException {
    Optional<Autor> respuesta = autorRepositorio.findById(id);
    if (respuesta.isPresent()) {
      Autor autor = respuesta.get();
      autor.setNombre(nombre);
      autorRepositorio.save(autor);
    } else {
      throw new MiException("Error al modificar autor");
    }
  }

  @Transactional(readOnly = true)
  public Autor getOne(UUID id){
    return autorRepositorio.getReferenceById(id);
  }

  private void validar(String nombre) throws MiException {
    if (nombre == null || nombre.isEmpty()) {
      throw new MiException("El nombre no puede ser nulo o estar vacío");
    }
  }



}
