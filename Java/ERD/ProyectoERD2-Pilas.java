//  Importar librerias
import java.io.*;
import java.util.Stack;

public class laboratorio3 {
    public static void main(String[] args) throws IOException {

        /* Declaracion de variables */
        Stack<Integer> pila = new Stack<>(); // Se crea una pila de tipo entero usando Stack
        int cima = 0;
        int datoNumero;
        int max = 6; // maximo de la pila
        boolean loop = true;
        boolean loop2 = true;
        boolean superloop = true;
        String option;
        int optionmenu;
        int elementoEliminado;

        /* Bufferedreader usado para leer el input */
        BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
        
        // Loop del Menu
       while (superloop) {
            System.out.println("Bienvenidos al menu\nPresione 1 para insertar elementos en la pila\nPresione 2 para eliminar elementos de la pila");
            optionmenu = Integer.parseInt(lectura.readLine());

            if (optionmenu == 1) { // algoritmo de insercion
                while (loop) {
                    System.out.printf("Ingrese un numero entero: ");
                    datoNumero = Integer.parseInt(lectura.readLine());

                    if (cima < max) {
                        pila.push(datoNumero);
                        cima += 1;
                        System.out.println("pila = " + pila);
                        System.out.println("cima = " + cima);
                    } else {
                        System.out.printf("Error de desbordamiento no puede insertar mas valores\n");
                        break;
                    }// fin if-else
                    System.out.println("Desea insertar un elemento? presione cualquier tecla\nSi desea volver al menu ingrese X");
                    option = lectura.readLine();

                    /* Salir de ingresar valores si el usuario ingresa 'X' o 'x' */
                    if (option.equals("X") || option.equals("x")) {
                        loop = false;
                    }
                } // fin while-loop
            } // fin if-option 1
            if (optionmenu == 2) { // algoritmo de eliminiacion
                while (loop2) {
                    if (cima > 0) {
                        elementoEliminado = pila.pop(); // Elimina el elemento en la cima 
                                // de la pila y se guarda en la variable elementoEliminado
                        cima -= 1;
                        System.out.println("pila = " + pila);
                        System.out.println("cima = " + cima);
                        System.out.println("El elemento eliminado es: " + elementoEliminado);
                    } else {
                        System.out.printf("Error de Subdesbordamiento, no hay mas elementos en la pila, la pila esta vacia\n");
                        break;
                    } // fin if-else
                    System.out.println("Quiere salir de ingresar valores? presione X, de lo contrario presione cualquier tecla");

                    option = lectura.readLine();

                    /* Salir de ingresar valores si el usuario ingresa 'X' o 'x'*/
                    if (option.equals("X") || option.equals("x")) {
                        loop2 = false;
                    }
                }// fin while-loop2
            }// fin if-option 2
        }// fin while-superLoop
    }// fin main
} // fin class
