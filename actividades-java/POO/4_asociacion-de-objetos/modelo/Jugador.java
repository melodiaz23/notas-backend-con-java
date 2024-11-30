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
    this.equipo = equipo;
  }

  public static Jugador[] jugadores = new Jugador[4];

  public static void listarJugadores() {

    for (int i = 0; i < jugadores.length; i++) {
      System.out.println(i + 1 + "- " + jugadores[i].getNombre()
          + " | " + (jugadores[i].getEquipo() != null ? jugadores[i].getEquipo().getNombre() : "--"));
    }
  }

  public static void eliminarJugadores(int index) {
    Jugador[] temp = new Jugador[jugadores.length - 1];
    int conteo = 0;
    for (int i = 0; i < jugadores.length; i++) {
      if (index == i) {
        System.out.println("Has eliminado un jugador");
      } else {
      temp[conteo] = jugadores[i];
      conteo++;
      }
    }
    jugadores = temp;
  }

  public static void refrescarJugadores(Equipo equipoABorrar){
    for (Jugador jugador : jugadores){
		    if (jugador.getEquipo().getNombre().equalsIgnoreCase(equipoABorrar.getNombre())) {
			    jugador.setEquipo(null);
		    }
    }
  }
}
