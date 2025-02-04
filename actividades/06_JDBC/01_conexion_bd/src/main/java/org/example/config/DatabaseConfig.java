package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
  public static Connection getConnection() {
    // Para configurar la conexión, crea un archivo 'config.properties' en la carpeta 'src/main/resources'
    // con las propiedades necesarias (db.host, db.port, db.name, db.password, db.database).
    // db.host=
    // db.port=
    // db.name=
    // db.password=
    // db.database=

    ConfigLoader config = new ConfigLoader("src/main/resources/config.properties");
    String host = config.getProperty("db.host");
    String port = config.getProperty("db.port");
    String name = config.getProperty("db.name");
    String password = config.getProperty("db.password");
    String database = config.getProperty("db.database");

    // Esto especifica una zona horaria, no es obligatorio de utilizar, pero en
    // algunas zonas genera conflictos de conexión si no existiera
    String zona = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database + zona;
    // esto indica la ruta de conexion, que es la combinacion de
    // host,usuario,puerto, nombre de la base de datos a la cual queremos
    // conectarnos y la zona horaria (si se precisara).
    Connection conexion = null;

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      conexion = DriverManager.getConnection(url, name, password);
      System.out.println("Conexión exitosa a la base de datos.");
    } catch (ClassNotFoundException e) {
      System.out.println("Error al cargar el conector JDBC: " + e.getMessage());
    } catch (SQLException e) {
      System.out.println("Error de conexión: " + e.getMessage());
    }
    return conexion;
  }


  public static void cerrarConexion(Connection conexion) {
    if (conexion != null) {
      try {
        conexion.close();
        System.out.println("La conexión a la base de datos fue cerrada de manera exitosa");
      } catch (SQLException e) {
        System.out.println("Error al cerrar la conexión:" + e.getMessage());
      }
    }
  }
}

