import java.util.Scanner;

public class Actividades {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      Temperatura temperatura = new Temperatura();
      Validacion validacion = new Validacion();
      // Actividad: Conversión de unidades de temperatura
      temperatura.iniciarActividad(scanner);
      // Actividad:Validación de contraseña
      validacion.iniciarActividad(scanner);

    } catch (Exception e) {
      System.out.println("Ocurrió un error inesperado al ejecutar el programa: " +
          e.getMessage());
    }
  }
}
