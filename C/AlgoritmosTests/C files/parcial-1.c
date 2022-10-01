#include<stdio.h>
// Declaración de variables
float estatura, prom, max, min, z;
int x, cont;

// Bloque de instrucciones
int main(){
    printf("Introduzca 1 para continuar, introduzca 0 para salir. ");
    scanf("%i",&x);
    cont=0;
    max=estatura;
    min=estatura;
    while(x==1){
        printf("Introduzca la estatura de los miembros: ");
        scanf("%f",&estatura);
            if(estatura>max){
                max=estatura;
            }
            else{
                min=estatura;
            }
        z=estatura+z;
        cont=cont+1;
        printf("Escriba 1 para continuar, 0 para salir. ");
        scanf("%i",&x);
        }
    prom=z/cont;
    printf("Su estatura promedio es: %.2f \n",prom);
    printf("La altura máxima es de: %.2f \n",max);
    printf("La altura mínima es de: %.2f \n",min);
}
