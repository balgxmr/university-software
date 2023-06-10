// Jonathan Nuñez 4-823-1010, Richard Herranz E-8-192057, José Encalada 8-999-1420

public class Calificaciones {
    public float calcularPromedio(float[] notas) {
        float promedio;
        float sumatoria = 0;

        // Sumar las notas y calcular promedio
        for (int i = 0; i < 5; i++) {
            sumatoria = sumatoria + notas[i];
        }
        promedio = sumatoria / 5;

        return promedio;
    } // fin calcularPromedio

    public void imprimirNotas(float[] notas) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Calificacion " + (i + 1) + ": " + notas[i]);
        }
    } // fin imprimirNotas
} // fin class Calificaciones
