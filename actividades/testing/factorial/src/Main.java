import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("\033\143"); // Limpia la consola
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("Indica un número para saber su factorial: ");
      int num = scanner.nextInt();
      System.out.println("El factorial es: " + calculoFactorial(num));

    } catch (Exception e) {
      System.out.println(e);
    }
  }

    public static int calculoFactorial(int num){
      int factorial = 1;
      int i = 1;
      do {
        factorial *= i;
        i++;
      } while (i <= num);
      return factorial;
    }
}