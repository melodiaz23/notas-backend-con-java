package com.example.libreriaapi.modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LibroDTO {
  private Long isbn;
  private String nombre;
  private Integer ejemplares;
  private Boolean isActive;
  private String nombreAutor;
  private String nombreEditorial;
}
