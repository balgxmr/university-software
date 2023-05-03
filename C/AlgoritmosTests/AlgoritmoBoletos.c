float descuentoBoleto(float boletos, float precio){
// Declaraciones locales
float resultado;
// Bloque de construcción
if(boletos==2){
    resultado=(boletos*precio)-((boletos*precio)*(0.10));
}
else if(boletos>2){
    resultado=(boletos*precio)-((boletos*precio)*(0.15));
}
return(resultado);
}

#include<stdio.h>
// Declaración de variables
float resultado, precioNeto, impuesto, descuento, PrecioNetoDesc, ManejoAdministrativo, totalImpuestos, totalPagar;
int zonas, boletos, boletosVip, boletosGold, boletosSilver, boletosGeneral, x;
// Bloque de construcción
int main(){
printf("Bienvenido. \nEl boleto para la zona VIP tiene un costo de 200$; en la zona Gold = 120$; en la zona silver = 80$; y en la zona general = 45$. \n");
x=1;
boletosVip=0;
boletosGold=0;
boletosSilver=0;
boletosGeneral=0;
resultado=0;
precioNeto=0;
while(x==1){
    printf("\nLos números para las zonas en que desea comprar son: \n1 para VIP \n2 para GOLD \n3 para SILVER \n4 para GENERAL \nDigite el número de la zona: ");
    scanf("%i",&zonas);
    switch(zonas){
        case 1:
        printf("Ingrese la cantidad de boletos que desea comprar en la zona VIP: ");
        scanf("%i",&boletos);
        boletosVip=boletosVip + boletos;
        precioNeto=precioNeto+(boletos*200);
        resultado=resultado+ descuentoBoleto(boletos, 200);
        break;

        case 2:
        printf("Ingrese la cantidad de boletos que desea comprar en la zona GOLD: ");
        scanf("%i",&boletos);
        boletosGold=boletosGold+boletos;
        precioNeto=precioNeto+(boletos*120);
        resultado=resultado+ descuentoBoleto(boletos, 120);
        break;

        case 3:
        printf("Ingrese la cantidad de boletos que desea comprar en la zona SILVER: ");
        scanf("%i",&boletos);
        boletosSilver=boletosSilver+boletos;
        precioNeto=precioNeto+(boletos*80);
        resultado=resultado+ descuentoBoleto(boletos, 80);
        break;

        case 4:
        printf("Ingrese la cantidad de boletos que desea comprar en la zona GENERAL: ");
        scanf("%i",&boletos);
        boletosGeneral=boletosGeneral+boletos;
        precioNeto=precioNeto+(boletos*45);
        resultado=resultado+ descuentoBoleto(boletos, 45);
        break;
    }
    printf("\n¿Desea comprar boletos en otra zona? \nIntroduzca 1 si desea continuar, introduzca 0 para no comprar mas boletos: ");
    scanf("%i",&x);
    }
PrecioNetoDesc=precioNeto-resultado;
// totalImpuestos=(resFinVip+resFinGold+resFinSilv+resGenFin);
if(resultado==0){
    impuesto=precioNeto*0.07;
    ManejoAdministrativo=precioNeto*0.1;
    totalPagar=precioNeto+impuesto+ManejoAdministrativo;
}
else{
    impuesto=resultado*0.07;
    ManejoAdministrativo=resultado*0.1;
    totalPagar=resultado+impuesto+ManejoAdministrativo;
}
printf("\n---------------------------------------");
printf("\nLa cantidad de boletos en la Zona VIP es de: %i",boletosVip);
printf("\nLa cantidad de boletos en la Zona GOLD es de: %i",boletosGold);
printf("\nLa cantidad de boletos en la Zona SILVER es de: %i",boletosSilver);
printf("\nLa cantidad de boletos en la Zona GENERAL es de: %i",boletosGeneral);
printf("\n---------------------------------------");
printf("\nEl descuento es de: %.2f$",PrecioNetoDesc);
printf("\nLa suma total sin descuento es de: %.2f$",precioNeto);
printf("\nLa suma total con descuento es de: %.2f$",resultado);
printf("\nEl manejo administrativo es de: %.2f$", ManejoAdministrativo);
printf("\nLa cantidad de impuestos a pagar es de: %.2f$", impuesto);
//printf("\nEl descuento realizado es de: %.2f", descuento);
printf("\nEl total a pagar (boletos + impuestos + manejo administrativo) es de: %.2f$",totalPagar);
}

