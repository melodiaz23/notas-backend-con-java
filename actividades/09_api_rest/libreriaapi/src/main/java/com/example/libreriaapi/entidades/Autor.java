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
@Table(name = "autores")
public class Autor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "autor_activo")
  private boolean autorActivo;


  @Column(name = "nombre_autor", nullable = false)
  private String nombreAutor;
}

