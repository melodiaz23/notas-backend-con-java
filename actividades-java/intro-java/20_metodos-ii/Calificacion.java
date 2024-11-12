import java.util.Scanner;

class Calificacion {
  public static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int nota = requerirNota();
    String resultado = obtenerNota(nota);
    System.out.println("La nota obtenida es de: " + resultado);
  }

  public static int requerirNota() {
    System.out.print("Ingresar calificacion: ");
    return sc.nextInt();
  }

  public static String obtenerNota(int nota) {
    String opcion;
    if (nota >= 90 && nota <= 100)
      opcion = "A";
    else if (nota >= 80 && nota < 90)
      opcion = "B";
    else if (nota >= 70 && nota < 80)
      opcion = "C";
    else if (nota >= 60 && nota < 70)
      opcion = "D";
    else if (nota < 60)
      opcion = "E";
    else
      opcion = "Opcion no valida.";
    return opcion;

  }
}