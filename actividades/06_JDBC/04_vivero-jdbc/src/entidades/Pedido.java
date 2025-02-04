package entidades;

import java.util.Date;

public class Pedido {
  private int idPedido;
  private int codigoPedido;
  private Date fechaPedido;
  private Date fechaEspera;
  private Date fechaEntrega;
  private String estado;
  private String comentarios;
  private int idCliente;

  public Pedido(int idPedido, int codigoPedido, Date fechaPedido, Date fechaEspera, Date fechaEntrega, String estado, String comentarios, int idCliente) {
    this.idPedido = idPedido;
    this.codigoPedido = codigoPedido;
    this.fechaPedido = fechaPedido;
    this.fechaEspera = fechaEspera;
    this.fechaEntrega = fechaEntrega;
    this.estado = estado;
    this.comentarios = comentarios;
    this.idCliente = idCliente;
  }

  public Pedido(int codigoPedido, Date fechaPedido, Date fechaEspera, Date fechaEntrega, String estado, String comentarios, int idCliente) {
    this.codigoPedido = codigoPedido;
    this.fechaPedido = fechaPedido;
    this.fechaEspera = fechaEspera;
    this.fechaEntrega = fechaEntrega;
    this.estado = estado;
    this.comentarios = comentarios;
    this.idCliente = idCliente;
  }

  public Pedido() {
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

  public Date getFechaPedido() {
    return fechaPedido;
  }

  public void setFechaPedido(Date fechaPedido) {
    this.fechaPedido = fechaPedido;
  }

  public Date getFechaEspera() {
    return fechaEspera;
  }

  public void setFechaEspera(Date fechaEspera) {
    this.fechaEspera = fechaEspera;
  }

  public Date getFechaEntrega() {
    return fechaEntrega;
  }

  public void setFechaEntrega(Date fechaEntrega) {
    this.fechaEntrega = fechaEntrega;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getComentarios() {
    return comentarios;
  }

  public void setComentarios(String comentarios) {
    this.comentarios = comentarios;
  }

  public int getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(int idCliente) {
    this.idCliente = idCliente;
  }

  @Override
  public String toString() {
    return "Pedido{" +
        "idPedido=" + idPedido +
        ", codigoPedido=" + codigoPedido +
        ", fechaPedido=" + fechaPedido +
        ", fechaEspera=" + fechaEspera +
        ", fechaEntrega=" + fechaEntrega +
        ", estado='" + estado + '\'' +
        ", comentarios='" + comentarios + '\'' +
        ", idCliente=" + idCliente +
        '}';
  }
}
