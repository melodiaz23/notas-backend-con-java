public class Calificaciones {
  public void MostrarCalificación(int calificacion) {
    switch (calificacion) {
      case 1 -> System.out.println(calificacion + ": Muy deficiente");
      case 2 -> System.out.println(calificacion + ": Muy deficiente");
      case 3 -> System.out.println(calificacion + ": Muy deficiente");
      case 4 -> System.out.println(calificacion + ": Muy deficiente");
      case 5 -> System.out.println(calificacion + ": Muy deficiente");
      default -> System.out.println("La calificación ingresada no es válida.");
    }
  }
}
