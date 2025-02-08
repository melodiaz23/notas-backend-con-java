package servicios;

import entidades.Cliente;
import persistencia.ClienteDAO;

import java.sql.SQLException;
import java.util.List;

public class ClienteServicio {
  private final ClienteDAO clienteDAO; // No se puede reasignar después de la inicialización

  public ClienteServicio() {
    this.clienteDAO = new ClienteDAO();
  }

  // Las excepciones se manejan en ListarClientes(), listarTodosLosClientes() las propaga.
  public List<Cliente> listarTodosLosClientes() throws SQLException, ClassNotFoundException {
      return clienteDAO.listarClientes();
  }

  public void guardarCliente(Cliente cliente) {
    validacionDatos(cliente);
    clienteDAO.guardarCliente(cliente);
  }

  public Cliente buscarClientePorCodigo(int codigo) {
    return clienteDAO.buscarClientePorCodigo(codigo);
  }

  private void validacionDatos(Cliente cliente) {
    if (cliente == null) throw new IllegalArgumentException("Cliente no puede ser nulo");
    if (cliente.getNombre() == null) throw new IllegalArgumentException("Nombre no puede ser nulo");
    if (cliente.getCiudad() == null) throw new IllegalArgumentException("Ciudad no puede ser nulo");
    if (cliente.getPais() == null) throw new IllegalArgumentException("País no puede ser nulo");
  }

}
