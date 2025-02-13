package com.egg.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="empleado")
public class Empleado {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_empleado")
  private int idEmpleado;

  @Column(name = "apellido", length = 50)
  private String apellido;

  @Column(name = "codigo_empleado")
  private int codigoEmpleado;

  @Column(name = "email", length = 100)
  private String email;

  @Column(name = "extension", length = 10)
  private String extension;

  @Column(name = "id_jefe")
  private int idJefe;

  @Column(name = "nombre", length = 50)
  private String nombre;

  @Column(name = "puesto")
  private String puesto;

  @ManyToOne // "Muchos empleados pueden pertenecer a una misma oficina"
  @JoinColumn(name = "id_oficina") //// Establezco la relacion con Oficina. Indico con que "dato se relacionan".
  private Oficina oficina;

  public Empleado(){}

  public String getApellido() {
    return apellido;
  }

  public int getCodigoEmpleado() {
    return codigoEmpleado;
  }

  public String getEmail() {
    return email;
  }

  public String getExtension() {
    return extension;
  }

  public int getIdEmpleado() {
    return idEmpleado;
  }

  public int getIdJefe() {
    return idJefe;
  }

  public Oficina getOficina() {
    return oficina;
  }

  public String getNombre() {
    return nombre;
  }

  public String getPuesto() {
    return puesto;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public void setCodigoEmpleado(int codigoEmpleado) {
    this.codigoEmpleado = codigoEmpleado;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public void setIdEmpleado(int idEmpleado) {
    this.idEmpleado = idEmpleado;
  }

  public void setIdJefe(int idJefe) {
    this.idJefe = idJefe;
  }

  public void setIdOficina(Oficina oficina) {
    this.oficina = oficina;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setPuesto(String puesto) {
    this.puesto = puesto;
  }


}

