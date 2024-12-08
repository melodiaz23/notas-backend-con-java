package codigospostales;

import codigospostales.util.MenuUsuario;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    HashMap<String, String> codigosPostales = new HashMap<>();

    codigosPostales.put("110111", "Bogotá");
    codigosPostales.put("050001", "Medellín");
    codigosPostales.put("760001", "Cali");
    codigosPostales.put("470001", "Santa Marta");
    codigosPostales.put("01000", "Ciudad de México");
    codigosPostales.put("C1000", "Buenos Aires");
    codigosPostales.put("8320000", "Santiago");
    codigosPostales.put("11000", "Montevideo");
    codigosPostales.put("28001", "Madrid");
    codigosPostales.put("08001", "Barcelona");

    try (Scanner scanner = new Scanner(System.in)) {
      int opcion;
      do {
        MenuUsuario.mostrarMenu();
        opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
          case 1 -> {
            System.out.println("Ciudades registradas");
//         System.out.println(codigosPostales);
            for (String codigo : codigosPostales.keySet()) {
              System.out.println("- " + codigo + ": " + codigosPostales.get(codigo));
            }
          }
          case 2 -> {
            System.out.println("Ingresa el nombre de la ciudad: ");
            String ciudad = scanner.nextLine();
            System.out.println("Ahora ingresa el código postal: ");
            String codigo = scanner.nextLine();
            System.out.println(codigosPostales.put(codigo, ciudad) == null ? "Ciudad adicionada" : "Código postal ya existe");
          }
          case 3 -> {
            System.out.println("Indica el código postal para encontrar a qué ciudad pertenece");
            String codigo = scanner.nextLine();
            System.out.println(codigosPostales.containsKey(codigo) ? "La ciudad es " + codigosPostales.get(codigo) : "El código no está registrado");
          }
          case 4 -> {
            System.out.println("Indica el nombre de la ciudad a eliminar");
            String ciudadSeleccionada = scanner.nextLine();
            for (String codigo : codigosPostales.keySet()) {
              if (codigosPostales.get(codigo).equalsIgnoreCase(ciudadSeleccionada)) {
                System.out.println(codigosPostales.remove(codigo) != null ? "Ciudad eliminada" : "Ciudad no encontrada");
                break;
              }
            }
          }
          case 5 -> {
            System.out.println("Indica el código postal para modificar su ciudad");
            String codigoIndicado = scanner.nextLine();
            System.out.println("Indica el nombre de la nueva ciudad");
            String nuevaCiudad = scanner.nextLine();
            System.out.println(codigosPostales.replace(codigoIndicado, nuevaCiudad) != null ? "Ciudad modificada" : "Código postal no existe");
          }
          case 6 -> {
          }
          default -> System.out.println("Opción inválida");
        }
      } while (opcion != 6);


    } catch (Exception e) {
      System.out.println("Error inesperado: " + e);
    }

  }
}
