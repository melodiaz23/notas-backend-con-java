package modelo;

public class Jugador {
  private String nombre;
  private Equipo equipo;

  public Jugador(String nombre, Equipo equipo) {
    this.nombre = nombre;
    this.equipo = equipo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Equipo getEquipo() {
    return equipo;
  }

  public void setEquipo(Equipo equipo) {
    this.equipo = equipo; // ??
  }

  public static void listarJugadores(Jugador[] jugadores) {
    for (int i = 0; i < jugadores.length; i++) {
      System.out.println(i + 1 + "- " + jugadores[i].getNombre()
          + " | " + (jugadores[i].getEquipo() != null ? jugadores[i].getEquipo().getNombre() : "--"));
    }
  }

  public static Jugador[] eliminarJugadores(Jugador[] jugadores, int index) {
    Jugador[] temp = new Jugador[jugadores.length - 1];
    for (int i = 0; i < jugadores.length; i++) {
      if (index == i)
        continue;
      temp[i] = jugadores[i];
    }
    return temp;
  }

}
