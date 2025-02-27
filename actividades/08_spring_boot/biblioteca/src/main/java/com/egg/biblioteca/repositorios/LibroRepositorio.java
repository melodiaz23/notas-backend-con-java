package com.egg.biblioteca.repositorios;

import com.egg.biblioteca.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long> {

  @Query("SELECT l FROM Libro l WHERE l.titulo = :titulo")
  public Libro buscarPorTitulo(@Param("titulo") String titulo);

  @Query("SELECT l FROM Libro l WHERE l.autor.nombre = :nombreAutor")
  public List<Libro> buscarPorAutor(@Param("nombreAutor") String nombre);




}
