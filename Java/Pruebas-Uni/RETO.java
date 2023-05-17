import java.io.*;
import java.lang.Math;

public class RETO {
    public static void main(String[] args) throws IOException{ // MAIN
        
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        boolean loop1 = true;

        /* Variables para pintar la consola con colores */
        String red="\033[31m"; 
        String green="\033[32m"; 
        String yellow="\033[33m"; 
        String reset="\u001B[0m";

        while(loop1){ // INICIO LOOP 1
            boolean MenuExc = false;
            Integer menu=0;
            try {
                System.out.println("Ingrese (1) para calcular el area y perimetro del triangulo");
                System.out.println("Ingrese (2) para calcular el area y perimetro del circulo");
                System.out.println("Ingrese (3) para calcular el area y perimetro del cuadrado");
                String menuExit = lector.readLine();

                if (menuExit.equals("EXIT")) {
                    System.out.println(yellow + "El programa ha finalizado! Que tengas buen dia c:");
                    loop1 = false;
                    break;
                }
                menu = Integer.parseInt(menuExit);
                MenuExc = true;
            } catch (Exception E){
                if(MenuExc == false){
                    System.out.println(red + "*OPCION NO VALIDA*");
                    System.out.println(red + "Ingrese una opcion valida");
                    loop1 = true;
                }
            } // FIN TRY-CATCH

            boolean Elado1 = false;
            boolean Elado2 = false;
            boolean Elado3 = false;
            boolean Eradio = false; 
            String entrada;

            boolean loop2 = true;
            switch(menu){ // INICIO MENU
                case 1:
                    while(loop2) { //INICIO LOOP 2 
                            try{ //INICIO TRY 
                                System.out.printf("> Ingresa el valor del lado 1: ");
                                double lado1 = Double.parseDouble(lector.readLine());
                                Elado1 = true;
                            
                                System.out.printf("> Ingresa el valor del lado 2: ");
                                double lado2 = Double.parseDouble(lector.readLine());
                                Elado2 = true;
                    
                                System.out.printf("> Ingresa el valor del lado 3: ");
                                double lado3 = Double.parseDouble(lector.readLine());
                                Elado3 = true;
                    
                                double perimetro = (lado1 + lado2 + lado3);
                                System.out.println(green + "El perimetro del triangulo es "+ perimetro);
                                
                                double valor = (perimetro / 2);
                    
                                // Formula de Heron
                                double area = Math.sqrt(valor*((valor-lado1)*(valor-lado2)*(valor-lado3)));
                    
                                // System.out.println("El area del triangulo es " + area);
                                // ESTE FORMATO PARA LAS IMPRESIONES CON SOLO 2 DECIMALES
                                System.out.printf(green + "El area del triangulo es %.2f", area);
                                System.out.println();
                                
                                // Salir
                                System.out.printf(reset + "> Escribe 'EXIT' para finalizar el programa o 1 para continuar: ");
                                entrada = lector.readLine();
                                
                                // Evaluar que entrada sea igual a "EXIT" usando equals(), y si es asi, finalizar el programa.
                                if (entrada.equals("EXIT")){
                                    System.out.println(yellow + "El programa ha finalizado! Que tengas buen dia c:");
                                    loop2 = false;
                                    loop1 = false;
                                } else {
                                    System.out.println("\nVolviendo al menu principal!\n");
                                    loop2 = false;
                                } // elif fin
                                
                            } // FIN TRY
                            catch(Exception e){ //INICIO CATCH
                                if(Elado1 == false && Elado2 == false && Elado3 == false)
                                    System.out.println(red + "El lado 1 no es valido, ingreselo nuevamente" + reset);
                                if(Elado2 == false && Elado1 == true && Elado3 == false)
                                    System.out.println(red + "El lado 2 no es valido, ingreselo nuevamente" + reset);
                                if(Elado1 == true && Elado2 == true && Elado3 == false)
                                    System.out.println(red + "El lado 3 no es valido, ingreselo nuevamente" + reset);
                            } // FIN CATCH
                    }   //FIN LOOP 2
                break; // CASE 1 FIN
                
                case 2:
                    while(loop2) { //INICIO LOOP 2 
                        try{ //INICIO TRY 
                            System.out.printf("> Ingresa el valor del radio del circulo: ");
                            double radio = Double.parseDouble(lector.readLine());
                            Eradio = true;
            
                            double areacirculo = 3.1416*(radio*radio);
                            double diametro = 2*(radio);
                            double perimetro = 3.1416*diametro;
                            
                            System.out.printf(green + "El area del circulo es %.2f\n", areacirculo);
                            System.out.printf(green + "El perimetro del circulo es %.2f\n", perimetro);

                            
                            // salir
                            System.out.printf(reset + "> Escribe 'EXIT' para finalizar el programa o 1 para continuar: ");
                            entrada = lector.readLine();
                            
                            // Evaluar que valor sea igual a "EXIT" usando equals(), y si es asi, finalizar el programa.
                            if (entrada.equals("EXIT")){
                                System.out.println(yellow + "El programa ha finalizado! Que tengas buen dia c:");
                                loop2 = false;
                                loop1 = false;
                                
                            } else {
                                System.out.println("\nVolviendo al menu principal!\n");
                                loop2 = false;
                            } // elif fin
                            
                        } catch (Exception e){ //INICIO CATCH
                            if(Eradio == false)
                                System.out.println(red + "El radio no es valido, ingreselo nuevamente" + reset);
                        } // FIN TRY-CATCH
                    } //FIN LOOP 2

                break; // CASE 2 FIN

                case 3:
                    while(loop2) { //INICIO LOOP 2 
                        try{ //INICIO TRY 
                            System.out.printf("> Ingresa el valor de un lado: ");
                            double lado = Double.parseDouble(lector.readLine());
                            Elado1 = true;

                            double area = lado * lado;
                            double perimetro = lado + lado + lado + lado; 
                            
                            System.out.printf(green + "El area del cuadrado es %.2f\n", area); // Este valor va al cuadrado, ej: cm^2
                            System.out.printf(green + "El perimetro del circulo es %.2f\n", perimetro);

                            
                            // salir
                            System.out.printf(reset + "> Escribe 'EXIT' para finalizar el programa o 1 para continuar: ");
                            entrada = lector.readLine();
                            
                            // Evaluar que valor sea igual a "EXIT" usando equals(), y si es asi, finalizar el programa.
                            if (entrada.equals("EXIT")){
                                System.out.println(yellow + "El programa ha finalizado! Que tengas buen dia c:");
                                loop2 = false;
                                loop1 = false;
                            } else {
                                System.out.println("\nVolviendo al menu principal!\n");
                                loop2 = false;
                            } // elif fin
                        } // FIN TRY
                        catch(Exception e){ //INICIO CATCH
                            if(Elado1 == false)
                                System.out.println(red + "El radio no es valido, ingreselo nuevamente" + reset);
                        }  // FIN CATCH
                    }    //FIN LOOP 2
                break; // CASE 3 FIN
            } // FIN MENU
        } //FIN LOOP 1
    } // FIN MAIN
}