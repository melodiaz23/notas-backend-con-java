
import java.util.InputMismatchException;
import java.util.Scanner;

public class Temperatura {
  public void iniciarActividad(Scanner scanner) {
    String unidadMedida;
    float temp, tempConvertida;
    System.out.println("----------");
    System.out.println("PROGRAMA CONVERSIÓN DE UNIDADES DE TEMPERATURA");
    System.out.println("----------");
    System.out.println("Indica unidad de medida a ingresar");

    try {
      do {
        System.out.println("C - Celsius");
        System.out.println("F - Fahrenheit");
        unidadMedida = scanner.nextLine().toUpperCase();
        if (!unidadMedida.equals("C") && !unidadMedida.equals("F")) {
          System.out.println("Unidad de medida no válida, ingrese:");
        }
      } while (!unidadMedida.equals("C") && !unidadMedida.equals("F"));

      System.out.println("Ahora ingresa la temperatura en °" + unidadMedida + ":");
      temp = scanner.nextFloat();

      tempConvertida = convertirTemp(unidadMedida, temp);

      System.out.printf(unidadMedida.equals("C")
          ? "%.0f grados Celsius equival %.1f a %.2f grados Fahrenheit.\n"
          : "%.0f grados Fahrenheit equivale a %.2f grados Celsius.\n",
          temp, tempConvertida);
      // \n inicia una nueva línea luego del mensaje

      // System.out.println(unidadMedida.equalsIgnoreCase("C")
      // ? temp + " grados Celsius equivale a " + tempConvertida + " grados
      // Fahrenheit"
      // : temp + " grados Fahrenheit equivale a " + tempConvertida + " grados
      // celcius.");

    } catch (InputMismatchException e) {
      System.out.println("El número a ingresar, deberá ser numérico: " + e.getMessage());
    } catch (Exception e) {
      System.out.println("Ocurrió un error inexperado: " + e.getMessage());
    }

  }

  private float convertirTemp(String grado, float temp) {
    float resultado = 0;
    switch (grado) {
      case "C" -> resultado = ((temp * (9f / 5f)) + 32);
      case "F" -> resultado = ((temp - 32) * (5f / 9f));
    }
    return resultado;

  }
}
