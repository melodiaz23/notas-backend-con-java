package com.egg.ui;
import com.egg.entidades.Autor;
import com.egg.servicios.AutorServicio;
import java.util.List;
import java.util.Scanner;

public class MenuAutor {
  public static void mostrarMenu(Scanner scanner) throws Exception {
      int opcion;
      AutorServicio autorServicio = new AutorServicio();
      do {
        System.out.println("""
            ----------------------
            === Menú Autores ===
            ----------------------
            1. Adicionar Autor
            2. Actualizar Autor
            3. Buscar Autor por ID
            4. Buscar Autor por Nombre
            5. Eliminar Autor
            6. Listar Todos los Autores
            7. Volver al Menú Principal""");
        System.out.print("Seleccione una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine();  // Limpia el buffer
        switch (opcion) {
          case 1 -> {
            // Adicionar Autor
            System.out.print("Ingrese el nombre del autor: ");
            String nombre = scanner.nextLine();
            Autor autor = new Autor();
            autor.setNombre(nombre);
            autorServicio.adicionarAutor(autor);
            System.out.println("Autor adicionado exitosamente.");
          }
          case 2 -> {
            // Actualizar Autor
            System.out.print("Ingrese el ID del autor a actualizar: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Autor autor = autorServicio.buscarAutor(id);
            if (autor != null) {
              System.out.print("Ingrese el nuevo nombre del autor: ");
              String nombre = scanner.nextLine();
              autor.setNombre(nombre);
              autorServicio.actualizarAutor(autor);
              System.out.println("Autor actualizado exitosamente.");
            } else {
              System.out.println("Autor no encontrado.");
            }
          }
          case 3 -> {
            System.out.print("Ingrese el ID del autor a buscar: ");
            int id = scanner.nextInt();
            Autor autor = autorServicio.buscarAutor(id);
            if (autor != null) {
              System.out.println("Autor encontrado: " + autor.getNombre());
            } else {
              System.out.println("Autor no encontrado.");
            }
          }
          case 4 -> {
            System.out.print("Ingrese el nombre del autor a buscar: ");
            String nombre = scanner.nextLine();
            List<Autor> autores = autorServicio.buscarAutorPorNombre(nombre);
            if (!autores.isEmpty()) {
              System.out.println("Autores encontrados:");
              for (Autor autor : autores) {
                System.out.println(autor.getNombre());
              }
            } else {
              System.out.println("No se encontraron autores.");
            }
          }
          case 5 -> {
            List<Autor> autores = autorServicio.listarTodosLosAutores();
            if (!autores.isEmpty()) {
              System.out.println("Lista de todos los autores:");
              for (Autor autor : autores) {
                System.out.println(autor.getNombre());
              }
            } else {
              System.out.println("No hay autores registrados.");
            }
          }
          case 6 -> System.out.println("Volviendo al menú principal...");
          case 7 -> System.out.println("Volviendo al menú principal...");
          default -> System.out.println("Opción no válida.");
        }
      } while (opcion != 6);
    }
  }

