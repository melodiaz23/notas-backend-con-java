import java.util.Arrays;
import java.util.Scanner;

public class RellenarArray {
  // POR REVISAR
  public static void main(String[] args) {
    System.out.println("\033\143"); // Limpia la consola
    try (Scanner sc = new Scanner(System.in)) {
      System.out.println("Indica el tamaño para el nuevo arreglo");
      int size = sc.nextInt();
      int[] arr = new int[size];
      int num, idx, start_idx = 0;
      do {
        System.out.println("¿Con qué número entero quieres rellenarlo?");
        num = sc.nextInt();

        do {
          System.out.println("¿Hasta que índice?");
          idx = sc.nextInt();
          if (idx <= start_idx) {
            System.out.println("Indice debe ser mayor a: " + start_idx);
          }
          if (idx >= arr.length) {
            System.out.println("Indice debe ser menor a: " + arr.length);
          }
        } while (idx <= start_idx || idx >= arr.length);

        Arrays.fill(arr, start_idx, idx + 1, num);

        start_idx = idx;

        System.out.println("El nuevo arreglo es: " + Arrays.toString(arr));
      } while (idx < arr.length - 1);
    }
  }
}