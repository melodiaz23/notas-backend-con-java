public class App {
  public static void main(String[] args) {
    System.out.println("\033\143");
    DiaSemana[] diasSemanas = DiaSemana.values();
    DiaSemana[] diasAAlmacenar = new DiaSemana[10];

    for (int i = 0; i < diasAAlmacenar.length; i++) {
      int randomNumber = (int) (Math.random() * 7); // Genera numero del 1-7
      diasAAlmacenar[i] = diasSemanas[randomNumber];
    }

    for (DiaSemana dia : diasAAlmacenar) {
      System.out.println("El día " + dia.name() + " es " + imprimirDiaLaboral(dia));
    }
  }

  public static String imprimirDiaLaboral(DiaSemana diaSemana) {
    boolean esLaboral = DiaSemanaClass.esDiaLaboral(diaSemana);
    return esLaboral ? "Dia laboral" : "No es dia laboral";
  }

}