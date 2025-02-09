package persistencia;
import entidades.Estancia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EstanciaDAO extends DAO {
  public void crearEstancia(Estancia estancia){
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String fechaDesde = dateFormat.format(estancia.getFechaDesde());
    String fechaHasta = dateFormat.format(estancia.getFechaHasta());

    String script = "INSERT INTO estancias (id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta) VALUES (" +
        estancia.getIdCLiente() + ", " + estancia.getIdCasa() + ", '" + estancia.getNombreHuesped() +
        "', '" + fechaDesde + "', '" + fechaHasta + "');";

    try {
      insertarModificarEliminarDataBase(script);
    } catch (SQLException | ClassNotFoundException e) {
      throw new RuntimeException("Error al crear nueva estancia: " + e);
    }
  }


  public List<Estancia> listarEstancias() throws SQLException {
    String script = "SELECT * FROM estancias;";
    List<Estancia> estancias = new ArrayList<>();

    try (ResultSet result = consultarDataBase(script)) {
      while (result.next()){
        Estancia estancia = new Estancia(
            result.getInt("id_estancia"),
            result.getInt("id_cliente"),
            result.getInt("id_casa"),
            result.getString("nombre_huesped"),
            result.getDate("fecha_desde"),
            result.getDate("fecha_hasta")
        );
        estancias.add(estancia);
      }
    } catch (SQLException | ClassNotFoundException e) {
      throw new SQLException(e);
    }
  return estancias;

  }

  public Estancia buscarEstanciaPorId(int id) throws SQLException {
    String script = "SELECT * FROM estancias WHERE id_estancia = " + id;
    try (ResultSet result = consultarDataBase(script)) {
      Estancia estancia = null;
      while (result.next()){
        estancia = new Estancia(
            result.getInt("id_estancia"),
            result.getInt("id_cliente"),
            result.getInt("id_casa"),
            result.getString("nombre_huesped"),
            result.getDate("fecha_desde"),
            result.getDate("fecha_hasta")
        );
      }
      return estancia;

    } catch (SQLException | ClassNotFoundException e) {
      throw new SQLException(e);
    }

  }

}
