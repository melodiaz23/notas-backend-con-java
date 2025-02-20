package com.egg.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "autor")
public class Autor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_autor")
  private Integer id;

  @Column(name = "nombre", length = 64)
  private String nombre;


  @Column(name = "alta", columnDefinition = "boolean default true")
  private boolean alta=true;

  public Autor() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public boolean getAlta() {
    return alta;
  }

  public void setAlta(boolean alta) {
    this.alta = alta;
  }

  @Override
  public String toString() {
    return "Autor{" +
        "id=" + id +
        ", nombre='" + nombre + '\'' +
        ", alta=" + alta +
        '}';
  }
}
