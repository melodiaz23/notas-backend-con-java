public class Figuras {
  public void mostrarOpciones() {
    System.out.println("------------");
    System.out.println("Ingresa un número de acuerdo a las siguientes opciones");
    System.out.println("1- Circulo");
    System.out.println("2- Cuadrado");
    System.out.println("3- Triangulo");
    System.out.println("------------");
  }

  public void realizarCalculo(int opcion, float medida, float... altura) {
    switch (opcion) {
      case 1 -> {
        float area = (float) (Math.PI * (medida * medida));
        System.out.println("El área del círculo es: " + area);
      }
      case 2 -> {
        float area = medida * medida;
        System.out.println("El área del cuadrado es: " + area);
      }
      case 3 -> {
        float area = (medida * altura[0]) / 2;
        System.out.println("El área del tríangulo es: " + area);

      }
      default -> System.out.println("Opción seleccionada no es válida");
    }
  }
}
