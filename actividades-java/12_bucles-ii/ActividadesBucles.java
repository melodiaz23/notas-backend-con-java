
import java.util.Scanner;

public class ActividadesBucles {
  public static void main(String[] args) {
    System.out.println("\033\143"); // Limpia la consola
    MenuInteractivo menuInteractivo = new MenuInteractivo();
    AdvivinandoNumero advivinandoNumero = new AdvivinandoNumero();
    ValidandoPassword validandoPassword = new ValidandoPassword();
    NumeroDeDigitos numeroDeDigitos = new NumeroDeDigitos();
    Complementarios complementarios = new Complementarios();

    try (Scanner scanner = new Scanner(System.in)) {
      menuInteractivo.iniciarMenu(scanner);
      advivinandoNumero.adivinar(scanner);
      validandoPassword.validarPassword(scanner);
      numeroDeDigitos.calcularDigitos();
      complementarios.tablasDeMultiplicar(scanner);
      complementarios.contadorNumeroPareseImpares(scanner);
      complementarios.sumaAcumulada(scanner);

    } catch (Exception e) {
      System.out.println("Ocurrió un error inesperado: " + e);
    }

  }
}