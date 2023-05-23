// Richard Herranz E-8-192057, Jose Encalada 8-999-1420, Jonathan Nunez 4-23-1010
import java.io.*;

public class Problema2Asignacion3 {
    public static void main(String[] args) throws IOException {

        int capturaNumeros = 0;
        int cantidadTotal = 0;
        boolean loop = true;
        int n, max, min, promedio;

        BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));

        while (loop) {
            try {
                /* Preguntarle al usuario la cantidad de numeros a ingresar */
                System.out.printf("Ingrese la cantidad de numeros: ");
                n = Integer.parseInt(lectura.readLine());

                /* Declarar maximos y minimos */
                max = 0;
                min = n;

                /* Ciclo for que atrapa input del usuario para cada numero, hasta que i < N */
                for (int i = 0; i < n; i++) {
                    System.out.printf("Ingrese el numero " + (i + 1) + ": ");
                    capturaNumeros = Integer.parseInt(lectura.readLine());
                    cantidadTotal = cantidadTotal + capturaNumeros; // Almacena la cantidad total

                    /* Establecer maximo y minimo */
                    if (capturaNumeros <= min)
                        min = capturaNumeros;
                    if (capturaNumeros >= max)
                        max = capturaNumeros;
                } // for end

                /* Calcular el promedio */
                promedio = cantidadTotal / 2;

                System.out.println("Cantidad total: " + cantidadTotal);
                System.out.println("El valor maximo es: " + max);
                System.out.println("El valor mínimo es: " + min);
                System.out.println("Promedio: " + promedio);

                loop = false;
            } catch (Exception e) {
                System.out.println("Valor invalido!");
            }
        } // loop end
    } // main end
}
