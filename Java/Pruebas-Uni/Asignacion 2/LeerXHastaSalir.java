// Problema 10
// Crear un programa que se mantenga capturando un valor de variable X hasta que el usuario introduzca la palabra “salir”. 

import java.io.*;

public class LeerXHastaSalir {
    public static void main(String[] args) throws IOException {
        
        BufferedReader libro = new BufferedReader(new InputStreamReader(System.in));
        
        // Declaracion de variables
        boolean loop = true;
        String valor;
        
        while(loop) {
            // Ingresar valor en C
            System.out.println("Ingresa un valor, o escribe 'salir' para finalizar el programa: ");
            valor = libro.readLine();
            valor = valor.toUpperCase(); // convertir a mayusculas
            
            // Evaluar que valor sea igual a "SALIR" usando equals(), y si es asi, finalizar el programa.
            if (valor.equals("SALIR")){
                System.out.println("El programa ha finalizado! Que tengas buen dia c:");
                loop = false;
            } // if end
        } // while end
    } // main end
} // class end
