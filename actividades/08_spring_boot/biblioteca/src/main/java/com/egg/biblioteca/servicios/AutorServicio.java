package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AutorServicio {

  @Autowired
  private AutorRepositorio autorRepositorio;

  @Transactional
  public void crearAutor(String nombre) throws MiException{
    crearAutor(nombre);
    Autor autor = new Autor();
    autor.setNombre(nombre);

    autorRepositorio.save(autor);
  }

  @Transactional(readOnly = true)
  public List<Autor> listarAutor(){
    return autorRepositorio.findAll();
  }

  @Transactional
  public void modificarAutor(String nombre, UUID id){
    Optional<Autor> respuesta = autorRepositorio.findById(id);
    if (respuesta.isPresent()) {
      Autor autor = respuesta.get();
      autor.setNombre(nombre);
      autorRepositorio.save(autor);
    }
  }

  private void validar(String nombre) throws MiException {
    if (nombre.isEmpty() || nombre == null) {
      throw new MiException("el nombre no puede ser nulo o estar vacío");
    }
  }



}
