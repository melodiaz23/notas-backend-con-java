package com.egg;

import com.egg.entidades.Autor;
import com.egg.servicios.AutorServicio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
  public static void main(String[] args) throws Exception {
    AutorServicio autorServicio = new AutorServicio();

//    Autor autor = new Autor();
//    autor.setNombre("Isabel Allende");
//    autor.setAlta(true);
//    autorServicio.adicionarAutor(autor);


    autorServicio.eliminarAutor(3);

    autorServicio.listarTodosLosAutores().forEach(a -> {
      System.out.println(a.getAlta());
    });

  }
}