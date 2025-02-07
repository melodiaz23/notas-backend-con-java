package entidades;

import java.util.Date;

public class Casa {
  private int idCasa;
  private String calle;
  private int numero;
  private int codigoPostal;
  private String ciudad;
  private String pais;
  private Date fechaDesde;
  private Date fechaHasta;
  private int tiempoMinimo;
  private int tiempoMaximo;
  private int precioHabitacion;
  private String tipoVivienda;

  public Casa() {
  }

  public Casa(String calle, int numero, int codigoPostal, String ciudad, String pais, Date fechaDesde, Date fechaHasta, int tiempoMinimo, int tiempoMaximo, int precioHabitacion, String tipoVivienda) {
    this.calle = calle;
    this.numero = numero;
    this.codigoPostal = codigoPostal;
    this.ciudad = ciudad;
    this.pais = pais;
    this.fechaDesde = fechaDesde;
    this.fechaHasta = fechaHasta;
    this.tiempoMinimo = tiempoMinimo;
    this.tiempoMaximo = tiempoMaximo;
    this.precioHabitacion = precioHabitacion;
    this.tipoVivienda = tipoVivienda;
  }

  public Casa(int idCasa, String calle, int numero, int codigoPostal, String ciudad, String pais, Date fechaDesde, Date fechaHasta, int tiempoMinimo, int tiempoMaximo, int precioHabitacion, String tipoVivienda) {
    this.idCasa = idCasa;
    this.calle = calle;
    this.numero = numero;
    this.codigoPostal = codigoPostal;
    this.ciudad = ciudad;
    this.pais = pais;
    this.fechaDesde = fechaDesde;
    this.fechaHasta = fechaHasta;
    this.tiempoMinimo = tiempoMinimo;
    this.tiempoMaximo = tiempoMaximo;
    this.precioHabitacion = precioHabitacion;
    this.tipoVivienda = tipoVivienda;
  }

  public int getIdCasa() {
    return idCasa;
  }

  public void setIdCasa(int idCasa) {
    this.idCasa = idCasa;
  }

  public String getCalle() {
    return calle;
  }

  public void setCalle(String calle) {
    this.calle = calle;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getCodigoPostal() {
    return codigoPostal;
  }

  public void setCodigoPostal(int codigoPostal) {
    this.codigoPostal = codigoPostal;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public Date getFechaDesde() {
    return fechaDesde;
  }

  public void setFechaDesde(Date fechaDesde) {
    this.fechaDesde = fechaDesde;
  }

  public Date getFechaHasta() {
    return fechaHasta;
  }

  public void setFechaHasta(Date fechaHasta) {
    this.fechaHasta = fechaHasta;
  }

  public int getTiempoMinimo() {
    return tiempoMinimo;
  }

  public void setTiempoMinimo(int tiempoMinimo) {
    this.tiempoMinimo = tiempoMinimo;
  }

  public int getTiempoMaximo() {
    return tiempoMaximo;
  }

  public void setTiempoMaximo(int tiempoMaximo) {
    this.tiempoMaximo = tiempoMaximo;
  }

  public int getPrecioHabitacion() {
    return precioHabitacion;
  }

  public void setPrecioHabitacion(int precioHabitacion) {
    this.precioHabitacion = precioHabitacion;
  }

  public String getTipoVivienda() {
    return tipoVivienda;
  }

  public void setTipoVivienda(String tipoVivienda) {
    this.tipoVivienda = tipoVivienda;
  }

  @Override
  public String toString() {
    return "Casa{" +
        "idCasa=" + idCasa +
        ", calle='" + calle + '\'' +
        ", numero=" + numero +
        ", codigoPostal=" + codigoPostal +
        ", ciudad='" + ciudad + '\'' +
        ", pais='" + pais + '\'' +
        ", fechaDesde=" + fechaDesde +
        ", fechaHasta=" + fechaHasta +
        ", tiempoMinimo=" + tiempoMinimo +
        ", tiempoMaximo=" + tiempoMaximo +
        ", precioHabitacion=" + precioHabitacion +
        ", tipoVivienda='" + tipoVivienda + '\'' +
        '}';
  }
}
