package persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
      System.out.println(e.getMessage());
      throw e;
    }
  }

  protected void insertarModificarEliminarDataBase(String script) throws SQLException, ClassNotFoundException {
    try {
      connectarDataBase();
      statement = conexion.createStatement();
      statement.executeUpdate(script);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw e;
    } finally {
      System.out.println("Dato modificado en DB");
      desconectarDataBase();
    }
  }

  protected ResultSet consultarDataBase(String script) throws SQLException, ClassNotFoundException {
    try {
      connectarDataBase();
      statement = conexion.createStatement();
      resultSet = statement.executeQuery(script);
      return resultSet;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw e;
    }
  }
}