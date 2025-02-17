package com.egg.persistencia;

import com.egg.entidades.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class EmpleadoDAO {

  private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
  private final EntityManager em = emf.createEntityManager();


  public void eliminarEmpleado(int id) {
    Empleado empleado = em.find(Empleado.class, id);
    if (empleado != null) {
      em.getTransaction().begin();
      em.remove(empleado);
      em.getTransaction().commit();
    }
  }

  public List<Empleado> buscarEmpleadoPorId(int id){
    String query = "SELECT e FROM Empleado e  WHERE e.oficina.id= :id";
    return em.createQuery(query, Empleado.class).setParameter("id", id).getResultList();
  }

  public List<Empleado> listarEmpleadosConOficina(){
    String query = "SELECT e.nombre, o.ciudad, o.idOficina FROM Empleado e JOIN Oficina o";
    return em.createQuery(query).getResultList();

  }
}