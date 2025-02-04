
public class GamaProducto {
  private int idGama;
  private String gama;
  private String descripcionTexto;
  private String descripcionHtml;
  private String imagen;

  public GamaProducto() {
  }

  public GamaProducto(int idGama, String gama, String descripcionTexto, String descripcionHtml, String imagen) {
    this.idGama = idGama;
    this.gama = gama;
    this.descripcionTexto = descripcionTexto;
    this.descripcionHtml = descripcionHtml;
    this.imagen = imagen;
  }

  public int getIdGama() {
    return idGama;
  }

  public String getGama() {
    return gama;
  }

  public String getDescripcionTexto() {
    return descripcionTexto;
  }

  public String getDescripcionHtml() {
    return descripcionHtml;
  }

  public String getImagen() {
    return imagen;
  }

  public void setIdGama(int idGama) {
    this.idGama = idGama;
  }

  public void setGama(String gama) {
    this.gama = gama;
  }

  public void setDescripcionTexto(String descripcionTexto) {
    this.descripcionTexto = descripcionTexto;
  }

  public void setDescripcionHtml(String descripcionHtml) {
    this.descripcionHtml = descripcionHtml;
  }

  public void setImagen(String imagen) {
    this.imagen = imagen;
  }

  @Override
  public String toString() {
    return "GamaProducto [idGama=" + idGama + ", gama=" + gama + ", descripcionTexto=" + descripcionTexto
        + ", descripcionHtml=" + descripcionHtml + ", imagen=" + imagen + "]";
  }

}
