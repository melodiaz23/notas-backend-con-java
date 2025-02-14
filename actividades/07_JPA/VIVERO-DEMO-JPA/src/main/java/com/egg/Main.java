package com.egg;
import com.egg.entidades.Oficina;
import com.egg.servicios.OficinaServicio;

import java.util.Scanner;

  public class Main {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int opcionPrincipal;
    do {
      System.out.println("""
                ---------------------
                === Menú Principal ===
                ---------------------
                1. Gestionar Clientes
                2. Gestionar Pedidos
                3. Gestionar Productos
                4. Gestionar Empleados
                5. Gestionar Pagos
                6. Gestionar Oficinas
                7. Gestionar Gamas de Productos
                8. Salir""");
      System.out.print("Seleccione una opción: ");
      opcionPrincipal = scanner.nextInt();

      switch (opcionPrincipal) {
        case 1 -> menuClientes(scanner);
        case 2 -> menuPedidos(scanner);
        case 3 -> menuProductos(scanner);
        case 4 -> menuEmpleados(scanner);
        case 5 -> menuPagos(scanner);
        case 6 -> menuOficinas(scanner);
        case 7 -> menuGamasProductos(scanner);
        case 8 -> System.out.println("Saliendo del sistema...");
        default -> System.out.println("Opción no válida, intente de nuevo.");
      }
    } while (opcionPrincipal != 8);
    scanner.close();
  }

  private static void menuClientes(Scanner scanner) {
    int opcion;
    do {
      System.out.println("""
                === Gestión de Clientes ===
                1. Crear Cliente
                2. Listar Clientes
                3. Actualizar Cliente
                4. Eliminar Cliente
                5. Buscar Cliente por Ciudad
                6. Ver Clientes con Crédito Superior a un Monto
                7. Volver al Menú Principal
                """);
      System.out.print("Seleccione una opción: ");
      opcion = scanner.nextInt();
    } while (opcion != 7);

    switch (opcion) {
        case 1 -> {}
        case 2 -> {}
        default -> {}
    }

  }

  private static void menuPedidos(Scanner scanner) {
    int opcion;
    do {
      System.out.println("""
                === Gestión de Pedidos ===
                1. Crear Pedido
                2. Listar Pedidos
                3. Actualizar Pedido
                4. Eliminar Pedido
                5. Listar Pedidos Pendientes
                6. Ver Pedidos Entregados en un Rango de Fechas
                7. Volver al Menú Principal
                """);
      System.out.print("Seleccione una opción: ");
      opcion = scanner.nextInt();
    } while (opcion != 7);
  }

  private static void menuProductos(Scanner scanner) {
    int opcion;
    do {
      System.out.println("""
                === Gestión de Productos ===
                1. Crear Producto
                2. Listar Productos
                3. Actualizar Producto
                4. Eliminar Producto
                5. Ver Productos con Bajo Stock
                6. Mostrar Productos de una Gama Específica
                7. Volver al Menú Principal
                """);
      System.out.print("Seleccione una opción: ");
      opcion = scanner.nextInt();
    } while (opcion != 7);
  }

  private static void menuEmpleados(Scanner scanner) {
    int opcion;
    do {
      System.out.println("""
                === Gestión de Empleados ===
                1. Crear Empleado
                2. Listar Empleados
                3. Actualizar Empleado
                4. Eliminar Empleado
                5. Mostrar Empleados de una Oficina
                6. Ver Empleados con un Puesto Específico
                7. Volver al Menú Principal
                """);
      System.out.print("Seleccione una opción: ");
      opcion = scanner.nextInt();
    } while (opcion != 7);
  }

  private static void menuPagos(Scanner scanner) {
    int opcion;
    do {
      System.out.println("""
                === Gestión de Pagos ===
                1. Registrar Pago
                2. Listar Pagos
                3. Actualizar Pago
                4. Eliminar Pago
                5. Ver Pagos por Cliente
                6. Ver Total de Pagos en un Rango de Fechas
                7. Volver al Menú Principal
                """);
      System.out.print("Seleccione una opción: ");
      opcion = scanner.nextInt();
    } while (opcion != 7);
  }

  private static void menuOficinas(Scanner scanner)  {
   try (OficinaServicio oficinaServicio = new OficinaServicio()) {
    int opcion;
    do {
      System.out.println("""
                === Gestión de Oficinas ===
                1. Registrar Oficina
                2. Actualizar Oficina
                3. Buscar Oficina por ID
                4. Eliminar Oficina
                5. Volver al Menú Principal
                """);
      System.out.print("Seleccione una opción: ");
      opcion = scanner.nextInt();
      switch (opcion) {
          case 1 -> {
            // Se toman dados del cliente y luego...
            oficinaServicio.crearOficina("OF123", "Madrid", "España", "Madrid", "123456789", "28001");
          }
          case 2 -> {
            // Con fines de prueba, se intenta modificar la oficina con ID 9
          Oficina oficinaAModificar = oficinaServicio.encontrarOficina(9);
          oficinaAModificar.setCodigoOficina("TOK-JP");
//        oficinaAModificar.setCodigoOficina("PRUEBA");
          oficinaServicio.actualizarOficina(oficinaAModificar);
          }
          case 3 -> {
            // Se busca oficina con ID: 9
            System.out.println(oficinaServicio.encontrarOficina(9));
          }
          case 4 -> {
            // Elimina la oficina creada en case 1
            oficinaServicio.eliminarOficina(10);
          }
          default -> {
            System.out.println("Selecciona una opción válida");
          }
      }
    } while (opcion != 7);
   } catch (Exception e) {
     System.out.println("Ocurrió un error al ejecutar el menú oficinas: " + e);
   }

  }

  private static void menuGamasProductos(Scanner scanner) {
    int opcion;
    do {
      System.out.println("""
          === Gestión de Gamas de Productos ===
          1. Agregar Gama de Producto
          2. Listar Gamas de Productos
          3. Actualizar Gama de Producto
          4. Eliminar Gama de Producto
          5. Ver Productos de una Gama Específica
          6. Mostrar la Gama con más Productos
          7. Volver al Menú Principal
          Seleccione una opción:
          """);
      opcion = scanner.nextInt();
    } while (opcion != 7);
  }
  }
