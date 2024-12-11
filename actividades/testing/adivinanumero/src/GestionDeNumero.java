
import java.util.Scanner;

public class GestionDeNumero {

  public static int numeroAleatorio(int num1, int num2){
    return (int) (num1 + Math.random() * (num2 - num1 + 1));
  }

  public static String encontrarNumero(int aleatorio, int numAdivinado){
    if (numAdivinado<aleatorio) return "El número aleatorio es mayor";
    if (numAdivinado>aleatorio) return "El número aleatorio es menor";
    else return "Has acertado! :D";
  }

}
