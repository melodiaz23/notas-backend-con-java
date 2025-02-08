package persistencia;
import entidades.Estancia;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstanciaDAO extends DAO {
  public List<Estancia> listarEstancias() {
    String script = "SELECT * FROM estancias;";
    List<Estancia> estancias = new ArrayList<>();

    try (ResultSet result = consultarDataBase(script)) {
      while (result.next()){
        result.
      }
    } catch (Exception e) {

    }


  }

}
