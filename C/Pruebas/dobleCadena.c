/*
 * balgxmr 2023
 *
 * PROBLEM SOURCE:
 * https://frrq.cvg.utn.edu.ar/pluginfile.php/15732/mod_resource/content/0/Practica_TUP_2020.pdf
 *
 * 25- Hacer un programa que ingrese dos cadenas y:
 * Determine cuál de ellas es mayor en orden alfabético.
 * Concatene ambas cadenas.
 * Determine cuál es mas larga.
 * Invierta la primera ingresada.
 * El programa deberá mostrar todas las salidas con carteles aclaratorios
 */

#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define STRING_LENGTH 100

/* Funcion para obtener que nombre es mayor ascendentemente en el abecedario */
int obtenerMayorAlfabeto(char primerNombre[], char segundoNombre[]) {
  return (primerNombre[0] > segundoNombre[0]) ? 1 : 0;
}

/* Imprime el nombre mayor alfabeticamente por pantalla */
void imprimirNombreMayor(bool alfaVsLong, int mayor, char primerNombre[],
                         char segundoNombre[]) {
  if (alfaVsLong == true) {
    if (mayor == 0)
      printf("El nombre mayor alfabeticamente es: %s\n", primerNombre);
    else
      printf("El nombre mayor alfabeticamente es: %s\n", segundoNombre);
  } else {
    if (mayor == 0)
      printf("La cadena con mayor longitud es: %s con una longitud de: %ld\n",
             primerNombre, strlen(primerNombre));
    else if (mayor == 1)
      printf("La cadena con mayor longitud es: %s con una longitud de: %ld\n",
             segundoNombre, strlen(segundoNombre));
    else if (mayor == 2)
      printf("Los nombres son iguales en longitud.\n");
  }
}

/* Funcion para obtener cual es la cadena más larga */
int obtenerCadenaLarga(char primerNombre[], char segundoNombre[]) {
  int n = strlen(primerNombre);
  int m = strlen(segundoNombre);
  if (n == m)
    return 2;
  return (n > m) ? 0 : 1;
}

/* Funcion para invertir cualquier cadena */
void invertirCadena(char nombre[]) {
  printf("Su nombre invertido es: ");
  for (int i = strlen(nombre); i >= 0; i--)
    printf("%c", nombre[i]);
}

int main() {
  while (true) {
    /* Declaracion de variables */
    char primerNombre[STRING_LENGTH];
    char segundoNombre[STRING_LENGTH];
    bool alfaVsLong; // Gets passed into imprimirPantalla, to validate when to
                     // print the type of search we're doing

    printf("Ingresa el primer nombre: ");
    fgets(primerNombre, STRING_LENGTH, stdin);
    primerNombre[strlen(primerNombre) - 1] = '\0'; // Removes the last \n

    printf("Ingresa el primer nombre: ");
    fgets(segundoNombre, STRING_LENGTH, stdin);
    segundoNombre[strlen(segundoNombre) - 1] = '\0'; // Removes the last \n

    printf("\nNombre #1: %s\n", primerNombre);
    printf("Nombre #2: %s\n\n", segundoNombre);

    alfaVsLong = true;
    int mayor = obtenerMayorAlfabeto(primerNombre, segundoNombre);
    imprimirNombreMayor(alfaVsLong, mayor, primerNombre, segundoNombre);

    alfaVsLong = false;
    int valorCadenaLarga = obtenerCadenaLarga(primerNombre, segundoNombre);
    imprimirNombreMayor(alfaVsLong, valorCadenaLarga, primerNombre,
                        segundoNombre);

    printf("Sus nombres combinados son: %s %s\n", primerNombre, segundoNombre);

    while (true) {
      int inv = 0;
      printf("Que nombre desea invertir? 1 o 2: ");
      scanf("%i", &inv);
      getchar();
      if (inv == 1) {
        invertirCadena(primerNombre);
        break;
      } else if (inv == 2) {
        invertirCadena(segundoNombre);
        break;
      } else {
        printf("Número incorrecto! Intentalo nuevamente.\n");
      }
    }

    while (true) {
      // Ask if the user wants to continue
      int c;
      printf("\nEscribe 1 para agregar mas nombres, 0 para salir: ");
      scanf("%i", &c);

      // Clear the last \n
      getchar();

      if (c == 1) {
        break;
      } else if (c == 0) {
        exit(0);
      } else {
        printf("Wrong id, try again!");
      }
    } // end while to ask
  }   // end while
} // end main
