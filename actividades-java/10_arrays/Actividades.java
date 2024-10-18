import java.util.Scanner;

public class Actividades {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      OperacionesArrays operacionesArrays = new OperacionesArrays();
      Complementarios complementarios = new Complementarios();
      // Sumando Elementos
      operacionesArrays.suma();
      // Promedio Elementos
      operacionesArrays.promedio(scanner);
      // Encontrando el máximo
      operacionesArrays.encuentraMaximo(scanner);
      // Busca un elemento
      operacionesArrays.encuentraElemento(scanner);
      // Copiando Elemento
      operacionesArrays.copiaElemento(scanner);

      // COMPLEMENTARIOS
      // Contanto elementos pares
      complementarios.elementosPares();
      // Sumando elementos de posiciones pares
      complementarios.sumaElementosPares();
      // Ordenando nombres
      complementarios.ordenarNombres(scanner);

    } catch (Exception e) {
      System.out.println("Ocurrió un error inesperado al ejecutar el programa: " +
          e.getMessage());
    }
  }
}
