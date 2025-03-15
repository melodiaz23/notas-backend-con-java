package com.egg.biblioteca.entidades;

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
  private String titulo;

  @Column
  private Integer ejemplares;

  @Temporal(TemporalType.DATE)
  private Date alta;

  @ManyToOne
  private Autor autor;

  @ManyToOne
  private Editorial editorial;

}
