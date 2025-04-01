package com.example.libreriaapi.repositorios;

import com.example.libreriaapi.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepositorio extends JpaRepository<Libro, Long> {

  List<Libro> findByLibroActivoTrue();
}
