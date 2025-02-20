package com.egg.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "libro")
public class Libro {

  @Id
  @Column(name = "isbn")
  private Long isbn;

  @Column(name = "titulo", length = 64)
  private String titulo;

  @Column(name = "anio")
  private Integer anio;

  @Column(name = "ejemplares")
  private Integer ejemplares;

  @Column(name = "alta")
  private boolean alta;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinColumn(name = "id_autor")
  private Autor autor;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinColumn(name = "id_editorial")
  private Editorial editorial;


  public Libro() {
  }

  public Long getIsbn() {
    return isbn;
  }

  public void setIsbn(Long isbn) {
    this.isbn = isbn;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public Integer getAnio() {
    return anio;
  }

  public void setAnio(Integer anio) {
    this.anio = anio;
  }

  public Integer getEjemplares() {
    return ejemplares;
  }

  public void setEjemplares(Integer ejemplares) {
    this.ejemplares = ejemplares;
  }

  public Boolean getAlta() {
    return alta;
  }

  public void setAlta(Boolean alta) {
    this.alta = alta;
  }

  public Autor getAutor() {
    return autor;
  }

  public void setAutor(Autor autor) {
    this.autor = autor;
  }

  public Editorial getEditorial() {
    return editorial;
  }

  public void setEditorial(Editorial editorial) {
    this.editorial = editorial;
  }

  @Override
  public String toString() {
    return "Libro{" +
        "isbn=" + isbn +
        ", titulo='" + titulo + '\'' +
        ", anio=" + anio +
        ", ejemplares=" + ejemplares +
        ", alta=" + alta +
        ", autor=" + autor +
        ", editorial=" + editorial +
        '}';
  }
}
