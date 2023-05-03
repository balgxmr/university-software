// Entradas y salidas

#include<stdio.h>

int main(){

    int a = 10;
    float b = 15.24;
    char c = 'e';

    // Para imprimir los 3 valores dentro de un solo print:
    printf("%i %f %c\n",a,b,c); // Debemos de asignar (a,b,c) en el mismo orden en que están los %
    printf("El primer valor es de: %i\nEl segundo valor es de: %f\nEl tercer valor es de: %c\n",a,b,c); // Mejor escrito XD


// PARTE 2 - PEDIRLE AL USUARIO QUE DIGITE DATOS

    int d;
    float f;
    char g;
    
    printf("Digite el valor de la variable d: ");
    scanf("%i",&d); // scanf se utiliza para guardar datos. el "&d" debe estar acompañado, este pide la variable d y guarda el valor en la misma.

    printf("Digite el valor de la variable f: ");
    scanf("%f",&f); // f para float, vamos XD.
    
    printf("El valor de int es: %i\n",d);
    printf("El digito para float es: %f\n",f);

// PARTE 3 - GUARDAR VARIABLES MAYORES

    char x[50]; // El [50] indica que se pueden hasta 50 espacios.
    printf("Digite su nombre: "); 
    //scanf("%s",x); // OJO! El %s es porque son caracteres/strings, y el "&" no hace falta. Además, se utiliza "s" para el tipo caracter.

    // OJOOOOOOOOO. EL SCAN SOLO LE HASTA DONDE HAY UN ESPACIO (Ejemplo: introducimos José Antonio, en el output saldrá José), POR LO CUAL, ES MEJOR UTILIZAR:
    gets(x); 

    printf("Su nombre es: %s",x); // El %s porque es string

    return 0;
}
