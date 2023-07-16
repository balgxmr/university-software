package ProyectoUno;
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
    private static Random random = new Random(); // Variable de instancia de la clase (Para generar datos aleatorios)
    public static void main(String[] args) throws IOException {
        // Limpiar pantalla
        Clean.clean();

        /* Declarar un objeto de la clase random para posteriormente usarse para generar datos aleatorios */
        Random random = new Random();

        /* Declaración de variables */
        String name;
        String cedula;
        int mesNac;
        int anioNac;
        String carrera;
        Float indice;

        Capturas datos = new Capturas(); // Se crea el objeto datos para capturar los datos ingresados manualmente.
                                         // No se utiliza actualmente ya que los valores son generados
                                         // aleatoriamente


        /* Inicializar el arreglo estudiantes con cantidad de 100
         * Usando el constructor dentro de la clase Estudiante
         * para inicializar las variables
         */
        Estudiante[] estudiantes = new Estudiante[100];


        /* for que iterará 100 veces y dentro se generarán los 100 estudiantes */
        for (int i = 0; i < 100; i++) {
            /* 
            ESTA PARTE ES EN LA QUE EL USUARIO AÑADE LOS DATOS MANUALMENTE.
            Fue reemplazada por los datos generados de manera aleatoria.

            System.out.println("Estudiante #" + (i + 1));
            name = datos.capturarDatos("Ingresa el nombre: ");
            cedula = datos.capturarDatos("Ingrese la cedula: ");
            mesNac = datos.validarFechas("Ingrese el mes de nacimiento: ", true);
            anioNac = datos.validarFechas("Ingrese el año de nacimiento: ", false);
            carrera = datos.capturarCarrera("Ingrese la carrera: ");
            indice = datos.validarIndice("Ingresa el indice: ");
            estudiantes[i] = new Estudiante(name, cedula, mesNac, anioNac, carrera, indice);
            */

            /* Valores generados de manera aletoria */
            // System.out.println("Estudiante #" + (i + 1));
            
            // Generar nombre aleatorio
            name = generateRandomName();
            
            // Generar cédula aleatoria
            cedula = generateRandomCedula();
            
            // Generar mes de nacimiento aleatorio
            mesNac = random.nextInt(12) + 1;
            
            // Generar año de nacimiento aleatorio
            anioNac = random.nextInt(20) + 2000; // Se asume que los estudiantes tienen entre 20 y 40 años
            
            // Generar una carrera aleatoria
            carrera = generateRandomCarrera();
            
            // Generar índice aleatorio
            indice = generateRandomIndice();
            
            estudiantes[i] = new Estudiante(name, cedula, mesNac, anioNac, carrera, indice);
    
            System.out.println();
            Clean.clean();
        }

        /*  DEBUG CODE (Descomentar para imprimir a los 100 estudiantes por pantalla)
        Impresiones impresion = new Impresiones();
        impresion.imprimirEstudiantes(estudiantes, 100);
            DEBUG CODE END
        */ 

        /* Llamar a calcularSobresalientes para calcular los mejores estudiantes con el indice */
        Calculos.calcularSobresalientes(estudiantes);
    } // main end


    /* VALORES DE PRUEBA UTILIZADOS Y GENERADOS ALEATORIAMENTE */
    private static String generateRandomName() {
        String[] names = {"Jose", "Richard", "Alex", "Miguel", "Jonathan", "Nicole", "Kidian", "Luis", "Octavio", "Juan", 
                          "Josema", "Alexis", "Leo Messi", "Neymar", "Crispina", "Ikair"};
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
        String[] carreras = {"Desarrollo de Software", "Medicina", "Aeronautica", "Administración de Negocios", "Licenciatura en ciberseguridad"};
        return carreras[random.nextInt(carreras.length)];
    }

    private static float generateRandomIndice() {
        float indice = random.nextFloat() * 2 + 1; // Generar un índice entre 1.0 y 3.0
        return Math.round(indice * 100) / 100.0f; // Redondear a dos decimales usando Math
    }
    /* FIN VALORES DE PRUEBA */
} // ProyectoFinal end