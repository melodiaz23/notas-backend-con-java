package com.example.libreriaapi.modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class EditorialDTO {
  private UUID id;
  private String nombre;
  private boolean isActive;
}
