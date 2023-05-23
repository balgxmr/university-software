// poner nombres
import java.io.*;
import java.text.DecimalFormat;

// en repositorio de github
public class Problema5 {
    public static void main(String[] args) throws Exception {
        boolean ciclo = true;
        boolean ciclo2 = true;
        float lado1;
        float lado2;
        float lado3;
        float lado4;
        float lado5;
        double perimetro;
        double area;

        DecimalFormat format1 = new DecimalFormat("#.00");
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        while (ciclo) {
            try {

                System.out.println(
                        "que figura va a calcular?\n1.rectangulo\n2.triangulo\n3.trapecio\n4.circulo");
                int option = Integer.parseInt(leer.readLine());
                if (option == 1) {
                    System.out.println("Introduzca la base");
                    lado1 = Float.parseFloat(leer.readLine());
                    System.out.println("Introduzca la altura");
                    lado2 = Float.parseFloat(leer.readLine());
                    perimetro = lado1 * 2 + lado2 * 2;
                    area = lado1 * lado2;

                    System.out.println(
                            "El perimetro es: " + format1.format(perimetro) + "\nEl area es: " + format1.format(area));
                } else if (option == 2) {
                    while (ciclo2) {
                        System.out.println("Introduzca el lado 1");
                        lado1 = Float.parseFloat(leer.readLine());

                        System.out.println("Introduzca el lado 2");
                        lado2 = Float.parseFloat(leer.readLine());

                        System.out.println("Introduzca el lado 3");
                        lado3 = Float.parseFloat(leer.readLine());
                        if ((lado1 + lado2 > lado3 && lado2 + lado3 > lado1 && lado3 + lado1 > lado2)) {
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

                    }

                } else if (option == 3) {
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

                    perimetro = lado1 + lado2 + lado3 + lado4;

                    area = ((lado1 + lado2) / 2) * lado5;

                    System.out.println(
                            "El perimetro es: " + format1.format(perimetro) + "\nEl area es: " + format1.format(area));
                } else if (option == 4) {
                    System.out.println("Introduzca el radio");
                    lado1 = Float.parseFloat(leer.readLine());

                    perimetro = (2 * lado1) * Math.PI;
                    area = Math.PI * (lado1 * lado1);

                    System.out.println(
                            "El perimetro es: " + format1.format(perimetro) + "\nEl area es: " + format1.format(area));
                }
                System.out.println(
                        "Desea calcular otra figura? presione cualquier tecla\nDe lo contrario presione X para salir del programa");
                String option2 = (leer.readLine());
                if (option2.equals("X") || option2.equals("x")) {
                    ciclo = false;
                    System.out.println("Usted ha salido del programa exitosamente");
                }
            } catch (Exception e) {
                System.out.println("Valor incorrecto");
            }
        }
    }
}