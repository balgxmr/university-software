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

        /* Realizar todo lo siguiente desde aqui ya que este metodo crearMatriz es el unico llamado */
        // Imprimir la matriz A
        System.out.println("Matriz A:");
        imprimirMatrizA(matrizA);

        // Transpuesta de A
        int[][] matrizA1 = transpuestaDeMatrizA(matrizA);
        System.out.println("Transpuesta de A (matriz A1):");
        imprimirMatrizA(matrizA1);
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
    public int[][] transpuestaDeMatrizA(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length; // Se obtiene la longitud de la fila, y representa el número de columnas en la matriz
        
        /* Se cambian las dimensiones de la matriz, ya que es transpuesta */
        int[][] matrizTranspuesta = new int[columnas][filas];
        
        for (int i = 0; i < columnas; i++){
            for (int j = 0; j < filas; j++){
                /* 
                Intercambiando los indices, se asignan 
                los valores como de una matriz transpuesta/invertidos 
                */
                matrizTranspuesta[i][j] = matriz[j][i];
            }
        }
        // se devuelve la matriz transpuesta hacia matrizA1, que se usa en imprimirMatrizA
        return matrizTranspuesta; 
    } // fin transpuesta de matriz A
} // fin class metodo 4