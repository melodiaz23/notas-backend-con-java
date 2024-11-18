public class Auto {
  String marca, modelo;
  Integer year; // Integer could be null

  public Auto(String marca, String modelo, int year) {
    this.marca = marca;
    this.modelo = modelo;
    this.year = year;
  }

  public Auto(String marca, String modelo) {
    this.marca = marca;
    this.modelo = modelo;
  }

  public Auto(String marca) {
    this.marca = marca;
  }

  public Auto() {
    this("No disponible", "No disponible", 0);
  }

  public void imprimirDatos() {
    if (this.marca == null && this.modelo == null && this.year == null) {
      System.out.println("Información del vehículo no disponible");
    } else {
      if (this.marca != null) {
        System.out.println("Marca: " + this.marca);
      }
      if (this.modelo != null) {
        System.out.println("Modelo: " + this.modelo);
      }
      if (this.year != null) {
        System.out.println("Año: " + this.year);
      }
    }
  }
}
