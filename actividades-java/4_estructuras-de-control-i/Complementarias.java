public class Complementarias {
  final String SECRET = "micontraseña";

  public void reviewPassword(String password) {
    if (password.equals(SECRET)) {
      System.out.println("Acceso CONCEDIDO");
    } else {
      System.out.println("Acceso DENEGADO");
    }
  }

  public void calcularDescuento(int price) {
    if (price >= 100) {
      price *= 0.90;
    }
    System.out.println("El valor a pagar es: " + price);

  }

  public void determinarCategoria(int edad) {
    if (edad < 18) {
      System.out.println("Eres menor de edad");
    } else if (edad >= 18 && edad <= 64) {
      System.out.println("Eres adulto");
    } else {
      System.out.println("Eres un adulto mayor");
    }
  }

}
