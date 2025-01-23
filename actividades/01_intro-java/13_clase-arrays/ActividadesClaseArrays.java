
import java.util.Scanner;

public class ActividadesClaseArrays {
  public static void main(String[] args) {
    System.out.println("\033\143"); // Limpia la consola

    try (Scanner scanner = new Scanner(System.in)) {
      ActividadesMath actividades = new ActividadesMath();
      actividades.ordenDescendente();
      actividades.busquedaBinaria(scanner);
      actividades.compararArreglos();
      actividades.copiandoArreglo(scanner);
      actividades.rellenandoArreglo(scanner);
    } catch (Exception e) {
      System.out.println(e);
    }

  }

}