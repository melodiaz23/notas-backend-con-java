import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;


class GestionDeNumeroTest {

  @ParameterizedTest
 @CsvFileSource(resources = "/csv/numeros-aleatorios.csv", numLinesToSkip = 1)
  void testNumeroAleatorio(int numMin, int numMax) {
    Integer resultado = GestionDeNumero.numeroAleatorio(numMin, numMax);
//    if(resultado == null) {return;}
    Assertions.assertTrue(
        numMin < numMax && (resultado >= numMin && resultado <= numMax),
        "Número aleatorio: " + resultado  + " no está entre el rango especificado :( \n"
    );
  }

  @ParameterizedTest
  @CsvSource({"23, 32, 'El número aleatorio es menor'", "53, 20, 'El número aleatorio es mayor'", "44, 44, 'Has acertado! :D'"})
  void testEncontrarNumero(int numAleatorio, int numAdivinado, String respuesta) {
    String resultado = GestionDeNumero.encontrarNumero(numAleatorio, numAdivinado);
//    String[] respuestasEsperadas = {"El número aleatorio es menor", "El número aleatorio es mayor", "Has acertado :D"};
    Assertions.assertEquals(respuesta, resultado);
//    Assertions.assertEquals(numAdivinado, numAletorio);
  }
}