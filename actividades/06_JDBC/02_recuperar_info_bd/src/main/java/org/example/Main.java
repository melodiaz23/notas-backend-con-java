package org.example;
import java.sql.*;
import static org.example.config.DatabaseConfig.getConnection;

public class Main {
  public static void main(String[] args) throws Exception {
    try (Connection connection = getConnection();) {

      buscarClientes(connection);
      buscarClientePorCodigo(connection,2);
      buscaClientesPorEmpleado(connection, 13);

      getProductosParaReponer(connection, 30);
      getProductosGama(connection, "Herramientas");
      getPedidosPorCliente(connection, 4);
      getPedidosPorEstado(connection, "Entregado");

    } catch (Exception e) {
      System.out.println("Error en la conexión: " + e.getMessage());
    } finally {
      System.out.println("Programa ejecutado con éxito");
    }
}

public static void buscarClientes(Connection connection){
  String query = """
      SELECT
      nombre_contacto,
      apellido_contacto,
      telefono
      FROM cliente""";

  System.out.println("- LISTADO DE CLIENTES -");
  try (Statement stmt = connection.createStatement();
       ResultSet rs = stmt.executeQuery(query)) {
      int count = 0;
      while (rs.next()) {
        String nombre = rs.getString("nombre_contacto");
        String apellido = rs.getString("apellido_contacto");
        String telefono = rs.getString("telefono");
        count++;
        System.out.println(count + " - " + nombre + " " + apellido + " -  " + telefono);
  }
    System.out.println("---------------");
  } catch (Exception e) {
    System.out.println("Error en la consulta" + e.getMessage());
  }
}


  public static void buscarClientePorCodigo(Connection connection, int codigo){
    String query = "SELECT * FROM cliente WHERE codigo_cliente=" + codigo;

    System.out.println("Datos del cliente con el código " + codigo + ": ");
    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(query);) {
      int count=0;
      while(rs.next()){
        String nombreCliente = rs.getString("nombre_cliente");
        String nombreContacto = rs.getString("nombre_contacto");
        String apellidoContacto = rs.getString("apellido_contacto");
        String fax = rs.getString("fax");
        String ciudad = rs.getString("ciudad");
        String region = rs.getString("region");
        String pais = rs.getString("pais");
        String codigoPostal = rs.getString("codigo_postal");
        Double limiteCredito = rs.getDouble("limite_credito");
        count++;
        System.out.printf("%d |  %s  | %s  |  %s  | %s  |  %s  |  %s  |  %s  |  %s  |  %.2f \n",
            count, nombreCliente, nombreContacto, apellidoContacto, fax, ciudad, region, pais, codigoPostal, limiteCredito);
      }
    } catch (Exception e) {
      System.out.println("Error en la consulta" + e.getMessage());
    } finally {
      System.out.println("---------------");
    }
  }

  public static void buscaClientesPorEmpleado(Connection con, int empleadoId){
    // Text block
    String query = """ 
        SELECT
           nombre_cliente,
           nombre_contacto,
           apellido_contacto,
           telefono,
           id_empleado
        FROM cliente WHERE id_empleado=?;""";

    System.out.println("Datos del empleado con el ID " + empleadoId + ":");
    try (PreparedStatement st = con.prepareStatement(query);) {
      st.setInt(1,empleadoId);
      try (ResultSet rs = st.executeQuery();) {
        while (rs.next()) {
          System.out.printf("%s | %s | %s | %s | %d \n",
              rs.getString("nombre_cliente"),
              rs.getString("nombre_contacto"),
              rs.getString("apellido_contacto"),
              rs.getString("telefono"),
              rs.getInt("id_empleado"));
        }
      }
    } catch (Exception e) {
      System.out.println("Error en la consulta" + e.getMessage());
    } finally {
      System.out.println("-----------------");
    }
}

    public static void getProductosParaReponer(Connection con, int puntoReposicion) {
      String query = """
          SELECT nombre, cantidad_en_stock
          FROM producto
          WHERE cantidad_en_stock < ?;""";

      try (PreparedStatement st = con.prepareStatement(query);) {
        st.setInt(1, puntoReposicion);
        System.out.println("- LISTADO DE PRODUCTOS A REPONER -");
        try (ResultSet rs = st.executeQuery();) {
          while (rs.next())
            System.out.printf("%s | %d \n",
                rs.getString("nombre"),
                rs.getInt("cantidad_en_stock"));
        }
      } catch (Exception e) {
        System.out.println("Error en la consulta" + e.getMessage());
      } finally {
        System.out.println("-------------");
      }
    }

  public static void getProductosGama(Connection con, String gama){
    String query = """
        SELECT
           p.codigo_producto,
           p.nombre,
           p.id_gama,
           gp.gama
        FROM producto p
        JOIN gama_producto gp ON gp.id_gama = p.id_gama
        WHERE gp.gama = ?;""";

    System.out.println("Listado de productos de la gama " + gama + ":");
    try (PreparedStatement st = con.prepareStatement(query);) {
      st.setString(1, gama);
      try (ResultSet rs = st.executeQuery();) {
      while (rs.next()) {
        System.out.printf("%s |  %s | ID Gama: %d  | %s\n",
            rs.getString("codigo_producto"),
            rs.getString("nombre"),
            rs.getInt("id_gama"),
            rs.getString("gama"));
      }}
    } catch (Exception e) {
      System.out.println("Error en la consulta" + e.getMessage());
    } finally {
      System.out.println("-------------");
    }
  }


    public static void getPedidosPorCliente(Connection con, int clienteId) {
      String query = """
          SELECT
             c.nombre_cliente,
             p.id_pedido,
             p.estado
          FROM pedido p
          JOIN cliente c ON c.id_cliente = p.id_cliente
          WHERE c.id_cliente = ?;""";

      System.out.println("Datos de los pedidos del cliente con código " + clienteId + ":");
      try (PreparedStatement st = con.prepareStatement(query);) {
        st.setInt(1,clienteId);
        try (ResultSet rs = st.executeQuery();) {
        while (rs.next()) {
          System.out.printf("%s |  ID Pedido: %d  | %s \n",
              rs.getString("nombre_cliente"),
              rs.getInt("id_pedido"),
              rs.getString("estado"));
        }}
      } catch (Exception e) {
        System.out.println("Error en la consulta" + e.getMessage());
      } finally {
        System.out.println("-------------");
      }
    }

    public static void getPedidosPorEstado(Connection connection, String estado){
      String query = """
          SELECT
             c.nombre_cliente,
             p.id_pedido,
             p.estado
          FROM pedido p
          JOIN cliente c ON c.id_cliente = p.id_cliente
          WHERE p.estado = ?;
          """;

      System.out.println("Listado de todos los pedidos " + estado.toLowerCase() + "s:");
      try (PreparedStatement st = connection.prepareStatement(query)) {
        st.setString(1, estado);
        try (ResultSet rs = st.executeQuery();) {
          while (rs.next()) {
            System.out.printf("%s |  ID Pedido: %d  | %s \n",
                rs.getString("nombre_cliente"),
                rs.getInt("id_pedido"),
                rs.getString("estado"));
          }}
      } catch (Exception e) {
        System.out.println("Error en la consulta" + e.getMessage());
      } finally {
        System.out.println("----------------");
      }
    }
}
