package servicios;

import entidades.Estancia;
import persistencia.EstanciaDAO;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class EstanciaServicio {
  private final EstanciaDAO estanciaDAO;

  public EstanciaServicio() {
    this.estanciaDAO = new EstanciaDAO();
  }

  public void crearNuevaEstancia(Estancia estancia) throws ParseException {
    validarDatos(estancia);
    estanciaDAO.crearEstancia(estancia);
  }

  private void validarDatos(Estancia estancia) {
    if (estancia == null) throw new IllegalArgumentException("Estancia no puede ser nulo");
    if (estancia.getIdCLiente() == 0) throw new IllegalArgumentException("Id del cliente debe ser un ID válido");
    if (estancia.getIdCasa() == 0) throw new IllegalArgumentException("Id de la casa debe ser un ID válido");
    if (estancia.getNombreHuesped() == null || estancia.getNombreHuesped().isEmpty()) throw new IllegalArgumentException("Nombre del huésped no puede ser nulo o vacío");
    if (estancia.getFechaDesde() == null) throw new IllegalArgumentException("Fecha de inicio no puede ser nula");
    if (estancia.getFechaHasta() == null) throw new IllegalArgumentException("Fecha de fin no puede ser nula");
  }

  public List<Estancia> listarTodasLasEstancias() throws SQLException {
    return estanciaDAO.listarEstancias();
  }

  public Estancia buscarEstanciaPorId(int id) throws SQLException {
    return estanciaDAO.buscarEstanciaPorId(id);
  }

}
