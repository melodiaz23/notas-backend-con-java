package com.egg.servicios;

import com.egg.entidades.Libro;
import com.egg.persistencia.LibroDAO;

import java.util.List;

public class LibroServicio {
  LibroDAO libroDAO = new LibroDAO();


  public void adicionarLibro(Libro libro){
    libroDAO.adicionarLibro(libro);
  }

  public void actualizarLibro(Libro libro){
    libroDAO.actualizarLibro(libro);
  }

  public Libro buscarLibro(Long isbn){
    return libroDAO.buscarLibro(isbn);
  }

  public List<Libro> listarTodosLosLibros(){
    return libroDAO.listarTodosLosLibros();
  }

}
