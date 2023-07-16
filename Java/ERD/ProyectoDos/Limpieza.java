/* 
 * Grupo 1SF121
 * 
 * Jonathan Núñez (4-823-1010)
 * José Encalada (8-999-1420)
 * Richard Herranz (E-8-192057)
 */

public class Limpieza {
    public static void Clean() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
