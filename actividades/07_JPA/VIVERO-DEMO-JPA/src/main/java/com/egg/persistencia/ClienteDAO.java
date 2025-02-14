package com.egg.persistencia;
import com.egg.entidades.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.RollbackException;

public class ClienteDAO {
  private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
  private final EntityManager em = emf.createEntityManager();

  public void guardarCliente (Cliente cliente) {
    em.getTransaction().begin();
    em.persist(cliente);
    em.getTransaction().commit();
  }

  public Cliente buscarCliente(int id) {
    return em.find(Cliente.class, id);
  }

  public void actualizarCliente(Cliente cliente){
   try {
     em.getTransaction().begin();
     em.merge(cliente);
     em.getTransaction().commit();
   } catch (RollbackException e){
      System.out.println("Error al realizar el commit en actualizar cliente: " + e);
    } finally {
      System.out.println("Cliente actualizado");
    }
  }

  public void eliminarCliente(Cliente cliente){
    em.getTransaction().begin();
    em.remove(cliente);
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
