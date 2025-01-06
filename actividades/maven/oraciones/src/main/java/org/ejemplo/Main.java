package org.ejemplo;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("\033\143"); // Limpia la consola
    System.out.println("MANIPULACIÓN DE ORACIONES");
    boolean salir = false;
    GestionOracion gestionarOracion = new GestionOracion("");

    try (Scanner scanner = new Scanner(System.in)) {
      do {
        System.out.println("-----------");
        System.out.println("¿Qué deseas hacer?");
        if (gestionarOracion.getOracion().isEmpty()) {
          System.out.println("1- Crear Oración");
          System.out.println("2- Salir");
        } else {
          System.out.println("1- Borrar Oración");
          System.out.println("2- Cantidad de Caracteres");
          System.out.println("3- Cantidad de Palabras");
          System.out.println("4- Mostrar Palabras Ordenadas Alfabéticamente");
          System.out.println("5- Ingresa un número para encontrar palabra");
          System.out.println("6- Encontrar Palabra");
          System.out.println("7- Modificar Palabra en oración");
          System.out.println("8- Agregar contenido");
          System.out.println("9- Salir");
        }
        System.out.println("-----------");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpia buffer

        if (gestionarOracion.getOracion().isEmpty()) {
          if (opcion == 2)
            opcion = 9;
          else if (opcion > 2)
            opcion = 0;
        }

        switch (opcion) {
          case 1 -> {
              System.out.println("Escribe la oración");
              String oracion = scanner.nextLine();
              gestionarOracion.setOracion(oracion);
          }
          case 2 -> System.out.println("La cantidad de caracteres es de: " + gestionarOracion.cantidadCaracteres());
          case 3 -> System.out.printf("La oración tiene: %d palabras \n",
              gestionarOracion.cantidadPalabras());
          case 4 -> gestionarOracion.organizarPalabras();
          case 5 -> gestionarOracion.encontrarPalabraEnOracion(scanner);
          case 6 -> gestionarOracion.encontrarPalabraConPalabra(scanner);
          case 7 -> gestionarOracion.modificarPalabra(scanner);
          case 8 -> gestionarOracion.agregarContenido(scanner);
          case 9 -> salir = true;
          default -> System.out.println("Elige una opción válida");
        }

      } while (!salir);

    } catch (Exception e) {
      System.out.println(e);
    }
  }
}