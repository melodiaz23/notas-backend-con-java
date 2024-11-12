public class Menu {
  public void mostrarMenu() {
    System.out.println("------------");
    System.out.println("Ingresa un número de acuerdo a las siguientes opciones");
    System.out.println("1- Guardar");
    System.out.println("2- Cargar");
    System.out.println("3- Salir");
    System.out.println("------------");
  }

  public void selecionarMenu(int opcion) {
    switch (opcion) {
      case 1 -> System.out.println("Opción de menú GUARDAR, seleccionada.");
      case 2 -> System.out.println("Opción de menú CARGAR seleccionada.");
      case 3 -> System.out.println("Opción SALIR seleccionada.");
      default -> System.out.println("Opción seleccionada NO es válida.");
    }
  }
}
