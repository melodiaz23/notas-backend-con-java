import entidades.Casa;
import entidades.Estancia;
import servicios.CasaServicio;
import servicios.ClienteServicio;
import servicios.EstanciaServicio;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws SQLException {
    ClienteServicio clienteServicio = new ClienteServicio();
    EstanciaServicio estanciaServicio = new EstanciaServicio();
    CasaServicio casaServicio = new CasaServicio();

//    try (Scanner scanner = new Scanner(System.in)) {
//    int opcion;
//    do {
//        menu();
//        opcion = scanner.nextInt();
//    } while (opcion != 2);
//    } catch (Exception e) {
//      throw new RuntimeException("Error: " +  e);
//    }

    try {

      // Clientes
//      clienteServicio.listarTodosLosClientes().forEach(System.out::println); // Metodo de referencia Clase::metodoDeInstancia
//      Cliente clienteEncontrado = clienteServicio.buscarClientePorCodigo(4);
//      System.out.println(clienteEncontrado);
//      clienteServicio.guardarCliente(null);

      // Estancias
//      List<Estancia> estancias = estanciaServicio.listarTodasLasEstancias();
//      System.out.println(estancias);
//      System.out.println(estanciaServicio.buscarEstanciaPorId(3));

      // Casas
      List<Casa> casas = casaServicio.listarTodasLasCasas();
      System.out.println(casas);
      System.out.println(casaServicio.buscarCasaPorId(5));

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public static void menu(){
    System.out.println("""
        - BIENVENIDO AL PROGRAMA DE GESTIÓN DE ESTANCIAS -
        1- 
        2- Salir""");


  }
}