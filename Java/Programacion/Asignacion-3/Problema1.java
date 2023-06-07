// Jonathan Nuñez 4-823-1010, Richard Herranz E-8-192057, José Encalada
// 8-999-1420

import java.io.*;

public class Problema1 {
  public static void main(String[] args) throws IOException {
    // Declaracion de variables
    String entrada;
    char minusmas;

    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Ingrese un valor");
    entrada = leer.readLine();

    try {
      // Verificar que la longitud de entrada sea igual a 1
      if (entrada.length() == 1) {
        /* Extrae el primer caracter (en el index 0) de la variable entrada */
        minusmas = entrada.charAt(0);
        try {
          if (Character.isUpperCase(minusmas)) { // Verifica si es en mayuscula
            System.out.println("USTED HA INGRESADO UNA LETRA MAYUSCULA");
          } else if (Character.isLowerCase(
                         minusmas)) { // Verifica si es en minuscula
            System.out.println("USTED HA INGRESADO UNA LETRA MINUSCULA");
          } else { // Si no es letra mayuscula ni minuscula, es un numero.
            System.out.println("USTED HA INGRESADO UN NUMERO");
          }
        } catch (Exception e) {
          System.out.println("ERROR AQUI");
        }
      } else {
        System.out.println("VALOR NO RECONOCIDO");
      } // fin if-else
    } catch (Exception e) {
      System.out.println("ERROR");
    } // fin try-catch
  }   // fin main
}