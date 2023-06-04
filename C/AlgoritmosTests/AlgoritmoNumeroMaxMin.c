#include <stdio.h>
int main() {
  // Declaración de variables
  float a, b, c, max, min;

  // Bloque de instrucciones
  printf("Introduzca su primer numero: \n");
  scanf("%f", &a);
  printf("Introduzca su segundo numero: \n");
  scanf("%f", &b);
  printf("Introduzca su tercer numero: \n");
  scanf("%f", &c);
  if (a > b) {
    if (a > c) {
      max = a;
    } else {
      max = c;
    }
  } else {
    if (b > c) {
      max = b;
    } else {
      max = c;
    }
  }
  if (a < b) {
    if (a < c) {
      min = a;
    } else {
      min = c;
    }
  } else {
    if (b < c) {
      min = b;
    } else {
      min = c;
    }
  }
  printf(
      "El número maximo ingresado es: %f y el valor mínimo ingresado es: %f.",
      max, min);
}