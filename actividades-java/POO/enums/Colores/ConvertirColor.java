public class ConvertirColor {

  public static String convertirHexadecimal(String valorHexadecimal) {
    if (Color.AMARILLO.getValorHexadecimal().equalsIgnoreCase(valorHexadecimal)) {
      return Color.AMARILLO.name();
    }
    if (Color.ROJO.getValorHexadecimal().equalsIgnoreCase(valorHexadecimal)) {
      return Color.ROJO.name();
    }
    if (Color.AZUL.getValorHexadecimal().equalsIgnoreCase(valorHexadecimal)) {
      return Color.AZUL.name();
    }
    return null;
  }
}
