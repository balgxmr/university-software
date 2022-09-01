// 6. Escriba un programa que lea la nota de 4 alumnos y que de el promedio final de los 4 alumnos.

#include<iostream>
using namespace std;

int main(){

    char nombre1 [25], nombre2 [25], nombre3 [25], nombre4 [25];
    float medio_alumno1, medio_alumno2, medio_alumno3, medio_alumno4; 
    float promedio_general = 0;

    cout<<"\nIntroduzca el promedio del alumno 1: "; cin>>medio_alumno1;
    cout<<"Introduzca el promedio del alumno 2: "; cin>>medio_alumno2;
    cout<<"Introduzca el promedio del alumno 3: "; cin>>medio_alumno3;
    cout<<"Introduzca el promedio del alumno 4: "; cin>>medio_alumno4;

    cout<<"\nIntroduzca el nombre del alumno 1: "; cin>>nombre1;
    cout<<"Introduzca el nombre del alumno 2: "; cin>>nombre2;
    cout<<"Introduzca el nombre del alumno 3: "; cin>>nombre3;
    cout<<"Introduzca el nombre del alumno 4: "; cin>>nombre4;


    promedio_general = ((medio_alumno1 + medio_alumno2 + medio_alumno3 + medio_alumno4)/4)+1;
    cout.precision(3);
    cout<<"\nLos estudiantes: "<<nombre1<< ", "<<nombre2<< ", "<<nombre3<<" y "<<nombre4; cout<<" tienen como promedio... ";
    cout<<"\nEl promedio general de los 4 estudiantes es de: "<<promedio_general<<endl;

    return 0;
}