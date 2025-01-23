import java.util.Scanner;

public class ActividadesArrays {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      OperacionesArrays operacionesArrays = new OperacionesArrays();
      ComplementariosArrays complementariosArrays = new ComplementariosArrays();
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
      complementariosArrays.elementosPares();
      // Sumando elementos de posiciones pares
      complementariosArrays.sumaElementosPares();
      // Ordenando nombres
      complementariosArrays.ordenarNombres(scanner);

    } catch (Exception e) {
      System.out.println("Ocurrió un error inesperado al ejecutar el programa: " +
          e.getMessage());
    }
  }
}
