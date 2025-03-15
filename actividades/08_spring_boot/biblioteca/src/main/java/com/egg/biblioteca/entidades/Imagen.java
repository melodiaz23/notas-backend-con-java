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
public class Imagen {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String mime;
  private String nombre;

  @Lob
  @Basic(fetch = FetchType.LAZY)
  @Column(columnDefinition = "LONGBLOB")
  private byte[] contenido;

}
