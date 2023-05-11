// Problema 8
// Captura un numero binario de 5 digitos y convertirlo a decimal. 10100

import java.io.*;

public class BinaryToDecimal {
    public static void main(String[] args) throws IOException {
        
        BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
        
        // Declaracion de variables
        boolean loop = true;
        int numeroBinario = 0, numeroBinarioLength, valorDecimal = 0, base = 1;
        
        while(loop) {
            // Ingresar valor en C
            System.out.println("Ingresa un numero binario de 5 digitos: ");
            String x = lectura.readLine();
            numeroBinarioLength = x.length();
            
            // Evaluar si es un numero binario, y si es de 5 digitos.
            // !x.matches[01]+ indica que solo puede contener unicamente 0s y 1s.
            // .matches, en este caso hace la misma funcion que el try and catch, por lo cual no es necesario.
            if (numeroBinarioLength != 5 || !x.matches("[01]+")) 
                System.out.println("Numero binario invalido! Ingresa nuevamente.");
            else {
                numeroBinario = Integer.parseInt(x);
                loop = false;
            } // if end
        } // while end
        
        // Convertir a decimal
        int temp = numeroBinario;
        while (temp > 0) {
            int ultimo_digito = temp % 10;
            temp = temp / 10;
            valorDecimal += ultimo_digito * base;
            base = base * 2;
        } // while end

        System.out.println("El numero " + numeroBinario + " en decimal es: " + valorDecimal);

    } // main end
} // class end
