package com.egg.biblioteca.entidades;

import com.egg.biblioteca.enumeraciones.Rol;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column
  private String nombre;

  @Column
  private String email;

  @Column(name = "contraseña")
  private String password;

  @Enumerated(EnumType.STRING)
  private Rol rol;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "imagen_id")
  private Imagen imagen;

}
