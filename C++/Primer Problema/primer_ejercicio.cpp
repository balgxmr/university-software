/* DESARROLLE UN PROGRAMA QUE LEA DE LA ENTRADA ESTANDAR EL PRECIO DE UN PRODUCTO Y QUE MUESTRE EN LA SALIDA ESTANDAR
EL PRECIO DEL PRODUCTO AL APLICARLE EL IVA (o descuento)

EJERCICIO NUMERO 1, VIDEO CURSO DE C++ DESDE 0 (COMPLETO) - NIVEL JUNIOR

*/

#include<iostream>

using namespace std;

int main(){

    float iva = 0.07;
    float precio_prod, multiplicacion = 0, precio_final = 0;

    cout<<"Introduzca un numero: "; cin>>precio_prod;

    precio_final=(multiplicacion = precio_prod * iva) + precio_prod;

    cout<<"\nEl precio del producto con impuestos incluidos es de: "<<precio_final;

    
    return 0;
}