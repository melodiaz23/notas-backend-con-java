import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


class MainTest {

  @ParameterizedTest
  @CsvFileSource(resources = "/csv/numeros-factoriales.csv", numLinesToSkip = 1)
  void testCalculoFactorial(int num, int factorialEsperado) {
    int resultado = Main.calculoFactorial(num);
    Assertions.assertEquals(factorialEsperado, resultado, "Factorial debe ser " + factorialEsperado);
  }
}