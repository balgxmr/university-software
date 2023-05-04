//
// Copyright (C) 2023 José M. (balgxmr)
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/* 
   Any info found in this code is not based on real people. All the data here
   is generated randomly
*/

/*

3. Cajero automático
    a. El cajero automático lo puede utilizar el cliente y el empleado de la sucursal
    b. El cliente deberá identificarse en la terminal antes de realizar cualquier operación
    c. El empleado y el cliente pueden retirar dinero.
    d. Además, podrá cambiar el pin, obtener los últimos movimientos y saldo, y realizar pagos tanto con visa o master card.
    e. El empleado tiene la función de reponer billetes en el cajero
    f. El cualquier reclamo o problema, el cliente debe reportarlo a través del empleado.
    g. El técnico es el único que puede realizar las operaciones de mantenimiento en caso de un daño.
    h. El empleado es el encargado de reportar los daños del cajero al técnico.
    i. Existe un formulario que el cliente debe llenar cada vez que realice un reclamo.

*/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define CANT_EMPLEADOS 5
#define CANT_CLIENTES 5

/* Variables */
/* REMINDER: USE STRUCTS */

int i, n = 0, usuario = 2, id_usuario, seleccion;
char nombre[100];
char empleados[10][100] = {
    "Jose Manuel",
    "Antonio Carmona",
    "Nicole Guerra",
    "Belkis Araúz",
    "Josema Escalante"
};

char clientes[10][100] = {
    "Richard Martinez",
    "David Martinez",
    "Ampeter Casillas",
    "Haaland Pieter",
    "Goatnel Messi"
};

char cedula[15];

char cedulasEmpleados[10][15] = {
    "8-999-1002", // jose manuel
    "4-812-1249", // antonio carmona
    "6-35-351",   // nicole guerra
    "E-8-29526",  // belkis arauz
    "8-1002-120"  // josema escalante
};

char cedulasClientes[10][15] = {
    "E-50-29526", // richard martinez
    "8-599-1592", // david martinez
    "6-992-5949", // ampeter casillas
    "3-100-991",  // haaland pieter
    "8-2587-120"  // goatnel messi
};

char pin[5];

char pinEmpleados[10][5] = {
    "1420", // jose manuel
    "2503", // antonio carmona
    "2506", // nicole guerra
    "1407", // belkis arauz
    "2207"  // josema escalante
};

char pinClientes[10][5] = {
    "0105", // richard martinez
    "0153", // david martinez
    "9893", // ampeter casillas
    "3564", // haaland pieter
    "8824"  // goatnel messi
};

float saldoEmpleados[10] = {
    1920.20, // jose manuel
    1204.20, // antonio carmona
    630.00,  // nicole guerra
    2603.34, // belkis arauz
    3578.07 // josema escalante
};

float saldoClientes[10] = {
    2582.00, // richard martinez
    4623.10, // david martinez
    693.90,  // ampeter casillas
    1005.35, // haaland pieter
    540.05   // goatnel messi
};

int main(){

    /* Ask the user's name */
    printf("Bienvenido al cajero, primero, introduzca su nombre: ");
    fgets(nombre, 100, stdin);
    nombre[strlen(nombre) - 1] = '\0';

    /* Check if the user is an employer or a client */
    for(i = 0; i < CANT_EMPLEADOS; i++){
        if(strcmp(nombre, empleados[i]) == 0){
            printf("Usted es el empleado %s, bienvenido\n\n", empleados[i]);
            id_usuario = i;
            usuario = 0;
        } else if (strcmp(nombre, clientes[i]) == 0){
            printf("Usted es el cliente %s, bienvenido!\n\n", empleados[i]);
            id_usuario = i;
            usuario = 1;
        }
    }
    
    if(usuario != 0 && usuario != 1){
        printf("Usted no está dentro del programa!");
        exit(0);
    }

    /* Ask user the ID (cédula) */
    switch (usuario)
    {
    case 0:
            printf("Introduzca su cédula (con guiones): ");
            fgets(cedula, 15, stdin);
            cedula[strlen(cedula) - 1] = '\0';

            for(int y = 0; y < CANT_EMPLEADOS; y++){
                if(strcmp(cedula, cedulasEmpleados[id_usuario]) == 0)
                    n = 1;
            }
        break;

    case 1:
            printf("Introduzca su cédula (con guiones): ");
            fgets(cedula, 15, stdin);
            cedula[strlen(cedula) - 1] = '\0';

            for(int y = 0; y < CANT_EMPLEADOS; y++){
                if(strcmp(cedula, cedulasClientes[id_usuario]) == 0)
                    n = 1;
            }
    
    default:
        break;
    } // end switch - cédula
    
    if(n == 1)
        printf("Cédula correcta!\n\n");
    else {
        printf("Cédula incorrecta!");
        exit(0);
    }
    
    /* reset n (used to check if user's values are correct) */
    n = 0;
    
    /* Ask the user the PIN */
    switch (usuario)
    {
    case 0:
            printf("Introduzca su PIN: ");
            fgets(pin, 5, stdin);

            for(int y = 0; y < CANT_EMPLEADOS; y++)
                if(strcmp(pin, pinEmpleados[id_usuario]) == 0)
                    n = 1;
        break;

    case 1:
            printf("Introduzca su PIN: ");
            fgets(pin, 5, stdin);

            for(int y = 0; y < CANT_CLIENTES; y++)
                if(strcmp(pin, pinClientes[id_usuario]) == 0)
                    n = 1;
    
    default:
        break;

    } // end switch - PIN
        
    if (n == 1)
        printf("PIN correcto!\n\n");
    else {
        printf("Cédula incorrecta!");
        exit(0);
    }


    /* MENU */
    printf("Qué desea hacer?\n");
    printf("1. Visualizar saldo actual\n");
    printf("2. xd\n");
    printf("> ");
    scanf("%i", &seleccion);

    // Start switch - Menu
    switch (seleccion)
    {
    case 1: // Ver saldo
        printf("Saldo actual: %.2f", saldoEmpleados[id_usuario]);
        break;
    
    default:
        break;
    }
    
    return 0;
}
