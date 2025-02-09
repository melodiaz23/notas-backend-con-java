package persistencia;
import entidades.Casa;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CasaDAO extends DAO {

public List<Casa> listarTodasLasCasas() throws SQLException {
  String script = "SELECT * FROM casas";
  List<Casa> casas = new ArrayList<>();
  try (ResultSet result = consultarDataBase(script);) {
    while (result.next()) {
      Casa casa = new Casa(
      result.getInt("id_casa"),
      result.getString("calle"),
      result.getInt("numero"),
      result.getInt("codigo_postal"),
      result.getString("ciudad"),
      result.getString("pais"),
      result.getDate("fecha_desde"),
      result.getDate("fecha_hasta"),
      result.getInt("tiempo_minimo"),
      result.getInt("tiempo_maximo"),
      result.getInt("precio_habitacion"),
      result.getString("tipo_vivienda"));
      casas.add(casa);
    }
  } catch (SQLException | ClassNotFoundException e) {
    throw new SQLException("Error al listar las casas " + e);
  }
  return casas;
}

  public Casa buscarCasaPorId(int id) throws SQLException {
      String script = "SELECT * FROM casas WHERE id_casa = " + id + ";";
    Casa casa = null;
    try (ResultSet result = consultarDataBase(script)) {
      while (result.next()) {
        casa = new Casa(
            result.getInt("id_casa"),
            result.getString("calle"),
            result.getInt("numero"),
            result.getInt("codigo_postal"),
            result.getString("ciudad"),
            result.getString("pais"),
            result.getDate("fecha_desde"),
            result.getDate("fecha_hasta"),
            result.getInt("tiempo_minimo"),
            result.getInt("tiempo_maximo"),
            result.getInt("precio_habitacion"),
            result.getString("tipo_vivienda"));
      }
    } catch (SQLException | ClassNotFoundException e) {
      throw new SQLException("Error al listar las casas " + e);
    }
    return casa;
  }

  public void crearCasa(Casa casa) throws SQLException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String fechaDesde = dateFormat.format(casa.getFechaDesde());
    String fechaHasta = dateFormat.format(casa.getFechaHasta());

    String script = "INSERT INTO casas (calle, numero, codigo_postal, ciudad, pais, fecha_desde, " +
        "fecha_hasta, tiempo_minimo, tiempo_maximo, precio_habitacion, tipo_vivienda) VALUES ('"
          + casa.getCalle() + "', " + casa.getNumero() + ", " + casa.getCodigoPostal() + ", '" +
          casa.getCiudad() + "', '" + casa.getPais() + "', '" + fechaDesde + "', '" + fechaHasta + "', " +
          casa.getTiempoMinimo() + ", " + casa.getTiempoMaximo() + ", " + casa.getPrecioHabitacion() + ", '" + casa.getTipoVivienda() + "')";
    try {
      insertarModificarEliminarDataBase(script);
    } catch (SQLException | ClassNotFoundException e) {
      throw new SQLException("Error al listar las casas " + e);
    }
  }


  public void eliminarCasa(int id) throws SQLException {
    try {
      String sql = "DELETE FROM casas WHERE id_casa = " + id + ";";
      insertarModificarEliminarDataBase(sql);
    } catch (SQLException | ClassNotFoundException e) {
      throw new SQLException("Error al eliminar casa " + e);
    }
  }
}

