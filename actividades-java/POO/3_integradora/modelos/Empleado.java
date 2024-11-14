// package modelos;
public class Empleado {
  private String nombre;
  private Integer edad;
  private Integer salario;
  private String departamento;

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Integer getEdad() {
    return edad;
  }

  public void setEdad(Integer edad) {
    this.edad = edad;
  }

  public Integer getSalario() {
    return salario;
  }

  public void setSalario(Integer salario) {
    this.salario = salario;
  }

  public String getDepartamento() {
    return departamento;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }

  /**
   * Permite crear un nuevo empleado y lo agrega al arreglo de empleados.
   * 
   * @param empleados el arreglo de empleados al que se va a agregar el nuevo
   *                  empleado
   */
  public static void crearEmpleado(Empleado[] empleados) {

  }

  /**
   * Muestra los empleados en pantalla.
   * La información se presentará en formato de tabla, donde la primera columna
   * mostrará el número de fila y la primera fila contendrá los encabezados de
   * cada columna.
   */
  public static void mostrarEmpleados(Empleado[] empleados) {

  }

  /**
   * Filtra empleados.
   * 
   * @param empleados la lista de empleados a filtrar
   * @param criterio  el criterio de ordenación, por ejemplo, "nombre", "edad",
   *                  "salario" o "departamento"
   * @return un nuevo arreglo según el criterio específico
   */
  public static Empleado[] filtarEmpleados(Empleado[] empleados, String criterio) {
    return null;
  }

  /**
   * Ordena un arreglo de empleados según el criterio especificado.
   * 
   * @param empleados el arreglo de empleados a ordenar
   * @param criterio  el criterio de ordenación, por ejemplo, "nombre", "edad",
   *                  "salario" o "departamento"
   * @return un nuevo arreglo de empleados ordenado según el criterio
   */
  public static Empleado[] ordenarEmpleados(Empleado[] empleados, String criterio) {
    return null;
  }

  /**
   * Busca un empleado por su nombre en el arreglo de empleados proporcionado.
   * 
   * @param empleados el arreglo de empleados en el que se realizará la búsqueda
   * @param nombre    el nombre del empleado que se desea buscar
   * @return el empleado que coincide con el nombre dado, o null si no se
   *         encuentra
   */
  public static Empleado buscarPorNombre(Empleado[] empleados, String nombre) {
    return null;
  }

  /**
   * Incrementa el salario del empleado proporcionado en un porcentaje dado.
   * 
   * @param empleado   el empleado al que se le va a incrementar el salario
   * @param incremento el porcentaje de incremento, por ejemplo, 0.1 para 10%
   * @return el empleado con el salario incrementado
   */
  public static Empleado incrementarSalario(Empleado empleado, float incremento) {
    return null;
  }

}
