import java.io.*;

public class Battleship {
    public static void main(String[] args) throws IOException, InterruptedException {
        /* Inicializacion de variables */
        String firstPlayer;
        String secondPlayer;

        /* Usado para leer el input del usuario */
        BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));

        /* Mensaje bienvenida */
        System.out.print(Colors.GREEN + """
Bienvenido a Battleship!

Battleship es un juego que combina conceptos matemáticos 
y razonamiento lógico con estrategia naval. El principal 
objetivo es hundir la flota de barcos enemiga tratando de 
adivinar las coordenadas de su ubicación en el tablero.

                """ + Colors.RESET_COLOR);

        boolean continuar = true;
        while(continuar){
            System.out.printf("Escriba C para continuar, exit para salir: ");
            String seleccion = lectura.readLine();

            Exit.CerrarPrograma(seleccion);

            if(seleccion.equals("C") || seleccion.equals("c") || seleccion.equals("continuar") || seleccion.equals("CONTINUAR")){
                Clean.clean();
                continuar = false;
            } else {
                continuar = true;
            }
        }

        /* Pedir nombre jugador 1 - 2 */
        System.out.printf("Introduzca el nombre del jugador 1: ");
        firstPlayer = lectura.readLine();

        System.out.printf("Introduzca el nombre del jugador 2: ");
        secondPlayer = lectura.readLine();

        System.out.println("Bienvenidos " + firstPlayer + " y " + secondPlayer);
    }
}