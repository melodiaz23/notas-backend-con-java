
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    System.out.println("\033\143");
    Empleado[] empleados = null;
    try (Scanner scanner = new Scanner(System.in)) {
      menu(scanner, empleados);
    } catch (Exception e) {
      System.out.println("Ha ocurrido un error: " + e);
    }
  }

  /**
   * Muestra un menú interactivo al usuario para gestionar empleados.
   * Permite al usuario seleccionar opciones para mostrar, crear, filtrar,
   * ordenar empleados, incrementar salario, limpiar filtros o salir.
   * 
   * @param scanner   el objeto Scanner para leer la entrada del usuario
   * @param empleados el arreglo de empleados que será manipulado
   */
  public static void menu(Scanner scanner, Empleado[] empleados) {
    int opcion;

    do {
      mostrarMenu();
      opcion = scanner.nextInt();
      switch (opcion) {
        case 1 -> {
          if (empleados == null) {
            System.out.println("No existen empleados registrados");
          } else {
            Empleado.mostrarEmpleados(empleados);
          }
        }
        case 2 -> {
        }
        case 3 -> {
        }
        case 4 -> {

        }
        case 5 -> {

        }
        case 6 -> {

        }
        case 7 -> {
        }
        default -> {

        }
      }
    } while (opcion != 7);

  }

  /**
   * Muestra el menú al usuario.
   */
  static void mostrarMenu() {
    System.out.println("SISTEMA DE GESTIÓN");
    System.out.println("-----------");
    System.out.println("1- Mostrar empleados");
    System.out.println("2- Crear empleado");
    System.out.println("3- Filtrar empleados");
    System.out.println("4- Ordenar empleados");
    System.out.println("5- Incrementar salario");
    System.out.println("6- Limpiar filtros");
    System.out.println("7- Salir");
    System.out.print(">> ");
  }

}