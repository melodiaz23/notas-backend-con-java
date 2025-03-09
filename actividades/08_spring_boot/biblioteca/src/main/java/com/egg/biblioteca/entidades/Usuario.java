package com.egg.biblioteca.entidades;

import com.egg.biblioteca.enumeraciones.Rol;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
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


  public Usuario() {
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Rol getRol() {
    return rol;
  }

  public void setRol(Rol rol) {
    this.rol = rol;
  }
}
