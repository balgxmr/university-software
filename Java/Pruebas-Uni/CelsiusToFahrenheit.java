import java.io.*;

public class CelsiusToFahrenheit {
  public static void main(String[] args) throws IOException {

    BufferedReader lectura =
        new BufferedReader(new InputStreamReader(System.in));

    boolean loop = true;

    while (loop == true) {
      try {
        // Ingresar valor en C
        System.out.println("Ingrese el primer numero en grados Celsius: ");
        double celsius = Double.parseDouble(lectura.readLine());

        // conversion
        double fahrenheit = celsius * 9 / 5 + 32;

        // Impresion
        System.out.println("Su valor en grados Fahrenheit es de: " +
                           fahrenheit);

        loop = false;
      } catch (Exception e) {
        System.out.println(
            "\n\n*Error*\nIngrese un valor en numeros no en letras \n");
      }
    }
  }
}
