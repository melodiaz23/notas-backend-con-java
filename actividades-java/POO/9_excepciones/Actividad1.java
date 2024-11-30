import java.util.Scanner;

public class Actividad1 {
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int dividendo, divisor;
    try {
      System.out.print("Ingrese dividendo: ");
      dividendo = scanner.nextInt();
      System.out.print("Ingrese divisor: ");
      divisor = obtenerNumerador();
      System.out.println(dividendo / divisor);

    } catch (Exception e) {
      System.out.println("Ocurrio un error: " + e.getMessage());
    }
  }

  public static Integer obtenerNumerador() throws Exception {
    int numero = scanner.nextInt();
    if (numero == 0) {
      scanner.nextLine();
      throw new Exception("No se puede dividir por 0");
    }
    return numero;
  }
}