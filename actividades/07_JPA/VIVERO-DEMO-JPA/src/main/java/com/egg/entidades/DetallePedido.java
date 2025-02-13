package com.egg.entidades;
import jakarta.persistence.*;

@Entity
@Table(name="detalle_pedido")
public class DetallePedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_detalle_pedido")
  private int idDetallePedido;

  @Column(name = "cantidad")
  private int cantidad;

  @Column(name = "numero_linea")
  private int numeroLinea;

  @Column(name = "precio_unidad")
  private double precioUnidad;

  @ManyToOne
  @JoinColumn(name = "id_producto")
  private Producto producto;

  @ManyToOne
  @JoinColumn(name = "id_pedido") // Indico con qué dato se relaciona
  private Pedido pedido;

  public DetallePedido() {
  }

  public int getDetallePedido() {
    return idDetallePedido;
  }

  public void setDetallePedido(int idDetallePedido) {
    this.idDetallePedido = idDetallePedido;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public int getNumeroLinea() {
    return numeroLinea;
  }

  public void setNumeroLinea(int numeroLinea) {
    this.numeroLinea = numeroLinea;
  }

  public double getPrecioUnidad() {
    return precioUnidad;
  }

  public void setPrecioUnidad(double precioUnidad) {
    this.precioUnidad = precioUnidad;
  }

}
