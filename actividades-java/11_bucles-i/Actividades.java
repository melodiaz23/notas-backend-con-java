
public class Actividades {

  public void imprimirElementos() {
    int[] nums = new int[6];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = (int) (1 + Math.random() * (100));
    }
    System.out.println("Los números generados son: ");
    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i]);
    }
  }

  public void encontrarMinimo() {
    int[] nums = new int[7];
    int valorMin = Integer.MAX_VALUE;

    for (int i = 0; i < nums.length; i++) {
      nums[i] = (int) (1 + Math.random() * 100);
      System.out.print(nums[i] + " | ");
    }
    System.out.println();

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < valorMin) {
        valorMin = nums[i];
      }
    }

    System.out.println("El valor mínimo es: " + valorMin);

  }

  public void imprimirInversos() {
    int[] myArray = { 9, 25, 8, 7, 4, 63 };

    System.out.println("Los números del array son: ");
    for (int i = 0; i < myArray.length; i++) {
      System.out.print(myArray[i] + " | ");
    }
    System.out.println();
    System.out.println("Los numeros en orden inverson son: ");
    for (int i = myArray.length - 1; i >= 0; i--) {
      System.out.print(myArray[i] + " | ");
    }
    System.out.println();

  }

  public void contandoPares() {
    int[] arr = new int[10];
    int pares = 0;
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (1 + Math.random() * 100);
      System.out.print(arr[i] + " | ");
    }

    for (int num : arr) {
      if (num % 2 == 0) {
        pares++;
      }

    }
    System.out.println();
    System.out.println("De los 10 elementos, " + pares + " son pares.");
  }

  public void calculoPromedio() {
    float[] nums = new float[2];
    float suma = 0;

    for (int i = 0; i < nums.length; i++) {
      nums[i] = (float) (1 + Math.random() * 100);
      System.out.print(nums[i] + " | ");
    }

    for (float num : nums) {
      suma += num;
    }

    System.out.format("La suma de los números es: %.2f y el promedio es: %.2f ", suma, (suma / nums.length));
    System.out.println();
  }

  public void concatenarElementos() {
    // Crea un array del tamaño que prefieras que contenga elementos de tipo cadena.
    // Luego, concatena los elementos en una sola cadena, separados por espacios, e
    // imprime el resultado por consola.

    String[] arr = { "H", "O", "L", "A" };
    String cadena = "";
    for (String arr1 : arr) {
      cadena += arr1 + " ";
    }
    System.out.println(cadena);
  }
}
