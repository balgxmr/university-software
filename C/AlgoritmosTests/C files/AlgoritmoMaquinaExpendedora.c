int CalcularVuelto (float dinero, float moneda){
    int cont;
    cont=0;
        while(dinero>=moneda){
            dinero=dinero-moneda;
            cont=cont+1;
        }
    return cont;
}

// Algoritmo Maquina de Refrescos
#include<stdio.h>

// Declaración de variables
float montototal, dinero, pagado, vuelto1, vuelto2, vuelto3, vuelto4, vuelto5, vueltofinal;
int articulo, x, sodas, jugos, agua, maltas, cantidadProducto;

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
        printf("\nIntroduzca el articulo que desea comprar\n1 para soda\n2 para jugo natural\n3 para botella de agua\n4 para malta.\nProducto: ");
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
    printf("\nSu total a pagar es: %f", montototal);
    printf("\nIngrese el dinero en monedas o en dólares. ");
    scanf("%f",&pagado);
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
    printf("\nLa cantidad de billetes de 5 dolares es de: %.0f", vuelto1);
    }
    if(vuelto2>0){
    printf("\nLa cantidad de billetes de 1 dolar es de: %.0f", vuelto2);
    }
    if(vuelto3>0){
    printf("\nLa cantidad de monedas de 0.25 es de: %.0f", vuelto3);
    }
    if(vuelto4>0){
    printf("\nLa cantidad de monedas de 0.10 es de: %.0f", vuelto4);
    }
    if(vuelto5>0){
    printf("\nLa cantidad de monedas de 0.05 es de: %.0f", vuelto5);
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