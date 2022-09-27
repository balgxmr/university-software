/* 1. Escribe un programa que lea de la entrada estandar dos numeros y muestre en la salida estandar su suma, resta, multiplicación y división
PROBLEMA #1

*/

#include<iostream>

using namespace std;

int main(){
    float n1, n2, suma = 0, resta = 0, multiplicacion = 0, division = 0; //ACÁ RECUERDA QUE SI PONES INT TE DARÁ SIEMPRE ENTERO ENTONCES LA DIVISION PUEDE QUE ESTÉ "MAL"

    cout<<"Digite un numero: "; cin>>n1;
    cout<<"Digite otro numero: "; cin>>n2;

    suma = n1 + n2;
    resta = n1 - n2;
    multiplicacion = n1 * n2;
    division = n1 / n2;

    cout<<"\nLa suma es: "<<suma<<endl;
    cout<<"La resta es: "<<resta<<endl;
    cout<<"La division es: "<<division<<endl;
    cout<<"La multiplicacion es: "<<multiplicacion<<endl;






    return 0;
}