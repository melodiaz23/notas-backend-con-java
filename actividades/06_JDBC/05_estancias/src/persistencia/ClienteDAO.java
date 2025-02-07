package persistencia;
import entidades.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends DAO {

  public List<Cliente> listarClientes() throws ClassNotFoundException {
    String script = "SELECT * FROM clientes;";
    List<Cliente> clientes = new ArrayList<>();

    try (ResultSet result = consultarDataBase(script)) {
      while (result.next()){
        Cliente cliente = new Cliente();
        cliente.setIdCliente(result.getInt("id_cliente"));
        cliente.setNombre(result.getString("nombre"));
        cliente.setCalle(result.getString("calle"));
        cliente.setNumero(result.getInt("numero"));
        cliente.setCodigoPostal(result.getString("codigo_postal"));
        cliente.setCiudad(result.getString("codigo_postal"));
        cliente.setPais(result.getString("pais"));
        cliente.setEmail(result.getString("email"));
        clientes.add(cliente);
      }
      } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return clientes;
  }

  public void guardarCliente(Cliente cliente){
    String script = "INSERT INTO clientes VALUES('" + cliente.getNombre() + "','" + cliente.getCalle() + "'," + cliente.getNumero() + ",'" +
        cliente.getCodigoPostal() + "', '" + cliente.getCiudad() + "', '" + cliente.getPais() + "','" + cliente.getEmail() + "');";
    try {
      insertarModificarEliminarDataBase(script);
    } catch (SQLException | ClassNotFoundException e) {
      throw new RuntimeException("Error al guardar cliente: " + e);
    }
  }

  public Cliente buscarClientePorCodigo(int idCliente){
    String script = "SELECT * FROM cliente WHERE id_cliente =" + idCliente + ";";


      try (ResultSet result = consultarDataBase(script)) {
        Cliente cliente = new Cliente();
        while (result.next()){
          cliente.setIdCliente(result.getInt("id_cliente"));
          cliente.setNombre(result.getString("nombre"));
          cliente.setCalle(result.getString("calle"));
          cliente.setNumero(result.getInt("numero"));
          cliente.setCodigoPostal(result.getString("codigo_postal"));
          cliente.setCiudad(result.getString("codigo_postal"));
          cliente.setPais(result.getString("pais"));
          cliente.setEmail(result.getString("email"));
        }
        return cliente;

      } catch (SQLException | ClassNotFoundException e) {
      throw new RuntimeException("Error al buscar cliente por código: " + e);
    }

  }

}
