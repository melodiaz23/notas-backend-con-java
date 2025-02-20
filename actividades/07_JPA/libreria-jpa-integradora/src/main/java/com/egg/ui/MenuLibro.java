package com.egg.ui;
import com.egg.entidades.Autor;
import com.egg.entidades.Libro;
import com.egg.servicios.AutorServicio;
import com.egg.servicios.EditorialServicio;
import com.egg.servicios.LibroServicio;

import java.util.List;
import java.util.Scanner;

public class MenuLibro {
  public static void mostrarMenu(Scanner scanner) throws Exception {
    int opcion;
    try (LibroServicio libroServicio = new LibroServicio()) {
      do {
        System.out.println("""
              ----------------------
              === Menú Libro ===
              ----------------------
              1. Registrar Libro
              2. Actualizar Libro
              3. Buscar Libro por ISBN
              4. Buscar Libro por Título
              5. Eliminar Libro
              6. Listar Todos los Libros
              7. Volver al Menú Principal""");
        System.out.print("Seleccione una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine();  // Limpia el buffer
        switch (opcion) {
          case 1 -> {
            // Registrar Libro
            Libro libro = new Libro();
            System.out.print("Ingrese el ISBN del libro: ");
            Long isbn = scanner.nextLong();
            libro.setIsbn(isbn);
            scanner.nextLine();
            System.out.print("Ingrese el título del libro: ");
            String titulo = scanner.nextLine();
            libro.setTitulo(titulo);
            System.out.print("Ingrese el año del libro: ");
            int anio = scanner.nextInt();
            libro.setAnio(anio);
            System.out.print("Ingrese el número de ejemplares: ");
            int ejemplares = scanner.nextInt();
            libro.setEjemplares(ejemplares);
            try (AutorServicio autor = new AutorServicio()) {
              System.out.println("Listado de autores existentes");
              for (Autor a : autor.listarTodosLosAutores()) {
                System.out.println(a.getNombre() + " | ID: " + a.getId());
              }
              System.out.print("Ingrese el ID del autor (Marque 0 sí el autor no existe y desea crearlo): ");
              int idAutor = scanner.nextInt();
              scanner.nextLine();
              if (idAutor == 0) {
                Autor nuevoAutor = new Autor();
                System.out.println("Indique el nombre del autor: ");
                nuevoAutor.setNombre(scanner.nextLine());
                autor.adicionarAutor(nuevoAutor);
                idAutor = autor.buscarAutorPorNombre(nuevoAutor.getNombre()).getFirst().getId();
              }
              libro.setAutor(autor.buscarAutor(idAutor));
            }
            System.out.print("Ingrese el ID de la editorial: ");
            try (EditorialServicio editorial = new EditorialServicio()) {
              int idEditorial = scanner.nextInt();
              libro.setEditorial(editorial.buscarEditorial(idEditorial));
            }
            libroServicio.registrarLibro(libro);
          }
          case 2 -> {
            // Actualizar Libro
            System.out.print("Ingrese el ISBN del libro a actualizar: ");
            Long isbn = scanner.nextLong();
            scanner.nextLine();
            Libro libro = libroServicio.obtenerLibroPorIsbn(isbn);
            if (libro != null) {
              System.out.print("Ingrese el nuevo título del libro: ");
              String titulo = scanner.nextLine();
              libro.setTitulo(titulo);
              libroServicio.actualizarLibro(libro);
              System.out.println("Libro actualizado exitosamente.");
            } else {
              System.out.println("Libro no encontrado.");
            }
          }
          case 3 -> {
            // Buscar libro por ISBN
            System.out.print("Ingrese el ISBN del libro a buscar: ");
            Long isbn = scanner.nextLong();
            Libro libro = libroServicio.obtenerLibroPorIsbn(isbn);
            if (libro != null) {
              System.out.println("Libro encontrado: " + libro.getTitulo());
            } else {
              System.out.println("Libro no encontrado.");
            }
          }
          case 4 -> {
            // Buscar libro por título
            System.out.print("Ingrese el título del libro a buscar: ");
            String titulo = scanner.nextLine();
            Libro libro = libroServicio.buscarLibrosPorTitulo(titulo);
            if (libro != null) {
              System.out.println("Libro encontrado: " + libro.getTitulo());
            } else {
              System.out.println("Libro no encontrado.");
            }
          }
          case 5 -> {
            // Dar de baja libro
            System.out.print("Ingrese el ISBN del libro a dar de baja: ");
            Long isbn = scanner.nextLong();
            libroServicio.darBajaLibro(isbn);
          }
          case 6 -> {
            // Listar todos los libros
            List<Libro> libros = libroServicio.listarLibros();
            if (!libros.isEmpty()) {
              System.out.println("Lista de todos los libros:");
              for (Libro libro : libros) {
                System.out.println(libro.getTitulo() + " | " + libro.getAlta());
              }
            } else {
              System.out.println("No hay libros registrados.");
            }
          }
          case 7 -> System.out.println("Volviendo al menú principal...");
          default -> System.out.println("Opción no válida.");
        }
      } while (opcion != 7);
    }
  }
}
