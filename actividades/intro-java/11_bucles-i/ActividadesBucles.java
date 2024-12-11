
import java.util.Scanner;

public class ActividadesBucles {
  public static void main(String[] args) {
    System.out.print("\033\143");
    try (Scanner scanner = new Scanner(System.in)) {

      ActividadesMath actividades = new ActividadesMath();
      actividades.imprimirElementos();
      actividades.encontrarMinimo();
      actividades.imprimirInversos();

      actividades.contandoPares();
      actividades.calculoPromedio();
      actividades.concatenarElementos();

      // Complementarios
      Complementarios complementarios = new Complementarios();

      complementarios.invertirArray();
      complementarios.sumaAcumulada();
      complementarios.contarConcurrencias(scanner);
    } catch (Exception e) {
      System.out.println(e);
    }

  }
}