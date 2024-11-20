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
      } while (opcion != 10);

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
    System.out.println("6- Eliminar jugador");
    System.out.println("7- Eliminar equipo");
    System.out.println("8- Seleccionar jugador");
    System.out.println("9- Seleccionar equipo");
    System.out.println("10- Salir");
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
        System.out.println("Indica el jugador que deseas eliminar");
        Jugador.listarJugadores(jugadores);
        int jugadorABorrar = scanner.nextInt();
        Jugador.eliminarJugadores(jugadores, jugadorABorrar - 1);
        System.out.println("Has eliminado un jugador");
      }
      case 7 -> {
        System.out.println("Indica el equipo que deseas eliminar");
        Equipo.listarEquipo(equipos);
        int equipoABorrar = scanner.nextInt();
        Equipo.eliminarEquipo(equipos, equipoABorrar - 1);
        System.out.println("Has eliminado un equipo");
      }
      case 8 -> {
        int opcionSubmenu;
        System.out.println("¿Que jugador deseas seleccionar?");
        Jugador.listarJugadores(jugadores);
        int jugadorSeleccionado = scanner.nextInt();
        scanner.nextLine();
        do {
          mostrarSubmenuJugador();
          opcionSubmenu = scanner.nextInt();
          scanner.nextLine();
          switch (opcionSubmenu) {
            case 1 -> {
              System.out.printf("El nombre del jugador es %s y está asignado al equipo %s",
                  jugadores[jugadorSeleccionado - 1].getNombre(),
                  jugadores[jugadorSeleccionado].getEquipo().getNombre());
            }
            case 2 -> {
              System.out.println("Indica el nuevo nombre: ");
              String nuevoNombre = scanner.nextLine();
              jugadores[jugadorSeleccionado - 1].setNombre(nuevoNombre);
            }
            case 3 -> {
              System.out.println("Selecciona el nuevo equipo:");
              Equipo.listarEquipo(equipos);
              int equipoACambiar = scanner.nextInt();
              jugadores[jugadorSeleccionado - 1].setEquipo(equipos[equipoACambiar - 1]);
              System.out.println("Has cambiado el equipo del jugador");
            }
            case 4 -> {
            }
            default -> {
              System.out.println("Has seleccionado una opción inválida");
            }
          }

        } while (opcionSubmenu != 4);

      }
      case 9 -> {

      }
      case 10 -> {

      }
      default -> {
        System.out.println("Has seleccionado una opción inválida");
      }
    }
  }

  public static void mostrarSubmenuJugador() {
    System.out.println("1- Ver detalles");
    System.out.println("2- Cambiar nombre");
    System.out.println("3- Cambiar equipo");
    System.out.println("4- Regresar al menú");
  }

}