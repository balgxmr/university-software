//
// Copyright (C) 2022 Richard Herranz & José M. (balgxmr/baalgx)
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


// Algoritmo Semestral de Principios de Programacion

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

#define _CRT_SECURE_NO_WARNINGS

//constantes globales
const char listaPlacasAutorizadas[15][10] = { "PAK798","GKS682","FRG681","KGS563","SGF952","GSG295","CK7193","FT2553","OT6559","LS5463","967AFW","368SFW","PR5467","SG8786","456BNM" };
const char listaNombresAutorizados[15][30] = { "Richard Herranz","Jose Encalada", "Francisco Asis Perez","Maria Milagros Vinas","Jesus Borras","Francisca Casals","Gustavo Valenzuela","Omar Vallejo","Gaspar Andres","Neus Rus","Veronica Coca","Saul Roman","Anastasio Carballo","Alejandra Otero","Florin Iglesias" };

int verificarPlacas(char placas[])
{
	//bloque de variables
	int i, resultado;

	//bloque de instrucciones
	resultado = -1;
	for (i = 0;i < 16;i++)
	{
		if (strcmp(listaPlacasAutorizadas[i], placas) == 0)
		{
			resultado = i;
		}
	}
	return resultado;
}

int main() 
{
	//bloque de variables
	int operacion, x, y, numeroEstacionamiento, menu, indice, m, i, identificadorEstacionamientos, w, z, salida, resultado, j;
	char nombres[30];
	int estacionamientos[10];
	char placas[8];
	char imprimirNombre[30];
	int registro[10][30] = { 0,0 };

	//bloque de instrucciones
    printf("--------------------------------------------------------\n"); 
    printf("           Bienvenido al Sistema de la UTP.\n"); 
    printf("--------------------------------------------------------\n"); 
	menu = 0;
	estacionamientos[0] = -1;
	estacionamientos[1] = -1;
	estacionamientos[2] = -1;
	estacionamientos[3] = -1;
	estacionamientos[4] = -1;
	estacionamientos[5] = -1;
	estacionamientos[6] = -1;
	estacionamientos[7] = -1;
	estacionamientos[8] = -1;
	estacionamientos[9] = -1;
	while (menu == 0)
	{
        printf("El siguiente listado son las opciones disponibles:\n"); 
        printf("1) Ver estacionamientos ocupados y disponibles.\n"); 
        printf("2) Acceder al estacionamiento.\n");
        printf("3) Salir del estacionamiento.\n");
        printf("4) Registro de acceso.\n");
        printf("5) Ver el listado de vehículos autorizados.\n");
        printf("6) Salir del sistema.\n");
        printf("\n>>> Ingrese su opción: ");
        scanf("%i",&operacion); 
        if(operacion<=0||operacion>6){
            system("clear");
            printf("\nSu opción no es válida! Ingrese una opción correcta, del 1 al 6 como se muestra en el siguiente menú.\n\n");
        }
		switch (operacion)
		{
		case 1:
            system("clear");
			for (i = 0; i < 10; i++)
			{
				if (estacionamientos[i] != -1)
				{
					printf("El espacio %i esta ocupado\n\n", i+1);
				}
				else if (estacionamientos[i] == -1)
				{
					printf("El espacio %i esta disponible\n\n", i+1);
				}
			}
			printf("Introduzca 0 para salir al menú principal: ");
            scanf("%i",&salida);
            if(salida==0){
                system("clear");
                break;
            }
		case 2:
            system("clear");
			printf("Ingrese la placa de su carro: ");
			scanf("%s", &placas);
			indice = verificarPlacas(placas);
			if (indice >= 0)
			{
				printf("Bienvenido %s \n", listaNombresAutorizados[indice]);
				identificadorEstacionamientos = -1;
				for (i = 0; i < 11; i++)
				{
					if (estacionamientos[i] == indice)
					{
						printf("Su carro ya esta estacionado en el espacio numero %i.\n\n",i+1);
						printf("Puede retirarlo en la opcion numero 3.\n\n");
						identificadorEstacionamientos = i;
					}
				}
				if (identificadorEstacionamientos == -1)
				{
					for (i = 0; i < 10; i++)
					{
						if (estacionamientos[i] != -1)
						{
							printf("El espacio %i esta ocupado\n", i + 1);
						}
						else if (estacionamientos[i] == -1)
						{
							printf("El espacio %i esta disponible\n", i + 1);
						}
					}
					x = 0;
					while (x == 0)
					{
						printf("En cual espacio disponible quiere estacionar su vehiculo: ");
						scanf("%i", &numeroEstacionamiento);
						if (estacionamientos[numeroEstacionamiento - 1] == -1)
						{
							estacionamientos[numeroEstacionamiento - 1] = indice;
							x = 1;
                            printf("Su carro se ha estacionado en el espacio %i.\n\n",numeroEstacionamiento);
						}
						else
						{
							printf("Ese estacionamiento esta actualmente ocupado, seleccione otro: ");
						}
					}
						
				}
				
			}
			else
			{
				printf("Su placa no esta registrada en nuestro sistema, por lo tanto no tiene acceso al estacionamiento.\n\n");
			}
			printf("Introduzca 0 para salir al menú principal: ");
            scanf("%i",&salida);
            if(salida==0){
                system("clear");
                break;
            }
		case 3:
            system("clear");
			printf("Ingrese la placa de su carro\n");
			scanf("%s", &placas);
			indice = verificarPlacas(placas);
			if (indice >= 0)
			{
				m = -1;
				for (i = 0;i < 11;i++)
				{
					if (estacionamientos[i] == indice)
					{
						printf("\nBienvenido %s\n", listaNombresAutorizados[indice]);
						printf("Su carro se encuentra en el estacionamiento numero %i.\n", i+1);
						estacionamientos[i] = -1;
						printf("Tenga buen dia.\n");
						m = i;
					}
				}
                if (m <= 0)
				{
					printf("Usted aun no ha estacionado su carro, puede ir a la opcion numero 2 para estacionarlo.\n\n");
				}
			}
			else
			{
				printf("Su placa no esta registrada en nuestro sistema, por lo tanto no tiene acceso al estacionamiento.\n\n");
			}
			printf("Introduzca 0 para salir al menú principal: ");
            scanf("%i",&salida);
            if(salida==0){
                system("clear");
                break;
            }

		case 4:
			for (i = 0;i < 10;i++)
			{
				for (j = 0;j < 30;j++)
				{
					if (registro[i][j] != 0)
					{
						printf("Estacionamiento numero %s", listaNombresAutorizados[registro[i][j] - 1]); //aqui es donde hay q imprimir un registro con la placa y el nombre de quienes entraron a cada estacionamiento
					}
				}
			}
			break;

		case 5:
		    system("clear");
            printf("\n----------------------------------------------------------\n");
            printf("|              Registro de personal autorizado          |\n");
            printf("----------------------------------------------------------\n");
            printf("| n°\t|PROPIETARIO\t\t|\tPLACA\t\t|\n");
            w=0;
            z=0;
            resultado=0;
            while(w<15){
                if(strlen(listaNombresAutorizados[w])<15){
                    printf("----------------------------------------------------------\n");
                    printf("| %i)\t|%s\t\t|\t%s\t\t|\n",w,listaNombresAutorizados[z],listaPlacasAutorizadas[z]);
                }
                else
                {
                    printf("----------------------------------------------------------\n");
                    printf("| %i)\t|%s\t|\t%s\t\t|\n",w,listaNombresAutorizados[z],listaPlacasAutorizadas[z]);
                }
                listaNombresAutorizados[w];
                listaPlacasAutorizadas[w];
                z=z+1;
                w=w+1;
                i++;
                
            }
            printf("----------------------------------------------------------\n\n");
            printf("Introduzca 0 para salir al menú principal: ");
            scanf("%i",&salida);
            if(salida==0){
                system("clear");
                break;
            }
			break;

        case 6:
            printf("El programa ha finalizado. Hasta pronto! La UTP le desea que tenga un buen día.\n\n");
			menu = 1;
			break;
		}
	}
	return 0;
}
