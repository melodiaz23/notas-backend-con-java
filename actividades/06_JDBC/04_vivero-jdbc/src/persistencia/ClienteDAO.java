package persistencia;

import com.mysql.cj.xdevapi.Client;
import entidades.Cliente;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends DAO {

  public void guardarCliente(Cliente cliente){
    String script = "INSERT INTO cliente (" +
        "codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto," +
        "telefono, fax, ciudad, region, pais, codigo_postal, id_empleado, limite_credito" +
        ")" +
        "VALUES (" + cliente.getCodigoCliente() +
        ", '" + cliente.getNombreCliente() + "', '" + cliente.getNombreContacto() + "','" +
        cliente.getApellidoContacto() + "', '" + cliente.getTelefono() + "', '" + cliente.getFax() +
        "', '" + cliente.getCiudad() + "', '" + cliente.getRegion()  + "', '" + cliente.getPais() +
        "', '" + cliente.getCodigoPostal() +  "'," + cliente.getIdEmpleado() + ", " +
        cliente.getLimiteCredito() + ");";

    try {
      insertarModificarEliminarDataBase(script);
    } catch (SQLException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }

  }

  public List<Cliente> listarTodosLosClientes(){
    String script = "SELECT id_cliente, nombre_contacto, apellido_contacto FROM cliente;";
    List<Cliente> clientes = new ArrayList<>();
    try {
      consultarDataBase(script);
    while (resultSet.next()){
      Cliente cliente = new Cliente();
      cliente.setIdCliente(resultSet.getInt("id_cliente"));
      cliente.setNombreContacto(resultSet.getString("nombre_contacto"));
      cliente.setApellidoContacto(resultSet.getString("apellido_contacto"));
      clientes.add(cliente);
    }
      clientes.forEach(Cliente::imprimirDatosCliente); // Metodo de referencia

    } catch (SQLException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
    return clientes;
  }



}
