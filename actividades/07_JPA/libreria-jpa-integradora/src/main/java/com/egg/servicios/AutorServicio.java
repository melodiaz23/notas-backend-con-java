package com.egg.servicios;

import com.egg.entidades.Autor;
import com.egg.persistencia.AutorDAO;

import java.util.ArrayList;
import java.util.List;

public class AutorServicio {
  AutorDAO autorDAO = new AutorDAO();

  public void adicionarAutor(Autor autor) throws Exception {
    if (autorExiste(autor)) {
      throw new Exception("Autor ya existe");
    }
    autorDAO.adicionarAutor(autor);
  }

  public void eliminarAutor(Integer id) throws Exception {
    Autor autor = autorDAO.buscarAutor(id);
    if (autor != null){
      autor.setAlta(false);
      autorDAO.actualizarAutor(autor);
    } else {
      throw new Exception("Autor no existe");
    }

  }

  public void actualizarAutor(Autor autor){
    autorDAO.actualizarAutor(autor);
  }

  public Autor buscarAutor(Integer id){
    return autorDAO.buscarAutor(id);
  }

  public List<Autor> listarTodosLosAutores(){
    List<Autor> autores = new ArrayList<>();
    for (Autor autor : autorDAO.listarTodosLosAutores()){
      // Si el autor no ha sido "eliminado"...
      if (autor.getAlta()) autores.add(autor);
    }
    return autores;
  }

  public List<Autor> buscarAutorPorNombre(String nombre){
    return autorDAO.buscarAutorPorNombre(nombre);
  }

  private Boolean autorExiste(Autor autor){
    return !autorDAO.buscarAutorPorNombre(autor.getNombre()).isEmpty();
  }


}
