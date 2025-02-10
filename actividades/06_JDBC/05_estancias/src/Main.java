import entidades.Casa;
import entidades.Familia;
import servicios.CasaServicio;
import servicios.ClienteServicio;
import servicios.EstanciaServicio;
import servicios.FamiliaServicio;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws SQLException {
    ClienteServicio clienteServicio = new ClienteServicio();
    EstanciaServicio estanciaServicio = new EstanciaServicio();
    CasaServicio casaServicio = new CasaServicio();


    try (Scanner scanner = new Scanner(System.in)) {
      menu(scanner);
    } catch (Exception e) {
      throw new RuntimeException("Error: " +  e);
    }

  }

  public static void menu(Scanner scanner) throws Exception {
    int opcion;
    do {
      System.out.println("""
          - BIENVENIDO AL PROGRAMA DE GESTIÓN DE ESTANCIAS -
          1- Gestión de Familias
          2- Gestión de Casas
          3- Gestión de Clientes
          4- Gestión de Estancias
          5- Salir""");

      opcion = scanner.nextInt();

      switch (opcion) {
          case 1 -> menuFamilias(scanner);
          case 2 -> menuCasas(scanner);
          default -> {
            System.out.println("Opción inválida");
          }
      }

    } while (opcion != 5);


  }

  public static void menuFamilias(Scanner scanner) throws Exception {
    FamiliaServicio familiaServicio = new FamiliaServicio();
    int opcion;

    do {
      System.out.println("""
        - MENÚ FAMILIAS -
        1- Listar familias
        2- Filtrar familias
        3- Buscar familias por email
        4- Menú Anterior""");

      opcion = scanner.nextInt();

      switch (opcion) {
          case  1-> {
            System.out.println("Listado de familias");
            familiaServicio.listarFamilias();
          }
          case  2-> {
            System.out.println("Indica edad máxima de hijos");
            int hijos = scanner.nextInt();
            System.out.println("Indica edad mínima ");
            int edad = scanner.nextInt();
            List<Familia> resultado = familiaServicio.filtrarDatos(edad, hijos);
            if (resultado.isEmpty()){
              System.out.println("No existen familias que cumplan estas condiciones");
            } else {
            resultado.forEach(familia -> {
              System.out.println(familia.getNombre() + " | " + familia.getEdadMaxima() + " | " + familia.getNumHijos());
            });
            }
          }
          case  3 -> {
            scanner.nextLine();
            System.out.println("Indica el e-mail a buscar");
            String email = scanner.nextLine().trim().toLowerCase();

            List<Familia> resultado = familiaServicio.filtrarDatosPorEmail(email);
            if (resultado.isEmpty()){
              System.out.println("No existen familias que cumplan estas condiciones");
            } else {
              resultado.forEach(familia -> {
                System.out.println(familia.getNombre() + " | " + familia.getEmail());
              });
            }
          }
          case  4 -> {}
            default -> System.out.println("Opción inválida");
      }
    } while (opcion !=4);
  }

  public static void menuCasas(Scanner scanner) throws SQLException, ParseException {
    CasaServicio casaServicio = new CasaServicio();
    int opcion;
    do {
      System.out.println("""
          - MENU CASAS -
          1- Listar Casas
          2- Listar Casas entre fechas
          3- Listar casas entre fechas y días
          4- Salir
          """);
        opcion = scanner.nextInt();

        switch (opcion) {
            case 1 -> {
              casaServicio.listarTodasLasCasas();
            }
            case 2 -> {
              scanner.nextLine();
              System.out.println("Indica periodo inicial (yyyy-mm-dd)");
              String fechaInicial = scanner.nextLine();
              System.out.println("Indica periodo final (yyyy-mm-dd)");
              String fechaFinal = scanner.nextLine();
              System.out.println("Indica el país");
              String pais = scanner.nextLine().trim().toLowerCase();

              List<Casa> casas = casaServicio.listarTodasLasCasasEntreFechas(fechaInicial, fechaFinal, pais);

              if (casas.isEmpty()){
                System.out.println("No existen casas que cumplan estas condiciones");
              } else {
              casas.forEach(casa -> {
                System.out.println(casa.getCalle() + " | " + casa.getFechaDesde() + " | " + casa.getFechaHasta() + " | " + casa.getPais());
              });
              }
            }
            case 3 -> {
              scanner.nextLine();
              System.out.println("Indica fecha inicial (yyyy-mm-dd)");
              String fechaInicial = scanner.nextLine();
              System.out.println("Indica número de días");
              int dias = scanner.nextInt();


            }
            case 4 -> {}
            default -> {}
        }


    } while (opcion!=4);

  }


}