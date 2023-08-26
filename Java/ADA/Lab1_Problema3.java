import java.io.*;
import java.lang.Math;

public class Lab1_Problema3 {
    public static void main(String[] args) throws IOException{

        // BufferedReader utilizado para leer el input del usuario
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingresa un numero entero: ");
        int n = Integer.parseInt(read.readLine());

        if(n < 5 && n > -5 || n < -10){
            System.out.println("Error! El valor actual de n (" + n + ") es incorrecto, los numeros de -4 a 4 no son validos, ni los menores a -10. ");
            System.exit(n);
        }

        int valorSum1 = (int) Math.pow(n, 2);
        int valorSum2 = (int) n*2;
        int sum = 0;
       
        for(int i = -20; i <= valorSum2; i++){ // Sumatoria i = -20 hasta 2n
            for(int j = 20; j <= valorSum1; j++){
                sum = sum + (2*i*j) + (4*j);
            }
        }

        System.out.println("El resultado de las sumatorias dobles es de: " + sum);
    }
}