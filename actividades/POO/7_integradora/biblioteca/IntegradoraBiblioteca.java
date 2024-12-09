package biblioteca;

import biblioteca.modelos.Libro;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IntegradoraBiblioteca {
  public static void main(String[] args) {
    System.out.println("\033\143");
    // Se incluye para inicializar programa con valores
    Biblioteca biblioteca = new Biblioteca();
    biblioteca.agregarLibro("Cien años de soledad", "Gabo", 350);
    biblioteca.agregarLibro("Hábitos Atómicos", "James", 250);
    biblioteca.agregarLibro("La casa de los espíritus", "Isabel Allende", 350);

    biblioteca.agregarRevista(1, 50, "Ciencia hoy");
    biblioteca.agregarRevista(23, 0, "Tecnología Moderna");
    biblioteca.agregarRevista(1, 50, "Historia y Cultura");

    try (Scanner scanner = new Scanner(System.in)) {
      String opcion;
      int opcionMenu;
        do {
          try {
            menuBiblioteca();
            opcionMenu = scanner.nextInt();
            switch (opcionMenu) {
              case 1 -> {
                menuLibro(scanner, biblioteca);
              }
              case 2 -> menuRevista(scanner);
              case 3 -> menuPelicula();
              case 4 -> System.out.println("Saliendo del programa...");
              default -> System.out.println("Opción seleccionada NO es válida");
            }
          } catch (InputMismatchException e) {
            opcionMenu = 0;
            scanner.nextLine();
            System.out.println("Ingresaste un valor no permitido, por favor, intenta de nuevo: " + e);
          }
        } while (opcionMenu != 4);

    } catch (Exception e) {
      System.out.println("Error inesperado: " + e);
    }

    // biblioteca.modelos.Revista[] revistas = new biblioteca.modelos.Revista[3];



    // try (Scanner scanner = new Scanner(System.in)) {
    // for (biblioteca.modelos.Revista revista : revistas) {
    // revista.obtenerInformacion();
    // revista.prestar();
    // System.out.println("- DESPUÉS DE PRESTAR -");
    // revista.obtenerInformacion();

    // System.out.println("Deseas devolver el ejemplar?, indica el id");
    // String idEjemplar = scanner.nextLine();
    // revista.devolver(idEjemplar);
    // System.out.println("- DESPUÉS DE DEVOLVER -");
    // revista.obtenerInformacion();
    // System.out.println();
    // System.out.println("-----------");
    // System.out.println();
    // }
    // } catch (Exception e) {
    // System.out.println("Error inesperado: " + e);
    // }

  }

  public static void menuBiblioteca(){
    System.out.println("-----------------------------------------------");
    System.out.println("BIENVENIDO A LA BIBLIOTECA");
    System.out.println("-----------------------------------------------");
    System.out.println("¿Qué deseas gestionar?");
    System.out.println("1- Libro");
    System.out.println("2- Revista");
    System.out.println("3- Película");
    System.out.println("4- Salir");
    System.out.print(">> ");
  }

  private static void menuLibro(Scanner scanner, Biblioteca biblioteca){
    int opcion;
    do {
      try {
        System.out.println("---------------------");
        System.out.println("GESTIÓN DE LIBROS");
        System.out.println("---------------------");
        System.out.println("1- Prestar Libro");
        System.out.println("2- Devolver Libro");
        System.out.println("3- Cargar nuevo libro a la biblioteca");
        System.out.println("4- Mostrar información de un libro");
        System.out.println("5- Regresar al menú principal");
        System.out.print(">> ");
        opcion = scanner.nextInt();
      switch (opcion){
        case 1 -> {
          try {
            int opcionLibroAPrestar;
            System.out.println("¿Qué libro deseas prestar?");
            Biblioteca.listarLibrosDisponibles();
            opcionLibroAPrestar = scanner.nextInt();
            Biblioteca.gestionarPrestamoLibro(scanner, Biblioteca.libros.get(opcionLibroAPrestar - 1));
          } catch (Exception e){
            System.out.println("No fue posible gestionar el préstamo: " + e);
          }

        }
        case 2 -> {
          int libroADevolver;
          String id;
          System.out.println("Indica que libro deseas devolver");
          Biblioteca.listarLibrosPrestados();
          libroADevolver = scanner.nextInt();
          scanner.nextLine();
          // ID podría no ser necesario
          System.out.println("Indica el ID: ");
          id = scanner.nextLine();
          Biblioteca.libros.get(libroADevolver-1).devolver(id);


        }
        case 3 -> {
          try {
            scanner.nextLine();
            System.out.println("Ingrese el titulo del libro: ");
            System.out.print(">> ");
            String titulo = scanner.nextLine();
            System.out.println("Ingrese el autor del libro: ");
            System.out.print(">> ");
            String autor = scanner.nextLine();
            System.out.println("Ingrese el numero de paginas del libro: ");
            System.out.print(">> ");
            int paginas = scanner.nextInt();
            scanner.nextLine();
            biblioteca.agregarLibro(titulo, autor, paginas);
            System.out.println("El libro fue añadido a la biblioteca");
        } catch (Exception e){
            scanner.nextLine();
            System.out.println("Error: No fue posible adicionar el libro");
        }
      }
      case 4 ->{
        int opcionLibroSeleccionado;
        System.out.println("¿De cual libro deseas obtener información?");
        Biblioteca.listarLibros();
        System.out.print(">> ");
        opcionLibroSeleccionado = scanner.nextInt();
        Libro libroSeleccionado = Biblioteca.libros.get(opcionLibroSeleccionado -1);
        libroSeleccionado.obtenerInformacion();
        libroSeleccionado.gestionarInfo(scanner);
      }
      case 5->{}
      default -> System.out.println("Opción inválida");
    }
      } catch (Exception e){
        opcion=0;
        System.out.println("Ingresaste un valor no permitido: " + e);
      }
    } while (opcion!=6);
  }

  private static void menuRevista(Scanner scanner){
    int opcion;
    do {
      try {
        System.out.println("---------------------");
        System.out.println("GESTIÓN DE REVISTAS");
        System.out.println("---------------------");
        System.out.println("1- Prestar revista");
        System.out.println("2- Devolver revista");
        System.out.println("3- Cargar nueva revista a la biblioteca");
        System.out.println("4- Mostrar información de una revista");
        System.out.println("5- Regresar al menú principal");
        System.out.print(">> ");
        opcion = scanner.nextInt();

        switch (opcion){
          case 1 -> {}
          case 2 -> {}
          case 3 -> {}
          case 4 -> {}
          case 5 -> {}
          case 6 -> {}
          default -> {}
        }
      } catch (Exception e){
        opcion=0;
        System.out.println("Ingresaste un valor no permitido: " + e);
      }
    } while (opcion!=6);


  }

  private static void menuPelicula() {
    System.out.println("---------------------");
    System.out.println("GESTIÓN DE PELÍCULAS");
    System.out.println("---------------------");

  }




}