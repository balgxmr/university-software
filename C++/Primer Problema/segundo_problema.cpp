/* Realice un programa que lea de la entrada estándar los siguientes datos de una persona:
Edad: dato entero
Sexo: tipo caracter
Altura en metros: dato de tipo real

Mostrarlos en la entrada de salida estandar
*/

#include<iostream>

using namespace std;

int main(){

    int edad;
    char sexo [15]; //en este caso se introduce la cantidad de letras que queramos con []
    float altura;

    cout<<"Introduzca su edad: "; cin>>edad;
    cout<<"\nUsted es sexo masculino o femenino, escriba: "; cin>>sexo;
    cout<<"\nIntroduzca su altura en metros: "; cin>>altura;

    cout<<"\n Su edad es: "<<edad<<endl; cout<<"Usted es de sexo: "<<sexo<<endl; cout<<"Y mide: "<<altura<<endl;


    return 0;
}
