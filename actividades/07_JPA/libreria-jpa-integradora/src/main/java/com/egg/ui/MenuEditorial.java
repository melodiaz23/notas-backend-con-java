package com.egg.ui;
import com.egg.entidades.Editorial;
import com.egg.servicios.EditorialServicio;
import java.util.List;
import java.util.Scanner;

public class MenuEditorial {
  public static void mostrarMenu(Scanner scanner) throws Exception {
    int opcion;
    try (EditorialServicio editorialServicio = new EditorialServicio()) {
      do {
        System.out.println("""
            ----------------------
            === Menú Editoriales ===
            ----------------------
            1. Adicionar Editorial
            2. Actualizar Editorial
            3. Buscar Editorial por ID
            4. Listar Todas las Editoriales
            5. Volver al Menú Principal""");
        System.out.print("Seleccione una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine();  // Limpia el buffer
        switch (opcion) {
          case 1 -> {
            // Adicionar Editorial
            System.out.print("Ingrese el nombre de la editorial: ");
            String nombre = scanner.nextLine();
            Editorial editorial = new Editorial();
            editorial.setNombre(nombre);
            editorialServicio.adicionarEditorial(editorial);
          }
          case 2 -> {
            // Actualizar Editorial
            System.out.print("Ingrese el ID de la editorial a actualizar: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Editorial editorial = editorialServicio.buscarEditorial(id);
            if (editorial != null) {
              System.out.print("Ingrese el nuevo nombre de la editorial: ");
              String nombre = scanner.nextLine();
              editorial.setNombre(nombre);
              editorialServicio.actualizarEditorial(editorial);
              System.out.println("Editorial actualizada exitosamente.");
            } else {
              System.out.println("Editorial no encontrada.");
            }
          }
          case 3 -> {
            // Buscar editorial por ID
            System.out.print("Ingrese el ID de la editorial a buscar: ");
            int id = scanner.nextInt();
            Editorial editorial = editorialServicio.buscarEditorial(id);
            if (editorial != null) {
              System.out.println("Editorial encontrada: " + editorial.getNombre());
            } else {
              System.out.println("Editorial no encontrada.");
            }
          }
          case 4 -> {
            // Listar todas las editoriales
            List<Editorial> editoriales = editorialServicio.listarTodasLosEditoriales();
            if (!editoriales.isEmpty()) {
              System.out.println("Lista de todas las editoriales:");
              for (Editorial editorial : editoriales) {
                System.out.println(editorial.getNombre());
              }
            } else {
              System.out.println("No hay editoriales registradas.");
            }
          }
          case 5 -> System.out.println("Volviendo al menú principal...");
          default -> System.out.println("Opción no válida.");
        }
      } while (opcion != 5);
    }
  }
}