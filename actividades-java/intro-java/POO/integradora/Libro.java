

/*
 * Agregar los atributos “titulo”, “autor” y “numeroDePaginas” a la clase “Libro”.
 *  Además, implementa un método “mostrarInformación()”
 */

public class Libro  {
  private String titulo, autor;
  private Integer numeroDePaginas;

  public Libro(String titulo, String autor, int numeroDePaginas) {
    this.titulo = titulo;
    this.autor = autor;
    this.numeroDePaginas = numeroDePaginas;
  }

  public void mostrarInformacion() {
    System.out.printf("""
        -- Información del libro --
        Titulo: %s
        Autor: %s
        Numero de paginas: %d
        """,
        this.titulo,
        this.autor,
        this.numeroDePaginas);
  }

  

  public String getTitulo() {
    return titulo;
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

  public Integer getNumeroDePaginas() {
    return numeroDePaginas;
  }

  public void setNumeroDePaginas(Integer numeroDePaginas) {
    this.numeroDePaginas = numeroDePaginas;
  }


  
}
