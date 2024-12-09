
public class Calificacion {

  public void mostrarCalificacion(int num) {
    if (num >= 90 && num <= 100) {
      System.out.println("La calificación obtenida es: A");
    } else if (num >= 80 && num < 90) {
      System.out.println("La calificación obtenida es: B");
    } else if (num >= 70 && num < 80) {
      System.out.println("La calificación obtenida es: C");
    } else if (num >= 60 && num < 70) {
      System.out.println("La calificación obtenida es: D");
    } else if (num < 60) {
      System.out.println("La calificación obtenida es: F");
    } else {
      System.out.println("Número ingresado está fuera del rango válido");
    }

  }
}
