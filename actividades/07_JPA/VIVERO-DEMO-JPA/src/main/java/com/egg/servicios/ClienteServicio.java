package com.egg.servicios;
import com.egg.entidades.Cliente;
import com.egg.persistencia.ClienteDAO;

import java.util.List;

public class ClienteServicio implements AutoCloseable {
  private final ClienteDAO clienteDAO;

  public ClienteServicio(){
    this.clienteDAO = new ClienteDAO();
  }

  public void guardarCliente(String apellidoContacto, String ciudad, int codigoCliente, String codigoPostal, String fax, int idEmpleado, double limiteCredito, String nombreCliente, String nombreContacto, String pais, String region, String telefono ) {
    Cliente newCliente = new Cliente();
    newCliente.setApellidoContacto(apellidoContacto);
    newCliente.setCiudad(ciudad);
    newCliente.setCodigoCliente(codigoCliente);
    newCliente.setCodigoPostal(codigoPostal);
    newCliente.setFax(fax);
    newCliente.setIdEmpleado(idEmpleado);
    newCliente.setLimiteCredito(limiteCredito);
    newCliente.setNombreCliente(nombreCliente);
    newCliente.setNombreContacto(nombreContacto);
    newCliente.setPais(pais);
    newCliente.setRegion(region);
    newCliente.setTelefono(telefono);
    clienteDAO.guardarCliente(newCliente);
  }

  public Cliente buscarCliente(int id) throws Exception{

      Cliente cliente = clienteDAO.buscarCliente(id);
      if (cliente == null) {
        throw new Exception("No existe cliente con este ID");
      }
      return cliente;

  }

  public void actualizarCliente(Cliente cliente){
    clienteDAO.actualizarCliente(cliente);
  }

  public void eliminarCliente(int id){
    Cliente cliente = clienteDAO.buscarCliente(id);
    if (cliente != null) {
      clienteDAO.eliminarCliente(cliente);
    } else {
      System.out.println("Cliente con ID especificado no existe.");
    }
  }

  public List<Cliente> listarClientes(){
    return clienteDAO.listarClientes();
  }

  public List<Cliente> buscarPorNombre(String nombre){
    return clienteDAO.buscarPorNombre(nombre);
  }

  public List<Cliente> buscarPorCiudad(String ciudad){
    return clienteDAO.buscarPorCiudad(ciudad);
  }




  @Override
  public void close() throws Exception {
    clienteDAO.cerrarEntidades();
  }
}