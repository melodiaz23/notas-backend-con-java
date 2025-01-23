package src;

import java.util.Scanner;

public class ActividadesMath {
  public static void main(String[] args) {
//    src.NumeroAbsoluto numeroAbsoluto = new src.NumeroAbsoluto();
//    src.RedondeoNumeros redondeoNumeros = new src.RedondeoNumeros();
//    src.NumerosAleatorios numerosAleatorios = new src.NumerosAleatorios();
//    src.CalculandoPotencia calculandoPotencia = new src.CalculandoPotencia();
//    src.CalculandoRaiz calculandoRaiz = new src.CalculandoRaiz();
//    src.NumerosAleatorios2 numerosAleatorios2 = new src.NumerosAleatorios2();
//    src.AnalisisDeRaiz analisisDeRaiz = new src.AnalisisDeRaiz();

    try (Scanner scanner = new Scanner(System.in)) {
      // Actividad 1: Calculando el valor absoluto.
//      numeroAbsoluto.iniciarActividad(scanner);
      // Actividad 2: Redondeo de números
//      redondeoNumeros.iniciarActividad(scanner);
      // Actividad 3: Generando números aleatorios
      NumerosAleatorios.iniciarActividad();
      // Actividad 4: Calculando la potencia
//      calculandoPotencia.iniciarActividad(scanner);
      // Actividad 5: Calculando la raíz cuadrada
//      calculandoRaiz.iniciarActividad(scanner);

      // EJERCICIOS COMPLEMENTARIOS
      // Actividad 1: Generando un número aleatorio entre dos límites
//      numerosAleatorios2.iniciarActividad(scanner);
      // Actividad 2: Generación aleatoria y análisis de raíz cuadrada
//      analisisDeRaiz.iniciarActividad(scanner);

    } catch (Exception e) {
      System.out.println("Ocurrió un error: " + e.getMessage());
    }

  }
}
