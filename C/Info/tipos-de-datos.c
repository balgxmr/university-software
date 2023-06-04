// Tipos de datos

#include <stdio.h>

int main() {
  char a = 'e'; // tamaño = 1 byte ; Rango: 0...255 // El elemento "e" se está
                // almacenando dentro de la variable "a" que es de tipo
                // char/caracter.
  printf("El elemento es: %c\n", a); // %c para char

  short b = -15;                     // tamaño = 2 bytes; Rango: -128...127
  printf("El elemento es: %i\n", b); // %i para short

  int c = 1024;                      // tamaño = 2 bytes; Rango: -32768...32767
  printf("El elemento es: %i\n", c); // %i para int

  unsigned int d = 128;              // tamaño = 2 bytes; Rango: 0...65535
  printf("El elemento es: %i\n", d); // %i para unsigned int

  long e = 123456; // tamaño = 4 bytes; Rango: -2147483648...2147483647
  printf("El elemento es: %li\n", e); // %li (long int) para long

  float f = 15.537; // tamaño = 4 bytes; Rango: 3.4*(10 ).. 3.4*(10 )
  printf("El elemento es: %.2f\n", f); //%lf para float

  double g = 1204912.412512; // tamaño = 8 bytes; Rango: 1.7*10 a 1.7*10
  printf("El elemento es: %lf",
         g); // %lf para double g (long float) // Si se pone %.lf se eliminarían
             // todos los decimales y pasaría a ser de flotante a numero entero.
  return 0;
}