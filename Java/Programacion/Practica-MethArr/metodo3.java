/*
 * Queremos un método que permita guardar los nombres
 * y las edades de los alumnos de un curso. Realiza
 * un programa que introduzca el nombre y la edad de
 * cada alumno. El proceso de lectura de datos debe permitir
 * 5 estudiantes. Desde el MAIN debemos poder imprimir la
 * información de uno de los estudiantes a partir del índice
 * en el arreglo:
 *       a. Ej. Escoja el estudiante que desea conocer: 1
 *       Nombre: Paulo
 *       Edad: 15 años
 */

import java.io.*;

public class metodo3 {
  // Para el metodo 3
  String[] nombreEstudiante = new String[5];
  int[] edadEstudiante = new int[5];

  /* BufferedReader usado para leer el input */
  BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));

  public void Estudiante() {
    int h = 1;
    for (int i = 0; i < 5; i++) {
      boolean loop = true;
      while (loop) {
        try {
          System.out.printf("Ingrese el nombre del estudiante #" + h + ": ");
          nombreEstudiante[i] = lectura.readLine();
          System.out.printf("Ingrese la edad del estudiante #" + h + ": ");
          edadEstudiante[i] = Integer.parseInt(lectura.readLine());
          if (edadEstudiante[i] <= 0)
            throw new IllegalArgumentException(); // Lanzado para indicar que a
                                                  // un método se le ha pasado
                                                  // un argumento ilegal o
                                                  // inapropiado. En este caso,
                                                  // la edad debe ser > 0
          loop = false;
          h++;
        } catch (Exception e) {
          System.out.println("Valor invalido! Intente nuevamente");
        }
      } // fin while
    } // fin for
  } // fin estudiante FN

  public void imprimirEstudiante(int indice) {
    // Imprimir solo si el indice del usuario es >=1 y <=5
    if (indice >= 1 && indice <= 5) {
      String nombre = nombreEstudiante[indice - 1]; // guardar temp. nombre
      int edad = edadEstudiante[indice - 1];        // guardar temp. edad
      System.out.println("Nombre: " + nombre);
      System.out.println("Edad: " + edad + " años");
    } else {
      System.out.println("Índice inválido! IT'S ONE TO FIVE BRO");
    }
  } // fin imprimirEstudiante
} // fin class metodo3