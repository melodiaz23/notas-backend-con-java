import java.util.Scanner;

public class Actividad2 {

  public void operacionesBasicas() {

    int num1 = 3;
    int num2 = 4;

    System.out.println("La suma de " + num1 + " y " + num2 + " es: " + (num1 + num2));
    System.out.println("La resta de " + num1 + " y " + num2 + " es: " + (num1 - num2));
    System.out.println("La multiplicación de " + num1 + " y " + num2 + " es: " + (num1 * num2));
    System.out.println("La división de " + num1 + " y " + num2 + " es: " + ((float) num1 / num2));
    System.out.println("El residuo de " + num1 + " y " + num2 + " es: " + (num1 % num2));
  }

  public void solicitarNum(Scanner read) {

    int num1;
    int num2;

    System.out.println("Ingresa 2 números");
    num1 = read.nextInt();
    num2 = read.nextInt();

    System.out.println("Los números ingresados son: " + num1 + " y " + num2);
    System.out.println("La suma de los números es: " + (num1 + num2));

  }

}
