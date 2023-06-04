#include <stdio.h>
#include <string.h>
int main() {
  int i;
  char nombres[6][10] = {"Jairo", "Angelica", "Mariana",
                         "Jose",  "Pedro",    "Juan"};
  char alum[10];
  int cont = 0;
  printf("aaa \n");
  scanf("%s", alum);
  for (i = 0; i < 6; i++) {
    if (strcmp(nombres[i], alum) == 0) {
      printf("El estudiante %s si está dentro del listado.", nombres[i]);
    } else {
      cont++;
    }
  }
  if (cont == 6) {
    printf("El estudiante %s no se encuentra dentro del listado.", alum);
  }
  return 0;
}
