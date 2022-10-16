/* 
[1]: Descuentos especiales todos los días para los jubilados del 30% (Mujeres mayores de 58 años y hombres mayores de 60 años). 
[2]: Para el resto del público, si sus compras son mayores a 40.00 dólares, los lunes habrá descuento del 5%, los martes del 10%, los
    miércoles del 15%. Para el resto de días (jueves, viernes, sábado y domingo) no habrá descuento.

Algunas condiciones:
- Se considerará el valor 1 para el femenino, el 2 para masculino. 
- Deberá utilizar la estructura mientras.
- Las iteraciones deben ser controladas por el usuario, no se permite preguntar la cantidad de iteraciones al inicio.
- Se deberá leer N cantidad de medicamentos.
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
float precioProducto, desc, montofinal, producto;
int sexo, edad, x, cont, dia, jubilado;
// Bloque de instrucciones
int main(){
    printf("Usted es hombre o mujer? \n Indique 1 para mujer, 2 para hombre: ");
    scanf("%i",&sexo);
    printf("\n¿Cuál es su edad? Ingrese: ");
    scanf("%i",&edad);
    if(edad>=58 && sexo==1 || edad>=60 && sexo==2){
    printf("\nUsted ha aplicado para el descuento para jubilados! \n");
    jubilado=1;
    x=1;
    cont=0;
    precioProducto=0;
        while(x==1){
            printf("\nIngrese el precio del producto: ");
            scanf("%f",&producto);
            cont=cont+1;
            precioProducto=precioProducto+producto;
            printf("\n¿Desea agregar otro producto? Indique 1 para si, 0 para no: ");
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
                printf("\n¿Desea agregar otro producto? Indique 1 para si, 0 para no: ");
                scanf("%i",&x);
            }
        if(precioProducto>40){
        printf("\n¿Qué día es hoy? \n 1 para lunes\n 2 para martes\n 3 para miércoles\n 4 para los demás días de la semana. \nIndique el numero del día: ");
        scanf("%i",&dia);
        switch (dia)
        {
        case 1:
            desc=precioProducto*0.05;
            break;
        
        case 2:
            desc=precioProducto*0.10;
            break;

        case 3:
            desc=precioProducto*0.15;
            break;

        default:
            break;
        }
        montofinal=precioProducto-desc;
    }
    }
    printf("\nLa cantidad total de medicamentos comprados es de: %i",cont);
    printf("\nEl monto total sin el descuento es de: %.2f",precioProducto);
    if(jubilado==1){
    printf("\nEl descuento de Jubilados es de: %.2f",desc);
    }
    else{
    printf("\nEl descuento es de: %.2f",desc);
    }
    printf("\nEl total a pagar es de: %.2f",montofinal);
}
