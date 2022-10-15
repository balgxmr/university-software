/* 
[1]: Descuentos especiales todos los días para los jubilados del 30% (Mujeres mayores de 58 años y hombres mayores de 60 años). 
[2]: Para el resto del público, si sus compras son mayores a 40.00 dólares, los lunes habrá descuento del 5%, los martes del 10%, los
miércoles del 15%. Para el resto de días no.

- Algunas condiciones:
Se considerará el valor 1 para el femenino, el 2 para masculino. 
Deberá utilizar la estructura mientras.
Las iteraciones deben ser controladas por el usuario, no se permite preguntar la cantidad de iteraciones al inicio.
Se deberá leer N cantidad de medicamentos.
*/

float descuentoJubilados (float precioProducto){
    //Bloque de variables
    float resultado;
    //Bloque de instrucciones
        resultado=precioProducto*0.30;
        return(resultado);
}

#include<stdio.h>
// Bloque de variables 
float precioProducto, desc, montofinal, resultado, producto;
int sexo, edad, x, cont, dia, jubilado;
// Bloque de instrucciones
int main(){
    printf("Usted es hombre o mujer? \n Indique 1 para mujer, 2 para hombre. ");
    scanf("%i",&sexo);
    printf("¿Cuál es su edad? \n");
    scanf("%i",&edad);
    if(edad>=58 && sexo==1 || edad>=60 && sexo==2){
    jubilado=1;
    x=1;
    cont=0;
    precioProducto=0;
        while(x==1){
            printf("Ingrese el precio del producto: ");
            scanf("%f",&producto);
            cont=cont+1;
            precioProducto=precioProducto+producto;
            printf("\n¿Desea agregar otro producto? Indique 1 para si, 0 para no. ");
            scanf("%i",&x);
        }
    desc=descuentoJubilados(precioProducto);
    montofinal=precioProducto-desc;
    }
    else if(edad<58){
        x=1;
        cont=0;
        precioProducto=0;
            while(x==1){
                printf("\nIngrese el precio de su producto: ");
                scanf("%f",&producto);
                cont=cont+1;
                precioProducto=precioProducto+producto;
                printf("\n¿Desea agregar otro producto? Indique 1 para si, 0 para no. ");
                scanf("%i",&x);
            }
        montofinal=precioProducto-desc;
        if(precioProducto>40){
        printf("¿Qué día es hoy? Indique 1 para lunes, 2 para martes, 3 para miércoles, 4 para los demás días de la semana. ");
        scanf("%i",&dia);
        switch (dia)
        {
        case 1:
            resultado=precioProducto*0.05;
            break;
        
        case 2:
            resultado=precioProducto*0.10;
            break;

        case 3:
            resultado=precioProducto*0.15;
            break;

        default:
            break;
        }
    }
    }
    printf("\nLa cantidad total de medicamentos comprados es de: %i",cont);
    printf("\nEl monto total sin el descuento es de: %f",precioProducto);
    if(jubilado==1){
    printf("\nEl descuento de Jubilados es de: %f",desc);
    }
    else{
    printf("\nEl descuento es de: %f",resultado);
    }
    printf("\nEl total a pagar es de: %f",montofinal);
}
