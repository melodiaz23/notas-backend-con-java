import java.util.Scanner;

public class AnalisisDeRaiz {
  public void iniciarActividad(Scanner scanner) {
    int numLimite;

    do {
      System.out.println("Ingresa un número entre 1 y 30");
      numLimite = scanner.nextInt();
    } while (numLimite < 1 || numLimite > 30);

    int numAleatorio = (int) (Math.floor(Math.random() * (numLimite - 1 + 1) + 1));
    double raizEntera = Math.sqrt(numAleatorio);

    System.out.println("El número aleatorio generado es: " + numAleatorio);
    System.out.println("La raiz del número aleatorio es: " + raizEntera);

    boolean esPrimo = calcularPrimo(numAleatorio, (int) raizEntera);

    System.out.println(esPrimo ? "El número es primo" : "El número NO es primo");

  }

  // https://es.stackoverflow.com/questions/34895/determinar-si-el-número-es-primo
  private boolean calcularPrimo(int num, int raiz) {
    if (num == 2)
      return true;
    if (num == 1 || num % 2 == 0)
      return false;
    // Para verificar si es primo se debe verificar si num es divisible por algún
    // número entre 3 y la raíz cuadrada de num.
    for (int i = 3; i <= raiz; i += 2) { // +2 porque ya se verificó números pares
      if (num % i == 0) // Se verifica si no es divisible por cualquier número impar hasta la raiz del
                        // mismo.
        return false;
    }
    return true;
  }
}
