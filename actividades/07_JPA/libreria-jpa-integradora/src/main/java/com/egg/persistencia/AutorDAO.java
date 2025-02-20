package com.egg.persistencia;

import com.egg.entidades.Autor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class AutorDAO {
  private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaJPA");
  private final EntityManager em = emf.createEntityManager();

  public void adicionarAutor(Autor autor){
    em.getTransaction().begin();
    em.persist(autor);
    em.getTransaction().commit();
  }

  public void actualizarAutor(Autor autor){
    em.getTransaction().begin();
    em.merge(autor);
    em.getTransaction().commit();
  }

  public Autor buscarAutor(Integer id){
    return em.find(Autor.class, id);
  }

  public List<Autor> buscarAutorPorNombre(String nombre){
    String query = "SELECT a FROM Autor a WHERE nombre LIKE :nombre";
    return em.createQuery(query, Autor.class).setParameter("nombre", "%" + nombre + "%").getResultList();
  }

  public List<Autor> listarTodosLosAutores(){
    return em.createQuery("SELECT a FROM Autor a", Autor.class).getResultList();
  }

  public void cerrarEntidades() throws Exception {
    try {
      if (em != null && em.isOpen()) {
        em.close();
      } if (emf != null && emf.isOpen()) {
        emf.close();
      }
    } catch (Exception e) {
      throw new Exception("Error al cerrar entidades");
    }
  }
}
