import java.io.*;

public class Capturas {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    public String capturarDatos(String message) {
        try {
            System.out.print(message);
            return read.readLine();
        } catch (Exception e) {
            System.out.println("Ingrese un valor valido");
            return capturarDatos(message);
        }
    }

    public int validarFechas(String message, boolean value) {
        int fecha;
        try {
            System.out.print(message);
            fecha = Integer.parseInt(read.readLine());
            if (value) {
                if (fecha > 0 && fecha < 13)
                    return fecha;
                else
                    throw new Exception();
            } else {
                if (fecha > 1900 && fecha < 2023)
                    return fecha;
                else
                    throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Ingrese un valor valido!");
            validarFechas(message, value);
        }
        return 0;
    }

    public Float validarIndice(String message) {
        float indice = 0;
        try {
            System.out.print(message);
            indice = Float.parseFloat(read.readLine());
            if (indice > 0.0 && indice <= 3.0) {
                return indice;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Ingrese un valor valido");
            return validarIndice(message); // Recursividad
        }
    }

    public String capturarCarrera(String x) {
        String ISC = "Ingenieria en Sistemas Computacionales";
        String IDS = "Ingenieria en Desarrollo de Software";
        String IC = "Ingeniería en Ciberseguridad";
        String LSC = "Licenciatura en Sistemas Computacionales";
        String LDS = "Licenciatura en Desarrollo de Software";
        String LC = "Licenciatura en Ciberseguridad";

        System.out.println("\nEl listado de las carreras son: ");
        System.out.println("1. " + ISC);
        System.out.println("2. " + IDS);
        System.out.println("3. " + IC);
        System.out.println("4. " + LSC);
        System.out.println("5. " + LDS);
        System.out.println("6. " + LC);
        System.out.print(x);

        try {
            int option = Integer.parseInt(read.readLine());
            System.out.println();
            switch (option) {
                case 1:
                    return ISC;

                case 2:
                    return IDS;

                case 3:
                    return IC;

                case 4:
                    return LSC;

                case 5:
                    return LDS;

                case 6:
                    return LC;

                default:
                    throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Ingresa un valor válido!");
            return capturarCarrera(x);
        }
    }
}
