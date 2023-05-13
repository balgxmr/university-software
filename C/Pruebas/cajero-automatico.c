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
#include <stdbool.h>

#define CANT_EMPLEADOS 3
#define CANT_CLIENTES 3

/* Variables */
/* REMINDER: USE STRUCTS */

int i, n = 0, usuario = 2, pin, id_usuario, seleccion;
float retiro;
char nombre[100], cedula[15];
bool looper = true;



/* EMPLEADOS */
struct Empleado {
    char nombre[100];
    char cedula[30];
    int pin;
    float saldo;
};

struct Empleado empleado1 = {
    "Jose Manuel",
    "8-999-1002",
    1420,
    1259.30
};

struct Empleado empleado2 = {
    "Antonio Carmona",
    "4-812-1249",
    2503,
    3259.35
};

struct Empleado empleado3 = {
    "Nicole Guerra",
    "6-35-351",
    2506,
    1003.35
};

/* FIN EMPLEADOS */


/* CLIENTES */
struct Cliente {
    char nombre[100];
    char cedula[30];
    int pin;
    float saldo;
};

struct Cliente cliente1 = {
    "Richard Martinez",
    "E-50-29526",
    0105,
    2582.00
};

struct Cliente cliente2 = {
    "David Martinez",
    "8-599-1592",
    0153,
    3593.02
};

struct Cliente cliente3 = {
    "Goatnel Messi",
    "6-395-2592",
    3993,
    6043.15
};

/* FIN CLIENTES */



void verSaldo (int usuario, int id_usuario, struct Empleado* empleado, struct Cliente* cliente);
void retirarDinero (int usuario, int id_usuario, float retiro, struct Empleado* empleado, struct Cliente* cliente);
void cambiarPin(int usuario, int id_usuario, struct Empleado* empleado, struct Cliente* cliente);

int main(){

    struct Empleado empleados[] = {empleado1, empleado2, empleado3};  
    struct Cliente clientes[] = {cliente1, cliente2, cliente3};  
    
    printf("Bienvenido al cajero automático.\n");

    /* Ask the user's name */
    printf("Introduzca su nombre: ");
    fgets(nombre, 100, stdin);
    nombre[strlen(nombre) - 1] = '\0';

    /* Check if the user is an employer or a client */
    for(i = 0; i < CANT_EMPLEADOS; i++){
        if(strcmp(nombre, empleados[i].nombre) == 0){
            printf("Usted es el empleado %s, bienvenido\n\n", empleados[i].nombre);
            id_usuario = i;
            usuario = 0;
        } else if (strcmp(nombre, clientes[i].nombre) == 0){
            printf("Usted es el cliente %s, bienvenido!\n\n", clientes[i].nombre);
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
                if(strcmp(cedula, empleados[id_usuario].cedula) == 0)
                    n = 1;
            }
        break;

    case 1:
            printf("Introduzca su cédula (con guiones): ");
            fgets(cedula, 15, stdin);
            cedula[strlen(cedula) - 1] = '\0';

            for(int y = 0; y < CANT_CLIENTES; y++){
                if(strcmp(cedula, clientes[id_usuario].cedula) == 0)
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
            scanf("%i", &pin);

            for(int y = 0; y < CANT_EMPLEADOS; y++)
                if(pin == empleados[id_usuario].pin)
                    n = 1;
        break;

    case 1:
            printf("Introduzca su PIN: ");
            scanf("%i", &pin);

            for(int y = 0; y < CANT_CLIENTES; y++)
                if(pin == clientes[id_usuario].pin)
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

    while(looper){
        /* MENU */
        printf("-----------MENU-----------\n");
        printf("1. Visualizar saldo actual\n");
        printf("2. Retirar dinero\n");
        printf("3. Cambiar mi PIN actual\n");
        printf("4. Ver últimos movimientos\n");
        printf("5. Salir\n");
        printf("> ");
        scanf("%i", &seleccion);
    
        // Start switch - Menu
        switch (seleccion)
        {
        case 1: // Ver saldo
            verSaldo(usuario, id_usuario, &empleados[id_usuario], &clientes[id_usuario]);
            break;

        case 2: // Retirar dinero
            printf("\nIngrese el dinero a retirar: ");
            scanf("%f", &retiro);

            retirarDinero(usuario, id_usuario, retiro, &empleados[id_usuario], &clientes[id_usuario]);
            verSaldo(usuario, id_usuario, &empleados[id_usuario], &clientes[id_usuario]);
            break;

        case 3: // Cambiar PIN actual
            cambiarPin(usuario, id_usuario, &empleados[id_usuario], &clientes[id_usuario]);
            break;

        case 4: // Ver ultimos movimientos
            break;

        case 5:
            printf("\nGracias por utilizar nuestro cajero automatico, que tengas buen día!");
            looper = false;
            break;
        
        default:
            break;
        } // end switch - Menu
    } // end while


    return 0;
} // main end

void verSaldo (int usuario, int id_usuario, struct Empleado* empleado, struct Cliente* cliente){
    if(usuario == 0)
        printf("\nSu saldo actual es de: %.2f\n\n", empleado[id_usuario].saldo);
    else
        printf("\nSu saldo actual es de: %.2f\n\n", cliente[id_usuario].saldo);
}

void retirarDinero (int usuario, int id_usuario, float retiro, struct Empleado* empleado, struct Cliente* cliente) {
    if(usuario == 0)
        if(retiro >= empleado[id_usuario].saldo) // fix to empleados!!
            printf("Fondos insuficientes!");
        else
            empleado[id_usuario].saldo -= retiro;
    else
        if(retiro >= cliente[id_usuario].saldo)
            printf("Fondos insuficientes!");
        else
            cliente[id_usuario].saldo -= retiro;
}

void cambiarPin(int usuario, int id_usuario, struct Empleado* empleado, struct Cliente* cliente){
    bool loop = true;
    int pinVerifier, newPin;

    /* Ask the user to re-introduce their pin to verify */
    while(loop){
        printf("Introduzca su PIN nuevamente: ");
        scanf("%i", &pinVerifier);

        /* Verification */
        if (usuario == 0){
            if(pinVerifier == empleado[id_usuario].pin)
                loop = false;
        } else {
            if(pinVerifier == cliente[id_usuario].pin)
                loop = false;
        }
    } // while end


    /* Introducir nuevo PIN */
    loop = true;
    while(loop){
        printf("Introduce tu nuevo PIN: ");
        scanf("%i", &newPin);
        getchar();

        char newPinString[5];
        sprintf(newPinString, "%d", newPin);

        if(strlen(newPinString) == 4)
            loop = false;
        else
            printf("Introduce un PIN de 4 dígitos!\n");

    } // while end

    if (usuario == 0) {
            empleado[id_usuario].pin = newPin;
            printf("Tu nuevo PIN es: %i!\n", empleado[id_usuario].pin);
    } else {
            cliente[id_usuario].pin = newPin;
            printf("Tu nuevo PIN es: %i\n", cliente[id_usuario].pin);
    } // if (usuario) end
} // while end
