// Escriba la siguiente expresion matemática como expresion en c++: a+b/c+d

#include<iostream>

using namespace std;

int main(){

    float a, b, c, d, resultado = 0;

    cout<<"Introduzca el valor de a: "; cin>>a;
    cout<<"Introduzca el valor de b: "; cin>>b;
    cout<<"Introduzca el valor de c: "; cin>>c;
    cout<<"Introduzca el valor de d: "; cin>>d;

    resultado = ((a+b)/(c+d));

    cout.precision(3);
    cout<<"\nEl resultado de a+b entre c+d es: "<<resultado;

    return 0;
}