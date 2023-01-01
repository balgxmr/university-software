/*  check
 * https://www.youtube.com/watch?v=4_2BEgOFd0E
 * https://stackoverflow.com/questions/46615620/c-structures-initializing-using-for-loop 
*/

#define BUFFER_SIZE 4096
#define F_FECHA 3
#define CASES_AMOUNT 3
#define ANIO_ACTUAL 2023

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

int dia[100][F_FECHA];
int mes[100][F_FECHA];
int anio[100][F_FECHA];

void salida(){
	int salida;
	printf("\nIntroduzca cualquier numero para salir al menú principal: ");
	scanf("%i", &salida);
	if (salida != BUFFER_SIZE) {
		system("clear");
	}
}

int main(void){
    char **nombresCumpleaneros;
    int total = 0, eleccion = 0;

    while(true && eleccion != CASES_AMOUNT){
        printf("Que quieres hacer? \n");
        printf("1) Ver lista de cumpleañeros.\n");
        printf("2) Guardar cumpleaños de alguien.\n");
        printf("3) Salir.\n");
        scanf("%d", &eleccion);

        switch (eleccion)
        {
        case 1:
            system("clear");
            printf("Has seleccionado ver la lista de cumpleañeros!\n");
            if(total <= 0){
                printf("Aún no has guardado a ningún cumpleañero! \n");
                break;
            } else {
            for(int i = 0; i < total; i++){
                printf("\n%d) %s ", i + 1, nombresCumpleaneros[i]);
                printf("\nCumple el día: %d %d %d\n\n", dia[i][0], mes[i][0], anio[i][0]);
            }
            }
            printf("\n");
            salida();
            break;

        case 2:
            system("clear");
            printf("Cuantos cumpleaneros quieres guardar?");
            scanf("%d", &total);

            nombresCumpleaneros = malloc(total * sizeof(char *));

            char nombres[BUFFER_SIZE];
            int largo = 0;

            while(getchar() != '\n'); // Truco para borrar el salto de linea que obtenemos en el primer scanf.

            printf("\n");

            for(int i = 0; i < total; i++){
                // Asking the name of the cumpleañero
                system("clear");
                printf("\nIntroduzca el nombre del cumpleañero %d: ", i + 1);
                fgets(nombres, BUFFER_SIZE, stdin);
                largo = strlen(nombres); // largo en int de nombres
                nombres[largo - 1] =  '\0'; // borra el ultimo coso, el salto de linea invisible ese ya tu sabe xd
                nombresCumpleaneros[i] = malloc(largo * sizeof(char));
                strcpy(nombresCumpleaneros[i], nombres);

                // Asking the date of the cumpleañero
                int fechaValida = 0;
                while(fechaValida != 1){
                    printf("\nCumple el día:  ");
                    scanf("%d", dia[i]);
                    printf("\nCumple el mes: ");
                    scanf("%d", mes[i]);
                    printf("\nCumple el año: ");
                    scanf("%d", anio[i]);
                    printf("\n");

                    if(dia[i][0] > 33 || dia[i][0] < 1 || mes[i][0] < 1 || mes[i][0] > 12 || anio[i][0] < 1900 || anio[i][0] > ANIO_ACTUAL){
                        printf("Una de sus fechas está incorrecta, corrijala nuevamente! \n");
                        fechaValida = 0;
                    } else {
                        int xd = 1;
                        while (true && xd == 1){
                            printf("Su fecha es: Dia: %d , Mes: %d , Año: %d\n", dia[i][0], mes[i][0], anio[i][0]);
                            printf("\nSi desea corregirla, introduzca 1, si desea continuar presione 0. \n");
                            scanf("%d", &xd);
                            if(xd == 1){
                                fechaValida = 0;
                                xd = 0;
                            } else if (xd == 0){
                                fechaValida = 1;
                            } else {
                                printf("Introduce un número correcto!\n");
                                fechaValida = 1;
                                xd = 1;
                            }
                        }
                    }
                }

                while(getchar() != '\n'); // Truco para borrar el salto de linea que obtenemos en el primer scanf.
            }
            salida();
            break;

        default:
            break;
        }
    }
}
