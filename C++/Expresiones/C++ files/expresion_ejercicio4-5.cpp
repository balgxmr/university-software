// 5. Escriba un fragmento de programa que intercambie los valores de dos variables

#include<iostream>
using namespace std;

int main(){

    float a, b, aux;

    cout<<"Introduzca el valor de la primera variable: "; cin>>a;
    cout<<"Introduzca el valor de la segunda variable: "; cin>>b;

    /* HACER QUE EL VALOR DE A SE INTERCAMBIE CON EL DE Y
    PARA ESO UTILIZAMOS EN ESTE CASO LA VARIABLE "AUX"
    */

    aux = a;
    a = b;
    b = aux;

    cout<<"\nEl nuevo valor de a es: "<<a<<endl;
    cout<<"El nuevo valor de b es: "<<b<<endl;

    return 0;
}