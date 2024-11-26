
public class Circulo {
  private Integer radio;

  public static int contadorCirculo = 0;

  public Circulo() {
    contadorCirculo++;
  }

  public Circulo(Integer radio) {
    this.radio = radio;
    contadorCirculo++;
  }

  public Double area() {
    return Math.PI * Math.pow(radio, 2);
  }

  public Double perimetro() {
    return 2 * Math.PI * radio;
  }

  public Integer getRadio() {
    return radio;
  }

  public void setRadio(Integer radio) {
    this.radio = radio;
  }

  public void imprimirArea() {
    System.out.println("El area es de: " + this.area());
  }

  public void imprimirPerimetro() {
    System.out.println("El Perimetro es de: " + this.perimetro());
  }

  public static int numTotal() {
    return contadorCirculo;
  }
}
