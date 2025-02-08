import persistencia.ClienteDAO;

public class Main {
  public static void main(String[] args) {
    ClienteDAO clientes = new ClienteDAO();


    try {
      clientes.listarClientes().forEach(System.out::println); // Metodo de referencia Clase::metodoDeInstancia
      System.out.println(clientes.buscarClientePorCodigo(4));
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}