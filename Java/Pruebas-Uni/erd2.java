import java.io.*;
import java.util.Arrays;

public class Proyecto1 {
    public static void main (String[] args) throws IOExeption {
        int[] arrayNumeros = new int[6];
        int cima, dato;
        int max = 6;

        BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));

        System.out.printf("Ingrese un dato: ");
        dato = Integer.parseInt(lectura.readline());
        
        // algoritmo de insercion
        if(cima < max){
            cima += 1;
            arrayNumeros[cima] = dato;
        } else {
            System.out.printf("Desbordamiento");
        }

        // algoritmo de eliminiacion
        if(cima > 0){
            int x = arrayNumeros[cima];
            arrayNumeros[] = ArrayUtils.removeElement(arrayNumeros, x);
            cima -= 1;
        
        } else {
            System.out.printf("Subesbordamiento");
        }
    }
}
