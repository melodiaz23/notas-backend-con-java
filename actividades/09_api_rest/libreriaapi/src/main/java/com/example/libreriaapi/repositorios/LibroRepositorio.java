package com.example.libreriaapi.repositorios;

import com.example.libreriaapi.entidades.Libro;
import com.example.libreriaapi.modelos.LibroListarActivosDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepositorio extends JpaRepository<Libro, Long> {

  List<Libro> findByLibroActivoTrue();

//  @Query("SELECT new com.example.libreriaapi.modelos.LibroListarActivosDTO(l.titulo, l.ejemplares) " +
//      "FROM Libro l WHERE l.libroActivo = true")
//  List<LibroListarActivosDTO> encontrarActivos();

    @Query("SELECT new com.example.libreriaapi.modelos.LibroListarActivosDTO(l.titulo, l.ejemplares) FROM Libro l WHERE l.libroActivo = true")
    List<LibroListarActivosDTO> encontrarActivos();


}
