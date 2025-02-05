package persistencia;

import java.sql.SQLException;

public class ProductoDAO extends DAO {

  public void eliminarProductoPorCodigo(int idProducto){
    String script = "DELETE FROM producto WHERE id_producto = " + idProducto +  ";";

    try {
      insertarModificarEliminarDataBase(script);
    } catch (SQLException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }


}
