package com.egg.biblioteca.repositorios;

import com.egg.biblioteca.entidades.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, UUID> {

  @Query("SELECT e FROM Editorial e WHERE e.nombre = :nombre")
  public Editorial buscarPorNombreEditorial(@Param("nombre") String nombreEditorial);

}
