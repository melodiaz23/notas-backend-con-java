package com.example.libreriaapi.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Editorial {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "editorial_activa")
  private Boolean editorialActiva;

  @Column(name = "nombre_editorial", nullable = false)
  private boolean nombreEditorial;

}

