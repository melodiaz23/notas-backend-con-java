package src;

public class NumerosAleatorios {
  public static int iniciarActividad() {
//    System.out.println("Generador número aleatorio: ");
    // +1 es el rango inferior
    // Se multiplica el máximo número deseado menos el mínimo número para que quede
    // en el rango.
    // Si queremos incluir el número máximo se le suma 1, sería:
    // Math.random()*(máx - mín + 1) + mín
    return (int) Math.floor((Math.random() * (355 - 1 + 1)) + 1);
  }
}
