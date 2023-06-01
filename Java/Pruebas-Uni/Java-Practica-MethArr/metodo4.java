import java.io.*;

public class metodo4 {

    /* BufferedReader usado para leer el input */
    BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));

    /* Crear y pedir los elementos de la matriz "A" */
    public void crearMatrizA(int x, int y) throws IOException {
        // Declaracion de variables
        int[][] matrizA = new int[x][y]; // M y N son ingresados por el usuario
        
        System.out.println("Ingrese los elementos de la matriz A:");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print("Ingrese el elemento (" + (i+1) + "," + (j+1) + "): ");
                matrizA[i][j] = Integer.parseInt(lectura.readLine());
            }
        } // fin for

        // Imprimir la matriz A
        System.out.println("Matriz A:");
        imprimirMatrizA(matrizA);
    } // fin crearMatriz

    /* Imprimir la matriz */
    public void imprimirMatrizA(int[][] matriz) {
        // filas (usando la longitud de la matriz, ej: input 2 = 2 filas)
        for (int i = 0; i < matriz.length; i++) {
            // columnas de la matriz
            for (int j = 0; j < matriz[0].length; j++)
                System.out.print(matriz[i][j] + " ");
            System.out.println();
        } // fin for
    } // fin imprimirMatrizA

    /* Traspuesta de A */
}
