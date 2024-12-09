public class Notas {

  public void iniciarNotas() {
    String texto = "Hola Mundo";
    // charAt(int index);
    System.out.println(texto.charAt(0)); // H

    // chars();
    System.out.println(texto.chars()); // Retorna java.util.stream.IntPipeline$Head@<hashcode>
    // Para visualizar los caracteres, se utiliza forEach para procesar el
    // IntStream, y se convirten los códigos Unicode a caracteres con (char).
    texto.chars().forEach(c -> System.out.print((char) c + " "));

    // codePointAt(int index)
    System.out.println(texto.codePointAt(0)); // Imprime 72 que es el unicode de h
  }

}
