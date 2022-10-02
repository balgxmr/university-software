/* 
Escriba un algoritmo que permita leer N cantidad de estaturas de un grupo de personas. 
Se requiere que el algoritmo imprima el promedio de todas las estaturas.
Además de la estatura más alta y más baja.
Las iteraciones deben ser controladas por el usuario, no se permite preguntar la cantidad de iteraciones al inicio.
Solamente podrá utilizar la estructura while.
*/

#include<stdio.h>
// Declaración de variables
float estatura, prom, max, min, z;
int x, cont;
// Bloque de instrucciones
int main(){
    printf("Introduzca 1 para inicializar el programa o introduzca 0 para salir. ");
    scanf("%i",&x);
    cont=0;
    max=0;
    min=999;
    while(x==1){
        printf("Introduzca la estatura de los miembros: ");
        scanf("%f",&estatura);
        if(estatura>max){
            max=estatura;
        }
        if(estatura<min){
            min=estatura;
        }
        z=estatura+z;
        cont=cont+1;
        printf("Introduzca 1 para continuar, 0 para salir. ");
        scanf("%i",&x);
        }
    prom=z/cont;
    printf("Su estatura promedio es: %.2f \n",prom);
    printf("La altura máxima es de: %.2f \n",max);
    printf("La altura mínima es de: %.2f \n",min);
}
