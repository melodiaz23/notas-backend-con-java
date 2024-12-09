
// Crea un menú interactivo con 5 opciones para que el usuario elija, como por ejemplo:
// Comprar producto.
// Realizar devolución.
// Ver mis pedidos.
// Preguntas frecuentes.
// Salir.
// Luego, solicita al usuario que elija una opción del menú mostrado en pantalla. El menú debe seguir apareciendo hasta que el usuario elija la opción para salir del programa. En este ejercicio, no es necesario que las opciones del menú realicen acciones reales, simplemente muestra un mensaje que indique qué opción eligió el usuario.
import java.util.Scanner;

public class MenuInteractivo {
  public void iniciarMenu(Scanner scanner) {
    int opcion;

    try {
      System.out.println("MENU: Elige una opción");
      System.out.println("1-Comprar Producto ");
      System.out.println("2- Realizar devolución");
      System.out.println("3- Ver mis pedidos");
      System.out.println("4- Preguntas frecuentes");
      System.out.println("5- Salir");
      opcion = scanner.nextInt();

      if (opcion < 0 || opcion > 5) {
        System.out.println("Opción inválida");
      } else {
        System.out.println("La opción elegida es la opción: " + opcion);
      }

      while ((opcion < 0 || opcion > 5) || opcion != 5) {
        System.out.println("MENU: Elige una opción");
        System.out.println("1-Comprar Producto ");
        System.out.println("2- Realizar devolución");
        System.out.println("3- Ver pedidos");
        System.out.println("4- FAQ");
        System.out.println("5- Salir");
        opcion = scanner.nextInt();

        if (opcion < 0 || opcion > 5) {
          System.out.println("Opción inválida");
        } else {
          System.out.println("La opción elegida es la opción: " + opcion);
        }

      }

    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
