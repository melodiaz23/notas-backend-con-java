package persistencia;

import entidades.Comentario;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ComentarioDAO extends DAO {

  public String buscarComentario(int idCasa) throws SQLException {
    String script = "SELECT comentario FROM comentarios WHERE id_casa=" + idCasa + ";";
    String comentario = null;
    try (ResultSet result = consultarDataBase(script)) {
      while (result.next()){
        comentario = result.getString("comentario");
      }

    } catch (Exception e) {
      throw new SQLException("Error al buscar comentario: " + e);
    }
    return comentario;
  }

  public void crearComentario(Comentario comentario){
    String script = "INSERT INTO comentarios (id_casa, comentario) VALUES (" +
        comentario.getIdCasa() + ", '" + comentario.getComentario() + "';";

    try {
      insertarModificarEliminarDataBase(script);
    } catch (SQLException | ClassNotFoundException e) {
      throw new RuntimeException("Error al crear comentario" +  e);
    }
  }

  public void eliminarComentario(int idComentario){
    String script = "DELETE FROM comentarios WHERE id_comentario=" + idComentario + ";";
    try {
      insertarModificarEliminarDataBase(script);
    } catch (SQLException | ClassNotFoundException e) {
      throw new RuntimeException("Error al crear comentario" +  e);
    }
  }
}
