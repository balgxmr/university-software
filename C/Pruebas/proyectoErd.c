/*
José M. / balgxmr (2023)
Enunciado:
Escriba un programa que cree una estructura de registro para los Estudiantes de una clase de 100
estudiantes. El programa debe calcular cuáles son los 5 estudiantes más sobresalientes de la clase.
Debe generar un listado con los datos de los 5 estudiantes ordenados de mayor a menor.
Los campos del registro son los siguientes:
- Nombre (cadena)
- Cedula (cadena)
- Mes de nacimiento (entero)
- Año (entero)
- Carrera (cadena)
- Índice (flotante)
Es importante destacar que el mes de nacimiento es un valor numérico entero que representa el
mes, en este caso enero(1), febrero(2), Marzo(3)…así sucesivamente, en la salida debe mostrar el
nombre del mes. Considere que ya se ha almacenado la información de los 100 registros de
estudiantes.
Para considerar a un estudiante sobresaliente su índice debe ser superior a 2.5 y el máximo 3.0.
Se recomienda el uso de estructuras de arreglos y de registros.
*/


#include <stdio.h>
#include <stdbool.h>
#include <string.h>

#define MAX_NOMBRE 150   // Cantidad de caracteres que puede contener nombre
#define MAX_CEDULA 12    // Cantidad de caracteres que puede tener cedula, formato X-XXXX-XXXX
#define MAX_CARRERA 40   // Cantidad de caracteres que puede tener cedula

struct Estudiantes
{
    char nombre[MAX_NOMBRE];
    char cedula[MAX_CEDULA];
    int mesNacimiento;
    int anioNacimiento;
    char carrera[MAX_CARRERA];
    float indice;
};

bool validarDatos(int x, int dato) {
    if (x == 1) {
        if (dato > 0 && dato < 13)
            return true;
    } else if (x == 2) {
        if (dato > 1900 && dato < 2023)
            return true;
    }
    return false;
}

int main(){
    int cantEstudiantes = 100;
    struct Estudiantes estudiantes[cantEstudiantes];

    for(int i = 0; i < 5; i++){
        printf("Estudiante #%d:\n", i + 1);
        printf("Ingrese su nombre: ");
        fgets(estudiantes[i].nombre, MAX_NOMBRE, stdin);

        printf("Ingrese su cedula: ");
        fgets(estudiantes[i].cedula, MAX_CEDULA, stdin);

        while(true){
            printf("Ingrese su mes de nacimiento: ");
            scanf("%i", &estudiantes[i].mesNacimiento);
            bool validacionMes = validarDatos(1, estudiantes[i].mesNacimiento);

            if(validacionMes == false){
                printf("Ingrese un valor correcto!\n");
                continue;
            }

            printf("Ingrese su anio de nacimiento: ");
            scanf("%i", &estudiantes[i].anioNacimiento);
            bool validacionAnio = validarDatos(2, estudiantes[i].anioNacimiento);
            getchar();

            if(validacionAnio == false){
                printf("Ingrese un valor correcto!\n");
                continue;
            }

            break;
        } // while end

        printf("Ingrese el nombre de su carrera: ");
        fgets(estudiantes[i].carrera, MAX_CARRERA, stdin);

        printf("Ingrese su indice: ");
        scanf("%f", &estudiantes[i].indice);
        getchar();
    }
}
