package com.example.libreriaapi.repositorios;

import com.example.libreriaapi.entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AutorRepositorio extends JpaRepository<Autor, UUID> {

  List<Autor> findByAutorActivoTrue();
}
