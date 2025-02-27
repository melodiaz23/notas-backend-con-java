package com.egg.biblioteca.repositorios;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, UUID> {

  @Query("SELECT a FROM Autor a WHERE a.nombre = :nombre")
  public Autor buscaAutor(@Param("nombre") String nombre);

}
