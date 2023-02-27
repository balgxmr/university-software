#include<stdio.h>
#include<math.h>
#include<ctype.h>
#include<stdbool.h>
#include<string.h>

// Constantes globales
char eleccion;
int loop = 1;

// Funcion para funciones aritméticas de + - * / raiz y potencia
double operaciones(double valor1, double valor2, int selector)
{
    double resultado;
    
    switch (selector)
    {
    case 1:
        resultado = valor1 + valor2;
        break;

    case 2:
        resultado = valor1 - valor2;
        break;

    case 3:
        resultado = valor1 * valor2;
        break;
    
    case 4:
        resultado = valor1 / valor2;
        break;

    case 5:
        resultado = sqrt(valor1);
        break;
    
    case 6:
        resultado = pow(valor1, valor2);
        break;

    default:
        break;
    }
    return resultado;
}

// Función que le pregunta al usuario si desea introducir otro valor en caso de que lo quiera.
double valorExtra()
{
    while(loop == 1){
        printf("\n\nDesea introducir otro valor? (y/n): ");
        scanf("\n%c", &eleccion);
        eleccion = toupper(eleccion);
        if(eleccion == 'Y' || eleccion == 'N'){
            return eleccion;
            loop = 0;
        } else {
            printf("Valor ingresado incorrecto! Use 'y' o 'n'.");
            loop = 1;
        }
    }
}

int main (){

    int operacion;
    double valor1;
    double valor2;
    double resultado;

    printf("1) Suma\n2) Resta\n3) Multiplicacion\n4) Division\n5) Raiz de un valor\n6) Potencia\n");
    printf("Introduce la operación que desea realizar: ");
    scanf("%i", &operacion);

    switch (operacion)
    {
    case 1: // Suma
        printf("Introduce tu primer valor: ");
        scanf("%lf", &valor1);
        printf("Introduce tu segundo valor: ");
        scanf("%lf", &valor2);

        resultado = operaciones(valor1, valor2, operacion);
        printf("El resultado de la suma es de: %g", resultado);

        while(loop == 1){
            eleccion = valorExtra();

            if(eleccion == 'Y'){
                printf("Introduce tu siguiente valor a sumar: ");
                scanf("%lf", &valor1);
                resultado = resultado + valor1;
                printf("\n%g", resultado);
                loop = 1;

            } else if (eleccion == 'N'){
                printf("Programa finalizado...");
                loop = 0;
                break;

            } else {
                loop = 1;
                printf("Invalid input!\n");
                break;
            }
        }
        break;

    case 2: // Resta
        printf("Introduce tu primer valor: ");
        scanf("%lf", &valor1);
        printf("Introduce tu segundo valor: ");
        scanf("%lf", &valor2);

        resultado = operaciones(valor1, valor2, operacion);
        printf("El resultado de la resta es de: %g", resultado);

        while(loop == 1){
            eleccion = valorExtra();

            if(eleccion == 'Y'){
                printf("Introduce tu siguiente valor a restar: ");
                scanf("%lf", &valor1);
                resultado = resultado - valor1;
                printf("\n%g", resultado);
                loop = 1;

            } else if (eleccion == 'N'){
                printf("Programa finalizado...");
                loop = 0;
                break;

            } else {
                loop = 1;
                printf("Invalid input!\n");
                break;
            }
        }
        break;

    case 3: // Multiplicación
        printf("Introduce tu primer valor: ");
        scanf("%lf", &valor1);
        printf("Introduce tu segundo valor: ");
        scanf("%lf", &valor2);

        resultado = operaciones(valor1, valor2, operacion);
        printf("El resultado de la multiplicación es de: %g", resultado);

        while(loop == 1){
            eleccion = valorExtra();

            if(eleccion == 'Y'){
                printf("Introduce tu siguiente valor a multiplicar: ");
                scanf("%lf", &valor1);
                resultado = resultado * valor1;
                printf("\n%g", resultado);
                loop = 1;

            } else if (eleccion == 'N'){
                printf("Programa finalizado...");
                loop = 0;
                break;

            } else {
                loop = 1;
                printf("Invalid input!\n");
                break;
            }
        }
        break;
    
    case 4: // División
        printf("Introduce tu primer valor: ");
        scanf("%lf", &valor1);
        printf("Introduce tu segundo valor: ");
        scanf("%lf", &valor2);

        resultado = operaciones(valor1, valor2, operacion);
        printf("El resultado de la división es de: %g", resultado);

        while(loop == 1){
            eleccion = valorExtra();

            if(eleccion == 'Y'){
                printf("Introduce tu siguiente valor a dividir: ");
                scanf("%lf", &valor1);
                resultado = resultado / valor1;
                printf("\n%g", resultado);
                loop = 1;

            } else if (eleccion == 'N'){
                printf("Programa finalizado...");
                loop = 0;
                break;

            } else {
                loop = 1;
                printf("Invalid input!\n");
                break;
            }
        }
        break;

    case 5: // Raíz
        printf("Introduce el valor que deseas sacar raiz: ");
        scanf("%lf", &valor1);
        resultado = operaciones(valor1, valor2, operacion);
        printf("El resultado de la división es de: %g", resultado);

        while(loop == 1){
            eleccion = valorExtra();

            if(eleccion == 'Y'){
                printf("Introduce el valor a sacar la raiz: ");
                scanf("%lf", &valor1);
                resultado = operaciones(valor1, valor2, operacion);
                printf("\n%g", resultado);
                loop = 1;

            } else if (eleccion == 'N'){
                printf("Programa finalizado...");
                loop = 0;
                break;

            } else {
                loop = 1;
                printf("Invalid input!\n");
                break;
            }
        }
        break;

    case 6: // Potencia
        printf("Introduce la base: ");
        scanf("%lf", &valor1);
        printf("Introduce el valor de la potencia: ");
        scanf("%lf", &valor2);

        resultado = operaciones(valor1, valor2, operacion);
        printf("El resultado de la potenciación es de: %g", resultado);

        while(loop == 1){
            eleccion = valorExtra();

            if(eleccion == 'Y'){
                printf("Introduce tu siguiente valor a potenciar: ");
                scanf("%lf", &valor2);
                resultado = operaciones(resultado, valor2, operacion);
                printf("\n%g", resultado);
                loop = 1;

            } else if (eleccion == 'N'){
                printf("Programa finalizado...");
                loop = 0;
                break;

            } else {
                loop = 1;
                printf("Invalid input!\n");
                break;
            }
        }
        break;

    default:
        printf("Valor no válido! Abortando...");
        break;
    }
    return 0;
}

// switch
// main
