package org.ejemplo;

public class Calificacion {

  public String mostrarCalificacion(int num) {
    if (num >= 90 && num <= 100) {
      return "A";
    } else if (num >= 80 && num < 90) {
      return "B";

    } else if (num >= 70 && num < 80) {
      return "C";

    } else if (num >= 60 && num < 70) {
      return "D";

    } else if (num < 60) {
      return "F";

    } else {
      return "Número ingresado está fuera del rango válido";
    }

  }
}
