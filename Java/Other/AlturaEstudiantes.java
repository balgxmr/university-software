/*
 *  Ejemplo de uso de un ArrayList: Calcular la altura media de los alumnos de una clase
 *  Programa Java que pida por teclado las alturas de N alumnos de una clase y las guarde en un 
 *  ArrayList de tipo Double. A continuación el programa calculará la altura media de todos 
 *  los alumnos, cuantos alumnos hay más altos que la media y cuantos más bajos.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AlturaEstudiantes {
    public static void main(String[] args) {
        ArrayList<Double> altura = new ArrayList<>();

        int x = (int) capturarDatos("Ingrese la cantidad de estudiantes", true);
        for (int i = 0; i < x; i++) {
            altura.add(capturarDatos("Ingrese la estatura del estudiante #" + (i + 1), false));
        }
        calcularAlturasMedias(altura);
    } // main end

    public static double capturarDatos(String message, boolean opcion) {
        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(message + ": ");

            if (opcion) {
                int x = Integer.parseInt(read.readLine());
                // verificar que la cantidad es como mínimo 2
                if (x < 2) {
                    throw new Exception();
                }
                return x;
            } else {
                double x = Double.parseDouble(read.readLine());
                // verificar que la cantidad es como mínimo 2
                if (x < 0) {
                    throw new Exception();
                }
                return x;
            }
        } catch (Exception e) {
            System.out.println("Input incorrecto!");
            return capturarDatos(message, opcion);
        }
    } // capturarDatos() end

    public static void calcularAlturasMedias(ArrayList<Double> altura) {
        double total = 0;
        int n = altura.size();

        /*
         * Calcular la altura promedio, sumando todas las alturas y
         * dividiendolo por el tamaño del array
         */
        for (int i = 0; i < n; i++) {
            total += altura.get(i);
        }
        double altMedia = total / n;

        /* Calcular las alturas mas bajas y altas que el promedio */
        int higherThanAvg = 0;
        int lowerThanAvg = 0;
        for (int i = 0; i < n; i++) {
            if (altura.get(i) > altMedia) {
                higherThanAvg++;
            } else if (altura.get(i) < altMedia) {
                lowerThanAvg++;
            }
        }

        /* Impresion de los calculos de alturas */
        System.out.println("La altura media es: " + altMedia);
        System.out.println("Cantidad media de estudiantes con una altura más baja que la media: " + lowerThanAvg);
        System.out.println("Cantidad media de estudiantes con una altura más baja que la media: " + higherThanAvg);
    } // calcularAlturasMedias() end
} // class AlturaEstudiantes end