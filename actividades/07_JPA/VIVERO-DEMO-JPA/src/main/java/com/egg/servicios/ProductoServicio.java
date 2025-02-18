package com.egg.servicios;

import com.egg.entidades.Producto;
import com.egg.persistencia.ProductoDAO;

import java.util.List;

public class ProductoServicio implements AutoCloseable {
  ProductoDAO productoDAO = new ProductoDAO();

  public List<Producto> listarProductos(){
    return productoDAO.listarProductos();
  }


  @Override
  public void close() throws Exception {
    productoDAO.cerrarEntidades();
  }
}
