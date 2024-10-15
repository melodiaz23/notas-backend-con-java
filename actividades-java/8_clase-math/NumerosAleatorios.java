
public class NumerosAleatorios {
  public void iniciarActividad() {
    System.out.println("Generador número aleatorio: ");
    double num = Math.floor((Math.random() * (355 - 1 + 1)) + 1);
    // +1 es el rango inferior
    // Se multiplica el máximo número deseado menos el mínimo número para que quede
    // en el rango.
    // Si queremos incluir el número máximo se le suma 1, sería:
    // (máx - mín + 1) + mín
    System.out.println(num);
  }
}
