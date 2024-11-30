public class Rectangulo extends Figura implements Dibujable {
  private int ancho;
  private int altura;

  public Rectangulo(int ancho, int altura) {
    this.ancho = ancho;
    this.altura = altura;
  }

  public int getAncho() {
    return ancho;
  }

  public void setAncho(int ancho) {
    this.ancho = ancho;
  }

  public int getAltura() {
    return altura;
  }

  public void setAltura(int altura) {
    this.altura = altura;
  }

  @Override
  public double calcularArea() {
    return ancho * altura;
  }

  @Override
  public double calcularPerimetro() {
    return (2 * ancho) + (2 * altura);
  }

  @Override
  public void dibujar() {
    System.out.println("La figura es un rectángulo");
  }

}
