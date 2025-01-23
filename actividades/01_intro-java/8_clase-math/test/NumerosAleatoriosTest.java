import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import src.NumerosAleatorios;

import static org.junit.jupiter.api.Assertions.assertTrue;

class NumerosAleatoriosTest {

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5})
  void testIniciarActividad() {
    int resultado = NumerosAleatorios.iniciarActividad();
    Assertions.assertTrue(resultado>=1 && resultado <=355, "Numero entre 1 y 355");
  }
}
