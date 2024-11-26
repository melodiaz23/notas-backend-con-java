
import java.time.LocalDate;

public class Libro extends ItemBiblioteca implements Catalogable {
  private String titulo;
  private String autor;
  private int nroPaginas;
  private Boolean prestado;

  public Libro(String titulo, String autor, int nroPaginas) {
    this.titulo = titulo;
    this.autor = autor;
    this.nroPaginas = nroPaginas;
  }

  public Libro(String titulo, String autor, int nroPaginas, Boolean esPrestado) {
    this.titulo = titulo;
    this.autor = autor;
    this.nroPaginas = nroPaginas;
    this.prestado = esPrestado;
  }

  public String getTitulo() {
    return titulo;
  }

  public boolean isPrestado() {
    return prestado;
  }

  public void setPrestado(boolean prestado) {
    this.prestado = prestado;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public int getNroPaginas() {
    return nroPaginas;
  }

  public void setNroPaginas(int nroPaginas) {
    this.nroPaginas = nroPaginas;
  }

  public void mostrarInformacion() {
    System.out.println("El nombre del libro es: " + this.titulo);
    System.out.println("El autor es: " + this.autor);
    System.out.println("El número de paginas es: " + this.nroPaginas);
  }

  @Override
  public void prestar() {
  }

  @Override
  public void devolver(String idPrestamo) {
  }

  @Override
  public void calcularMultas(LocalDate fechaPrestamo) {

  }

  @Override
  public void obtenerInformacion() {

  }

}
