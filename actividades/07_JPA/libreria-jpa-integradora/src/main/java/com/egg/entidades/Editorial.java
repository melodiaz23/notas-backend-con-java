package com.egg.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "editorial")
public class Editorial {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_editorial")
  private Integer id;

  @Column(name = "nombre", length = 64)
  private String nombre;

  @Column(name = "alta")
  private boolean alta;

  public Editorial() {
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

  public Boolean getAlta() {
    return alta;
  }

  public void setAlta(Boolean alta) {
    this.alta = alta;
  }

  @Override
  public String toString() {
    return "Editorial{" +
        "id=" + id +
        ", nombre='" + nombre + '\'' +
        ", alta=" + alta +
        '}';
  }
}
