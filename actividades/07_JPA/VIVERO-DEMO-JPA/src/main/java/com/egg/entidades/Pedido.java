package com.egg.entidades;
import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_pedido")
  private int idPedido;

  @Column(name = "codigo_pedido")
  private int codigoPedido;

  @Column(name = "comentarios")
  private String comentarios;

  @Column(name = "estado")
  private String estado;

  @Temporal(TemporalType.DATE)
  @Column(name = "fecha_entrega")
  private Date fechaEntrega;

  @Temporal(TemporalType.DATE)
  @Column(name = "fecha_esperada")
  private Date fechaEsperada;

  @Temporal(TemporalType.DATE)
  @Column(name = "fecha_pedido")
  private Date fechaPedido;

  @ManyToOne
  @JoinColumn(name = "id_cliente")
  private Cliente cliente;

  public Pedido(){

  }

  public int getIdPedido() {
    return idPedido;
  }

  public void setIdPedido(int idPedido) {
    this.idPedido = idPedido;
  }

  public int getCodigoPedido() {
    return codigoPedido;
  }

  public void setCodigoPedido(int codigoPedido) {
    this.codigoPedido = codigoPedido;
  }

  public String getComentarios() {
    return comentarios;
  }

  public void setComentarios(String comentarios) {
    this.comentarios = comentarios;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public Date getFechaEntrega() {
    return fechaEntrega;
  }

  public void setFechaEntrega(Date fechaEntrega) {
    this.fechaEntrega = fechaEntrega;
  }

  public Date getFechaEsperada() {
    return fechaEsperada;
  }

  public void setFechaEsperada(Date fechaEsperada) {
    this.fechaEsperada = fechaEsperada;
  }

  public Date getFechaPedido() {
    return fechaPedido;
  }

  public void setFechaPedido(Date fechaPedido) {
    this.fechaPedido = fechaPedido;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

}
