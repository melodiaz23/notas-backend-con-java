public class Debugger {
  public static void main(String[] args) {
    int numero;
    int suma = 0;
    int[] numeros = new int[10];
    for (int i = 0; i < numeros.length; i++) {
      numeros[i] = (int) (1 + Math.random() * 100);
      numero = numeros[i];
      System.out.print(numero + " ");
      suma += numeros[i];
    }
    System.out.println(suma);
  }
}