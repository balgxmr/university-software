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

#define _CRT_SECURE_NO_WARNINGS

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

//constantes globales
const char listaPlacasAutorizadas[15][10] = { "PAK798","GKS682","FRG681","KGS563","SGF952","GSG295","CK7193","FT2553","OT6559","LS5463","967AFW","368SFW","PR5467","SG8786","456BNM" };
const char listaNombresAutorizados[15][30] = { "Richard Herranz","Jose Encalada", "Francisco Perez","Maria Viñas","Jesus Borras","Francisca Casals","Gustavo Valenzuela","Omar Vallejo","Gaspar Andres","Neus Rus","Veronica Coca","Saul Roman","Ana Carballo","Alejandra Otero","Florin Iglesias" };

int espacioDisponible(int registro[])
{
	//bloque de variables
	int i;

	//bloque de instrucciones
	for (i = 0;i < 30;i++)
	{
		if (registro[i] == 0)
		{
			return i;
		}
	}
	return -1;
}

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
			resultado = i + 1;
		}
	}
	return resultado;
}

int verificarEstacionamientosLlenos(int estacionamientos[])
{
	//bloque de variables
	int i, resultado;

	//bloque de instrucciones
	resultado = 0;
	for (i = 0;i < 10;i++)
	{
		if (estacionamientos[i] == 0)
		{
			resultado = 1;
			break;
		}
	}
	return resultado;
}

void volverYSalir()
{
	int salida;
	printf("Introduzca cualquier numero para salir al menú principal: ");
	scanf("%i", &salida);
	if (salida != 478) {
		system("cls");
	}
}

