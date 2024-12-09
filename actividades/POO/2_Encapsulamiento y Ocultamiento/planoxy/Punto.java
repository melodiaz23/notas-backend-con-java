package planoxy;

public class Punto {
  private int x;
  private int y;

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public double distanciaDesdeOrigen() {
	  return Math.sqrt((this.x * this.x + this.y * this.y));
  }

  public static double calcularDistancia(Punto punto1, Punto punto2) {
	  return Math
	      .sqrt(Math.pow((punto2.getX() - punto1.getX()), 2) + Math.pow((punto2.getY() - punto1.getY()), 2));
  }

  public static Boolean estanAlineados(Punto punto1, Punto punto2, Punto punto3) {
    // pendiente = y2-y1/x2-x1
    // float pendiente1 = (float) (punto2.getY() - punto1.getY() / punto2.getX() -
    // punto1.getX());
    // float pendiente2 = (float) (punto3.getY() - punto2.getY() / punto3.getX() -
    // punto2.getX());
    // Para evitar división por cero, se usa producto cruzado
    double pendiente1 = ((punto2.getY() - punto1.getY()) * (punto3.getX() - punto2.getX()));
    double pendiente2 = ((punto3.getY() - punto2.getY()) * (punto2.getX() - punto1.getX()));

    return pendiente1 == pendiente2;
  }
}
