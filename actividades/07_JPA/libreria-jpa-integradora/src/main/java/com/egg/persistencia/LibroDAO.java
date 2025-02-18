package com.egg.persistencia;

import com.egg.entidades.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class LibroDAO {

  private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaJPA");
  private final EntityManager em = emf.createEntityManager();

  public void adicionarLibro(Libro libro){
    em.getTransaction().begin();
    em.persist(libro);
    em.getTransaction().commit();
  }

  public void actualizarLibro(Libro libro){
    em.getTransaction().begin();
    em.merge(libro);
    em.getTransaction().commit();
  }

  public Libro buscarLibro(Long isbn){
    return em.find(Libro.class, isbn);
  }

  public List<Libro> listarTodosLosLibros(){
    return em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
  }


}
