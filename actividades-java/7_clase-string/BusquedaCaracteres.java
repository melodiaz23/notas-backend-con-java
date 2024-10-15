import java.util.Scanner;

public class BusquedaCaracteres {
  public void iniciarActividad(Scanner scanner) {
    String caracter;
    String palabra;

    System.out.println("Indica una palabra");
    palabra = scanner.nextLine();
    System.out.println("Ahora indica un caracter");
    caracter = scanner.nextLine();

    if (palabra.indexOf(caracter) == -1) {
      System.out.println("El caracter ingresado no se encuentra en la palabra.");
    } else {
      System.out.println("El caracter ingresado, se encuentra en la posición: " + palabra.indexOf(caracter));
    }

    ;

  }
}
