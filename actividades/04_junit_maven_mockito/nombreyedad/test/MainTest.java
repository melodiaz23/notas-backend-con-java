import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class MainTest {
  private final PrintStream standarOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @AfterEach
  public void tearDown() {
    System.setOut(standarOut);
  }

  @Test
  void nombreYEdadTest() {
    Main.nombreYEdad("Melissa", 33);
    String resultado = outputStreamCaptor.toString();
    Assertions.assertEquals("Me llamo Melissa y tengo 33 años\n", resultado);

  }
}