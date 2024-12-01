package biblioteca;

import java.time.LocalDate;

public abstract class ItemBiblioteca {

  public abstract void prestar();

  public abstract void devolver(String id);

  public abstract void calcularMultas(LocalDate fechaPrestamo);

}
