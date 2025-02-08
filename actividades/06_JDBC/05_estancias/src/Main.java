import entidades.Cliente;
import servicios.ClienteServicio;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    ClienteServicio clienteServicio = new ClienteServicio();

    try (Scanner scanner = new Scanner(System.in)) {
    int opcion;
    do {
        menu();
        opcion = scanner.nextInt();
    } while (opcion != 2);

    } catch (Exception e) {
      throw new RuntimeException("Error: " +  e);
    }

    try {
      clienteServicio.listarTodosLosClientes().forEach(System.out::println); // Metodo de referencia Clase::metodoDeInstancia
      Cliente clienteEncontrado = clienteServicio.buscarClientePorCodigo(4);
      clienteServicio.guardarCliente(null);
      System.out.println(clienteEncontrado);
    } catch (ClassNotFoundException | SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public static void menu(){
    System.out.println("""
        - BIENVENIDO AL PROGRAMA DE GESTIÓN DE ESTANCIAS -
        1- xxxxx
        2- Salir""");


  }
}