package org.example;
import java.sql.*;

import static org.example.config.DatabaseConfig.getConnection;

public class Main {
  public static void main(String[] args) throws Exception {

    try (Connection conexion = getConnection()) {
      Statement stmt = conexion.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT codigo_cliente, nombre_cliente, limite_credito FROM cliente");
      while (rs.next()) {
        int x = rs.getInt("codigo_cliente");
        String s = rs.getString("nombre_cliente");
        double d = rs.getDouble("limite_credito");
        System.out.println("Fila = " + x + " " + s + " " + d);
      }

      // Sentencia preparada
      PreparedStatement ps = conexion.prepareStatement("UPDATE cliente SET nombre_cliente = 'GoldFish Garden' WHERE id_cliente = ?");
      ps.setInt(1, 5);
      ps.executeUpdate();

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}




