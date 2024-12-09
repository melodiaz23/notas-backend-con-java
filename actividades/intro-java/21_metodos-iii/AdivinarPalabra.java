public class AdivinarPalabra {

  public static void main(String[] args) {
    System.out.println("\033\143"); // Limpia la consola

    String[] listaPalabras = { "casa", "arbol", "silla", "mesa", "flor" };

    int numAleatorio = (int) (Math.random() * listaPalabras.length);

    pistaPalabra(listaPalabras[numAleatorio]);

  }

  public static void pistaPalabra(String palabra) {
    for (int i = 0; i < palabra.length(); i++) {
      System.out.print("_ ");
    }
    System.out.println();
  }

  // public static boolean letraExiste(String palabra){

  // }
}
