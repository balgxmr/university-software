// Problema 6
// Capturar un numero N, imprimir todos los numeros primos entre 1 y N 

import java.io.*;

public class NumeroPrimoDe1aN {
    public static void main(String[] args) throws IOException {
        
        BufferedReader libro = new BufferedReader(new InputStreamReader(System.in));
        
        // Declaracion de variables
        boolean loop = true;
        int numero = 0;
        
        try{
            while(loop){
                // Ingresar valor en C
                System.out.println("Ingresa un numero mayor a 0: ");
                numero = Integer.parseInt(libro.readLine());
                
                if (numero <= 0)
                    System.out.println("Numero invalido! Ingresa nuevamente.");
                else 
                    loop = false;
            } // while end
            
            System.out.println("Numeros primos entre el 1 y " + numero + ":\n");
            
            for(int i = 2; i <= numero; i++) {     // Este bucle itera sobre todos los números enteros desde 2 hasta el número dado.
                boolean validarNumPrimo = true;    // Usado para saber si el numero es primo o no. Se inicializa al comienzo del 1er for.
                for(int j = 2; j <= i/2; j++) {    // Ejecuta desde 2 hasta la mitad de N, comprueba si "i" es divisible entre 2 o su mitad
                    if(i % j == 0) {               // Si es divisible, "i" no es primo, procede a:
                        validarNumPrimo = false;   // validarNumPrimo = verdadero (rompe ciclo)
                        break;                      
                    }
                } // j for end

                if(validarNumPrimo) {  // Si validarNumPrimo = true, imprime el numero primo
                    System.out.print(i + ", ");
                } // if end
            } // i for end
            
        } catch (Exception e) {
                System.out.println("\n\n*Error*\nIngrese un valor en numeros no en letras \n");
        }
    } // main end
} // class end
