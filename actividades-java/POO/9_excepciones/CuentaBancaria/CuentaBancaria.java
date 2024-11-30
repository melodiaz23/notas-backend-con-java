package CuentaBancaria;

public class CuentaBancaria {
  private int saldoInicial = 10000;

  public void retirar(int cantidadSolicitada) throws SaldoInsuficienteException {
    if (saldoInicial < cantidadSolicitada) {
      throw new SaldoInsuficienteException("Saldo insuficiente :(");
    } else {
      saldoInicial -= cantidadSolicitada;
      System.out.println("Transaccion realizada! Tu monto total ahora es de: " + saldoInicial);
    }
  }

  public int getSaldoInicial() {
    return saldoInicial;
  }

  public void setSaldoInicial(int saldoInicial) {
    this.saldoInicial = saldoInicial;
  }
}
