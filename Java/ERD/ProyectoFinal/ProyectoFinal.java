/*

Universidad Tecnológica de Panamá
José M. / balgxmr (2023)

Enunciado:
Escriba un programa que cree una estructura de registro para los Estudiantes de una clase de 100
estudiantes. El programa debe calcular cuáles son los 5 estudiantes más sobresalientes de la clase.
Debe generar un listado con los datos de los 5 estudiantes ordenados de mayor a menor.

Los campos del registro son los siguientes:
- Nombre (cadena)
- Cedula (cadena)
- Mes de nacimiento (entero)
- Año (entero)
- Carrera (cadena)
- Índice (flotante)

Es importante destacar que el mes de nacimiento es un valor numérico entero que representa el
mes, en este caso enero(1), febrero(2), Marzo(3)…así sucesivamente, en la salida debe mostrar el
nombre del mes. Considere que ya se ha almacenado la información de los 100 registros de
estudiantes.

Para considerar a un estudiante sobresaliente su índice debe ser superior a 2.5 y el máximo 3.0.
Se recomienda el uso de estructuras de arreglos y de registros.

*/

import java.io.*;
import java.util.Random;

public class ProyectoFinal {
    private static Random random = new Random(); // Variable de instancia de la clase (PRUEBA)
    public static void main(String[] args) throws IOException {
        Clean.clean();

        // PRUEBA
        Random random = new Random();

        String name;
        String cedula;
        int mesNac;
        int anioNac;
        String carrera;
        Float indice;

        Capturas datos = new Capturas();

        Estudiante[] estudiantes = new Estudiante[100];

        // DATOS DE PRUEBA

        for (int i = 0; i < 100; i++) {
            /* ESTA PARTE ES EN LA QUE EL USUARIO AÑADE LOS DATOS MANUALMENTE
            System.out.println("Estudiante #" + (i + 1));
            name = datos.capturarDatos("Ingresa el nombre: ");
            cedula = datos.capturarDatos("Ingrese la cedula: ");
            mesNac = datos.validarFechas("Ingrese el mes de nacimiento: ", true);
            anioNac = datos.validarFechas("Ingrese el año de nacimiento: ", false);
            carrera = datos.capturarCarrera("Ingrese la carrera: ");
            indice = datos.validarIndice("Ingresa el indice: ");
            estudiantes[i] = new Estudiante(name, cedula, mesNac, anioNac, carrera, indice);
            */

            /* VALORES DE PRUEBA */
            System.out.println("Estudiante #" + (i + 1));
            
            // Generar nombre aleatorio
            name = generateRandomName();
            
            // Generar cédula aleatoria
            cedula = generateRandomCedula();
            
            // Generar mes de nacimiento aleatorio
            mesNac = random.nextInt(12) + 1;
            
            // Generar año de nacimiento aleatorio
            anioNac = random.nextInt(20) + 2000; // Asumiendo que los estudiantes tienen entre 20 y 40 años
            
            // Generar carrera aleatoria
            carrera = generateRandomCarrera();
            
            // Generar índice aleatorio
            indice = generateRandomIndice();
            
            estudiantes[i] = new Estudiante(name, cedula, mesNac, anioNac, carrera, indice);
    
            System.out.println();
            Clean.clean();
        }

        /*  DEBUG CODE
        Impresiones impresion = new Impresiones();
        impresion.imprimirEstudiantes(estudiantes, 100);
            DEBUG CODE END
        */ 

        /* Llamar a mejores estudiantes */
        Calculos.calcularSobresalientes(estudiantes);
    } // main end


    /* VALORES DE PRUEBA */
    private static String generateRandomName() {
        String[] names = {"John", "Emily", "Michael", "Sophia", "William", "Olivia", "Daniel", "Emma", "David", "Ava"};
        return names[random.nextInt(names.length)];
    }

    private static String generateRandomCedula() {
        StringBuilder cedula = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            cedula.append(random.nextInt(10));
        }
        return cedula.toString();
    }

    private static String generateRandomCarrera() {
        String[] carreras = {"Ingeniería Informática", "Medicina", "Derecho", "Administración de Empresas", "Arquitectura"};
        return carreras[random.nextInt(carreras.length)];
    }

    private static float generateRandomIndice() {
        float indice = random.nextFloat() * 2 + 2; // Generar un índice entre 2.0 y 4.0
        return Math.round(indice * 100) / 100.0f; // Redondear a dos decimales
    }
    /* FIN VALORES DE PRUEBA */
} // ProyectoFinal end