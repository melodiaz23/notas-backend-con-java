package persistencia;

import entidades.Casa;
import entidades.Familia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FamiliaDAO extends DAO {
    public List<Familia> listarFamilias() throws SQLException{
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
        }
        return familias;
    }

    public Familia buscarFamiliaPorId(int idFamilia) {
        String script = "SELECT * FROM familias WHERE id_familia = " + idFamilia + ";";
        try (ResultSet rs = consultarDataBase(script)) {
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
        }
    }

    public List<Familia> ubicacionFamilias() throws SQLException{
        String script = "SELECT nombre,email FROM familias ORDER BY nombre ASC;";
        List<Familia> familias = new ArrayList<>();

        try(ResultSet rs = consultarDataBase(script)){
            while(rs.next()){
                Familia familia = new Familia();
                familia.setNombre(rs.getString("nombre"));
                familia.setEmail(rs.getString("email"));
                familias.add(familia);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new SQLException(e);
        }
        return familias;

    }
}
