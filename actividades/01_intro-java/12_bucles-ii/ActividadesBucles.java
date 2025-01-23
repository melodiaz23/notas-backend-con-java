
import java.util.Scanner;

public class ActividadesBucles {
  public static void main(String[] args) {
    System.out.println("\033\143"); // Limpia la consola
    MenuInteractivo menuInteractivo = new MenuInteractivo();
    AdvivinandoNumero advivinandoNumero = new AdvivinandoNumero();
    ValidandoPassword validandoPassword = new ValidandoPassword();
    NumeroDeDigitos numeroDeDigitos = new NumeroDeDigitos();
    ComplementariosArrays complementariosArrays = new ComplementariosArrays();

    try (Scanner scanner = new Scanner(System.in)) {
      menuInteractivo.iniciarMenu(scanner);
      advivinandoNumero.adivinar(scanner);
      validandoPassword.validarPassword(scanner);
      numeroDeDigitos.calcularDigitos();
      complementariosArrays.tablasDeMultiplicar(scanner);
      complementariosArrays.contadorNumeroPareseImpares(scanner);
      complementariosArrays.sumaAcumulada(scanner);

    } catch (Exception e) {
      System.out.println("Ocurrió un error inesperado: " + e);
    }

  }
}