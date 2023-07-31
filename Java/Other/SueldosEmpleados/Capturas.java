import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Capturas {
    
    public String capturarNombre(String message) {
        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(message);
            return read.readLine();
        } catch (Exception e) {
            System.out.println("Input incorrecto!");
            return capturarNombre(message);
        }
    } // capturarDatos() end

    public Number capturarDatos(String message, boolean opcion) {
        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(message);

            // Preguntar sueldo si opcion true; la condicion si opcion es false
            if(opcion){
                Float sueldo = Float.parseFloat(read.readLine());
                if(sueldo < 0)
                    throw new Exception();
                return sueldo;
            } else {
                Integer condicion = Integer.parseInt(read.readLine());
                if(condicion < 0 || condicion > 2)
                    throw new Exception();
                return condicion;
            }
            
        } catch (Exception e) {
            System.out.println("Input incorrecto!");
            return capturarDatos(message, opcion);
        }
    } // capturarDatos() end
}
