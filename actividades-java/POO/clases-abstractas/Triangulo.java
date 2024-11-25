public class Triangulo extends Figura implements Dibujable {
  private int base;
  private int lado1;
  private int lado2;

  public Triangulo(int base, int lado1, int lado2) {
    this.base = base;
    this.lado1 = lado1;
    this.lado2 = lado2;
  }

  public int getBase() {
    return base;
  }

  public int getLado1() {
    return lado1;
  }

  public void setLado1(int lado1) {
    this.lado1 = lado1;
  }

  public int getLado2() {
    return lado2;
  }

  public void setLado2(int lado2) {
    this.lado2 = lado2;
  }

  public void setBase(int base) {
    this.base = base;
  }

  @Override
  public double calcularArea() {
    double semiPerimetro = (lado1 + lado2 + base) / 2;
    return Math.sqrt(semiPerimetro * (semiPerimetro - lado1) * (semiPerimetro - lado2) * (semiPerimetro - base));
  }

  @Override
  public double calcularPerimetro() {
    return lado1 + lado2 + base;
  }

  @Override
  public void dibujar() {
    System.out.println("La figura es un tríangulo");
  }

}
