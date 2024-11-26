public class Gato extends Animal {
  private String razaGato;

  public Gato(String nombre, int edad, String raza) {
    super();
    this.nombre = nombre;
    this.edad = edad;
    this.razaGato = raza;

  }

  public String getRazaGato() {
    return razaGato;
  }

  public void setRazaGato(String razaGato) {
    this.razaGato = razaGato;
  }

  public void maullar() {
    System.out.println("Miau");
  }

  @Override
  public void comer() {
    System.out.println("El gato está comiendo sus whiskas");
  }

  @Override
  public void dormir() {
    System.out.println("El gato está durmiendo encima del sofá");
  }

}
