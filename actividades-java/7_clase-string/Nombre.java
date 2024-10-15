
import java.util.Scanner;

public class Nombre {
  public void iniciarActividad(Scanner scanner) {
    String nombre, apellido;

    System.out.println("Indica tú nombre:");
    nombre = scanner.nextLine();
    System.out.println("Indica tu apellido");
    apellido = scanner.nextLine();

    String nombreCompleto = nombre.concat(" ").concat(apellido);

    System.out.println(nombreCompleto);

  }
}
