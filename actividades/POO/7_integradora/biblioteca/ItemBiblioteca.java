package biblioteca;

import java.time.LocalDate;

public abstract class ItemBiblioteca {

  public abstract void prestar();

  public abstract void devolver(String id);

  public abstract void calcularMultas(LocalDate fechaPrestamo);

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public String toString() {
    return super.toString();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }
}
