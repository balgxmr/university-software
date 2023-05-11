// Thursday, May 4, 2023
// Programacion - Software

import java.io.*;

public class suma {

    public static void main(String[] args) throws IOException {

        int var1 = 0;
        int var2 = 0;
        boolean seguir = true;
      
        BufferedReader libro = new BufferedReader(new InputStreamReader(System.in)); 

        while (seguir) {
            try {
                System.out.println("Ingrese el primer numero: ");
                var1 = Integer.parseInt(libro.readLine());

                System.out.println("Ingrese el segundo numero: ");
                var2 = Integer.parseInt(libro.readLine());

                int result = var1 + var2;
                System.out.println("El resultado es: " + result);

                seguir = false;

            } catch (Exception e) {
                System.out.println("\n\n*Error*\nIngrese un valor en numeros no en letras \n");
            }
        }
    }
}
