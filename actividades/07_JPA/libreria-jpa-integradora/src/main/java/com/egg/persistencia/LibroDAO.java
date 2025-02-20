package com.egg.persistencia;
import com.egg.entidades.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class LibroDAO {

  private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaJPA");
  private final EntityManager em = emf.createEntityManager();

  public void adicionarLibro(Libro libro) {
    em.getTransaction().begin();
    em.persist(libro);
    em.getTransaction().commit();
  }

  public void actualizarLibro(Libro libro) {
    em.getTransaction().begin();
    em.merge(libro);
    em.getTransaction().commit();
  }

  public Libro buscarLibro(Long isbn) {
    return em.find(Libro.class, isbn);
  }

  public List<Libro> buscarLibroPorAutor(String autor) {
    String query = "SELECT l FROM Libro l JOIN l.autor a WHERE a.nombre = :autor";
    return em.createQuery(query, Libro.class)
        .setParameter("autor", autor)
        .getResultList();
  }

  public List<Libro> buscarLibroPorEditorial(String editorial) {
    String query = "SELECT l FROM Libro l JOIN l.editorial a WHERE a.nombre = :editorial";
    return em.createQuery(query, Libro.class)
        .setParameter("autor", editorial)
        .getResultList();
  }


  public Libro buscarLibroPorTitulo(String titulo) {
    String query = "SELECT l from Libro l WHERE nombre= :nombre";
    return em.createQuery(query, Libro.class).setParameter("nombre", titulo).getSingleResult();
  }

//  public Libro listarLibrosPorTitulo(String tituloABuscar) {
//    try {
//      return em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo", Libro.class)
//          .setParameter("titulo", "%" + tituloABuscar + "%")
//          .setMaxResults(1)
//          .getSingleResult();
//    } catch (Exception e) {
//      System.out.println(e);
//      return null;
//    }
//  }

  public List<Libro> listarTodosLosLibros() {
    return em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
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
