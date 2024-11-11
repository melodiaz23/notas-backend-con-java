
import java.util.Arrays;

public class ImprimirArray {
  public static void main(String[] args) {
    int[] numeros = { 1, 2, 3, 4 };
    String[] nombres = { "Ana", "Roberto", "María" };
    int[][] matriz = { { 1, 2 }, { 1, 3 } };
    imprimirArray(numeros);
    imprimirArray(nombres, matriz);
  }

  public static void imprimirArray(int[] array) {
    System.out.println(Arrays.toString(array));
  }

  public static void imprimirArray(String[] arrayString, int[][] arrayBidimensional) {
    System.out.println(Arrays.toString(arrayString));
    System.out.println(Arrays.deepToString(arrayBidimensional)); // .deepToString para arreglos multidimensionales.
  }
}
