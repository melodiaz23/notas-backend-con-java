package com.egg;
import com.egg.entidades.Autor;
import com.egg.servicios.AutorServicio;
import com.egg.ui.MenuAutor;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Exception {
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
          default -> {
          }
        }
      } while (opcion != 4);

    } catch (Exception e) {
      System.out.println("Error en menú principal: " + e);
    }
  }
}