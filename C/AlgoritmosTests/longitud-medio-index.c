/*

03/may/23

Objetivo: Utilizar las funciones de cadenas definidas en un lenguaje de
programación.

Enunciado: Escriba un programa, codificado en un lenguaje de programación
específico, que dado una cadena de caracteres se obtenga lo siguiente:

    a. La longitud de la cadena S. Mostrar en la salida el siguiente texto:
    “La longitud de la cadena”, S, “es:”, L

    b. Extraer el elemento medio de la cadena S. Mostrar en la salida el
siguiente texto: “El elemento medio de la cadena “, S, “es”, c

    c. Reemplazar la letra ”a” en la cadena S por el número “7”. Mostrar la
cadena S después de la acción. Si la letra no se encuentra en la cadena imprimir
el respectivo mensaje.

*/

#include <stdio.h>
#include <string.h>

int main() {
  char s[100];
  int l;
  int c;
  int n;

  printf("Introduce una cadena de caracteres:");
  fgets(s, 100, stdin);

  // longitud de la cadena
  l = strlen(s);
  printf("La longitud de la cadena %s es: %i\n", s, l);

  // Elemento medio
  c = l / 2;
  printf("El elemento medio de la cadena %s es %c\n", s, s[c]);

  // Reemplazar las "a" -> "7"
  for (int i = 0; i < l; i++) {
    if (s[i] == 'a' || s[i] == 'A') {
      s[i] = '7';
      n = 1;
    } // if end
  }   // for end

  // Imprimir mensaje en caso de no encontrar "A", o imprimir la nueva cadena
  printf((n != 1) ? "No se ha encontrado A dentro de la cadena"
                  : "Nueva cadena: %s",
         s);
}
