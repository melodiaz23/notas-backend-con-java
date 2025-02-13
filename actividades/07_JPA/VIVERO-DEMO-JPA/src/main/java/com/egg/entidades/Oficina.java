package com.egg.entidades;
import jakarta.persistence.*;

@Entity
@Table(name = "oficina")
public class Oficina {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_oficina")
  private int idOficina;

  @Column(name = "ciudad", length = 30)
  private String ciudad;

  @Column(name = "codigo_postal", length = 10)
  private String codigoPostal;

  @Column(name = "codigo_oficina", length = 10)
  private String codigoOficina;

  @Column(name = "pais", length = 50)
  private String pais;

  @Column(name = "region", length = 50)
  private String region;

  @Column(name = "telefono", length = 20)
  private String telefono;

  public Oficina(){}

  public String getCiudad() {
    return ciudad;
  }

  public String getCodigoOficina() {
    return codigoOficina;
  }
  public String getCodigoPostal() {
    return codigoPostal;
  }
  public int getIdOficina() {
    return idOficina;
  }
  public String getPais() {
    return pais;
  }
  public String getRegion() {
    return region;
  }
  public String getTelefono() {
    return telefono;
  }
  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }
  public void setCodigoOficina(String codigoOficina) {
    this.codigoOficina = codigoOficina;
  }
  public void setCodigoPostal(String codigoPostal) {
    this.codigoPostal = codigoPostal;
  }
  public void setIdOficina(int idOficina) {
    this.idOficina = idOficina;
  }
  public void setPais(String pais) {
    this.pais = pais;
  }
  public void setRegion(String region) {
    this.region = region;
  }
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

}

