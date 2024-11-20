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

  public static Equipo[] eliminarEquipo(Equipo[] equipos, int index) {
    Equipo[] temp = new Equipo[equipos.length - 1];
    for (int i = 0; i < equipos.length; i++) {
      if (index == i)
        continue;
      temp[i] = equipos[i];
    }
    return temp;
  }
}
