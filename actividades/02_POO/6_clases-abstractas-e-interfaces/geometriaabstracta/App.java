package geometriaabstracta;

public class App {
  public static void main(String[] args) {
    System.out.println("\033\143");
    Circulo circulo = new Circulo(5);
    Rectangulo rectangulo = new Rectangulo(3, 7);
    Triangulo triangulo = new Triangulo(4, 5, 5);

    circulo.dibujar();
    System.out.printf("El área es: %.2f y el perímetro es: %.2f \n", circulo.calcularArea(),
        circulo.calcularPerimetro());

    rectangulo.dibujar();
    System.out.printf("El área es: %.2f y el perímetro es: %.2f \n", rectangulo.calcularArea(),
        rectangulo.calcularPerimetro());

    triangulo.dibujar();
    System.out.printf("El área es: %.2f y el perímetro es: %.2f \n", triangulo.calcularArea(),
        triangulo.calcularPerimetro());

  }
}