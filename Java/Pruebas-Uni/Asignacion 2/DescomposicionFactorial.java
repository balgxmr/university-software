// Problema 4

import java.io.*;

public class DescomposicionFactorial {
    public static void main(String[] args) throws IOException {
        
        BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            // Ingresar valor en C
            System.out.println("Ingrese un numero: ");
            double numero = Double.parseDouble(lectura.readLine());
            
            
            // Evaluar la descomposicion factorial
            while ( numero % 5 == 0){
                System.out.println(numero + " / 5");
                numero = numero/5;
            }

            while ( numero % 3 == 0){
                System.out.println(numero + " / 3");
                numero = numero/3;
            }

            while(numero % 2 == 0){
                System.out.println(numero + " / 2");
                numero = numero/2;
            }
            // Fin de evaluar descomposicion factorial
            
            
            if(numero == 1){
                System.out.println("1");
            }
            
            if (numero > 1){
                System.out.println("No se puede realizar por descomposicion factorial.");
            }
        } catch (Exception e) {
                System.out.println("\n\n*Error*\nIngrese un valor en numeros no en letras \n");
            }
    }
}
