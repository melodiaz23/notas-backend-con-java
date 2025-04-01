package com.example.libreriaapi.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Libro {

  @Id
  private Long isbn;

  @Column
  private Integer ejemplares;

  @Column(name = "libro_activo")
  private Boolean libroActivo;

  @Column(nullable = false)
  private String titulo;

  @ManyToOne
  private Autor autor;

  @ManyToOne
  private Editorial editorial;

}
