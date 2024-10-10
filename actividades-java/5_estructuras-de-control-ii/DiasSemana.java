
public class DiasSemana {

  public void SolicitarDias() {
    System.out.println("------------");
    System.out.println("De acuerdo a los días de la semana:");
    System.out.println("1- Lunes");
    System.out.println("2- Martes");
    System.out.println("3- Miercoles");
    System.out.println("4- Jueves");
    System.out.println("5- Viernes");
    System.out.println("6- Sábado");
    System.out.println("7- Domingo");
    System.out.println("------------");
    System.out.print("Indica un número de acuerdo al día que quieres selecionar: ");

  }

  public void mostrarDia(int dia) {
    switch (dia) {
      case 1:
        System.out.println("Lunes");
        break;
      case 2:
        System.out.println("Martes");
        break;
      case 3:
        System.out.println("Miercoles");
        break;
      case 4:
        System.out.println("Jueves");
        break;
      case 5:
        System.out.println("Viernes");
        break;
      case 6:
        System.out.println("Sábado");
        break;
      case 7:
        System.out.println("Domingo");
        break;
      default:
        System.out.println("Número indicado no es un día válido");
    }
  }

}
