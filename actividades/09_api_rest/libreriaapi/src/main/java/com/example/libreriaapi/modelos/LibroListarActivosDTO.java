package com.example.libreriaapi.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class LibroListarActivosDTO {
  private String titulo;
  private Integer ejemplares;
}
