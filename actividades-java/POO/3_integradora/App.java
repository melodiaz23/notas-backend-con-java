
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
  static Empleado[] empleados = new Empleado[3];

  public static void main(String[] args) {
    System.out.println("\033\143");
    boolean reintentar = true;

    empleados[0] = new Empleado("Melissa", 33, 1500, " TI ");
    empleados[1] = new Empleado("Guille ", 34, 2500, "Ventas");
    empleados[2] = new Empleado(" Nico  ", 27, 1500, " QA ");

    try (Scanner scanner = new Scanner(System.in)) {
      do {
        try {
          menu(scanner);
          reintentar = false;
        } catch (InputMismatchException e) {
          System.out.println("Has ingresado un valor que no corresponde al tipo de dato. Intenta nuevamente");
          scanner.nextLine(); // Limpia el buffer, asegurando que no quede ninguna entrada residual que genere
                              // error
        } catch (Exception e) {
          System.out.println("Ha ocurrido un error: " + e);
          System.out.println("...CERRANDO PROGRAMA.");
          reintentar = false;
        }
      } while (reintentar);
    } catch (Exception e) {
      System.out.println("Ha ocurrido un error inesperado: " + e);
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
          int opcionFiltro;
          do {
            System.out.println("¿Qué atributo deseas filtrar?");
            System.out.println("1- Nombre");
            System.out.println("2- Edad");
            System.out.println("3- Salario");
            System.out.println("4- Departamento");
            System.out.print(">> ");
            opcionFiltro = scanner.nextInt();
            if (opcionFiltro > 4) {
              System.out.println("Ingresa una opción válida");
            }
          } while (opcionFiltro > 4);
          switch (opcionFiltro) {
            case 1, 4 -> {
              String criterio = scanner.nextLine();
              System.out.println("Cual es el valor a filtrar? ");
              Empleado.mostrarEmpleados(Empleado.filtarEmpleados(empleados, criterio));
            }
            case 2, 3 -> {
              System.out.println("Indica el rango mínimo: ");
              System.out.print(">> ");
              int min = scanner.nextInt();
              System.out.println("Indica el rango máximo: ");
              System.out.print(">> ");
              int max = scanner.nextInt();
              scanner.nextLine();
              Empleado.mostrarEmpleados(Empleado.filtarEmpleados(empleados, max, min));
            }
          }
        }
        case 4 -> {
          int opcionFiltro;
          do {
            System.out.println("Indica el atributo que deseas ordenar:");
            System.out.println("1- Nombre");
            System.out.println("2- Edad");
            System.out.println("3- Salario");
            System.out.println("4- Departamento");
            System.out.print(">> ");
            opcionFiltro = scanner.nextInt();
            if (opcionFiltro > 4) {
              System.out.println("Ingresa una opción válida");
            }
          } while (opcionFiltro > 4);

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