package com.egg.biblioteca.entidades;

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
//  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column
  private String nombre;

}
