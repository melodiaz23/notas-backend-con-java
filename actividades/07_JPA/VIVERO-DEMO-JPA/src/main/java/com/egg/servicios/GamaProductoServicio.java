//GamaProductoServicio

package com.egg.servicios;

import com.egg.entidades.GamaProducto;
import com.egg.persistencia.GamaProductoDAO;

public class GamaProductoServicio {
  private final GamaProductoDAO gamaProductoDAO = new GamaProductoDAO();

  public void guardarGamaProducto(String descripcionHtml, String descripcionTexto, String gama, String imagen) throws Exception {
    try {
      GamaProducto gamaProducto = new GamaProducto();

      gamaProducto.setDescripcionHtml(descripcionHtml);
      gamaProducto.setDescripcionTexto(descripcionTexto);
      gamaProducto.setGama(gama);
      gamaProducto.setImagen(imagen);

      gamaProductoDAO.guardarGamaProducto(gamaProducto);

      System.out.println("Gama de producto guardada exitosamente.");
    } catch (Exception e) {
      System.err.println("Error al guardar la gama de producto: " + e.getMessage());
      throw new Exception("No se pudo guardar la gama de producto", e);
    }

  }

  public GamaProducto buscarGamaProducto(int id) throws Exception {
    if (id < 0) {
      throw new Exception("El id debe ser mayor a 0");
    }

    GamaProducto gama = gamaProductoDAO.buscarGamaProducto(id);
    if (gama == null) {
      throw new Exception("No existe cliente con ese id");
    }
    return gama;

  }
}