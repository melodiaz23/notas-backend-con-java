
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class MainTest {
  @ParameterizedTest
  @CsvFileSource(resources = "csv/numeros-primos.csv")
  void testEsPrimo(int num) {
    boolean resultado = Main.esPrimo(num);
    Assertions.assertTrue(resultado, "Número debe ser primo");
  }

  @ParameterizedTest
  @CsvFileSource(resources = "csv/numeros-no-primos.csv")
  void testNoEsPrimo(int num) {
    boolean resultado = Main.esPrimo(num);
    Assertions.assertFalse(resultado, "Número no debe ser primo");
  }

}