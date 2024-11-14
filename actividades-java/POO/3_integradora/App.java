
import java.util.Arrays;
import java.util.Scanner;

public class App {
  static Empleado[] empleados = new Empleado[3];

  public static void main(String[] args) {
    System.out.println("\033\143");

    empleados[0] = new Empleado("Melissa", 33, 1500, "TI");
    empleados[1] = new Empleado("Guille", 34, 2500, "Informatica");
    empleados[2] = new Empleado("Nico", 27, 1500, "IT");

    try (Scanner scanner = new Scanner(System.in)) {
      menu(scanner);
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
  public static void menu(Scanner scanner) {
    int opcion;

    do {
      mostrarMenu();
      opcion = scanner.nextInt();
      scanner.nextLine();
      switch (opcion) {
        case 1 -> {
          if (empleados == null) {
            System.out.println("No existen empleados registrados");
          } else {
            Empleado.mostrarEmpleados(empleados);
          }
        }
        case 2 -> {
          empleados = Arrays.copyOf(empleados, empleados.length + 1);
          Empleado empleado = new Empleado();
          empleados[empleados.length - 1] = empleado;
          System.out.println("Ingresa el nombre del empleado");
          String nombre = scanner.nextLine();
          empleado.setNombre(nombre);
          System.out.println("Ingresa edad: ");
          Integer edad = scanner.nextInt();
          empleado.setEdad(edad);
          System.out.println("Ingresa salario");
          Integer salario = scanner.nextInt();
          scanner.nextLine();
          empleado.setSalario(salario);
          System.out.println("Ingresa el departamento al que pertenece");
          String departamento = scanner.nextLine();
          empleado.setDepartamento(departamento);
        }
        case 3 -> {
          System.out.println("Indica el criterio para el filtro");
          String criterio = scanner.nextLine();
          Empleado.filtarEmpleados(empleados, criterio);
          // Empleado.mostrarEmpleados(Empleado.filtarEmpleados(empleados, criterio));

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