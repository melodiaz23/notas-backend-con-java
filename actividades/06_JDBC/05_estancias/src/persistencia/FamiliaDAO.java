package persistencia;

import entidades.Familia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FamiliaDAO extends DAO {
    public List<Familia> listarFamilias() throws SQLException, ClassNotFoundException {
        String script = "SELECT * FROM familias;";
        List<Familia> familias = new ArrayList<>();

        try(ResultSet rs = consultarDataBase(script)){
            while(rs.next()){
                Familia familia = new Familia();
                familia.setIdFamilia(rs.getInt("id_familia"));
                familia.setNombre(rs.getString("nombre"));
                familia.setEdadMinima(rs.getInt("edad_minima"));
                familia.setEdadMaxima(rs.getInt("edad_maxima"));
                familia.setNumHijos(rs.getInt("num_hijos"));
                familia.setEmail(rs.getString("email"));
                familia.setIdCasaFamilia(rs.getInt("id_casa_familia"));
                familias.add(familia);
            }
        } catch(SQLException | ClassNotFoundException e){
            throw new SQLException(e);
        } finally {
            desconectarDataBase();
        }
        return familias;
    }

    public Familia buscarFamiliaPorId(int idFamilia) throws SQLException, ClassNotFoundException {
        String script = "SELECT * FROM familias WHERE id_familia = ?;";
        try (ResultSet rs = consultarDataBase(script, idFamilia)) {
            Familia familia = new Familia();
            while (rs.next()) {
                familia.setIdFamilia(rs.getInt("id_familia"));
                familia.setNombre(rs.getString("nombre"));
                familia.setEdadMinima(rs.getInt("edad_minima"));
                familia.setEdadMaxima(rs.getInt("edad_maxima"));
                familia.setNumHijos(rs.getInt("num_hijos"));
                familia.setEmail(rs.getString("email"));
                familia.setIdCasaFamilia(rs.getInt("id_casa_familia"));
            }
            return familia;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Error al buscar familia por id: " + e);
        } finally {
            desconectarDataBase();
        }
    }

    public void crearFamilia(Familia familia) throws SQLException {
        String query = "INSERT INTO familias (nombre, edad_minima, edad_maxima, num_hijos, " +
            "email, id_casa_familia) VALUES (?,?,?,?,?,?);";
        try{
            insertarModificarEliminarDataBase(query,
                familia.getNombre(),
                familia.getEdadMinima(),
                familia.getEdadMaxima(),
                familia.getNumHijos(),
                familia.getEmail(),
                familia.getIdCasaFamilia());
        } catch (SQLException | ClassNotFoundException e) {
            throw new SQLException("Error al listar las familias " + e);
        }
    }

    public void eliminarFamilia(int idFamilia) throws SQLException{
        try{
            String script = "DELETE FROM familias WHERE id_familia = ?;";
            insertarModificarEliminarDataBase(script, idFamilia);
        } catch (SQLException | ClassNotFoundException e) {
            throw new SQLException("Error al eliminar familia " + e);
        }
    }


    public List<Familia> filtrarDatos(int edadMin, int cantHijos) throws Exception {
        String sql = "SELECT * FROM familias WHERE num_hijos > ? AND edad_maxima < ?;";
        List<Familia> familias = new ArrayList<Familia>();

        try (ResultSet rs = consultarDataBase(sql, cantHijos, edadMin)) {
            while (rs.next()){
                Familia familia = new Familia(
                rs.getInt("id_familia"),
                rs.getString("nombre"),
                rs.getInt("edad_minima"),
                rs.getInt("edad_maxima"),
                rs.getInt("num_hijos"),
                rs.getString("email"),
                rs.getInt("id_casa_familia")
                );
                familias.add(familia);
            }
        } catch (Exception e) {
          throw new Exception("Error al filtrar datos: " + e);
        }
        return familias;
    }

    public List<Familia> buscarPorEmail(String email) throws Exception {
        String sql = "SELECT * FROM familias WHERE email LIKE" + " '%" + email + "%';" ;

        List<Familia> familias = new ArrayList<>();

        try (ResultSet rs = consultarDataBase(sql)) {
            while (rs.next()){
                Familia familia = new Familia(
                rs.getInt("id_familia"),
                rs.getString("nombre"),
                rs.getInt("edad_minima"),
                rs.getInt("edad_maxima"),
                rs.getInt("num_hijos"),
                rs.getString("email"),
                rs.getInt("id_casa_familia")
                );
                familias.add(familia);
            }
        } catch (Exception e) {
          throw new Exception("Error al buscar por email: " + e);
        }
        return familias;
    }


}

