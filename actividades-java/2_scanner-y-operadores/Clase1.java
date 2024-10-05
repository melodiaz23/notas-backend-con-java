import java.util.Scanner;

public class Clase1 {
  public static void main(String[] args) {
    // try-with-resources se usa para asegurar que Scanner se cierre automáticamente
    // al finalizar el bloque, liberando recursos de manera segura.
    try (Scanner read = new Scanner(System.in)) {
      // // Actividad 1
      System.out.println("Actividad 1");
      Actividad1 actividad1 = new Actividad1();
      actividad1.solicitaNombre(read);
      actividad1.solicitaEdad(read);
      actividad1.imprimirDatos();

      // // Actividad 2
      System.out.println("Actividad 2");
      Actividad2 actividad2 = new Actividad2();
      actividad2.operacionesBasicas();
      actividad2.solicitarNum(read);

      // // Actividad 3
      System.out.println("Actividad 3");
      Actividad3 actividad3 = new Actividad3();
      actividad3.solicitarNum(read);

      // Complementario
      System.out.println("Complementario");
      Complementario complementario = new Complementario();
      complementario.verificaEdad(read);

      // Complementario 2
      System.out.println("Complementario 2");
      Complementario2 complementario2 = new Complementario2();
      complementario2.solicitarDatos(read);
      complementario2.calculaPerimetro();
      complementario2.calculaArea();
    }

  }

}