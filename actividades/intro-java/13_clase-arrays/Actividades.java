
import java.util.Arrays;
import java.util.Scanner;

public class Actividades {
  public void ordenDescendente() {
    int[] array = new int[10];
    for (int i = 0; i < array.length; i++) {
      array[i] = (int) (1 + Math.random() * 100);
    }

    System.out.println("Arreglo inicial: " + Arrays.toString(array));
    Arrays.sort(array);
    System.out.println("Ascendente: " + Arrays.toString(array));
    invertirArray(array);
    System.out.println("Arreglo final: " + Arrays.toString(array));

  }

  public void busquedaBinaria(Scanner scanner) {

    int[] array = new int[10];
    int value;

    for (int i = 0; i < array.length; i++) {
      array[i] = (int) (1 + Math.random() * 100);
    }

    Arrays.sort(array);
    System.out.println("El arreglo es: " + Arrays.toString(array));

    System.out.println("¿Cual valor necesitas buscar?");
    value = scanner.nextInt();
    int index = Arrays.binarySearch(array, value);
    System.out.println(index);
    if (index >= 0) {
      System.out.printf("El entero %d se encuentra en la posición %d.\n", value, index);
    } else {
      System.out.println("El elemento no se encuentra en el arreglo.");
    }
  }

  private void invertirArray(int[] array) {
    for (int i = 0; i < array.length / 2; i++) {
      int temp = array[i];
      array[i] = array[array.length - 1 - i];
      array[array.length - 1 - i] = temp;
    }
  }

  public void compararArreglos() {
    int[] array1 = { 1, 2, 3, 4 };
    int[] array2 = { 1, 2, 3, 4 };

    System.out.println("Arreglo 1: " + Arrays.toString(array1));
    System.out.println("Arreglo 2: " + Arrays.toString(array2));

    System.out
        .println(Arrays.equals(array1, array2) == true ? "Los arreglos son iguales" : "Los arreglos no son iguales");

  }

  public void copiandoArreglo(Scanner scanner) {
    int[] array1 = { 1, 2, 3, 4 };

    System.out.println("Arreglo: ");

    for (int i = 0; i < array1.length; i++) {
      System.out.print("Elemento: " + array1[i] + " | pos: " + i);
      System.out.println();
    }
    System.out.println();
    int posInicial;
    int posFinal;
    do {
      System.out.println("Indica una posición inicial");
      posInicial = scanner.nextInt();
      System.out.println("Indica una posición final");
      posFinal = scanner.nextInt();
      if (posInicial > posFinal || posFinal > array1.length - 1) {
        if (posInicial > posFinal) {
          System.out.println("La posición inicial debe ser menor a la posición final");
        }
        if (posFinal > array1.length - 1) {
          System.out.println("La posición final debe ser menor a: " + array1.length);
        }
      }
    } while (posInicial > posFinal || posFinal > array1.length - 1);

    int[] newArray = Arrays.copyOfRange(array1, posInicial, posFinal + 1);
    System.out.println(Arrays.toString(newArray));

  }

  public void rellenandoArreglo(Scanner scanner) {
    System.out.println("Indica el tamaño para el nuevo arreglo");
    int size = scanner.nextInt();
    int[] array = new int[size];
    System.out.println("¿Con qué número entero quieres rellenarlo?");
    int num = scanner.nextInt();
    Arrays.fill(array, num);

    System.out.println("Tu arreglo es: " + Arrays.toString(array));
  }

}
