
import java.util.Scanner;

public class Complementarios {

  // Escribe un programa que solicite al usuario un número entero y muestre la
  // tabla de multiplicar de ese número utilizando un bucle while. El programa
  // debe seguir solicitando números hasta que el usuario ingrese un valor igual a
  // cero, en cuyo caso debería salir del bucle.
  public void tablasDeMultiplicar(Scanner scanner) {

    try {
      System.out.println("Ingresa un número para conocer la tabla de multiplicar");
      int num = scanner.nextInt();
      System.out.println("TABLA DE MULTIPLICAR X " + num);
      if (num != 0) {
        for (int i = 1; i <= 10; i++) {
          System.out.printf("%d x %d = %d \n", num, i, num * i);
        }
      }
      while (num != 0) {
        System.out.println("Ingresa otro número (0 para salir):");
        num = scanner.nextInt();
        if (num != 0) {
          for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d \n", num, i, num * i);
          }
        }
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void contadorNumeroPareseImpares(Scanner scanner) {

    int num;
    int pares = 0;
    int impares = 0;

    try {
      System.out.println("SUMADOR PARES E IMPARES");
      do {
        System.out.println("Indica un número (0 para salir):");
        num = scanner.nextInt();
        if (num % 2 == 0 && num != 0) {
          pares++;
        } else if (num % 2 != 0 && num != 0) {
          impares++;
        }
      } while (num != 0);
    } catch (Exception e) {
      System.out.println(e);
    }

    System.out.printf("PARES: %d, IMPARES: %d \n", pares, impares);
  }

  public void sumaAcumulada(Scanner scanner) {
    System.out.println("\033\143");
    int suma = 0, num;
    char opcion;
    do {
      System.out.println("Ingrese un numero:");
      num = scanner.nextInt();
      scanner.nextLine(); // Limpia el buffer despúes de leer el entero
      suma += num;
      do {
        System.out.println("Desea ingresar otro numero? S/N");
        opcion = scanner.nextLine().toUpperCase().charAt(0);
        if (opcion != 'S' && opcion != 'N') {
          System.out.println("Opción inválida");
        }
      } while (opcion != 'S' && opcion != 'N'); // Se repite si ingresan datos diferentes a S o N
    } while (opcion == 'S');

    System.out.printf("La suma de los números es: %d \n", suma);
  }
}
