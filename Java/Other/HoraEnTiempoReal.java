package HoraEnTiempoReal;
import java.io.*;

public class HoraEnTiempoReal {
    public static void main(String[] args) throws InterruptedException, IOException {

        /* Declaracion de variables */
        int horas = 0, minutos = 0, segundos = 0;
        
        BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            try {
                /* Input usuario */
                System.out.printf("Ingrese la hora (formato 24h): ");
                horas = Integer.parseInt(lectura.readLine());

                if(horas > 24 || horas < 0)
                    throw new IOException();

                System.out.printf("Ingrese los minutos: ");
                minutos = Integer.parseInt(lectura.readLine());

                if(minutos > 60 || minutos < 0)
                    throw new IOException();

                System.out.printf("Ingrese los segundos: ");
                segundos = Integer.parseInt(lectura.readLine());

                if(segundos > 60 || segundos < 0)
                    throw new IOException();

                break;

            } catch (Exception e) {
                System.out.println("Invalido, intenta nuevamente!");
            }
        } // fin while - input

        while (true){
            /* Si la hora/min/seg es 
            < 10, imprimir 0 */
            
            if (horas < 10)
                System.out.print(":");
            
            System.out.print(horas + ":");

            if (minutos < 10)
                System.out.print(":");

            System.out.print(minutos + ":");

            if (segundos < 10)
                System.out.print(":");

            System.out.println(segundos);

            /* FIN IMPRESION DEL TIEMPO */

            // Aumentar tiempo
            segundos++;

            /* Lógica del tiempo */
            // Resetear seg. cuando == 60
            if (segundos == 60){
                segundos = 0;
                minutos++;

                // Resetear min. cuando == 60
                if (minutos == 60){
                    minutos = 0;
                    horas++;

                    // Resetear horas si == 24
                    if (horas == 24)
                        horas = 0;
                }
            } // fin Reseteo

            // Dormir el programa XD por 1 segundo
            Thread.sleep(1000);

        } // fin while
    } // fin main
} // fin class
