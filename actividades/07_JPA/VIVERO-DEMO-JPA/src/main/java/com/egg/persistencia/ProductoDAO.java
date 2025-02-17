package com.egg.persistencia;

import com.egg.entidades.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ProductoDAO {
  private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
  private final EntityManager em = emf.createEntityManager();


  public List<Producto> listarProductos(){
    return em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();

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
