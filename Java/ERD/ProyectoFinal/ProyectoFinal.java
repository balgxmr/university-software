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

public class ProyectoFinal {
    public static void main(String[] args) throws IOException {
        Clean.clean();

        String name;
        String cedula;
        int mesNac;
        int anioNac;
        String carrera;
        Float indice;

        Capturas datos = new Capturas();

        Estudiante[] estudiantes = new Estudiante[100];

        for (int i = 0; i < 2; i++) {
            System.out.println("Estudiante #" + (i + 1));
            name = datos.capturarDatos("Ingresa el nombre: ");
            cedula = datos.capturarDatos("Ingrese la cedula: ");
            mesNac = datos.validarFechas("Ingrese el mes de nacimiento: ", true);
            anioNac = datos.validarFechas("Ingrese el año de nacimiento: ", false);
            carrera = datos.capturarCarrera("Ingrese la carrera: ");
            indice = datos.validarIndice("Ingresa el indice: ");
            estudiantes[i] = new Estudiante(name, cedula, mesNac, anioNac, carrera, indice);
            System.out.println();
            Clean.clean();
        }

        // DEBUG CODE
        Impresiones impresion = new Impresiones();
        impresion.imprimirEstudiantes(estudiantes);
        // DEBUG CODE END

    } // main end
} // ProyectoFinal end