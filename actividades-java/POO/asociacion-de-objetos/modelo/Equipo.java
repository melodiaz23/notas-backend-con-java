package modelo;

public class Equipo {
  public String nombre;

  public Equipo(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public static void listarEquipo(Equipo[] equipos) {
    for (int i = 0; i < equipos.length; i++) {
      System.out.println(i + 1 + "-" + equipos[i].getNombre());
    }
  }
}
