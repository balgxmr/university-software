import java.io.*;

public class CapturarDatos {

    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    public String capturarDatos(String message) {

        try {
            System.out.println(message);
            return read.readLine();
        } catch (Exception e) {
            System.out.println("Ingrese un valor valido");
            return capturarDatos(message);
        }
    }

    public int capturarMenu(String message) {

        boolean loop = true;
        int option = 0;
        try {
            while (loop) {
                System.out.println(message);
                option = Integer.parseInt(read.readLine());
                if (option > 5 || option < 0) {
                    System.out.println("Ingrese un valor valido");
                } else {
                    loop = false;
                }
            }
            return option;
        } catch (Exception e) {
            System.out.println("Ingrese un valor valido");
            return capturarMenu(message);
        }
    }

    public int capturarPosicion(String message) {

        boolean loop = true;
        int option = 0;
        try {
            while (loop) {
                System.out.println(message);
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
    }

    public int capturarNumero(String message) {

        int numero;
        try {
            System.out.println(message);
            numero = Integer.parseInt(read.readLine());
            return numero;
        } catch (Exception e) {
            System.out.println("Ingrese un valor valido");
            return capturarNumero(message);
        }

    }
}