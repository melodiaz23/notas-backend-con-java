
// Entidad Estancia:

package entidades;
import java.util.Date;

public class Estancia {
  private int idEstancia;
  private int idCLiente;
  private int idCasa;
  private String nombreHuesped;
  private Date fechaDesde;
  private Date fechaHasta;

  public Estancia(int idEstancia, int idCLiente, int idCasa, String nombreHuesped, Date fechaDesde, Date fechaHasta) {
    this.idEstancia = idEstancia;
    this.idCLiente = idCLiente;
    this.idCasa = idCasa;
    this.nombreHuesped = nombreHuesped;
    this.fechaDesde = fechaDesde;
    this.fechaHasta = fechaHasta;
  }

  public Estancia(int idCLiente, int idCasa, String nombreHuesped, Date fechaDesde, Date fechaHasta) {
    this.idCLiente = idCLiente;
    this.idCasa = idCasa;
    this.nombreHuesped = nombreHuesped;
    this.fechaDesde = fechaDesde;
    this.fechaHasta = fechaHasta;
  }

  public Estancia() {
  }

  public int getIdEstancia() {
    return idEstancia;
  }

  public void setIdEstancia(int idEstancia) {
    this.idEstancia = idEstancia;
  }

  public int getIdCLiente() {
    return idCLiente;
  }

  public void setIdCLiente(int idCLiente) {
    this.idCLiente = idCLiente;
  }

  public int getIdCasa() {
    return idCasa;
  }

  public void setIdCasa(int idCasa) {
    this.idCasa = idCasa;
  }

  public String getNombreHuesped() {
    return nombreHuesped;
  }

  public void setNombreHuesped(String nombreHuesped) {
    this.nombreHuesped = nombreHuesped;
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

  @Override
  public String toString() {
    return "Estancia{" +
        "idEstancia=" + idEstancia +
        ", idCLiente=" + idCLiente +
        ", idCasa=" + idCasa +
        ", nombreHuesped='" + nombreHuesped + '\'' +
        ", fechaDesde=" + fechaDesde +
        ", fechaHasta=" + fechaHasta +
        '}';
  }
}