public class DiaSemanaClass {
  static public boolean esDiaLaboral(DiaSemana diaSemana) {
    boolean valor = false;
    switch (diaSemana) {
      case LUNES, MARTES, MIERCOLES, JUEVES, VIERNES -> valor = true;
      case SABADO, DOMINGO -> valor = false;
    }
    return valor;
  }
}
