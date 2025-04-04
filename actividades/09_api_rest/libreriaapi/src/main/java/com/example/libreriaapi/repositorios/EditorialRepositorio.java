package com.example.libreriaapi.repositorios;


import com.example.libreriaapi.entidades.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EditorialRepositorio extends JpaRepository<Editorial, UUID> {

  List<Editorial> findByEditorialActivaTrue();

  List<Editorial> findByEditorialActivaFalse();
}
