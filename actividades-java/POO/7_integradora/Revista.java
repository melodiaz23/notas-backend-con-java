
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

public class Revista extends ItemBiblioteca implements Catalogable {
  private int nroEdicion;
  private int cantidadEjemplares;
  private String nombreRevista;
  private LocalDate fechaPrestamo;
  private String idPrestamo;

  private static Revista[] ejemplaresPrestados = new Revista[0];

  public Revista(int nroEdicion, int cantidadEjemplares, String nombreRevista) {
    this.nroEdicion = nroEdicion;
    if (cantidadEjemplares < 0)
      this.cantidadEjemplares = 0;
    else
      this.cantidadEjemplares = cantidadEjemplares;
    this.nombreRevista = nombreRevista;
  }

  private Revista(int nroEdicion, int cantidadEjemplares, String nombreRevista, LocalDate fechaPrestamo,
      String idPrestamo) {
    this.nroEdicion = nroEdicion;
    if (cantidadEjemplares < 0)
      this.cantidadEjemplares = 0;
    else
      this.cantidadEjemplares = cantidadEjemplares;
    this.nombreRevista = nombreRevista;
    this.fechaPrestamo = fechaPrestamo;
    this.idPrestamo = idPrestamo;
  }

  @Override
  public void prestar() {
    if (cantidadEjemplares > 0) {
      cantidadEjemplares--;
      fechaPrestamo = LocalDate.now();
      idPrestamo = LocalDate.now().toString().replace("-", "");
      System.out.println("El id del ejemplar prestado es: " + idPrestamo);
      ejemplaresPrestados = Arrays.copyOf(ejemplaresPrestados, ejemplaresPrestados.length + 1);
      ejemplaresPrestados[ejemplaresPrestados.length - 1] = new Revista(nroEdicion, cantidadEjemplares, nombreRevista,
          fechaPrestamo, idPrestamo);
    } else {
      System.out.println("No hay ejemplares disponibles para prestar");
    }
  }

  @Override
  public void devolver(String idPrestamo) {
    if (ejemplaresPrestados.length > 0) {
      Revista[] temp = new Revista[ejemplaresPrestados.length - 1];
      int conteo = 0;
      for (Revista ejemplaresPrestado : ejemplaresPrestados) {
        if (ejemplaresPrestado.idPrestamo.equalsIgnoreCase(idPrestamo)) {
          cantidadEjemplares++;
          System.out.println("Gracias!, el ejemplar ha sido devuelto");
          calcularMultas(ejemplaresPrestado.fechaPrestamo);
        } else {
          temp[conteo] = ejemplaresPrestado;
          conteo++;
        }
        ejemplaresPrestados = temp;
      }
    } else {
      System.out.println("No hay ejemplares prestados");
    }

  }

  @Override
  public void calcularMultas(LocalDate fechaPrestamo) {

    Period periodo = Period.between(fechaPrestamo, LocalDate.of(2024, 11, 29));
    // Asumiendo fecha de entrega con multa el 29-11-2024
    int diasMulta = periodo.getDays();
    if (diasMulta > 0)
      System.out.println("El valor de la multa es de " + (diasMulta * 1) + "USD"); // Asumiendo valor de multa es de
                                                                                   // 1usd x día.
    else
      System.out.println("El prestamo no generó multas.");

  }

  @Override
  public void obtenerInformacion() {
    System.out.println("Nombre revista: " + this.nombreRevista);
    System.out.println("Nro de Edición: " + this.nroEdicion);
    System.out.println("Ejemplares disponibles " + this.cantidadEjemplares);
  }

  public int getNroEdicion() {
    return nroEdicion;
  }

  public void setNroEdicion(int nroEdicion) {
    this.nroEdicion = nroEdicion;
  }

  public int getCantidadEjemplares() {
    return cantidadEjemplares;
  }

  public void setCantidadEjemplares(int cantidadEjemplares) {
    this.cantidadEjemplares = cantidadEjemplares;
  }

  public String getNombreRevista() {
    return nombreRevista;
  }

  public void setNombreRevista(String nombreRevista) {
    this.nombreRevista = nombreRevista;
  }

}
