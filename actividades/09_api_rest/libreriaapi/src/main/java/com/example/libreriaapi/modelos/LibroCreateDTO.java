package com.example.libreriaapi.modelos;

import lombok.Data;

import java.util.UUID;

@Data
public class LibroCreateDTO {
  private Long isbn;//Este dato sera utilizado como idLibro
  private String titulo;
  private Integer ejemplares;
  private UUID idAutor;
  private UUID idEditorial;
  private boolean libroActivo;

}
