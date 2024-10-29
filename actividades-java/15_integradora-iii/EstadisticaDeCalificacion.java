
public class EstadisticaDeCalificacion {
  public static void main(String[] args) {
    System.out.println("\033\143"); // Limpia la consola
    String[] grades = new String[10];

    for (int i = 0; i < grades.length; i++) {
      // Asumiendo que la máxima nota sea 12
      double randomGrade = Math.random() * 12 + 1;
      grades[i] = String.valueOf(randomGrade);
    }

    int conteoDesaprobado = 0, conteoAprobado = 0, conteoExcelente = 0;
    double sumaDesaprobado = 0, sumaAprobado = 0, sumaExcelente = 0;

    double sumaTotal = 0;

    // Conteo para determinar el tamaño del array
    for (String grade : grades) {
      double gradeValue = Double.parseDouble(grade);
      sumaTotal += Double.parseDouble(grade);
      if (gradeValue < 4) {
        conteoDesaprobado++;
      } else if (gradeValue < 10) {
        conteoAprobado++;
      } else if (gradeValue >= 10) {
        conteoExcelente++;
      }
    }

    double[] desaprobado = new double[conteoDesaprobado];
    double[] aprobado = new double[conteoAprobado];
    double[] excelente = new double[conteoExcelente];

    conteoDesaprobado = conteoAprobado = conteoExcelente = 0;

    for (String grade : grades) {
      double gradeValue = Double.parseDouble(grade);
      if (gradeValue < 4) {
        desaprobado[conteoDesaprobado] = gradeValue;
        sumaDesaprobado += gradeValue;
        conteoDesaprobado++;
      } else if (gradeValue < 10) {
        aprobado[conteoAprobado] = gradeValue;
        sumaAprobado += gradeValue;
        conteoAprobado++;
      } else if (gradeValue >= 10) {
        excelente[conteoExcelente] = gradeValue;
        sumaExcelente += gradeValue;
        conteoExcelente++;
      }
    }

    double promedioGeneral = sumaTotal / grades.length;
    double promedioAprobado = sumaAprobado / conteoAprobado;
    double promedioDesarobado = sumaDesaprobado / conteoDesaprobado;
    double promedioExcelente = sumaExcelente / conteoExcelente;

    System.out.println("Total");
    for (String grade : grades) {
      double gradeValue = Double.parseDouble(grade);
      System.out.printf("%.2f | ", gradeValue);
    }
    System.out.println();
    System.out.println("Desaprobado");
    for (double grade : desaprobado) {
      System.out.printf("%.2f | ", grade);
    }
    System.out.println();
    System.out.println("Aprobado");
    for (double grade : aprobado) {
      System.out.printf("%.2f | ", grade);
    }
    System.out.println();
    System.out.println("Excelente");
    for (double grade : excelente) {
      System.out.printf("%.2f | ", grade);
    }
    System.out.println();

    System.out.printf("Promedio general: %.2f \n", promedioGeneral);
    System.out.printf("Promedio desaprobado: %.2f \n", promedioDesarobado);
    System.out.printf("Promedio aprobado: %.2f \n", promedioAprobado);
    System.out.printf("Promedio excelente: %.2f \n", promedioExcelente);

  }
}