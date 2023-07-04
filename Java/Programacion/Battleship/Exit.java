public class Exit {
    public static void CerrarPrograma (String x) throws InterruptedException {
        if(x.equals("exit") || x.equals("EXIT")){
            System.out.println(Colors.RED + """

Has escrito 'exit'!   
                    """);

            /*
             *
             * En esta parte del codigo, si el exit es puesto en el turno del jugador 1
             * el ganador será el jugador 2, y viceversa.
             * 
             * En caso de que el exit se haya ingresado en el menu, no se retorna ganador
             * (obviamente si no se jugó)
             * 
             */

            System.out.println("El programa será cerrado en 5 segundos. \n" + //
                    "Gracias por jugar!  ");

            for(int i = 4; i >= 0; i--){
                System.out.println(i+1);
                Thread.sleep(1000); // esperar 1s
            }
            System.exit(0); // cerrar programa
        }
    }
}
