// Jonathan Nuñez 4-823-1010, Richard Herranz E-8-192057, José Encalada 8-999-1420

// Importación de librerias
import java.io.*;

public class CapturarDatos {

    /* BufferedReader usado para leer el input */
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    public String capturarDatos(String message) {
        try {
            System.out.println(message);
            return read.readLine();
        } catch (Exception e) {
            System.out.println("Ingrese un valor valido");
            return capturarDatos(message);
        } // fin try-catch
    } // fin capturarDatos

    // Captura las notas del estudiante
    public float capturarNotas(String message) {
        boolean loop = true;
        float grade = 0;
        try {
            while (loop) {
                System.out.println(message);
                grade = Float.parseFloat(read.readLine());
                if (grade > 5.00 || grade < 0) {
                    System.out.println("El indice tiene que estar en el rango de 0 a 5");
                } else {
                    loop = false;
                } // fin if-else
            } // fin while
            return grade;
        } catch (Exception e) {
            System.out.println("Ingrese un valor valido");
            return capturarNotas(message);
        } // fin try-catch
    } //fin capturarNotas

    // Captura valores ingresados en el Menu
    public int capturarMenu(String message) {
        boolean loop = true;
        int option = 0;
        try {
            while (loop) {
                System.out.println(message);
                option = Integer.parseInt(read.readLine());
                // Verificar que la opcion de Menu sea valida 
                if (option > 5 || option < 0) {
                    System.out.println("Ingrese un valor valido");
                } else {
                    loop = false;
                } // fin if-else
            } // fin while
            return option;
        } catch (Exception e) {
            System.out.println("Ingrese un valor valido");
            return capturarMenu(message);
        } // fin try-catch
    } // fin capturarMenu
} // fin class CapturarDatos