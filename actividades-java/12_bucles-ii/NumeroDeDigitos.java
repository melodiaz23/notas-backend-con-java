public class NumeroDeDigitos {
  public void calcularDigitos() {
    int num = 4578;
    int conteo = 0;

    if (num == 0) {
      conteo = 1;
    } else {
      while (Math.abs(num) > 0) {
        num /= 10;
        conteo++;
        System.out.println(num);
      }
    }

    System.out.printf("El número tiene %d dígitos \n", conteo);
  }
}
