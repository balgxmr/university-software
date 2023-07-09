/*
 * balgxmr 2023 
 *
 * PROBLEM SOURCE: https://frrq.cvg.utn.edu.ar/pluginfile.php/15732/mod_resource/content/0/Practica_TUP_2020.pdf
 *
 * 25- Hacer un programa que ingrese dos cadenas y:
 * Determine cuál de ellas es mayor en orden alfabético.
 * Concatene ambas cadenas.
 * Determine cuál es mas larga.
 * Invierta la primera ingresada.
 * El programa deberá mostrar todas las salidas con carteles aclaratorios
*/


#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

#define STRING_LENGTH 100

/* Funcion para obtener que nombre es mayor ascendentemente en el abecedario */
int obtenerMayorAlfabeto (char primerNombre[], char segundoNombre[]) {
    return (primerNombre[0] > segundoNombre[0]) ? true : false;
}

/* Imprime el nombre mayor alfabeticamente por pantalla */
void imprimirNombreMayor (bool alfaVsLong, bool mayor, char primerNombre[], char segundoNombre[]) {
    if(alfaVsLong == true){
        if(mayor == false)
            printf("El nombre mayor alfabeticamente es: %s\n", primerNombre);
        else
            printf("El nombre mayor alfabeticamente es: %s\n", segundoNombre);
    } else {
        if(mayor == false)
            printf("La cadena con mayor longitud es: %s con una longitud de: %i\n", primerNombre, strlen(primerNombre));
        else
            printf("La cadena con mayor longitud es: %s con una longitud de: %i\n", segundoNombre, strlen(segundoNombre));
    }
}

/* Funcion para obtener cual es la cadena más larga */
bool obtenerCadenaLarga (char primerNombre[], char segundoNombre[]){
    if(strlen(primerNombre) > strlen(segundoNombre))
        return false;
    else
        return true;
}

int main(){
    while(true){
        /* Declaracion de variables */
        char primerNombre[STRING_LENGTH];
        char segundoNombre[STRING_LENGTH];
        char nombreConcatenado[STRING_LENGTH*2];
        bool alfaVsLong; // Gets passed into imprimirPantalla, to validate when to print
                         // the type of search we're doing 

        printf("Ingresa el primer nombre: ");
        fgets(primerNombre, STRING_LENGTH, stdin);
        primerNombre[strlen(primerNombre) - 1] = '\0';   // Removes the last \n 

        printf("Ingresa el primer nombre: ");
        fgets(segundoNombre, STRING_LENGTH, stdin);
        segundoNombre[strlen(segundoNombre) - 1] = '\0'; // Removes the last \n 

        printf("\nNombre #1: %s\n", primerNombre);
        printf("Nombre #2: %s\n\n", segundoNombre);

        alfaVsLong = true;
        bool mayor = obtenerMayorAlfabeto(primerNombre, segundoNombre);
        imprimirNombreMayor(alfaVsLong, mayor, primerNombre, segundoNombre);

        alfaVsLong = false;
        bool valorCadenaLarga = obtenerCadenaLarga(primerNombre, segundoNombre);
        imprimirNombreMayor(alfaVsLong, valorCadenaLarga, primerNombre, segundoNombre);

        while(true){
            // Ask if the user wants to continue
            int c;
            printf("\nEscribe 1 para agregar mas nombres, 0 para salir: ");
            scanf("%i", &c);

            // Clear the last \n
            getchar();

            if(c == 1){
                break;
            } else if (c == 0){
                exit(0);
            } else {
                printf("Wrong id, try again!");
            }
        } // end while to ask
    } // end while
} // end main