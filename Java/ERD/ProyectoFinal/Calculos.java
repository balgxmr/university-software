public class Calculos {
    /* Almacenar estudiantes sobresalientes */
    public static void calcularSobresalientes(Estudiante[] estudiantes){
        Estudiante[] mejoresEstudiantes = new Estudiante[5];
        for (int i = 0; i < estudiantes.length; i++) {
            Estudiante estudiante = estudiantes[i];
            if (estudiante != null) { // Verificar si el estudiante no es null
                // Verificar si el estudiante es uno de los 5 mejores estudiantes
                for (int j = 0; j < mejoresEstudiantes.length; j++) {
                    if (mejoresEstudiantes[j] == null || (estudiante.getIndice() != null && estudiante.getIndice() > mejoresEstudiantes[j].getIndice())) {
                        // Se reemplaza el estudiante en la posición j si es nulo o si tiene un índice más alto
                        mejoresEstudiantes[j] = estudiante;
                        break;
                    }
                }
            }
        }
        ordenarSobresalientes(mejoresEstudiantes);
    } // calcularSobresalientes end

    /* Se ordenan los 5 estudiantes sobresalientes */
    public static void ordenarSobresalientes(Estudiante[] mejoresEstudiantes){
        for (int i = 0; i < mejoresEstudiantes.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < mejoresEstudiantes.length; j++) {
                if (mejoresEstudiantes[j].getIndice() > mejoresEstudiantes[maxIndex].getIndice()) {
                    maxIndex = j;
                }
            }
            Estudiante temp = mejoresEstudiantes[i];
            mejoresEstudiantes[i] = mejoresEstudiantes[maxIndex];
            mejoresEstudiantes[maxIndex] = temp;
        }
        Impresiones imprimir = new Impresiones();
        System.out.println("LOS MEJORES 5 ESTUDIANTES SON: ");
        imprimir.imprimirEstudianteSobresalientes(mejoresEstudiantes, 5);
    }
}
