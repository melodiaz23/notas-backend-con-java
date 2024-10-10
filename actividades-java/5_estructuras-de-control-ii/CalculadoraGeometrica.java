public class CalculadoraGeometrica {
  public void medidasCirculo(int opcion, double medida) {
    switch (opcion) {
      case 1 -> {
        double area = Math.PI * (medida * medida);
        System.out.println("El área es: " + area);
      }
      case 2 -> {
        double perimetro = 2 * medida * Math.PI;
        System.out.println("El perimetro es: " + perimetro);
      }
      default -> System.out.println("Opción inválida");
    }
  }

  public void medidasRectangulo(int opcion, int base, int altura) {
    switch (opcion) {
      case 1 -> {
        double area = base * altura;
        System.out.println("El área es: " + area);
      }
      case 2 -> {
        double perimetro = (2 * base) + (2 * altura);
        System.out.println("El perimetro es: " + perimetro);
      }
      default -> System.out.println("Opción inválida");
    }

  }
}
