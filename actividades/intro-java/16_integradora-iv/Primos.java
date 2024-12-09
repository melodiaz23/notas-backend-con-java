import java.util.Arrays;
import java.util.Scanner;

public class Primos {
  public static void main(String[] args) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.println("Cantidad de numeros primos: ");
      int num = scan.nextInt();

      int[] primos = new int[num];
      int count = 0;
      int i = 2;

      while (count < num) {
        boolean primo = true;
        for (int j = 2; j <= Math.sqrt(i); j++) {
          if (i % j == 0) {
            primo = false;
            break;
          }
        }
        if (primo) {
          primos[count] = i;
          count++;
        }
        i++;
      }

      System.out.println("Numeros primos: " + Arrays.toString(primos));
    }
  }
}