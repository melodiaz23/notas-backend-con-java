package com.egg;
import com.egg.ui.MenuAutor;
import com.egg.ui.MenuEditorial;
import com.egg.ui.MenuLibro;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    menu();
  }

  public static void menu() {
    try (Scanner scanner = new Scanner(System.in)) {
      int opcion;
      do {
        System.out.println("""
            ----------------------
            === Menú Principal ===
            ----------------------
            1. Gestionar Autores
            2. Gestionar Editoriales
            3. Gestionar Libros
            4. Salir""");
        System.out.print("Seleccione una opción: ");
        opcion = scanner.nextInt();
        switch (opcion) {
          case 1 -> MenuAutor.mostrarMenu(scanner);
          case 2 -> MenuEditorial.mostrarMenu(scanner);
          case 3 -> MenuLibro.mostrarMenu(scanner);
          case 4 -> System.out.println("Finalizando programa...");
          default -> System.out.println("Ingrese una opción válida.");
        }
      } while (opcion != 4);
    } catch (Exception e) {
      System.out.println("Error en menú principal: " + e);
    }
  }
}