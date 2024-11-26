public class Actividad {
  public static void main(String[] args) {
    System.out.println("\033\143");
    Animal[] animales = { new Perro("Beagle", "Luna", 2), new Gato("Cata", 4, "Siames") };

    for (Animal animal : animales) {
      animal.comer();
      animal.dormir();

      if (animal instanceof Perro p) {
        p.ladrar();
      }
      if (animal instanceof Gato g) {
        g.maullar();
      }
    }

  }
}
