#include <stdio.h>
int main(){
    // Declaración de variables
    float est, prom=0, max, min;
    int i=0;

    //Bloque de instrucciones
    printf("Estatura: ");
    scanf("%f",&est);
    max=est;
    min=est;
    while(est==0){ // Mientras est sea =! de 0, se cumple lo otro.
        if(est>max){ // Si est>max, la nueva est será max
            max=est;
        }
            else if(est<min){ // Si min>est, la nueva est será min
            min=est;
        }
            prom=prom+est; // Esto es un acumulador
            printf("Ingrese la estatura:\nSi desea finalizar el programa, escriba 0 ");
            scanf("%f",&est);
            i++;
    }
    prom=(prom/i);
    printf("El promedio de sus estaturas es de: %f\n", prom);
    printf("La estatura máxima es de: %f\n", max);
    printf("La estatura mínima es: %f\n", min);
}