int main()
{
	//bloque de variables
	int operacion, x, numeroEstacionamiento, menu, indice, m, i, identificadorEstacionamientos, j, jose, richard, k, estacionamientosLLenos, lugar;
	int estacionamientos[10] = { 0 };
	int registro[10][30] = { 0,0 };
	char placas[8];

	//bloque de instrucciones
	menu = 0;
	while (menu == 0)
	{
		printf("o-------------------------------------------------------o\n");
		printf("|              Bienvenido al Sistema de la UTP    - ▢ X |\n");
		printf("o-------------------------------------------------------o\n");
		printf("|\t\tQue operacion desea realizar?\t\t|\n|\t\t\t\t\t\t\t|\n");
		printf("| El siguiente listado son las opciones disponibles:\t|\n");
		printf("| 1) Ver estacionamientos ocupados y disponibles.\t|\n");
		printf("| 2) Acceder al estacionamiento.\t\t\t|\n");
		printf("| 3) Salir del estacionamiento.\t\t\t\t|\n");
		printf("| 4) Registro de acceso.\t\t\t\t|\n");
		printf("| 5) Ver el listado de vehículos autorizados.\t\t|\n");
		printf("| 6) Salir del sistema.\t\t\t\t\t|\n");
		printf("o-------------------------------------------------------o\n");
		printf("\n>>> Ingrese su opción: ");
		scanf("%i", &operacion);
		if (operacion <= 0 || operacion > 6) {
			system("cls");
			printf("\nSu opción no es válida! Ingrese una opción correcta, del 1 al 6 como se muestra en el siguiente menú.\n\n");
		}
		switch (operacion)
		{
		case 1:
			system("cls");
			printf("Estacionamientos ocupados y disponibles:\n");
			printf("-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
			k = 0;
			while (k == 0)
			{
				for (i = 0; i < 10; i++)
				{
					if (i == 5) {
						printf("\n");
						printf("-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
					}
					if (estacionamientos[i] != 0)
					{
						printf("|\t\033[31mEspacio %i ocupado.\033[0m\t|", i + 1);
					}
					else if (estacionamientos[i] == 0)
					{
						printf("|\t\033[32mEspacio %i disponible.\033[0m\t|", i + 1);
					}
				}
				printf("\n");
				k = k + 1;
			}
			printf("-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
			printf("\n");
			volverYSalir();
			break;
		case 2:
			system("cls");
			printf("Para acceder al estacionamiento, ingrese la placa de su carro: ");
			scanf("%s", &placas);
			indice = verificarPlacas(placas);
			if (indice > 0)
			{
				printf("-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
				if (strlen(listaNombresAutorizados[indice - 1]) < 15)
				{
					printf("|\t\t\t\t\t\t\t\tBienvenido %s\t\t\t\t\t\t\t\t\t\t|\n", listaNombresAutorizados[indice - 1]);
				}
				else
				{
					printf("|\t\t\t\t\t\t\t\tBienvenido %s\t\t\t\t\t\t\t\t\t|\n", listaNombresAutorizados[indice - 1]);
				}
				printf("-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
				identificadorEstacionamientos = -1;
				for (i = 0; i < 10; i++)
				{
					if (estacionamientos[i] == indice)
					{
						printf("|                                                   Su carro ya esta estacionado en el espacio numero %i.                                                        |\n", i + 1);
						printf("-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
						k = 0;
						while (k == 0) // Inicio de la tabla para mostrar el espacio actual del propietario.
						{
							for (i = 0; i < 10; i++)
							{
								if (i == 5)
								{
									printf("\n");
									printf("-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
								}
								if (estacionamientos[i] == indice)
								{
									printf("|\t\033[33mEspacio %i\033[0m\t\t|", i + 1);
									estacionamientos[i] = 0;
								}
								else
								{
									if (estacionamientos[i] != 0)
									{
										printf("|\t\033[31mEspacio %i ocupado.\033[0m\t|", i + 1);
									}
									else if (estacionamientos[i] == 0)
									{
										printf("|\t\033[32mEspacio %i disponible.\033[0m\t|", i + 1);
									}
								}
							}
							printf("\n");
							k = k + 1;
						}
						printf("-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
						printf("\n"); // Fin de la tabla que muestra el espacio actual del propietario.
						printf("Puede retirarlo ingresando a la opción numero 3 del menú.\n");
						identificadorEstacionamientos = i;
					}
				}
				if (identificadorEstacionamientos == -1)
				{
					k = 0;
					while (k == 0)
					{
						for (i = 0; i < 10; i++)
						{
							if (i == 5)
							{
								printf("\n");
								printf("-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
							}
							if (estacionamientos[i] != 0)
							{
								printf("|\t\033[31mEspacio %i ocupado.\033[0m\t|", i + 1);
							}
							else if (estacionamientos[i] == 0)
							{
								printf("|\t\033[32mEspacio %i disponible.\033[0m\t|", i + 1);
							}
						}
						printf("\n");
						k = k + 1;
					}
					printf("-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
					printf("\n");
					estacionamientosLLenos = verificarEstacionamientosLlenos(estacionamientos);
					if (estacionamientosLLenos == 1)
					{
						x = 0;
						while (x == 0)
						{
							printf("Seleccione en cual espacio disponible desea estacionar su vehiculo: ");
							scanf("%i", &numeroEstacionamiento);
							if ((numeroEstacionamiento < 1) || (numeroEstacionamiento > 10))
							{
								printf("El estacionamiento %i no es valido! Seleccione un estacionamiento de los disponibles.\n", numeroEstacionamiento);
								x = 0;
							}
							else if (estacionamientos[numeroEstacionamiento - 1] == 0)
							{
								estacionamientos[numeroEstacionamiento - 1] = indice;
								lugar = espacioDisponible(registro[numeroEstacionamiento - 1]);
								if (lugar >= 0)
								{
									registro[numeroEstacionamiento - 1][lugar] = indice;
								}
								x = 1;
								printf("\033[32mSu carro ha sido reservado en el espacio %i.\033[0m\n", numeroEstacionamiento);
							}
							else 
							{
								printf("Ese estacionamiento esta actualmente ocupado, seleccione otro. \n");
							}
						}
					}
					else
					{
						printf("Todos los estacionamientos estan ocupados actualmente, porfavor regrese mas tarde. \n");
					}
				}

			}
			else
			{
				printf("Su placa no esta registrada en nuestro sistema, por lo tanto no tiene acceso al estacionamiento. \n");
			}
			volverYSalir();
			break;
		case 3:
			system("cls");
			printf("Para salir del estacionamiento, ingrese la placa de su carro: ");
			scanf("%s", &placas);
			indice = verificarPlacas(placas);
			if (indice > 0)
			{
				m = -1;
				for (i = 0;i < 10;i++)
				{
					if (estacionamientos[i] == indice)
					{
						printf("Bienvenido %s\n", listaNombresAutorizados[indice - 1]);
						printf("Su carro se encuentra en el estacionamiento numero %i\n", i + 1);
						printf("-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
						k = 0;
						while (k == 0) // Inicio de la tabla para mostrar el espacio actual del propietario.
						{
							for (i = 0; i < 10; i++)
							{
								if (i == 5)
								{
									printf("\n");
									printf("-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
								}
								if (estacionamientos[i] == indice)
								{
									printf("|\t\033[33mEspacio %i\033[0m\t\t|", i + 1);
									estacionamientos[i] = 0;
									m = i;
								}
								else
								{
									if (estacionamientos[i] != 0)
									{
										printf("|\t\033[31mEspacio %i ocupado.\033[0m\t|", i + 1);
									}
									else if (estacionamientos[i] == 0)
									{
										printf("|\t\033[32mEspacio %i disponible.\033[0m\t|", i + 1);
									}
								}
							}
							printf("\n");
							k = k + 1;
						}
						printf("-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
						printf("\n"); // Fin de la tabla que muestra el espacio actual del propietario.
					}
				}
				if (m < 0)
				{
					printf("Usted aun no ha estacionado su carro, puede ir a la opcion numero 2 para estacionarlo\n");
				}
			}
			else
			{
				printf("Su placa no esta registrada en nuestro sistema, por lo tanto no tiene acceso al estacionamiento");
			}
			volverYSalir();
			break;
		case 4:
			printf("\n----------------------------------------------------------\n");
			printf("|       Historial de entrada al estacionamiento          |\n");
			printf("----------------------------------------------------------\n");
			printf("|Estacionamientos|            Entradas\n");
			printf("------------------\n");
			for (i = 0;i < 10;i++)
			{
				printf("|        %i)\t|", i + 1);
				for (j = 0;j < 30;j++)
				{
					if (registro[i][j] == 0)
					{
						printf("\t");
					}
					else if (registro[i][j] != 0)
					{
						printf(" [ %s (%s) ]", listaNombresAutorizados[registro[i][j] - 1], listaPlacasAutorizadas[registro[i][j] - 1]);
					}
				}
				printf("------------------\n");
			}
			volverYSalir();
			break;
		case 5:
			system("cls");
			printf("\n--------------------------------------------------------\n");
			printf("|              Registro de personal autorizado          |\n");
			printf("----------------------------------------------------------\n");
			printf("| n°\t|PROPIETARIO\t\t|\tPLACA\t\t|\n");
			richard = 1;
			jose = 0;
			while (richard < 16) {
				if (strlen(listaNombresAutorizados[jose]) < 15)
				{
					printf("----------------------------------------------------------\n");
					printf("| %i)\t|%s\t\t|\t%s\t\t|\n", richard, listaNombresAutorizados[jose], listaPlacasAutorizadas[jose]);
				}
				else
				{
					printf("----------------------------------------------------------\n");
					printf("| %i)\t|%s\t|\t%s\t\t|\n", richard, listaNombresAutorizados[jose], listaPlacasAutorizadas[jose]);
				}
				listaNombresAutorizados[jose];
				listaPlacasAutorizadas[jose];
				jose = jose + 1;
				richard = richard + 1;
			}
			printf("----------------------------------------------------------\n\n");
			volverYSalir();
			break;
		case 6:
			system("cls");
			printf("Usted ha seleccionado la opción 6.\n");
			printf("El programa ha finalizado. ¡Hasta pronto! La UTP le desea que tenga un buen día.\n\n");
			menu = 1;
			break;
		}
	}
	return 0;
}
