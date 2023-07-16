/* 
 * Grupo 1SF121
 * 
 * Jonathan Núñez (4-823-1010)
 * José Encalada (8-999-1420)
 * Richard Herranz (E-8-192057)
 */

// Importar librerias
import java.io.*;

public class CapturarDatos {
    /* BufferedReader utilizado para leer el input del usuario */
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    /* Método para capturar los datos del usuario, manejando las excepciones con try-catch */
    public String capturarDatos(String message) {
        try {
            System.out.print(message);
            return read.readLine();
        } catch (Exception e) {
            System.out.println("Ingrese un valor valido");
            return capturarDatos(message);
        }
    } // fin capturarDatos()


    /* Valida que el input del usuario esté entre 1 y 5 */
    public int capturarMenu(String message) {
        boolean loop = true;
        int option = 0;
        try {
            while (loop) {
                System.out.print(message);
                option = Integer.parseInt(read.readLine());
                if (option > 5 || option < 0) {
                    System.out.println("Ingrese un valor valido");
                } else {
                    loop = false;
                }
            } // fin while
            return option;
        } catch (Exception e) {
            System.out.println("Ingrese un valor valido");
            return capturarMenu(message);
        }
    } // fin capturarMenu()


    /* Metodo que valida que la posicion sea 1 (inicio) o 2 (final) */
    public int capturarPosicion(String message) {

        boolean loop = true;
        int option = 0;
        try {
            while (loop) {
                System.out.print(message);
                option = Integer.parseInt(read.readLine());
                if (option > 2 || option < 0) {
                    System.out.println("Ingrese un valor valido");
                } else {
                    loop = false;
                }
            }
            return option;
        } catch (Exception e) {
            System.out.println("Ingrese un valor valido");
            return capturarPosicion(message);
        }
    } // fin capturarPosicion()


    /* Valida que el numero ingresado sea valido (un entero) */
    public int capturarNumero(String message) {
        int numero;
        try {
            System.out.print(message);
            numero = Integer.parseInt(read.readLine());
            return numero;
        } catch (Exception e) {
            System.out.println("Ingrese un valor valido");
            return capturarNumero(message);
        }
    } // fin capturarNumero()
} // fin clase CapturarDatos