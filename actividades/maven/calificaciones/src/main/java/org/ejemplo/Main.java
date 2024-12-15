package org.ejemplo;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Actividad 1
    Calificacion calificacion = new Calificacion();
    // try-with-resources statement
    try (Scanner readNum = new Scanner(System.in)) {
      System.out.print("Indica un número entre 0 y 100: ");
      int num = readNum.nextInt();
      System.out.println("La calificación obtenida es: " + calificacion.mostrarCalificacion(num));
    }
  }
}