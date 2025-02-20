package com.egg.servicios;
import com.egg.entidades.Autor;
import com.egg.persistencia.AutorDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class AutorServicio implements AutoCloseable {
  AutorDAO autorDAO = new AutorDAO();

  public void adicionarAutor(Autor autor) throws IllegalArgumentException {
    List<Autor> autores = buscarAutorPorNombre(autor.getNombre());
    boolean esElMismo = false;
    if (!autores.isEmpty()){
      for (Autor a : autores){
        if (autor.getNombre().equalsIgnoreCase(a.getNombre()) && !a.getAlta()){
          a.setAlta(true);
          autorDAO.actualizarAutor(a);
          System.out.println("Autor ya existía y ha sido reactivado");
          break;
        } else if (autor.getNombre().equalsIgnoreCase(a.getNombre())) {
          esElMismo = true;
        }
      }
    }
    if (!esElMismo){
      autorDAO.adicionarAutor(autor);
      System.out.println("Autor adicionado");
    } else {
      throw new IllegalArgumentException("Autor ya existe");
    }
  }

  public void eliminarAutor(Integer id) throws NoSuchElementException {
    Autor autor = autorDAO.buscarAutor(id);
    if (autor != null){
      autor.setAlta(false);
      autorDAO.actualizarAutor(autor);
      System.out.println("Autor eliminado");
    } else {
      throw new NoSuchElementException("Autor no existe");
    }
  }

  public void actualizarAutor(Autor autor){
    autorDAO.actualizarAutor(autor);
  }

  public Autor buscarAutor(Integer id) throws NoSuchElementException {
    Autor autor = autorDAO.buscarAutor(id);
    if (autor == null) {
      throw new NoSuchElementException("Autor no existe");
    }
    return autor;
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


  @Override
  public void close() throws Exception {
    autorDAO.cerrarEntidades();
  }
}
