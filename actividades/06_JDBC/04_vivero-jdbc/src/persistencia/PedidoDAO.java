package persistencia;

import entidades.Pedido;

public class PedidoDAO extends DAO {

  public void guardarPedido(Pedido pedido){
    String script = "INSERT INTO pedido (id_pedido, codigo_pedido, fecha_pedido, fecha_esperada, " +
        "fecha_entrega, estado, comentarios, id_cliente) VALUES ";
  }

}
