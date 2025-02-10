package servicios;

import persistencia.FamiliaDAO;
import entidades.Familia;

import java.sql.SQLException;
import java.util.List;

public class FamiliaServicio {
    private final FamiliaDAO familiaDAO;

    public FamiliaServicio(){
        this.familiaDAO = new FamiliaDAO();
    }

    private void validarDatos(Familia familia){
        if(familia == null) throw new IllegalArgumentException("Familia no puede ser nulo");
        if(familia.getNombre()== null || familia.getNombre().isEmpty()) throw new IllegalArgumentException("Nombre de la familia no puede ser nulo o estar vacío.");
        if(familia.getEmail()== null || familia.getEmail().isEmpty()) throw new IllegalArgumentException("Correo no puede ser nulo ni estar vacío");
        if(familia.getIdCasaFamilia()==0) throw new IllegalArgumentException("Id de la casa debe ser un ID valido");
    }


    public List<Familia> listarFamilias() throws SQLException, ClassNotFoundException {
        return familiaDAO.listarFamilias();
    }

    public Familia buscarFamiliaPorId(int idFamilia) throws SQLException, ClassNotFoundException {
        return familiaDAO.buscarFamiliaPorId(idFamilia);
    }

    public void crearFamilia(Familia familia) throws SQLException, ClassNotFoundException {
        validarDatos(familia);
        familiaDAO.crearFamilia(familia);
    }

    public void eliminarFamilia(int idFamilia) throws SQLException{
        familiaDAO.eliminarFamilia(idFamilia);
    }

    public List<Familia> filtrarDatos(int edadMin, int cantHijo) throws Exception {
        return familiaDAO.filtrarDatos(edadMin, cantHijo);
    }

    public List<Familia> filtrarDatosPorEmail(String email) throws Exception {
        return familiaDAO.buscarPorEmail(email);
    }

}
