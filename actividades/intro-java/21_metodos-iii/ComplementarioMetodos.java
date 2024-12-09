import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ComplementarioMetodos {
  private String oracion = "";

  public static void main(String[] args) {
    Actividad1 actividad1 = new Actividad1();
    actividad1.mostrarMenu();
  }

  public static void mostrarMenu() {
    Scanner scanner = new Scanner(System.in);
    int opcion = 0;

    do {
      System.out.println("\n--- Menú ---");
      if (oracion.isEmpty()) {
        System.out.println("1. Crear oración");
      } else {
        System.out.println("1. Borrar oración");
      }
      System.out.println("2. Cantidad de caracteres de la oración");
      System.out.println("3. Cantidad de palabras de la oración");
      System.out.println("4. Mostrar palabras ordenadas alfabéticamente");
      System.out.println("5. Ingresar un número y devolver la palabra correspondiente");
      System.out.println("6. Buscar palabra dentro de la oración");
      System.out.println("7. Modificar palabra dentro de la oración");
      System.out.println("8. Agregar contenido a la oración");
      System.out.println("9. Salir");
      System.out.print("Seleccione una opción: ");

      try {
        opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion) {
          case 1:
            manejarCrearOBorrarOracion(scanner);
            break;
          case 2:
            mostrarCantidadCaracteres();
            break;
          case 3:
            mostrarCantidadPalabras();
            break;
          case 4:
            mostrarPalabrasOrdenadas();
            break;
          case 5:
            obtenerPalabraPorNumero(scanner);
            break;
          case 6:
            buscarPalabra(scanner);
            break;
          case 7:
            modificarPalabra(scanner);
            break;
          case 8:
            agregarContenido(scanner);
            break;
          case 9:
            System.out.println("Saliendo del programa...");
            break;
          default:
            System.out.println("Opción inválida. Intente nuevamente.");
        }
      } catch (InputMismatchException e) {
        System.out.println("Entrada inválida. Por favor, ingrese un número.");
        scanner.nextLine();
      }
    } while (opcion != 9);

    scanner.close();
  }

  private void manejarCrearOBorrarOracion(Scanner scanner) {
    if (oracion.isEmpty()) {
      System.out.print("Ingrese la nueva oración: ");
      oracion = scanner.nextLine();
    } else {
      System.out.println("Oración borrada.");
      oracion = "";
    }
  }

  private void mostrarCantidadCaracteres() {
    System.out.println("Cantidad de caracteres (incluyendo espacios): " + oracion.length());
  }

  private void mostrarCantidadPalabras() {
    String[] palabras = oracion.split("\\s+");
    System.out.println("Cantidad de palabras: " + palabras.length);
  }

  private void mostrarPalabrasOrdenadas() {
    String[] palabras = oracion.split("\\s+");
    ArrayList<String> listaPalabras = new ArrayList<>();
    Collections.addAll(listaPalabras, palabras);
    Collections.sort(listaPalabras);
    System.out.println("Palabras ordenadas alfabéticamente: " + listaPalabras);
  }

  private void obtenerPalabraPorNumero(Scanner scanner) {
    String[] palabras = oracion.split("\\s+");
    System.out.print("Ingrese el número de la palabra: ");

    try {
      int numero = scanner.nextInt();
      scanner.nextLine();

      if (numero > 0 && numero <= palabras.length) {
        System.out.println("La palabra en la posición " + numero + " es: " + palabras[numero - 1]);
      } else {
        System.out.println("Número inválido. Intente nuevamente.");
      }
    } catch (InputMismatchException e) {
      System.out.println("Entrada inválida. Por favor, ingrese un número.");
      scanner.nextLine();
    }
  }

  private void buscarPalabra(Scanner scanner) {
    System.out.print("Ingrese la palabra a buscar: ");
    String palabraBuscada = scanner.nextLine();
    String[] palabras = oracion.split("\\s+");

    boolean encontrada = false;
    for (int i = 0; i < palabras.length; i++) {
      if (palabras[i].equalsIgnoreCase(palabraBuscada)) {
        System.out.println("Palabra encontrada en la posición: " + (i + 1));
        encontrada = true;
        break;
      }
    }
    if (!encontrada) {
      System.out.println("Palabra no encontrada.");
    }
  }

  private void modificarPalabra(Scanner scanner) {
    System.out.print("Ingrese la palabra a modificar: ");
    String palabraOriginal = scanner.nextLine();
    String[] palabras = oracion.split("\\s+");

    boolean encontrada = false;
    for (String palabra : palabras) {
      if (palabra.equalsIgnoreCase(palabraOriginal)) {
        encontrada = true;
        break;
      }
    }

    if (!encontrada) {
      System.out.println("Palabra no encontrada. Intente nuevamente.");
      return;
    }

    System.out.print("Ingrese la nueva palabra: ");
    String nuevaPalabra = scanner.nextLine();

    if (!nuevaPalabra.matches("[a-zA-Z ]+")) {
      System.out.println("La palabra nueva debe contener solo letras y espacios.");
      return;
    }

    oracion = oracion.replaceFirst("(?i)\\b" + palabraOriginal + "\\b", nuevaPalabra);
    System.out.println("Oración modificada: " + oracion);
  }

  private void agregarContenido(Scanner scanner) {
    System.out.print("Ingrese el contenido a agregar: ");
    String contenidoAdicional = scanner.nextLine();
    oracion = oracion + " " + contenidoAdicional;
    System.out.println("Oración actualizada: " + oracion);
  }
}