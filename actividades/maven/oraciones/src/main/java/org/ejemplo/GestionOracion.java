package org.ejemplo;

import java.util.Arrays;
import java.util.Scanner;

public class GestionOracion {
  private String oracion;

  public GestionOracion(String oracion) {
    this.oracion = oracion;
  }

  public String getOracion() {
    return oracion;
  }

  public void setOracion(String oracion) {
    this.oracion = oracion;
  }

  public int cantidadCaracteres(){
    return oracion.length();
  }

  public int cantidadPalabras(){
    return oracion.trim().split(" ").length;
  }

  public void organizarPalabras(){
    String[] palabras = oracion.trim().split(" ");
    System.out.println("Listado de palabras: ");
    System.out.println(Arrays.toString(palabras));
    Arrays.sort(palabras);
    System.out.println("Listado organizado alfabéticamente: ");
    System.out.println(Arrays.toString(palabras));
  }

  public void encontrarPalabraEnOracion(Scanner scanner) {
    String[] palabras = oracion.split(" ");
    int pos;
    do {
      System.out.println("Indica una posición para encontrar la palabra");
      pos = scanner.nextInt();
      if (pos < 1 || pos > palabras.length) {
        System.out.println("Número inválido, intente nuevamente");
      }
    } while (pos < 1 || pos > palabras.length);

    System.out.println("La palabra es: " + palabras[pos - 1]);
  }

  public void encontrarPalabraConPalabra(Scanner scanner){
    String[] palabras = oracion.split(" ");
    System.out.println("Indica una palabra a encontrar");
    String palabra = scanner.nextLine().toUpperCase();
    boolean exist = false;
    for (int i = 0; i < palabras.length; i++) {
      if (palabra.contentEquals(palabras[i].toUpperCase())) {
        System.out.println("Palabra encontrada en la posición " + (i + 1));
        exist = true;
        break;
      }
    }
    if (!exist)
      System.out.println("Palabra no encontrada");
  }


  public void modificarPalabra(Scanner scanner) {
    String[] palabras = oracion.split(" ");
    boolean exist = false;
    int pos = 0;
    do {
      System.out.println("Indica la palabra a modificar");
      String palabraAntigua = scanner.nextLine();
      for (int i = 0; i < palabras.length; i++) {
        if (palabraAntigua.contentEquals(palabras[i])) {
          pos = i;
          exist = true;
          break;
        }
      }
      if (!exist)
        System.out.println("Palabra no existe, intenta de nuevo");
    } while (!exist);
    System.out.println("Indica la nueva palabra");
    String palabraNueva = scanner.nextLine();
    palabras[pos] = palabraNueva;
    oracion = String.join(" ", palabras); // delimiter indica lo que se coloca entre cada elemento
    System.out.println("La nueva oración es:");
    System.out.println(oracion);
  }

  public void agregarContenido(Scanner scanner){
    System.out.println("Ingresa el nuevo contenido");
    String contenido = scanner.nextLine();
    oracion += " " + contenido;
    System.out.println("La nueva frase es: ");
    System.out.println(oracion);
  }
}
