package modelo;

import java.util.Arrays;

import static modelo.Jugador.jugadores;

public class Equipo {
  private String nombre;

  public Equipo(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public static Equipo[] equipos = new Equipo[4];

  public static void listarEquipo() {
    for (int i = 0; i < equipos.length; i++) {
      System.out.println((i+1) + "- " + equipos[i].getNombre());
    }
  }

  public static Jugador[] listarJugadoresEquipo(Equipo equipoSeleccionado){
    Jugador[] jugadoresEquipo = new Jugador[0];
    for (Jugador jugador : jugadores) {
      if (jugador.getEquipo().getNombre() != null &&
              jugador.getEquipo().getNombre().equalsIgnoreCase(equipoSeleccionado.getNombre())) {
        jugadoresEquipo = Arrays.copyOf(jugadoresEquipo, jugadoresEquipo.length + 1);

        jugadoresEquipo[jugadoresEquipo.length - 1] = jugador;
      }
    }
    return jugadoresEquipo;
  }

  public static void eliminarEquipo(int index) {
    Equipo[] temp = new Equipo[equipos.length - 1];
    int conteo = 0;
    for (int i = 0; i < equipos.length; i++) {
      if (index == i) {
        System.out.println("Has eliminado un equipo");
      } else {
      temp[conteo] = equipos[i];
      conteo++;
      }

    }
   equipos = Arrays.copyOf(temp, temp.length);
  }
}
