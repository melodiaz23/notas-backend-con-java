
import java.util.Arrays;
import java.util.Scanner;

public class OperacionesArrays {
  public void suma() {
    int[] arreglo = { 2, 3, 1 };
    int suma = arreglo[0] + arreglo[1] + arreglo[2];
    System.out.println("El resultado de la suma es: " + suma);

  }

  public void promedio(Scanner scanner) {
    int[] arreglo = new int[4];
    System.out.println("Ingresa 4 números: ");
    arreglo[0] = scanner.nextInt();
    arreglo[1] = scanner.nextInt();
    arreglo[2] = scanner.nextInt();
    arreglo[3] = scanner.nextInt();

    int suma = arreglo[0] + arreglo[1] + arreglo[2] + arreglo[3];
    float promedio = (float) suma / arreglo.length;

    System.out.println("El promedio de los números ingresados es: " + promedio);
  }

  public void encuentraMaximo(Scanner scanner) {
    int[] arreglo = new int[5];
    System.out.println("Ingresa 5 números: ");
    arreglo[0] = scanner.nextInt();
    arreglo[1] = scanner.nextInt();
    arreglo[2] = scanner.nextInt();
    arreglo[3] = scanner.nextInt();
    arreglo[4] = scanner.nextInt();

    int numMayor = arreglo[0];

    if (numMayor < arreglo[1])
      numMayor = arreglo[1];
    if (numMayor < arreglo[2])
      numMayor = arreglo[2];
    if (numMayor < arreglo[3])
      numMayor = arreglo[3];
    if (numMayor < arreglo[4])
      numMayor = arreglo[4];

    System.out.println("El número mayor del arreglo es: " + numMayor);

  }

  public void encuentraElemento(Scanner scanner) {
    int[] arreglo = { 23, 21, 32 };
    System.out.print("Adivine el numero: ");
    int numero = scanner.nextInt();
    System.out.println((arreglo[0] == numero || arreglo[1] == numero || arreglo[2] == numero) ? "Adivinaste el numero"
        : "No adivinaste el numero");

  }

  public void copiaElemento(Scanner scanner) {
    int[] arreglo = { 23, 21, 32 };
    int[] copiaArreglo = Arrays.copyOf(arreglo, 5);
    System.out.println("Ingresa dos nuevos números");
    copiaArreglo[3] = scanner.nextInt();
    copiaArreglo[4] = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Los nuevos elementos del array son: ");
    System.out.print(copiaArreglo[0] + " | ");
    System.out.print(copiaArreglo[1] + " | ");
    System.out.print(copiaArreglo[2] + " | ");
    System.out.print(copiaArreglo[3] + " | ");
    System.out.println(copiaArreglo[4] + " | ");
  }

}
