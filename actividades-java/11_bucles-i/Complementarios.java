import java.util.Scanner;

public class Complementarios {

  public void invertirArray() {
    int[] arr = { 45, 32, 45, 67, 123, 2, 1 };
    int[] arr2 = new int[arr.length];

    System.out.println("Primer arreglo:");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " | ");
      arr2[i] = arr[(arr.length - 1 - i)];
    }
    System.out.println();

    System.out.println("Arreglo invertido:");
    for (int i = 0; i < arr2.length; i++) {
      arr[i] = arr2[i];
      System.out.print(arr[i] + " | ");
    }
    System.out.println();

  }

  public void sumaAcumulada() {
    int[] arr = { 1, 2, 3, 4, 5 };
    int resultado = 0;
    System.out.println("Arreglo inicial");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " | ");
    }
    System.out.println();
    System.out.println("Sumatoria");
    for (int i = 0; i < arr.length; i++) {
      arr[i] = resultado += arr[i];
      System.out.print(arr[i] + " | ");
    }
    System.out.println();

  }

  public void contarConcurrencias(Scanner scanner) {
    String frase = "Hola mundo";
    char[] arr = new char[50];
    char busqueda;
    int cont = 0;

    for (int i = 0; i < frase.length(); i++) {
      arr[i] = frase.charAt(i);

    }
    System.out.print("Por favor ingrese un caracter a buscar en la frase: ");
    busqueda = scanner.nextLine().charAt(0);

    for (char caracter : arr) {
      if (busqueda == caracter) {
        cont++;
      }

    }

    System.out.println(cont == 0 ? "El caracter " + busqueda + " no aparece en la frase."
        : "El caracter " + busqueda + " aparece " + cont + " veces.");

  }

}
