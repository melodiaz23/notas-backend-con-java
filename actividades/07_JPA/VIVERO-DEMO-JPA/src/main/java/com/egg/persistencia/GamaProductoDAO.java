///GamaProducto DAO

package com.egg.persistencia;

import com.egg.entidades.GamaProducto;
import com.egg.entidades.Oficina;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GamaProductoDAO {
  private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
  private final EntityManager em = emf.createEntityManager();

  public void guardarGamaProducto(GamaProducto gamaProducto) throws Exception {
    em.getTransaction().begin();
    em.persist(gamaProducto);
    em.getTransaction().commit();
  }

  public GamaProducto buscarGamaProducto(int id) {
    return em.find(GamaProducto.class, id);
  }

  public void actualizarGamaProducto(GamaProducto gama) {
    em.getTransaction().begin();
    em.merge(gama);
    em.getTransaction().commit();
  }
}
    