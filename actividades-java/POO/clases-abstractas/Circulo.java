public class Circulo extends Figura implements Dibujable {
  private int radio;

  public Circulo(int radio) {
    this.radio = radio;
  }

  public int getRadio() {
    return radio;
  }

  public void setRadio(int radio) {
    this.radio = radio;
  }

  @Override
  public double calcularArea() {
    return Math.PI * radio * radio;
  }

  @Override
  public double calcularPerimetro() {
    return 2 * Math.PI * radio;
  }

  @Override
  public void dibujar() {
    System.out.println("La figura es un círculo");
  }

}
