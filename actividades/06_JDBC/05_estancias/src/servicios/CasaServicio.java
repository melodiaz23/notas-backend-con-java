package servicios;
import entidades.Casa;
import persistencia.CasaDAO;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CasaServicio {
  private final CasaDAO casaDAO;

  public CasaServicio() {
    this.casaDAO = new CasaDAO();
  }

  public List<Casa> listarTodasLasCasas() throws SQLException {
    return casaDAO.listarTodasLasCasas();
  }

  public List<Casa> listarTodasLasCasasEntreFechas(String fechaInicial, String fechaFinal, String pais ) throws SQLException, ParseException {
    return casaDAO.listasCasasEntreFechas(fechaInicial, fechaFinal, pais);
  }

  public Casa buscarCasaPorId(int id) throws SQLException {
    return casaDAO.buscarCasaPorId(id);
  }

  public void crearCasa(Casa casa) throws SQLException {
    // Pendiente: Incluir validaciones adicionales al crear casa
    casaDAO.crearCasa(casa);
  }

  public void eliminarCasa(int id) throws SQLException {
    casaDAO.eliminarCasa(id);
  }
}