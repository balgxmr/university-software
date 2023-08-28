import java.io.*;

public class Lab1_Problema3 {
    public static void main(String[] args) throws IOException {

        int c = 0;

        BufferedReader read = 
        new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese el numero: ");
        int n = Integer.parseInt(read.readLine());

        if(n < 5 && n > -5 || n < -10){
            System.out.println("Error! El valor actual de n (" + n + ") es incorrecto, los numeros de -4 a 4 no son validos, ni los menores a -10. ");
            System.exit(n);
        }

        for (int i = -20; i <= 2 * n; i++) {
            for (int j = 20; j <= n * n; j++) {
                c = c + 2 * i * j + 4 * j;
            }
        }
        System.out.println("El resultado es de: " + c);
    }
}
