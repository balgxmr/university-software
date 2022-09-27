#include<stdio.h>

float lado1, lado2, lado3;

int main(){
    printf("Introduzca el lado de su primer triángulo: ");
    scanf("%f",&lado1);
    printf("Introduzca el lado de su primer triángulo: ");
    scanf("%f",&lado2);
    printf("Introduzca el lado de su primer triángulo: ");
    scanf("%f",&lado3);
    if(lado1!=lado2 && lado1!=lado3 && lado2!=lado3){
        printf("Su triangulo es Escaleno. ");
        }
        else if(lado1==lado2 && lado2==lado3){
        printf("Su triangulo es Equilátero. ");
        }
        else{
            printf("Su triangulo es Isósceles.");
        }
    return 0;
}