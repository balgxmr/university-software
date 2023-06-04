/*
Escriba un algoritmo que permita leer N cantidad de estaturas de un grupo de
personas. Se requiere que el algoritmo imprima el promedio de todas las
estaturas. Además de la estatura más alta y más baja. Las iteraciones deben ser
controladas por el usuario, no se permite preguntar la cantidad de iteraciones
al inicio. Solamente podrá utilizar la estructura while.
*/

#include <stdio.h>
// Declaración de variables
float estatura, prom, max, min, z;
int cont;

// Bloque de instrucciones
int main() {
  printf("Introduzca la primera estatura: ");
  scanf("%f", &estatura);
  cont = 0;
  z = estatura;
  max = estatura;
  min = estatura;
  while (estatura != 0) {
    printf("Introduzca la siguiente estatura o introduzca 0 para finalizar: ");
    scanf("%f", &estatura);
    if (estatura > max) {
      max = estatura;
    } else if (estatura < min && estatura > 0) {
      min = estatura;
    }
    z = estatura + z;
    cont = cont + 1;
  }
  prom = z / cont;
  printf("Su estatura promedio es: %.2f \n", prom);
  printf("La altura máxima es de: %.2f \n", max);
  printf("La altura mínima es de: %.2f \n", min);
}
