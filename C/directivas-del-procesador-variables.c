// Directivas del procesador y variables

// Toda libreria comienza con include.
#include<stdio.h>
#include<string.h>
#include<math.h>
#include<stdlib.h>

// Las macros nos sirven para asignarle un valor a una variable que utilizaremos durante todo el programa. Ej:
#define PI 3.1416

int y = 5; // Esto es una variable GLOBAL. Podemos utilizarla durante todo el código.

int main(){
    int x = 10; // Esto es una variable LOCAL, debido a que está dentro UNICAMENTE dentro de esta funcion main.

    float suma = 0; // Suma va a empezar con un valor cero, por lo cual más adelante le podemos asignar otro valor... (Véase siguiente linea)
    suma = PI + x + y; // Se ha asignado el valor de "PI + x + y".

    /* El %i es debido a que se le está indicando el tipo de dato para "suma". En este caso i = integer
        Se puede utilizar también %f, en donde f = float
            Si utilizamos float, dan muchos decimales, para recortar la cantidad de cifras, se añade ".X" en donde X sería la cantidad de decimales que se quiera. 
            Ejemplo: ...%.2f, suma);
    */
    printf("La suma es: %.3f", suma);
    return 0;
}