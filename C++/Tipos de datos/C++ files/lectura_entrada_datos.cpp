//Lectura o entrada de datos

#include<iostream>

using namespace std;

/*

TODO LO QUE ESTÉ DENTRO DE ESTOS SLASH SON COMENTARIOS DE VARIAS LINEAS!
MIRA COMO COMENTO ABAJO SIN ESTAR PONIENDO SLASH TODO EL RATO JIJI

*/

int main(){

    int numero; //en este caso no le asignamos nosotros, si no el usuario. Estamos definiendo la variable

    cout<<"Digite un numero: ";
    cin>>numero; //cin>> hace que el numero que el entero que introduzca el usuario se guarde en "numero". Guardamos la variable

    cout<<"\n El numero que digitaste es: "<<numero; // n salta de linea, y el <<numero después es para que imprima luego de que el cleinte ingrese numero

    return 0;
}