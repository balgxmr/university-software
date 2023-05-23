// Richard Herranz E-8-192057, Jose Encalada 8-999-1420, Jonathan Nunez 4-23-1010

import java.io.*;

public class Problema4 {
    public static void main(String[] args) throws Exception {
    
    	/* Declaracion de variables */
        boolean ciclo = true;
        boolean ciclo2 = true;

        double zapatosPrecio = 25.00;
        int zapatosCantidad = 150;

        double carterasPrecio = 15.50;
        int carterasCantidad = 100;

        double vestidosPrecio = 150.75;
        int vestidosCantidad = 2;

        double sombrerosPrecio = 5.00;
        int sombrerosCantidad = 10;

        double costoTotal = 0;
        int cantidad;

        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        while (ciclo) {
            try {
                // INVENTARIO DE LA TIENDA
                System.out.println("Tenemos los siguientes productos:");
                System.out.println("Items - precio - cantidad");
                System.out.println("Zapatos - " + zapatosPrecio + " - " + zapatosCantidad);
                System.out.println("Carteras - " + carterasPrecio + " - " + carterasCantidad);
                System.out.println("Vestidos - " + vestidosPrecio + " - " + vestidosCantidad);
                System.out.println("Sombreros - " + sombrerosPrecio + " - " + sombrerosCantidad);

                System.out.println("\nQue desea comprar?\n1. Zapatos\n2. Carteras\n3. Vestidos\n4. Sombreros\n5. Salir");
                int option = Integer.parseInt(leer.readLine());

                ciclo2 = true;
                
                if (option == 1) { // ZAPATOS
                    while (ciclo2) {
                        System.out.println("Cual es la cantidad que va a comprar?");
                        cantidad = Integer.parseInt(leer.readLine());

                        /* Verificar que la cantidad del usuario no exceda la del inventario */
                        if (cantidad <= zapatosCantidad) {
                            zapatosCantidad = zapatosCantidad - cantidad;
                            costoTotal = zapatosPrecio * cantidad;
                            ciclo2 = false;
                        } else {
                            System.out.println(
                                    "No es posible hacer la compra porque no hay ese numero de productos en el inventario actualmente, seleccione otra cantidad");
                        } // if fin
                    } // while (ciclo2) fin

                } else if (option == 2) { // CARTERAS
                    while (ciclo2) {
                        System.out.println("Cual es la cantidad que va a comprar?");
                        cantidad = Integer.parseInt(leer.readLine());

                        /* Verificar que la cantidad del usuario no exceda la del inventario */
                        if (cantidad <= carterasCantidad) {
                            carterasCantidad = carterasCantidad - cantidad;
                            costoTotal = carterasPrecio * cantidad;
                            ciclo2 = false;
                        } else {
                            System.out.println(
                                    "No es posible hacer la compra porque no hay ese numero de productos en el inventario actualmente, seleccione otra cantidad");
                        } // if fin
                    } // while (ciclo2) fin

                } else if (option == 3) { // VESTIDOS
                    while (ciclo2) {
                        System.out.println("Cual es la cantidad que va a comprar?");
                        cantidad = Integer.parseInt(leer.readLine());

                        /* Verificar que la cantidad del usuario no exceda la del inventario */
                        if (cantidad <= vestidosCantidad) {
                            vestidosCantidad = vestidosCantidad - cantidad;
                            costoTotal = vestidosPrecio * cantidad;
                            ciclo2 = false;
                        } else {
                            System.out.println(
                                    "No es posible hacer la compra porque no hay ese numero de productos en el inventario actualmente, seleccione otra cantidad");
                        } // if fin
                    } // while (ciclo2) fin

                } else if (option == 4) { // SOMBREROS
                    while (ciclo2) {
                        System.out.println("Cual es la cantidad que va a comprar?");
                        cantidad = Integer.parseInt(leer.readLine());

                        /* Verificar que la cantidad del usuario no exceda la del inventario */
                        if (cantidad <= sombrerosCantidad) {
                            sombrerosCantidad = sombrerosCantidad - cantidad;
                            costoTotal = sombrerosPrecio * cantidad;
                            ciclo2 = false;
                        } else {
                            System.out.println(
                                    "No es posible hacer la compra porque no hay ese numero de productos en el inventario actualmente, seleccione otra cantidad");
                        } // if fin
                    } // while (ciclo2) fin

                } else if (option == 5) { // SALIR DEL SISTEMA
                    System.out.println("Ha salido exitosamente del sistema");
                }

                // Costo total
                System.out.println("El costo total para pagar los productos es: " + costoTotal);
                System.out.println(
                        "Revise el inventario actualizado si quiere realizar otra compra, de lo contrario seleccione la opcion 5");
            } catch (Exception e) {
                System.out.println("Valor incorrecto");
            } // try-catch fin
        } // while (ciclo) fin
    } // main fin
}
