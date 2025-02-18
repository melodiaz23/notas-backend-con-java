package com.egg.persistencia;
import com.egg.entidades.Editorial;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class EditorialDAO {
  private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaJPA");
  private final EntityManager em = emf.createEntityManager();

  public void adicionarEditorial(Editorial editorial){
    em.getTransaction().begin();
    em.persist(editorial);
    em.getTransaction().commit();
  }

  public void actualizarEditorial(Editorial editorial){
    em.getTransaction().begin();
    em.merge(editorial);
    em.getTransaction().commit();
  }

  public Editorial buscarEditorial(Integer id){
    return em.find(Editorial.class, id);
  }

  public List<Editorial> listarTodosLasEditoriales(){
    return em.createQuery("SELECT e FROM Editorial e", Editorial.class).getResultList();
  }
}
