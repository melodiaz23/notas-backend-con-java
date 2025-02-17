package com.egg.servicios;

import com.egg.entidades.Empleado;
import com.egg.persistencia.EmpleadoDAO;

import java.util.List;

public class EmpleadoServicio {

  private final EmpleadoDAO daoEmpleado;

  public EmpleadoServicio(){
    this.daoEmpleado = new EmpleadoDAO();
  }

  public void eliminarEmpleado(int id) throws Exception{
    try {
      daoEmpleado.eliminarEmpleado(id);
      System.out.println("Empleado eliminado");
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public List<Empleado> buscarEmpleadosPorId(int id){
    return daoEmpleado.buscarEmpleadoPorId(id);
  }

  public List<Empleado> listarEmpleadoConOficina(){
    return daoEmpleado.listarEmpleadosConOficina();
  }


}
