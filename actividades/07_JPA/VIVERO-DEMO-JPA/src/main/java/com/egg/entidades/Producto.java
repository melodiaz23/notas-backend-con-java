package com.egg.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="producto")
public class Producto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_producto")
  private int idProducto;

  @Column(name = "cantidad_en_stock")
  private short cantidadEnStock;

  @Column(name = "codigo_producto")
  private int codigoProducto;

  @Column(name="descripcion")
  private String descripcion;

  @Column (name="dimensiones")
  private String dimensiones;

  @Column (name="nombre")
  private String nombre;

  @Column (name="proveedor")
  private String proveedor;

  @Column (name="precioVenta")
  private double precioVenta;

  @Column (name="precioProveedor")
  private double precioProveedor;

  @ManyToOne
  @JoinColumn (name="id_gama")
  private GamaProducto gamaProducto;

  public Producto() {
  }

  public int getIdProducto() {
    return idProducto;
  }

  public void setIdProducto(int idProducto) {
    this.idProducto = idProducto;
  }

  public int getCodigoProducto() {
    return codigoProducto;
  }

  public void setCodigoProducto(int codigoProducto) {
    this.codigoProducto = codigoProducto;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }


  public String getDimensiones() {
    return dimensiones;
  }

  public void setDimensiones(String dimensiones) {
    this.dimensiones = dimensiones;
  }

  public String getProveedor() {
    return proveedor;
  }

  public void setProveedor(String proveedor) {
    this.proveedor = proveedor;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public short getCantidadEnStock() {
    return cantidadEnStock;
  }

  public void setCantidadEnStock(short cantidadEnStock) {
    this.cantidadEnStock = cantidadEnStock;
  }

  public double getPrecioVenta() {
    return precioVenta;
  }

  public void setPrecioVenta(double precioVenta) {
    this.precioVenta = precioVenta;
  }

  public double getPrecioProveedor() {
    return precioProveedor;
  }

  public void setPrecioProveedor(double precioProveedor) {
    this.precioProveedor = precioProveedor;
  }

  public GamaProducto getGamaProducto() {
    return gamaProducto;
  }

  public void setGamaProducto(GamaProducto gamaProducto) {
    this.gamaProducto = gamaProducto;
  }

}
