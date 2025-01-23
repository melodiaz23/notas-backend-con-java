public class Divisibilidad {
  public void calcularDivisibilidad(int num) {
    if (num % 3 == 0 && num % 5 == 0) {
      System.err.println("El número " + num + " es divisible por 5 y por 3.");
    } else if (num % 5 == 0) {
      System.err.println("El número " + num + " es divisible por 5.");
    } else if (num % 3 == 0) {
      System.err.println("El número " + num + " es divisible por 3.");
    } else {
      System.err.println("El número " + num + " no es divisible por 3 o 5.");

    }
  }

}
