#include <stdio.h>
int main() {
  // Declaración de constantes
  int SEG = 3600, MEDIOD = 43200;

  // Declaración de variables
  int total, hora, min;

  // Bloque de instrucciones
  printf("Introduzca la hora en formato 24H: \n");
  scanf("%i", &hora);
  printf("Introduzca los minutos: \n");
  scanf("%i", &min);
  total = (hora * SEG) + (min * 60);
  if (total < MEDIOD) {
    printf("Su hora actual en segundos es de: %i y se encuentra antes del "
           "mediodía.",
           total);
  } else if (total > MEDIOD) {
    printf("Su hora actual en segundos es de: %i y se encuentra después del "
           "mediodía.",
           total);
  } else {
    printf(
        "Su hora actual en segundos es de: %i y se encuentra en el mediodía.",
        total);
  }
}