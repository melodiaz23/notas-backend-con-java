package servicios;
import entidades.Cliente;
import persistencia.ClienteDAO;

import java.util.List;

public class ClienteServicio {
  private ClienteDAO cd;

  public  ClienteServicio(){
    this.cd =  new ClienteDAO();
  }
  public Cliente crearNuevoCliente(int codigoC, String nombre, String nombreContacto, String apellidoContacto,
                                   String telefono, String fax, String ciudad, String region, String pais, String codigoPostal,
                                   int idEmpleado, double limiteCredito) throws Exception {
    // Validaciones - Pueden estar metodo independiente.
    validacionesNyA(nombreContacto, apellidoContacto);
    Cliente cliente = new Cliente(codigoC, nombre, nombreContacto, apellidoContacto, telefono, fax, ciudad, region,
        pais, codigoPostal, idEmpleado, limiteCredito);
    cd.guardarCliente(cliente);
    return cliente;
  }
  public void validacionesNyA(String nombreContacto, String apellidoContacto) throws Exception{
    if (nombreContacto == null) {
      throw new Exception("El nombre del contacto no puede ser nulo.");
    }
    if (apellidoContacto == null) {
      throw new Exception("El apellido del contacto no puede ser nulo.");
    }
  }

  public List<Cliente> listarTodosLosClientes() {
    return cd.listarTodosLosClientes();
  }

  public Cliente validarCodigo(int codigo) throws Exception {
    if (codigo < 1) {
      throw new Exception("Código no puede ser menor a 0");
    }

    try {
      int temp = Integer.parseInt(String.valueOf(codigo));
    } catch (NumberFormatException e){
      System.out.println("Código no es un dato válido");
      throw e;
    }

    Cliente resultado = cd.buscarClientePorCodigo(codigo);
    if (tieneValoresNulos(resultado)) throw new Exception("Código no existe");
    return resultado;
  }

  private boolean tieneValoresNulos(Cliente resultado) {
    return resultado.getIdCliente() == 0 && resultado.getCodigoCliente() == 0 && resultado.getIdEmpleado() == 0 && resultado.getLimiteCredito() == 0.0 &&
        resultado.getNombreCliente() == null && resultado.getNombreContacto() == null &&
        resultado.getApellidoContacto() == null && resultado.getTelefono() == null &&
        resultado.getFax() == null && resultado.getCiudad() == null && resultado.getRegion() == null &&
        resultado.getPais() == null && resultado.getCodigoPostal() == null;
  }
}