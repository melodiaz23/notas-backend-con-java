import java.util.Arrays;
import java.util.Scanner;
import modelo.Equipo;
import modelo.Jugador;
import static modelo.Jugador.jugadores;
import static modelo.Equipo.equipos;

public class LigaFutbol {
  public static void main(String[] args) {
  equipos[0]= new Equipo("Stars");
  equipos[1]= new Equipo("Nexus");
  equipos[2]= new Equipo("Eclipse");
  equipos[3]= new Equipo("Sun");

  jugadores[0] = new Jugador("Melissa", new Equipo("Stars"));
  jugadores[1] = new Jugador("John", new Equipo("Nexus"));
  jugadores[2] = new Jugador("Isabela", new Equipo("Nexus"));
  jugadores[3] = new Jugador("Jane", new Equipo("Sun"));

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
        if (equipos.length==0){
          System.out.println("Para poder crear un jugador, primero deberás crear un equipo");
          return;
        }
        System.out.println("Ingresa el nombre del jugador");
        String nombre = scanner.nextLine();
        Jugador jugador = new Jugador(nombre, null);
//        if (equipos.length > 0) {
          System.out.println("Selecciona el equipo: ");
          Equipo.listarEquipo();
          int equipo = scanner.nextInt();
          jugador.setEquipo(equipos[equipo - 1]);
//        }
//        else {
//          System.out.println("Para incluir al jugador a un equipo, primero deberás crear un equipo");
//        }
        jugadores = Arrays.copyOf(jugadores, jugadores.length + 1);
        jugadores[jugadores.length - 1] = jugador;

      }
      case 2 -> {
	      boolean nombreExiste = false;
	      String nombreEquipo;
	      do {
		      System.out.println("Ingresa el nombre del equipo");
		      nombreEquipo = scanner.nextLine();
		      for (Equipo equipo : equipos) {
			      if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
				      System.out.println("Nombre ya existe. Intenta con otro o escribe 'S' para regresar al menú");
				      nombreExiste = true;
				      break;
			      }
		      }
	      } while (nombreExiste && !nombreEquipo.equalsIgnoreCase("S"));
	      Equipo equipo = new Equipo(nombreEquipo);
	      equipos = Arrays.copyOf(equipos, equipos.length + 1);
	      equipos[equipos.length - 1] = equipo;
      }
      case 3 -> {
        if (equipos.length == 0) {
          System.out.println("No has registrado ningún equipo.");
          return;
        }
        System.out.println("Selecciona el jugador: ");
        Jugador.listarJugadores();
        int opcionJugador = scanner.nextInt();
        Jugador jugadorSeleccionado = jugadores[opcionJugador - 1];
        System.out.println("Selecciona un equipo:");
        Equipo.listarEquipo();
        int opcionEquipo = scanner.nextInt();
        jugadorSeleccionado.setEquipo(equipos[opcionEquipo - 1]);
      }
      case 4 -> {
        if (jugadores.length == 0) {
          System.out.println("No has registrado ningún jugador.");
          return;
        }
        System.out.println("- JUGADORES -");
	      Jugador.listarJugadores();
      }
	    case 5 -> {
		    if (equipos.length == 0) {
		      System.out.println("No has registrado ningún equipo.");
		      return;
		    }
        System.out.println("- EQUIPOS -");
		    Equipo.listarEquipo();
	    }
	    case 6 -> {
        if (jugadores.length == 0) {
          System.out.println("No has registrado ningún jugador.");
          return;
        }
        System.out.println("Indica el jugador que deseas eliminar");
        Jugador.listarJugadores();
        int jugadorABorrar = scanner.nextInt();
        Jugador.eliminarJugadores(jugadorABorrar - 1);

      }
      case 7 -> {
        if (equipos.length == 0) {
          System.out.println("No has registrado ningún equipo.");
          return;
        }
        System.out.println("Indica el equipo que deseas eliminar");
        Equipo.listarEquipo();
        int equipoABorrar = scanner.nextInt();
       Jugador.refrescarJugadores(equipos[equipoABorrar-1]);
       Equipo.eliminarEquipo(equipoABorrar - 1);
      }
      case 8 -> {
        if (jugadores.length>0){
        int opcionSubmenu;
        System.out.println("¿Que jugador deseas seleccionar?");
        Jugador.listarJugadores();
        int jugadorSeleccionado = scanner.nextInt();
        scanner.nextLine();
        do {
          mostrarSubmenuJugador();
          opcionSubmenu = scanner.nextInt();
          scanner.nextLine();
          switch (opcionSubmenu) {
            case 1 -> System.out.printf("El nombre del jugador es %s y está asignado al equipo %s. \n",
                jugadores[jugadorSeleccionado - 1].getNombre(),
                jugadores[jugadorSeleccionado - 1].getEquipo().getNombre());
            case 2 -> {
              System.out.println("Indica el nuevo nombre: ");
              String nuevoNombre = scanner.nextLine();
              jugadores[jugadorSeleccionado - 1].setNombre(nuevoNombre);
            }
            case 3 -> {
              System.out.println("Selecciona el nuevo equipo:");
              Equipo.listarEquipo();
              System.out.print(">> ");
              int equipoACambiar = scanner.nextInt();
              jugadores[jugadorSeleccionado - 1].setEquipo(equipos[equipoACambiar - 1]);
              System.out.println("Has cambiado el equipo del jugador");
            }
            case 4 -> {
            }
            default -> System.out.println("Has seleccionado una opción inválida");
          }
        } while (opcionSubmenu != 4);
        } else {
          System.out.println("No tienes jugadores registrados");
        }
      }
      case 9 -> {
        if (equipos.length > 0){
        System.out.println("Lista de equipos");
        System.out.println("--------------------");
        Equipo.listarEquipo();
        System.out.println("Selecciona un equipo");
        System.out.print(">>");
        int equipoSeleccionado = scanner.nextInt();
          String nombreEquipoSeleccionado = equipos[equipoSeleccionado-1].getNombre();
        int opcionSubmenu;
        do {
        System.out.println("¿Qué deseas hacer?");
        mostrarMenuEquipo();
        opcionSubmenu = scanner.nextInt();
        scanner.nextLine();
        switch (opcionSubmenu){
          case 1 -> {
            Jugador[] jugadoresEquipo = Equipo.listarJugadoresEquipo(equipos[equipoSeleccionado-1]);
            System.out.printf("Has seleccionado el equipo %s, que tiene %d jugador/es. \n", equipos[equipoSeleccionado-1].getNombre(), jugadoresEquipo.length);
          }
          case 2 -> {
            System.out.println("¿Cual será el nuevo nombre del equipo?");
            System.out.print(">> ");
            String nuevoNombreEquipo = scanner.nextLine();
            equipos[equipoSeleccionado-1].setNombre(nuevoNombreEquipo);
	          for (Jugador jugador : jugadores) {
		          if (jugador.getEquipo().getNombre().equalsIgnoreCase(nombreEquipoSeleccionado)) {
			          jugador.setEquipo(equipos[equipoSeleccionado - 1]);
		          }
	          }
            System.out.println("El nuevo nombre del equipo es: " + nuevoNombreEquipo);
          }
          case 3 -> {
            if (jugadores.length == 0) {
              System.out.println("No tienes jugadores registrados. Primero deberás crear un nuevo jugador.");
              return;
            }
            System.out.println("¿Cual jugador deseas agregar al equipo?");
            Jugador.listarJugadores();
            int jugadorSeleccionado = scanner.nextInt();
            jugadores[jugadorSeleccionado-1].setEquipo(equipos[equipoSeleccionado-1]);
            System.out.printf("%s ha sido agregado al equipo. \n", jugadores[jugadorSeleccionado-1].getNombre());
          }
          case 4 -> {
            Jugador[] jugadoresEquipo = Equipo.listarJugadoresEquipo(equipos[equipoSeleccionado-1]);
              System.out.println("Los jugadores del equipo son: ");
	          for (int i = 0; i < jugadoresEquipo.length; i++) {
		          System.out.println((i+1) + "- " + jugadoresEquipo[i].getNombre());
	          }

          }
          case 5 -> {}
          default -> System.out.println("Has seleccionado una opción inválida");
        }
        } while (opcionSubmenu != 5);
        } else {
          System.out.println("No has registrado equipos");
        }
      }
      case 10 -> {
      }
      default -> System.out.println("Has seleccionado una opción inválida");
    }
  }

  private static void mostrarSubmenuJugador() {
    System.out.println("1- Ver detalles");
    System.out.println("2- Cambiar nombre");
    System.out.println("3- Cambiar equipo");
    System.out.println("4- Regresar al menú");
    System.out.print(">> ");
  }

  private static void mostrarMenuEquipo() {
    System.out.println("1- Ver detalles");
    System.out.println("2- Cambiar nombre");
    System.out.println("3- Agregar Jugador al equipo");
    System.out.println("4- Mostrar jugadores del equipo");
    System.out.println("5- Regresar al menú");
    System.out.print(">> ");
  }



}