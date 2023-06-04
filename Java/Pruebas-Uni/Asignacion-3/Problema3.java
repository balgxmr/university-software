// Jonathan Nuñez 4-823-1010, Richard Herranz E-8-192057, José Encalada
// 8-999-1420

import java.io.*;

// Fibonacci
public class Problema3 {
  public static void main(String[] args) throws IOException {

    // Declaracion de variables
    int num, opera;
    boolean ciclo = true;
    int i, j = 0, z = 1;

    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    while (ciclo) {
      try {
        System.out.print("Introduza un valor numerico = ");
        num = Integer.parseInt(leer.readLine());

        if (num > 0) {
          /* Generar e imprimir la secuencia de Fibonacci */
          for (i = 0; i < num; i++) {
            System.out.println(j);
            opera = z + j;
            j = z;
            z = opera;
          }
          ciclo = false;
        } else {
          System.out.println("Por favor introduzca un numero valido");
        } // fin if-else
      } catch (Exception e) {
        System.out.println("Por favor introduzca un numero valido");
      } // fin try-catch
    }   // fin while
  }     // fin main
}