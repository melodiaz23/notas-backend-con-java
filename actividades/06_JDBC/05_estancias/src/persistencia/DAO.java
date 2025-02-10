package persistencia;
import java.sql.*;

public abstract class DAO {
  protected Connection conexion = null;
  protected ResultSet resultSet = null;
  protected Statement statement = null;
  private final String HOST = "127.0.0.1";
  private final String PORT = "3306";
  private final String USER = "root";
  private final String PASSWORD = "admin";
  private final String DATABASE = "estancias_exterior";
  private final String DRIVER = "com.mysql.cj.jdbc.Driver";

  protected void connectarDataBase() throws SQLException, ClassNotFoundException {
    try {
      Class.forName(DRIVER);
      String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
      conexion = DriverManager.getConnection(url, USER, PASSWORD);
      System.out.println("Conexión exitosa a la base de datos.");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw e;
    }
  }
  protected void desconectarDataBase() throws SQLException, ClassNotFoundException {
    try {
      if (resultSet != null) {
        resultSet.close();
      }
      if (statement != null) {
        statement.close();
      }
      if (conexion != null) {
        conexion.close();
      }
    } catch (Exception e) {
      System.out.println("Error al cerrar la conexión: " + e.getMessage());
      throw e;
    }
  }

  protected void insertarModificarEliminarDataBase(String script, Object... params) throws SQLException, ClassNotFoundException {
    try (PreparedStatement statement = prepareStatement(script, params)) {
      statement.executeUpdate();
      System.out.println("Dato modificado en DB");
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println("Error al modificar datos en la base de datos: " + e.getMessage());
      throw e;
    } finally {
      desconectarDataBase();
    }
  }

  protected ResultSet consultarDataBase(String script, Object... params) throws SQLException, ClassNotFoundException {
    try {
      PreparedStatement statement = prepareStatement(script, params);
      return statement.executeQuery();
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println("Error al consultar la base de datos: " + e.getMessage());
      throw e;
    }
  }

  private PreparedStatement prepareStatement(String script, Object... params) throws SQLException, ClassNotFoundException {
    connectarDataBase();
    PreparedStatement statement = conexion.prepareStatement(script);
    for (int i = 0; i < params.length; i++) {
      statement.setObject(i + 1, params[i]);
    }
    return statement;
  }

}