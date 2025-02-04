package entidades;

public class Pago {
  private int idPago;
  private int idCliente;
  private String formaPago;
  private String idTransaccion;
  private int fechaPago;
  private Double total;

  public Pago( int idPago,int idCliente, String formaPago, String idTransaccion,
               int fechaPago, double total) {
    this.idPago = idPago;
    this.idCliente = idCliente;
    this.formaPago = formaPago;
    this.idTransaccion = idTransaccion;
    this.fechaPago = fechaPago;
    this.total = total;
  }

  public Pago( int idCliente, String formaPago, String idTransaccion,
               int fechaPago, double total) {
    this.idCliente = idCliente;
    this.formaPago = formaPago;
    this.idTransaccion = idTransaccion;
    this.fechaPago = fechaPago;
    this.total = total;
  }

  public Pago() {
  }

  public int getIdCliente() {
    return idCliente;
  }

  public int getIdPago() {
    return idPago;
  }

  public String getFormaPago() {
    return formaPago;
  }

  public String getIdTransaccion() {
    return idTransaccion;
  }

  public int getFechaPago() {
    return fechaPago;
  }

  public Double getTotal() {
    return total;
  }

  public void setIdPago(int idPago) {
    this.idPago = idPago;
  }

  public void setIdCliente(int idCliente) {
    this.idCliente = idCliente;
  }

  public void setFormaPago(String formaPago) {
    this.formaPago = formaPago;
  }

  public void setIdTransaccion(String idTransaccion) {
    this.idTransaccion = idTransaccion;
  }

  public void setFechaPago(int fechaPago) {
    this.fechaPago = fechaPago;
  }

  public void setTotal(Double total) {
    this.total = total;
  }
}