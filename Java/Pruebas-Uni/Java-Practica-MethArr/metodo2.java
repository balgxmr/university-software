/*
 * 2. Debe crear un Método externo que solicite 5 números en un arreglo.
 * El método debe devolver el promedio de estos números a una variable
 * que se imprime en el MAIN principal. Imprimir el resultado a pantalla.
 */

public class metodo2 {
  public int Promedio(int[] valores) {
    int promedio = 0;
    for (int i = 0; i < 5; i++)
      promedio = promedio + valores[i];
    promedio = promedio / 5;
    return promedio;
  } // fin Promedio
} // fin class
