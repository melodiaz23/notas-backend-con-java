package persistencia;

import entidades.Cliente;

import java.sql.SQLException;

public class ClienteDAO extends DAO {

  public void guardarCliente(Cliente cliente){

    String script = "INSERT INTO cliente (" +
        "codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto," +
        "telefono, fax, ciudad, region, pais, codigo_postal, id_empleado, limite_credito" +
        ")" +
        "VALUES (" + cliente.getCodigoCliente() +
        ", '" + cliente.getNombreCliente() + "', 'Norah', 'Perez', '557235826', '557235826', \n" +
        "    'Medellin', 'Antioquia', 'Colombia', '24006', 5, 50000\n" +
        ");\n";

    try {
      insertarModificarEliminarDataBase(script);
    } catch (SQLException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }

  }
}
