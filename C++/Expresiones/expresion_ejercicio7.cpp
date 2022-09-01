/* 7. La calificación final de un estudiante es el promedio de 3 notas.

-La nota de prácticas que cuenta un 30% del total.
-La nota teórica que cuenta un 60%.
-La nota de participación que cuenta con un 10% restante.

Escriba un programa que lea las 3 notas del alumno y escriba su nota final.

*/

#include<iostream>

using namespace std;

int main(){

    float practica, teorica, participacion, cal_final = 0;
    char name_estudiante[70];

    cout<<"SISTEMA EVALUADO EN TABLA ESCOLAR DEL MEDUCA DEL 1 AL 5";
    cout<<"\nPor favor, ingrese el nombre completo de estudiante: "; cin>>name_estudiante;
    cout<<"\nIntroduzca la nota de prácticas: "; cin>>practica;
    cout<<"Introduzca la nota teórica: "; cin>>teorica;
    cout<<"Introduzca la nota de participación: "; cin>>participacion;

    cal_final = (practica*0.30)+(teorica*0.60)+(participacion*0.1);

    cout.precision(3);
    cout<<"\n La calificacion final del estudiante "<<name_estudiante<<" es de: "<<cal_final;


    return 0;
}