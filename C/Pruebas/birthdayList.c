/*  check
 * https://www.youtube.com/watch?v=4_2BEgOFd0E
 * https://stackoverflow.com/questions/46615620/c-structures-initializing-using-for-loop 
*/

#define BUFFER_SIZE 4096
#define F_FECHA 3

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

int dia[100][F_FECHA];
int mes[100][F_FECHA];
int anio[100][F_FECHA];

int main(void){
    char **nombresCumpleaneros;
    int total = 0, eleccion = 0;

    while(true && eleccion != 3){
        printf("Que quieres hacer? \n");
        printf("1) Ver lista de cumpleañeros.\n");
        printf("2) Guardar cumpleaños de alguien.\n");
        printf("3) Salir.\n");
        scanf("%d", &eleccion);

        switch (eleccion)
        {
        case 1:
            system("cls");
            printf("Has seleccionado ver la lista de cumpleañeros!\n");
            if(total <= 0){
                printf("Aún no has guardado a ningún cumpleañero! \n");
                break;
            } else {
            for(int i = 0; i < total; i++){
                printf("\nCumpleañero n%d es %s", i + 1, nombresCumpleaneros[i]);
                for(int j = 0; j < total - 1; j++){ 
                    printf("\nY su dia de nacimiento fue el: %d %d %d", dia[i][j], mes[i][j], anio[i][j]);
                    }
                }
            }
            printf("\n");
            break;

        case 2:
            system("cls");
            printf("Cuantos cumpleaneros quieres guardar?");
            scanf("%d", &total);

            nombresCumpleaneros = malloc(total * sizeof(char *));

            char nombres[BUFFER_SIZE];
            int largo = 0;

            while(getchar() != '\n'); // Truco para borrar el salto de linea que obtenemos en el primer scanf.

            printf("\n");

            for(int i = 0; i < total; i++){
                printf("\nIntroduzca el nombre del cumpleañero %d: ", i + 1);
                fgets(nombres, BUFFER_SIZE, stdin);
                largo = strlen(nombres); // largo en int de nombres
                nombres[largo - 1] =  '\0'; // borra el ultimo coso, el salto de linea invisible ese ya tu sabe xd
                nombresCumpleaneros[i] = malloc(largo * sizeof(char));
                strcpy(nombresCumpleaneros[i], nombres);

                printf("%d", i);
                printf("\nCumple el día:  ");
                scanf("%d", &dia[i]);
                printf("\nCumple el mes: ");
                scanf("%d", &mes[i]);
                printf("\nCumple el año: ");
                scanf("%d", &anio[i]);
                printf("\n");

                while(getchar() != '\n'); // Truco para borrar el salto de linea que obtenemos en el primer scanf.
            }
            break;

        default:
            break;
        }
    }
}
