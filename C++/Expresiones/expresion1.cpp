// 1. Escribe la siguiente expresión como expresión en C++

#include<iostream>

using namespace std;

int main(){

    float a, b, resultado = 0;

    cout<<"Digite el valor que tendra a: "; cin>>a;
    cout<<"Digite el valor que tendra b: "; cin>>b; 

    resultado = (a/b)+1;

    cout.precision(2); //CON ESTO REDONDEAS A 2 NUMEROS!
    cout<<"El resultado de a entre b mas 1 es: "<<resultado; 


    return 0;
}