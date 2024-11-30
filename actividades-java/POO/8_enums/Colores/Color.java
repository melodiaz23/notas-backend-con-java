package Colores;

public enum Color {
  ROJO("#FF0000"), AMARILLO("#FFFF00"), AZUL("#0000FF");

  private String valorHexadecimal;

  private Color(String valorHexadecimal) {
    this.valorHexadecimal = valorHexadecimal;
  }

  public String getValorHexadecimal() {
    return valorHexadecimal;
  }

}
