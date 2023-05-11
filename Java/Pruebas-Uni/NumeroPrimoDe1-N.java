// Problema 6
// Capturar un numero N, imprimir todos los numeros primos entre 1 y N 

import java.io.*;

public class Primos {
    public static void main(String[] args) throws IOException {
        
        BufferedReader libro = new BufferedReader(new InputStreamReader(System.in));
        
        boolean loop = true;
        int i, j;
        int numero = 0;
        
        try{
            while(loop){
                // Ingresar valor en C
                System.out.println("Ingresa un numero mayor a 0: ");
                String N = libro.readLine();
                numero = Integer.parseInt(N);
                
                if (numero <= 0)
                    System.out.println("Numero invalido! Ingresa nuevamente.");
                else 
                    loop = false;
            } // while end
            
            System.out.println("Numeros primos entre el 1 y " + numero + ":\n");
            
            for(i = 2; i <= numero; i++) {
                boolean validarNumPrimo = true;
                for(j = 2; j <= i/2; j++) {
                    if(i % j == 0) {
                        validarNumPrimo = false;
                        break;
                    }
                }
                if(validarNumPrimo) {
                    System.out.print(i + ", ");
                }
            }
            
        } catch (Exception e) {
                System.out.println("\n\n*Error*\nIngrese un valor en numeros no en letras \n");
        }
    }
}
