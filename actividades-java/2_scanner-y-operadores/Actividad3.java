
import java.util.Scanner;

public class Actividad3 {

  public void solicitarNum(Scanner read) {
    int num1, num2, num3, num4;
    String comparacion;

    System.out.println("Ingresa 2 números: ");
    num1 = read.nextInt();
    num2 = read.nextInt();

    comparacion = num1 > num2 ? "mayor" : "menor";
    System.out.println("El número " + num1 + " es " + comparacion + " que " + num2);
    comparacion = num1 != num2 ? "diferente" : "igual";
    System.out.println("El número " + num1 + " es " + comparacion + " al " + num2);
    comparacion = num1 % 2 == 0 ? " es divisible" : " no es divisible";
    System.out.println("El número " + num1 + comparacion + " por 2.");

    System.out.println("Ingresa 2 nuevos números: ");
    num3 = read.nextInt();
    num4 = read.nextInt();

    System.out.print("De los números ingresados. ");
    comparacion = (num1 > num2) && (num3 > num4) ? " son mayores" : " no son mayores";
    System.out.println(
        "El número " + num1 + " y el " + num3 + comparacion + " al compararlos con los números " + num2 + " y "
            + num4 + ".");
    System.out.print("Además, ");
    comparacion = (num1 > num2) || (num3 > num4) ? " es mayor" : " es menor";
    System.out.println(
        "el número " + num1 + " o el " + num3 + comparacion + " al compararlos con los números " + num2 + " y " + num4);

  }

}
