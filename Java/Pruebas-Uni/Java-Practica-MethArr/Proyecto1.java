import java.io.*;

public class Proyecto1 {
    public static void main(String[] args ) throws IOException{
        /* Declaracion de variables */

        // Para el metodo 2
        int[] valores = new int[5]; 

        // Para el metodo 3
        int seleccionEst;

        /* BufferedReader usado para leer el input */
        BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));

        /* Menu */
        System.out.println("1.\n2.\n3.\n4.\n");
        System.out.printf("> ");
        int opcionMenu = Integer.parseInt(lectura.readLine());

        /* ? */
        metodo2 objMethod2 = new metodo2();
        metodo3 objMethod3 = new metodo3();
        metodo4 objMethod4 = new metodo4();

        switch (opcionMenu) {
            case 1:
                System.out.println("---- Opcion 1 ----");
                int[][] matriz = metodo1.cargarArreglo();
                metodo1.imprimirArreglo(matriz);
                break;
            
            case 2: /* PROMEDIO DE 5 NUMEROS */
                System.out.println("---- Opcion 2 ----");
                for(int i = 0; i<5; i++){
                    boolean loop = true;
                    while(loop){
                        try{
                            System.out.print("Ingrese el numero #" + (i+1) + ": ");
                            valores[i] = Integer.parseInt(lectura.readLine());
                            loop = false;
                        } catch (Exception e) {
                            System.out.println("Valor invalido! Intente nuevamente");
                        }
                    } // fin while
                } // fin for

                System.out.println("Su promedio es: "+ objMethod2.Promedio(valores));
                break;

            case 3: /* GUARDAR E IMPRIMIR 5 ESTUDIANTES, SEGUN INDICE */
                System.out.println("---- Opcion 3 ----");
                objMethod3.Estudiante();
                try{
                    System.out.println("Hay 5 estudiantes, cual desea ver? (1-5): ");
                    seleccionEst = Integer.parseInt(lectura.readLine());
                    objMethod3.imprimirEstudiante(seleccionEst);
                } catch (Exception e){
                    System.out.println("BRO ITS A NUMBER WHAT ARE YOU ON?!");
                }
                break;

            case 4: /* MATRIZ */
                System.out.println("---- Opcion 4 ----");
                boolean loop = true;
                while (loop){
                    try{
                    System.out.printf("Ingrese el primer tamaño de la matriz: ");
                    int x = Integer.parseInt(lectura.readLine());
                    System.out.printf("Ingrese el segundo tamaño de la matriz: ");
                    int y = Integer.parseInt(lectura.readLine());
                    objMethod4.crearMatrizA(x, y);
                    } catch (Exception e){
                        System.out.println("one piece");
                    }
                }
                break;
        
            default:
                break;
        } // fin switch
    } // fin main
} // fin class