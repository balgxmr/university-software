/*
>>> Algoritmo - Maquina de Refrescos <<<
Se requiere de un algoritmo para programar un sistema de máquina de refrescos. En este prototipo existen 4 opciones de compra. 
1: soda a $0.80 centavos. 
2: Jugos naturales a $1.00. 
3: Agua embotellada a $1.25. 
4: Malta a $0.75 centavos. 
- La máquina acepta monedas de 5, 10, 25 y dólares de $1 y $5. 
- En este prototipo se le pregunta al usuario qué opciones desea adquirir, el usuario puede pedir de diferentes opciones y diferentes cantidades. 
- El prototipo debe mostrar el monto a pagar y el usuario deberá proporcionar el monto en cantidades dependiendo si es moneda o dólares. 
- Finalmente, el prototipo deberá indicar al usuario si puede retirar el producto, además, de dar el vuelto en monedas si lo amerita.
- El vuelto solo se da en dólares o monedas de mayor a menos denominaciones.
- Utilizar la estructura según, y al menos una función.
*/

int CalcularVuelto (float dinero, float moneda){
    int cont;
    cont=0;
        while(dinero>=moneda){
            dinero=dinero-moneda;
            cont=cont+1;
        }
    return cont;
}

#include<stdio.h>
// Declaración de variables
float montototal, dinero, pagado, vueltofinal;
int articulo, x, y, vuelto1, vuelto2, vuelto3, vuelto4, vuelto5, sodas, jugos, agua, maltas, cantidadProducto;
//Bloque de instrucciones
int main(){
    printf("Los costos de los productos son: \n0.80$ para la soda\n1.00$ para los jugos naturales\n1.25$ para la botella de agua\n0.75$ para la malta");
    x=1;
    sodas=0;
    jugos=0;
    agua=0;
    maltas=0;
    montototal=0;
    while(x==1){
        printf("\n¿Qué articulo desea comprar?\n1 para soda\n2 para jugo natural\n3 para botella de agua\n4 para malta.\nIngrese el número del producto: ");
        scanf("%i",&articulo);
            switch(articulo)
            {
            case 1:
                printf("¿Qué cantidad de sodas desea? Ingrese: ");
                scanf("%i",&cantidadProducto);
                sodas=sodas+cantidadProducto;
                montototal=montototal+(cantidadProducto*0.80);
                break;

            case 2:
                printf("¿Qué cantidad de jugos naturales desea? Ingrese: ");
                scanf("%i",&cantidadProducto);
                jugos=jugos+cantidadProducto;
                montototal=montototal+(cantidadProducto*1.00);
                break;

            case 3:
                printf("¿Qué cantidad de botellas de agua desea? Ingrese: ");
                scanf("%i",&cantidadProducto);
                agua=agua+cantidadProducto;
                montototal=montototal+(cantidadProducto*1.25);
                break;

            case 4:
                printf("¿Qué cantidad de maltas desea? Ingrese: ");
                scanf("%i",&cantidadProducto);
                maltas=maltas+cantidadProducto;
                montototal=montototal+(cantidadProducto*0.75);
                break;

            default:
                break;
            }
        printf("Desea comprar otro artículo? \nIntroduzca 1 para si, 0 para no: ");
        scanf("%i",&x);
    }
    x=1;
    while(x==1){
    printf("\nSu total a pagar es: %.2f", montototal);
    printf("\nIngrese el dinero en monedas o en dólares: ");
    scanf("%f",&pagado);
      if(montototal>pagado){
        printf("\nEl dinero ingresado no es suficiente! Intente nuevamente, presione 1 para intentar nuevamente, 0 para salir: ");
        scanf("%i",&x);
        if(x==0){
            printf("Se le ha devuelto la cantidad ingresada que fue de: %f",pagado);
        }
    }
    else if(montototal<pagado){
        x=0;
    // Utilizando la función CalcularVuelto para devolver el cambio.
    dinero=pagado-montototal;
    vuelto1=CalcularVuelto(dinero, 5);
    dinero=dinero-(vuelto1*5);
    vuelto2=CalcularVuelto(dinero, 1);
    dinero=dinero-(vuelto2*1);
    vuelto3=CalcularVuelto(dinero, 0.25);
    dinero=dinero-(vuelto3*0.25);
    vuelto4=CalcularVuelto(dinero, 0.10);
    dinero=dinero-(vuelto4*0.10);
    vuelto5=CalcularVuelto(dinero, 0.05);
    dinero=dinero-(vuelto5*0.05);
    vueltofinal=pagado-montototal;

    printf("\nSu vuelto es de: %.2f",vueltofinal);
    if(vuelto1>0){
    printf("\nLa cantidad de billetes de 5 dolares es de: %i", vuelto1);
    }
    if(vuelto2>0){
    printf("\nLa cantidad de billetes de 1 dolar es de: %i", vuelto2);
    }
    if(vuelto3>0){
    printf("\nLa cantidad de monedas de 0.25 es de: %i", vuelto3);
    }
    if(vuelto4>0){
    printf("\nLa cantidad de monedas de 0.10 es de: %i", vuelto4);
    }
    if(vuelto5>0){
    printf("\nLa cantidad de monedas de 0.05 es de: %i", vuelto5);
    }

    if(sodas>0){
        printf("\nRetire su(s) soda(s): Cantidad: %i",sodas);
    }
    if(jugos>0){
        printf("\nRetire su(s) jugo(s) natural(es): Cantidad: %i",jugos);
    }
    if(agua>0){
        printf("\nRetire su(s) botella(s) de agua: Cantidad: %i",agua);
    }
    if(maltas>0){
        printf("\nRetire su(s) malta(s): Cantidad: %i",maltas);
    }
    }
    }
}
