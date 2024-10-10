
import java.util.Scanner;

public class Actividades {
  public static void main(String[] args) {
    // try-with-resources se asegura que que cada recurso sea cerrado al finalizar
    // la declaración
    try (Scanner scanner = new Scanner(System.in)) {

      // División segura
      Division division = new Division();
      division.IniciarActividad(scanner);

      // Resta con Manejo de Excepciones
      Resta resta = new Resta();
      resta.IniciarActividad(scanner);

      scanner.nextLine(); // Limpia el salto de línea que queda pendiente cuando se usa .nextInt()

      // Conversión de Cadena a Entero
      CadenaCaracteres cadena = new CadenaCaracteres();
      cadena.IniciarActividad(scanner);
    } catch (Exception e) {
      System.err.println(e);
    }
  }
}