
import java.util.Scanner;

public class Complementarios {

  public void elementosPares() {
    int[] arreglo = { 2, 3, 4, 5, 6, 7 };
    int conteo = arreglo.length;
    if (arreglo[0] % 2 == 0)
      conteo -= 1;
    if (arreglo[1] % 2 == 0)
      conteo -= 1;
    if (arreglo[2] % 2 == 0)
      conteo -= 1;
    if (arreglo[3] % 2 == 0)
      conteo -= 1;
    if (arreglo[4] % 2 == 0)
      conteo -= 1;
    if (arreglo[5] % 2 == 0)
      conteo -= 1;
    System.out.println((conteo == 0 ? "No existen números pares en el arreglo"
        : "En el arreglo se encuentran " + conteo + " numero/s pares"));
  }

  public void sumaElementosPares() {
    int[] arreglo = { 2, 3, 4, 5, 6 };

    int suma = arreglo[0] + arreglo[2] + arreglo[4];

    System.out.println("El resultado de la suma es: " + suma);
  }

  public void ordenarNombres(Scanner scanner) {
    String[] nombres = new String[4];
    System.out.println("Ingresa 4 nombres");
    nombres[0] = scanner.nextLine();
    nombres[1] = scanner.nextLine();
    nombres[2] = scanner.nextLine();
    nombres[3] = scanner.nextLine();

    String temp;

    // Primera iteración
    if (nombres[0].charAt(0) > nombres[1].charAt(0)) {
      temp = nombres[0];
      nombres[0] = nombres[1];
      nombres[1] = temp;
    }
    if (nombres[1].charAt(0) > nombres[2].charAt(0)) {
      temp = nombres[1];
      nombres[1] = nombres[2];
      nombres[2] = temp;
    }
    if (nombres[2].charAt(0) > nombres[3].charAt(0)) {
      temp = nombres[2];
      nombres[2] = nombres[3];
      nombres[3] = temp;
    }
    // Segunda iteración
    if (nombres[0].charAt(0) > nombres[1].charAt(0)) {
      temp = nombres[0];
      nombres[0] = nombres[1];
      nombres[1] = temp;
    }
    if (nombres[1].charAt(0) > nombres[2].charAt(0)) {
      temp = nombres[1];
      nombres[1] = nombres[2];
      nombres[2] = temp;
    }

    if (nombres[2].charAt(0) > nombres[3].charAt(0)) {
      temp = nombres[2];
      nombres[2] = nombres[3];
      nombres[3] = temp;
    }

    // Tercera iteración
    if (nombres[0].charAt(0) > nombres[1].charAt(0)) {
      temp = nombres[0];
      nombres[0] = nombres[1];
      nombres[1] = temp;
    }
    if (nombres[1].charAt(0) > nombres[2].charAt(0)) {
      temp = nombres[1];
      nombres[1] = nombres[2];
      nombres[2] = temp;
    }

    if (nombres[2].charAt(0) > nombres[3].charAt(0)) {
      temp = nombres[2];
      nombres[2] = nombres[3];
      nombres[3] = temp;
    }

    // Otra opción
    // Arrays.sort(nombres);
    // Si se desea ignorar mayusculas/minusculas
    // Arrays.sort(nombres, String.CASE_INSENSITIVE_ORDER);

    System.out.println("La lista de nombres organizados alfabéticamente es: ");
    System.out.println(nombres[0]);
    System.out.println(nombres[1]);
    System.out.println(nombres[2]);
    System.out.println(nombres[3]);

  }

}
