package CuentaBancaria;

import java.util.Scanner;

public class CuentasBancarias {
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    CuentaBancaria cuentaBancaria = new CuentaBancaria();

    try {
      System.out.println("Buenas. Cuanto saldo desea retirar? ");
      Integer res = scanner.nextInt();
      cuentaBancaria.retirar(res);
    } catch (SaldoInsuficienteException e) {
      System.out.println("ERROR: " + e.getMessage());
    } finally {
      scanner.close();
    }
  }
}