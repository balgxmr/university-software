#include<stdio.h>

float cal1, cal2, cal3, prom;
char equivalencia;
int A=91, B=81, C=71, D=61, F=60;

int main(){
    printf("Introduzca su primera calificación: ");
    scanf("%f",&cal1);
    printf("Introduzca su segunda calificación: ");
    scanf("%f",&cal2);
    printf("Introduzca su tercera calificación: ");
    scanf("%f",&cal3);
    prom=(cal1+cal2+cal3)/3;
    if(prom>A){
        equivalencia='A';
        }
        else if(prom>B){
        equivalencia='B';
        }
        else if(prom>C){
        equivalencia='C';
        }
        else if(prom>D){
        equivalencia='D';
        }
        else{
        equivalencia='F';
    }
    printf("Su nota promedio es de %.2f, y su calificación en letra es de %c",prom,equivalencia);
    return 0;
}