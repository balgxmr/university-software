/*
 * Construir un programa que permita ingresar el Código, Nombre, Sueldo, Condición 
 * (Estable, Contratado), etc. de N empleados, luego calcule el sueldo promedio por 
 * condición, sabiendo que si el empleado tiene más de 10 años de servicio tiene una 
 * bonificación del 15%, ordene los datos de acuerdo al código e imprima sus datos.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {
    public static void main (String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String codigo;
        String nombre;
        Float sueldo;
        Integer condicion;
        
        // Creamos una lista/arreglo de la clase Empleado que se guardarán empleados 
        ArrayList<Empleado> empleados = new ArrayList<>();

        // Objetos de clases para acceder a métodos
        Capturas capturas = new Capturas();

        // Numero de empleados actuales
        int CANT_EMP;
        System.out.print("Ingrese la cantidad de empleados: ");
        CANT_EMP = Integer.parseInt(read.readLine());
        System.out.println();

        for(int i = 0; i < CANT_EMP; i++){
            System.out.println("Empleado #" + (i+1));
            codigo = capturas.capturarNombre("Ingresa el codigo: ");
            nombre = capturas.capturarNombre("Ingresa el nombre: ");
            sueldo = (Float) capturas.capturarDatos("Ingresa el sueldo: ", true);
            condicion = (int) capturas.capturarDatos("Ingresa la condición: (1: Estable) (2: Permanente): ", false);
            if(condicion == 2){
                sueldo = (float) (sueldo + sueldo * 0.15);
            }
            Empleado empleado = new Empleado(codigo, nombre, sueldo, condicion);
            empleados.add(empleado);
        }

        Interfaz.limpiarPantalla();
        System.out.println();
        System.out.println("\u001B[32m* Empleados permanentes (con más de 10 años de servicio) reciben un 15% de bonificación.\u001B[0m");
        System.out.println();
        System.out.println("-----------------------------------------");
        for(int i = 0; i < CANT_EMP; i++){
            System.out.println("Empleado #" + (i+1));
            System.out.println("CODIGO: " + empleados.get(i).getCodigo());
            System.out.println("NOMBRE: " + empleados.get(i).getName());
            System.out.println("SUELDO: " + empleados.get(i).getSueldo());
            System.out.println("CONDICIÓN: " + empleados.get(i).getStatusCondicion());
            System.out.println("-----------------------------------------");
        }
    }
}
