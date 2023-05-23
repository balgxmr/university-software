// Richard Herranz E-8-192057, Jose Encalada 8-999-1420, Jonathan Nunez 4-23-1010

import java.io.*;
import java.text.DecimalFormat;

public class Problema5 {
    public static void main(String[] args) throws Exception {

        /* Declaracion de variables */
        boolean ciclo = true;
        boolean ciclo2 = true;
        float lado1;
        float lado2;
        float lado3;
        float lado4;
        float lado5;
        double perimetro;
        double area;

        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        // Formato para imprimir dos decimales
        DecimalFormat format1 = new DecimalFormat("#.00");

        while (ciclo) {
            try {
                System.out.println(
                        "Que figura va a calcular?\n1. Rectangulo\n2. Triangulo\n3. Trapecio\n4. Circulo");
                int option = Integer.parseInt(leer.readLine());

                if (option == 1) { // RECTANGULO
                    System.out.println("Introduzca la base");
                    lado1 = Float.parseFloat(leer.readLine());
                    System.out.println("Introduzca la altura");
                    lado2 = Float.parseFloat(leer.readLine());

                    // Calcular el perimetro y el area del rectangulo
                    perimetro = lado1 * 2 + lado2 * 2;
                    area = lado1 * lado2;

                    System.out.println(
                            "El perimetro es: " + format1.format(perimetro) + "\nEl area es: " + format1.format(area));
                        
                } else if (option == 2) { // TRIANGULO
                    while (ciclo2) {
                        System.out.println("Introduzca el lado 1");
                        lado1 = Float.parseFloat(leer.readLine());

                        System.out.println("Introduzca el lado 2");
                        lado2 = Float.parseFloat(leer.readLine());

                        System.out.println("Introduzca el lado 3");
                        lado3 = Float.parseFloat(leer.readLine());

                        /* 
                        * Verificar que los lados del triangulo cumplan con la desigualdad triangular
                        * Que dice que la suma de las longitudes de cualquier par de los lados debe ser
                        * mayor que la longitud del tercer lado.
                        */
                        if ((lado1 + lado2 > lado3 && lado2 + lado3 > lado1 && lado3 + lado1 > lado2)) {
                            // Calcular el perimetro y el area del triangulo
                            perimetro = lado1 + lado2 + lado3;

                            area = Math.sqrt((perimetro / 2) * ((perimetro / 2) - lado1) * ((perimetro / 2) - lado2)
                                    * ((perimetro / 2) - lado3));
            
                            System.out.println(
                                    "El perimetro es: " + format1.format(perimetro) + "\nEl area es: "
                                            + format1.format(area));
                            ciclo2 = false;
                        } else {
                            System.out.println("Sus lados del triangulo no son correctos ingreselos nuevamente\n");
                        }
                    } // while en opcion 2 end

                } else if (option == 3) { // TRAPECIO
                    System.out.println("Introduzca la base inferior");
                    lado1 = Float.parseFloat(leer.readLine());

                    System.out.println("Introduzca la base superior");
                    lado2 = Float.parseFloat(leer.readLine());

                    System.out.println("Introduzca el lado derecho");
                    lado3 = Float.parseFloat(leer.readLine());

                    System.out.println("Introduzca el lado izquierdo");
                    lado4 = Float.parseFloat(leer.readLine());

                    System.out.println("Introduzca la altura");
                    lado5 = Float.parseFloat(leer.readLine());

                    // Calcular el perimetro y area del Trapecio
                    perimetro = lado1 + lado2 + lado3 + lado4;

                    area = ((lado1 + lado2) / 2) * lado5;

                    System.out.println(
                            "El perimetro es: " + format1.format(perimetro) + "\nEl area es: " + format1.format(area));

                } else if (option == 4) { // CIRCULO
                    System.out.println("Introduzca el radio");
                    lado1 = Float.parseFloat(leer.readLine());

                    // Calcular perimetro y area del circulo
                    perimetro = (2 * lado1) * Math.PI;
                    area = Math.PI * (lado1 * lado1);

                    System.out.println(
                            "El perimetro es: " + format1.format(perimetro) + "\nEl area es: " + format1.format(area));
                } // else if end

                // SEGUIR O SALIR DEL PROGRAMA
                System.out.println(
                        "\nDesea calcular otra figura? Presione cualquier tecla\nDe lo contrario presione X para salir del programa");
                String option2 = (leer.readLine());
                if (option2.equals("X") || option2.equals("x")) {
                    ciclo = false;
                    System.out.println("Usted ha salido del programa exitosamente");
                }

            } catch (Exception e) {
                System.out.println("Valor incorrecto");
            }
        } // while end
    } // main end
}