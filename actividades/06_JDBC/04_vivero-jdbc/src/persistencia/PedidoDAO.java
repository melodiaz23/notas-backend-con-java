package persistencia;

import entidades.Pedido;
import servicios.PedidoServicio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO extends DAO {
  public List<Pedido> obtenerPedido() {
    String script = "SELECT * FROM pedido";
    List<Pedido> pedidos = new ArrayList<>();
    try {
      consultarDataBase(script);
      while (resultSet.next()){
        Pedido pedido = new Pedido();
        pedido.setIdPedido(resultSet.getInt("id_pedido"));
        pedido.setCodigoPedido(resultSet.getInt("codigo_pedido"));
        pedido.setFechaPedido(resultSet.getDate("fecha_pedido"));
        pedido.setFechaEspera(resultSet.getDate("fecha_esperada"));
        pedido.setFechaEntrega(resultSet.getDate("fecha_entrega"));
        pedido.setEstado(resultSet.getString("estado"));
        pedido.setComentarios(resultSet.getString("comentarios"));
        pedido.setIdCliente(resultSet.getInt("id_cliente"));
        pedidos.add(pedido);
      }
      pedidos.forEach(System.out::println); // Metodo de referencia
    } catch (SQLException | ClassNotFoundException e) {
      throw new RuntimeException("Error al listar los pedidos: ", e);
    }
    return pedidos;
  }

  public void guardarPedido(Pedido pedido){
    String script = "INSERT INTO pedido (id_pedido, codigo_pedido, fecha_pedido, fecha_esperada, " +
        "fecha_entrega, estado, comentarios, id_cliente) VALUES ";
  }

}
