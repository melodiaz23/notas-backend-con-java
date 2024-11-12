import java.util.Scanner;

public class Actividades {
  public static void main(String[] args) {

    NumeroAbsoluto numeroAbsoluto = new NumeroAbsoluto();
    RedondeoNumeros redondeoNumeros = new RedondeoNumeros();
    NumerosAleatorios numerosAleatorios = new NumerosAleatorios();
    CalculandoPotencia calculandoPotencia = new CalculandoPotencia();
    CalculandoRaiz calculandoRaiz = new CalculandoRaiz();
    NumerosAleatorios2 numerosAleatorios2 = new NumerosAleatorios2();
    AnalisisDeRaiz analisisDeRaiz = new AnalisisDeRaiz();

    try (Scanner scanner = new Scanner(System.in)) {
      // Actividad 1: Calculando el valor absoluto.
      numeroAbsoluto.iniciarActividad(scanner);
      // Actividad 2: Redondeo de números
      redondeoNumeros.iniciarActividad(scanner);
      // Actividad 3: Generando números aleatorios
      numerosAleatorios.iniciarActividad();
      // Actividad 4: Calculando la potencia
      calculandoPotencia.iniciarActividad(scanner);
      // Actividad 5: Calculando la raíz cuadrada
      calculandoRaiz.iniciarActividad(scanner);

      // EJERCICIOS COMPLEMENTARIOS
      // Actividad 1: Generando un número aleatorio entre dos límites
      numerosAleatorios2.iniciarActividad(scanner);
      // Actividad 2: Generación aleatoria y análisis de raíz cuadrada
      analisisDeRaiz.iniciarActividad(scanner);

    } catch (Exception e) {
      System.out.println("Ocurrió un error: " + e.getMessage());
    }

  }
}
