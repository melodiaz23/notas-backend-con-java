public class Triangulo {
  private Integer base;
  private Integer altura;

  public static int contadorTriangulo = 0;

  public Triangulo() {
    contadorTriangulo++;
  }

  public Triangulo(Integer base, Integer altura) {
    this.base = base;
    this.altura = altura;
    contadorTriangulo++;
  }

  public Double area() {
    return (double) (base * altura) / 2;
  }

  public Integer getBase() {
    return base;
  }

  public void setBase(Integer base) {
    this.base = base;
  }

  public Integer getAltura() {
    return altura;
  }

  public void setAltura(Integer altura) {
    this.altura = altura;
  }

  public void imprimirDatos() {
    System.out.println("La base es: " + this.base);
    System.out.println("La altura es: " + this.altura);
    System.out.println("El area es de: " + this.area());
  }

  public static int numTotal() {
    return contadorTriangulo;
  }
}
