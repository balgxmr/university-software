public class Limpieza {
    public static void Clean() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
