
package com.egg.servicios;

import com.egg.entidades.Oficina;
import com.egg.persistencia.OficinaDAO;

// Implementa interfaz AutoCloseable
public class OficinaServicio implements AutoCloseable {
  // Instancio a la unidad d persistencia para acceder a los metodos del EM
  private final OficinaDAO oficinaDAO;

  public OficinaServicio() {
    this.oficinaDAO = new OficinaDAO();
  }

  public void crearOficina(String codigoOficina, String ciudad, String pais, String region, String telefono, String codigoPostal) {
    try {
      // Crear una nueva instancia de Oficina
      Oficina oficinaNueva = new Oficina();
      oficinaNueva.setCiudad(ciudad);
      oficinaNueva.setCodigoPostal(codigoPostal);
      oficinaNueva.setCodigoOficina(codigoOficina);
      oficinaNueva.setPais(pais);
      oficinaNueva.setRegion(region);
      oficinaNueva.setTelefono(telefono);

      // Llamar al método de OficinaDAO para guardar la nueva oficina
      oficinaDAO.guardaOficina(oficinaNueva);

    } catch (Exception e) {
      System.out.println(e + ": No se guardo la nueva oficina de manera correcta");
    }
  }

 public void actualizarOficina(Oficina oficina){
    oficinaDAO.actualizarOficina(oficina);
 }

 public Oficina encontrarOficina(int id){
    return oficinaDAO.buscarOficina(id);
 }

 public void eliminarOficina(int id){
   Oficina oficina = oficinaDAO.buscarOficina(id);
   if (oficina != null) {
     oficinaDAO.eliminarOficina(oficina);
   } else {
     System.out.println("Oficina con ID especificado no existe.");
   }
 }

  @Override
  public void close() throws Exception {
    oficinaDAO.cerrarEntidades();
  }
}
  