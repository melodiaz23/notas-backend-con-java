import java.util.Scanner;

public class Actividad {
  public static void main(String[] args) {
    // Ejemplos de métodos
    Notas notas = new Notas();
    notas.iniciarNotas();
    LongitudCadena longitudCadena = new LongitudCadena();
    Nombre nombre = new Nombre();
    ExtraerSubcadenas extraerSubcadenas = new ExtraerSubcadenas();
    BusquedaCaracteres busquedaCaracteres = new BusquedaCaracteres();
    ConversionMayusMinus conversionMayusMinus = new ConversionMayusMinus();
    RemplazoCaracteres remplazoCaracteres = new RemplazoCaracteres();
    ComparandoCadenas comparandoCadenas = new ComparandoCadenas();
    CalculandoLongitud calculandoLongitud = new CalculandoLongitud();

    try (Scanner scanner = new Scanner(System.in)) {
      // Actividad 1.
      longitudCadena.iniciarActividad(scanner);
      // Actividad 2.
      nombre.iniciarActividad(scanner);
      // Actividad 3.
      extraerSubcadenas.iniciarActividad(scanner);
      // Actividad 4.
      // nextLine(), limpia el salto de linea que quedó despues de ingresar un número.
      scanner.nextLine();
      busquedaCaracteres.iniciarActividad(scanner);
      // Actividad 5.
      conversionMayusMinus.iniciarActividad(scanner);
      // COMPLEMENTARIOS
      // Actividad 1.
      scanner.nextLine();
      remplazoCaracteres.iniciarActividad(scanner);
      // Actividad 2.
      comparandoCadenas.iniciarActividad(scanner);
      // Actividad 3
      calculandoLongitud.iniciarActividad(scanner);

    } catch (Exception e) {
      System.out.println("Se ha presentado un error inesperado: " + e.getMessage());
    }

  }

}
