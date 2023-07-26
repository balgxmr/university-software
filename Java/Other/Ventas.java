/*
 * Program with an array of 30, that will save 30 sales and tell which and how many of these
 * are over 2000$
 */

import java.io.*;

public class Ventas {
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int CANT_VENTAS = 30;
        Float[] ventas = new Float[CANT_VENTAS];
        int cont = 0;

        for(int i = 0; i < CANT_VENTAS; i++){
            try{
            System.out.print("Ingrese la venta #" + (i+1)+ ": ");
            ventas[i] = Float.parseFloat(read.readLine());
            } catch (Exception e){
                System.out.println("Try again! Invalid input");
                i--;
            }
        }

        /* Contar cuales son mayores a 2000 */
        for(int i = 0; i < CANT_VENTAS; i++){
            if(ventas[i] > 2000)
                cont++;
        }

        /* Almacenar las ventas en ventasMayores usando la cantidad (cont) */
        Float[] ventasMayores = new Float[cont];
        int index = 0;
        for(int i = 0; i < CANT_VENTAS; i++){
            if(ventas[i] > 2000){
                ventasMayores[index] = ventas[i];
                index++;
            }
        }

        System.out.println("La cantidad de ventas mayores a 2000$ fue de: " + cont);
        for(int i = 0; i < cont; i++){
            System.out.println("Venta mayor a 2k #" + (i+1)+ ": " + ventasMayores[i]);
        }
    }
}