public class Interfaz {
    public static void limpiarPantalla() { // limpirar la pantalla para las siguientes impresione
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Manejo de errores
            e.printStackTrace();
        }
    }
}
