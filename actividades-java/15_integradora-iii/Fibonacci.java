
import java.util.Arrays;

public class Fibonacci {
  public static void main(String[] args) {
    System.out.println("\033\143"); // Limpia la consola
    int[] fibonacci = new int[8];
    int i = 2;

    while (i < fibonacci.length) {
      fibonacci[0] = 0;
      fibonacci[1] = 1;
      fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
      i++;
    }
    System.out.println(Arrays.toString(fibonacci));

  }
}
