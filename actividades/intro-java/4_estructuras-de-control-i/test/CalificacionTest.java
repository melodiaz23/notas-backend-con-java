import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalificacionTest {
  @ParameterizedTest
  @CsvSource({"90, 'A'", "85, 'B'", "75, 'C'", "65, 'D'", "35, 'F'", "110, 'Número ingresado está fuera del rango válido'"})
  void testMostrarCalificacion(int num, String valorEsperado) {
    Calificacion calificacion = new Calificacion();
    String resultado = calificacion.mostrarCalificacion(num);
    Assertions.assertEquals(valorEsperado, resultado);
  }
}