
package com.egg.persistencia;

import com.egg.entidades.Oficina;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.RollbackException;

public class OficinaDAO {
  private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
  private final EntityManager em = emf.createEntityManager();

  public void guardaOficina(Oficina oficina) {
    em.getTransaction().begin();
    em.persist(oficina);
    em.getTransaction().commit();
  }

  public Oficina buscarOficina(int id) {
    return em.find(Oficina.class, id);
  }

  public void actualizarOficina(Oficina oficina) throws RollbackException {
    try {
      em.getTransaction().begin();
      em.merge(oficina);
      em.getTransaction().commit();
    }
    catch (RollbackException e){
      System.out.println("Error al realizar el commit de la transacción: " + e);
    } finally {
      System.out.println("Oficina actualizada");
    }
  }

  public void eliminarOficina(Oficina oficina) {
      em.getTransaction().begin();
      em.remove(oficina);
      em.getTransaction().commit();
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
