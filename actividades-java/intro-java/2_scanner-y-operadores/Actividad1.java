import java.util.Scanner;

public class Actividad1 {

  private String name;
  private int age;

  public void solicitaNombre(Scanner read) {
    System.out.println("Indica tu nombre");
    name = read.nextLine();
    System.out.println("El nombre ingresado es: " + name);
  }

  public void solicitaEdad(Scanner read) {
    System.out.println("Ingresa tú edad");
    age = read.nextInt();
    System.out.println("La edad ingresada es: " + age);
  }

  public void imprimirDatos() {
    System.out.println("Su nombre es " + name + " y su edad es " + age);
  }

}
