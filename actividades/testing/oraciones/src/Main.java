
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("\033\143"); // Limpia la consola
    System.out.println("MANIPULACIÓN DE ORACIONES");
    boolean salir = false;
    String oracion = "";

    try (Scanner scanner = new Scanner(System.in)) {
      do {
        System.out.println("-----------");
        System.out.println("¿Qué deseas hacer?");
        if (oracion.isEmpty()) {
          System.out.println("1- Crear Oración");
          System.out.println("2- Salir");
        } else {
          System.out.println("1- Borrar Oración");
          System.out.println("2- Cantidad de Caracteres");
          System.out.println("3- Cantidad de Palabras");
          System.out.println("4- Mostrar Palabras Ordenadas Alfabeticamente");
          System.out.println("5- Ingresa un número para encontrar palabra");
          System.out.println("6- Encontrar Palabra");
          System.out.println("7- Modificar Palabra en oración");
          System.out.println("8- Agregar contenido");
          System.out.println("9- Salir");
        }
        System.out.println("-----------");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpia buffer

        if (oracion.isEmpty()) {
          if (opcion == 2)
            opcion = 9;
          else if (opcion > 2)
            opcion = 0;
        }

        switch (opcion) {
          case 1 -> {
            if (oracion.isEmpty()) {
              System.out.println("Escribe la oración");
              oracion = scanner.nextLine();
            } else {
              oracion = "";
            }
          }
          case 2 -> System.out.println("La cantidad de caracteres es de: " + oracion.length());
          case 3 -> {
            int cantPalabras = oracion.trim().split(" ").length;
            System.out.printf("La oración tiene: %d palabras \n", cantPalabras);
          }
          case 4 -> {
            String[] palabras = oracion.trim().split(" ");
            System.out.println("Listado de palabras: ");
            System.out.println(Arrays.toString(palabras));
            Arrays.sort(palabras);
            System.out.println("Listado organizado alfabéticamente: ");
            System.out.println(Arrays.toString(palabras));
          }
          case 5 -> {
            String[] palabras = oracion.split(" ");
            int pos;
            do {
              System.out.println("Indica una posición para encontrar la palabra");
              pos = scanner.nextInt();
              if (pos < 1 || pos > palabras.length) {
                System.out.println("Número inválido, intente nuevamente");
              }
            } while (pos < 1 || pos > palabras.length);

            System.out.println("La palabra es: " + palabras[pos - 1]);

          }
          case 6 -> {
            String[] palabras = oracion.split(" ");
            System.out.println("Indica una palabra a encontrar");
            String palabra = scanner.nextLine().toUpperCase();
            boolean exist = false;
            for (int i = 0; i < palabras.length; i++) {
              if (palabra.contentEquals(palabras[i].toUpperCase())) {
                System.out.println("Palabra encontrada en la posición " + (i + 1));
                exist = true;
                break;
              }
            }
            if (!exist)
              System.out.println("Palabra no encontrada");
          }
          case 7 -> {
            String[] palabras = oracion.split(" ");
            boolean exist = false;
            int pos = 0;
            do {
              System.out.println("Indica la palabra a modificar");
              String palabraAntigua = scanner.nextLine();
              for (int i = 0; i < palabras.length; i++) {
                if (palabraAntigua.contentEquals(palabras[i])) {
                  pos = i;
                  exist = true;
                  break;
                }
              }
              if (!exist)
                System.out.println("Palabra no existe, intenta de nuevo");
            } while (!exist);
            System.out.println("Indica la nueva palabra");
            String palabraNueva = scanner.nextLine();
            palabras[pos] = palabraNueva;
            oracion = String.join(" ", palabras); // delimiter indica lo que se coloca entre cada elemento
            System.out.println("La nueva oración es:");
            System.out.println(oracion);
          }
          case 8 -> {
            System.out.println("Ingresa el nuevo contenido");
            String contenido = scanner.nextLine();
            oracion += " " + contenido;
            System.out.println("La nueva frase es: ");
            System.out.println(oracion);
          }
          case 9 -> salir = true;
          default -> System.out.println("Elige una opción válida");
        }

      } while (!salir);

    } catch (Exception e) {
      System.out.println(e);
    }
  }
}