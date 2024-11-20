import java.util.Arrays;
import java.util.Scanner;
import modelo.Equipo;
import modelo.Jugador;

public class LigaFutbol {
  static Jugador[] jugadores = new Jugador[0];
  static Equipo[] equipos = new Equipo[0];

  public static void main(String[] args) {
    System.out.println("\033\143");
    int opcion;
    try (Scanner scanner = new Scanner(System.in)) {
      do {
        mostrarMenu();
        opcion = scanner.nextInt();
        scanner.nextLine();
        ejecutarAccion(opcion, scanner);
      } while (opcion != 6);

    } catch (Exception e) {

      System.out.println("Error inesperado: " + e);
    }
  }

  public static void mostrarMenu() {
    System.out.println("---------------------");
    System.out.println("GESTIÓN JUGADORES");
    System.out.println("---------------------");
    System.out.println("1- Crear jugador");
    System.out.println("2- Crear Equipo");
    System.out.println("3- Asignar jugador a equipo");
    System.out.println("4- Mostrar lista de jugadores");
    System.out.println("5- Mostrar lista de equipos");
    System.out.println("6- Salir");
    System.out.print(">> ");
  }

  public static void ejecutarAccion(int opcion, Scanner scanner) {
    switch (opcion) {
      case 1 -> {
        System.out.println("Ingresa el nombre del jugador");
        String nombre = scanner.nextLine();
        Jugador jugador = new Jugador(nombre, null);

        if (equipos.length > 0) {
          System.out.println("Selecciona el equipo: ");
          Equipo.listarEquipo(equipos);
          int equipo = scanner.nextInt();
          jugador.setEquipo(equipos[equipo - 1]);
        } else {
          System.out.println("No hay equipos disponibles");
        }
        jugadores = Arrays.copyOf(jugadores, jugadores.length + 1);
        jugadores[jugadores.length - 1] = jugador;

      }
      case 2 -> {
        System.out.println("Ingresa el nombre del equipo");
        String nombreEquipo = scanner.nextLine();
        Equipo equipo = new Equipo(nombreEquipo);
        equipos = Arrays.copyOf(equipos, equipos.length + 1);
        equipos[equipos.length - 1] = equipo;

      }
      case 3 -> {
        System.out.println("Selecciona el jugador: ");
        Jugador.listarJugadores(jugadores);
        int opcionJugador = scanner.nextInt();
        Jugador jugadorSeleccionado = jugadores[opcionJugador - 1];

        System.out.println("Selecciona un equipo:");
        Equipo.listarEquipo(equipos);
        int opcionEquipo = scanner.nextInt();
        jugadorSeleccionado.setEquipo(equipos[opcionEquipo - 1]);
      }
      case 4 -> {
        Jugador.listarJugadores(jugadores);
      }
      case 5 -> {
        Equipo.listarEquipo(equipos);
      }
      case 6 -> {

      }
      default -> {
        System.out.println("Has seleccionado una opción inválida");
      }
    }
  }

}