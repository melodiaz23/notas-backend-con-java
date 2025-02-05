import entidades.Cliente;
import persistencia.ClienteDAO;
import persistencia.ProductoDAO;
import servicios.ClienteServicio;

public class Main {
  public static void main(String[] args) {
    ClienteDAO clienteDAO = new ClienteDAO();
//
//    Cliente cliente = new Cliente(1, "Blue Ocean", "Norah", "Perez", "557235826", "557235826",
//        "Medellin", "Antioquia", "Colombia", "24006", 5, 50000);
//
//    Cliente cliente2 = new Cliente(21, "Ocean", "Maria", "Yepes", "557235826", "557235826",
//        "Medellin", "Antioquia", "Colombia", "24006", 5, 20000);
//
//    clienteDAO.guardarCliente(cliente2);
//    clienteDAO.listarTodosLosClientes();

//    ProductoDAO productoDAO = new ProductoDAO();
//    productoDAO.eliminarProductoPorCodigo(13);

//    System.out.println(clienteDAO.buscarClientePorCodigo(11));

    ClienteServicio clienteServicio = new ClienteServicio();
    try {
//      clienteServicio.crearNuevoCliente(1, "Blue Ocean", null,
//          "Perez", "557235826", "557235826",
//          "Medellin", "Antioquia", "Colombia", "24006",
//          5, 50000);
      System.out.println(clienteServicio.validarCodigo(22));


    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }
}