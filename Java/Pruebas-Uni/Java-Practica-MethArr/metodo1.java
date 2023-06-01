/* 
En un método externo escribir un programa que permita cargar en un arreglo de dos 
dimensiones de 6 x 6, y se debe auto-cargar solo con números pares. Imprimir el arreglo
*/

public class metodo1 {
    public int[][] cargarArreglo() {
        int[][] arreglo = new int[6][6];
        
        int num = 2;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arreglo[i][j] = num;
                num += 2;
            }
        }
        return arreglo;
    }
    
    /* 
     * Se crea un arreglo de 6*6, y va cargadndo este mismo
     * con valores pares, comenzando desde el 2.
     */
    public void imprimirArreglo(int[][] arreglo) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(arreglo[i][j] + " ");
            }
            System.out.println();
        }
    }
}
