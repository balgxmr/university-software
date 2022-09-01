// 4. Exprese en lenguaje C++: a + (b/c-d)

#include<iostream>
using namespace std;

int main(){

    float a, b, c, d, resultado =0;

    cout<<"Digite el numero de a: "; cin>>a;
    cout<<"Digite el numero de b: "; cin>>b;
    cout<<"Digite el numero de c: "; cin>>c;
    cout<<"Digite el numero de d: "; cin>>d;

    resultado = a + (b/(c-d));
    cout.precision(3);
    cout<<"\nEl resultado de la operacion es: "<<resultado;

    return 0;
}
