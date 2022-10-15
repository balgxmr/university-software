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
int sexo, edad, x, cont, dia;
// Bloque de instrucciones
int main(){
    printf("Usted es hombre o mujer? \n Indique 1 para mujer, 2 para hombre. ");
    scanf("%i",&sexo);
    printf("¿Cuál es su edad? \n");
    scanf("%i",&edad);
    if(edad>=58 && sexo==1 || edad>=60 && sexo==2){
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
                printf("\nIngrese el precio de su producto XD: ");
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
    printf("La cantidad total de medicamentos comprados es de: %i",cont);
    printf("El monto total sin el descuento es de: %f",precioProducto);
    printf("El descuento de Jubilados es de: %f",desc);
    printf("El descuento de Jubilados es de: %f",resultado);
    printf("El total a pagar es de: %f",montofinal);
}