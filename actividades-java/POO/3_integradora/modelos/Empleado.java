
import java.util.Arrays;

// package modelos;
public class Empleado {
  private String nombre;
  private Integer edad;
  private Integer salario;
  private String departamento;

  public Empleado() {
  }

  public Empleado(String nombre, Integer edad, Integer salario, String departamento) {
    this.nombre = nombre;
    this.edad = edad;
    this.salario = salario;
    this.departamento = departamento;
  }

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
    System.out.println(" No. Fila |     Nombre      |    Edad   |    Salario   | Departamento");
    System.out.println("----------------------------------------------------------------------");
    for (int i = 0; i < empleados.length; i++) {
      System.out.printf("     %d    |     %s     |     %d    |     %d     |     %s \n", i + 1,
          empleados[i].getNombre(),
          empleados[i].getEdad(),
          empleados[i].getSalario(), empleados[i].getDepartamento());
    }
    System.out.println();

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
    Empleado[] arregloFiltrado = new Empleado[0];
    int conteo = 0;
    for (Empleado empleado : empleados) {
      if (empleado.getNombre().trim().equalsIgnoreCase(criterio)
          || empleado.getDepartamento().trim().equalsIgnoreCase(criterio)) {
        arregloFiltrado = Arrays.copyOf(arregloFiltrado, arregloFiltrado.length + 1);
        arregloFiltrado[conteo] = empleado;
        conteo++;
      }
    }
    return arregloFiltrado;
  }

  public static Empleado[] filtarEmpleados(Empleado[] empleados, int max, int min) {
    Empleado[] arregloFiltrado = new Empleado[0];
    int conteo = 0;
    for (Empleado empleado : empleados) {
      if ((empleado.getSalario() >= min && empleado.getSalario() <= max)
          || (empleado.getEdad() >= min && empleado.getEdad() <= max)) {
        arregloFiltrado = Arrays.copyOf(arregloFiltrado, arregloFiltrado.length + 1);
        arregloFiltrado[conteo] = empleado;
        conteo++;
      }
    }
    return arregloFiltrado;
  }

  /**
   * Ordena un arreglo de empleados según el criterio especificado.
   * 
   * @param empleados el arreglo de empleados a ordenar
   * @param criterio  el criterio de ordenación, por ejemplo, "nombre", "edad",
   *                  "salario" o "departamento"
   * @return un nuevo arreglo de empleados ordenado según el criterio
   */
  public static Empleado[] ordenarEmpleados(Empleado[] empleados, int criterio) {

    Empleado[] arregloOrdenado = Arrays.copyOf(empleados, empleados.length);
    switch (criterio) {
      case 1 -> {
        for (int i = 0; i < arregloOrdenado.length - 1; i++) {
          for (int j = 0; j < arregloOrdenado.length - 1 - i; j++) {
            if (arregloOrdenado[j].getNombre().trim().toCharArray()[0] > arregloOrdenado[j + 1].getNombre().trim()
                .toCharArray()[0]) {
              Empleado temp;
              temp = arregloOrdenado[j];
              arregloOrdenado[j] = arregloOrdenado[j + 1];
              arregloOrdenado[j + 1] = temp;
            }
          }
        }
      }
      case 2 -> {
        for (int i = 0; i < arregloOrdenado.length - 1; i++) {
          for (int j = 0; j < arregloOrdenado.length - i - 1; j++) {
            if (arregloOrdenado[j].getEdad() > arregloOrdenado[j + 1].getEdad()) {
              Empleado temp;
              temp = arregloOrdenado[j];
              arregloOrdenado[j] = arregloOrdenado[j + 1];
              arregloOrdenado[j + 1] = temp;
            }
          }
        }
      }
      case 3 -> {
        for (int i = 0; i < arregloOrdenado.length - 1; i++) {
          for (int j = 0; j < arregloOrdenado.length - i - 1; j++) {
            if (arregloOrdenado[j].getSalario() > arregloOrdenado[j + 1].getSalario()) {
              Empleado temp;
              temp = arregloOrdenado[j];
              arregloOrdenado[j] = arregloOrdenado[j + 1];
              arregloOrdenado[j + 1] = temp;
            }
          }
        }
      }
      case 4 -> {
        for (int i = 0; i < arregloOrdenado.length - 1; i++) {
          for (int j = 0; j < arregloOrdenado.length - 1 - i; j++) {
            if (arregloOrdenado[j].getDepartamento().trim().toCharArray()[0] > arregloOrdenado[j + 1].getDepartamento()
                .trim()
                .toCharArray()[0]) {
              Empleado temp;
              temp = arregloOrdenado[j];
              arregloOrdenado[j] = arregloOrdenado[j + 1];
              arregloOrdenado[j + 1] = temp;
            }
          }
        }
      }
    }

    return arregloOrdenado;

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
    for (Empleado empleado : empleados) {
      if (empleado.getNombre().trim().equalsIgnoreCase(nombre)) {
        return empleado;
      }
    }
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
    empleado.setSalario(Math.round(empleado.getSalario() + (empleado.getSalario() * (incremento / 100))));
    return empleado;
  }

}
