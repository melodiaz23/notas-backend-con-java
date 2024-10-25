
import java.util.Scanner;

public class ActividadesClaseWrappers {
  public static void main(String[] args) {
    System.out.println("\033\143"); // Limpia la consola
    VerificacionCadena_Act1 verificarCadena = new VerificacionCadena_Act1();
    CadenaANumero_Act2 cadenaANumero = new CadenaANumero_Act2();
    ContieneLetras_Act3 contieneLetras = new ContieneLetras_Act3();
    ContarEspacios_Act4 contarEspacio = new ContarEspacios_Act4();
    SumaNumeros_Act5 sumaNumeros = new SumaNumeros_Act5();
    ContantoDigitos_Act6 contarDigitos = new ContantoDigitos_Act6();

    try (Scanner scanner = new Scanner(System.in)) {
      verificarCadena.verificar(scanner);
      cadenaANumero.conversion(scanner);
      contieneLetras.validarLetras(scanner);
      contarEspacio.contarEspacio(scanner);
      sumaNumeros.sumar(scanner);
      contarDigitos.contarDigitos(scanner);

    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
