public class Impresiones {
    /*
     * Funcion que imprime a todos los estudiantes
     * Esta funcion de momento no se llama debido a que no se pide
     * Pero basta con llamarla desde el main para que imprima a todos
     * los estudiantes
     */
    public void imprimirEstudiantes(Estudiante[] estudiantes, int CANT_ESTUDIANTES) {
        System.out.println("-----------------------------------");
        for (int i = 0; i < CANT_ESTUDIANTES; i++) {
            Estudiante estudiante = estudiantes[i];
            System.out.println(Colors.GREEN + "Nombre: " + Colors.RESET_COLOR + estudiante.getName());
            System.out.println(Colors.GREEN + "Cédula: " + Colors.RESET_COLOR + estudiante.getCedula());
            System.out.println(Colors.GREEN + "Mes de nacimiento: " + Colors.RESET_COLOR + estudiante.getMesNac());
            System.out.println(Colors.GREEN + "Año de nacimiento: " + Colors.RESET_COLOR + estudiante.getAnioNac());
            System.out.println(Colors.GREEN + "Carrera: " + Colors.RESET_COLOR + estudiante.getCarrera());
            System.out.println(Colors.GREEN + "Índice: " + Colors.RESET_COLOR + estudiante.getIndice());
            System.out.println("-----------------------------------");
        }
    } // imprimirEstudiantes end

    /* Funcion que imprime a los 5 estudiantes sobresalientes */
    public void imprimirEstudianteSobresalientes(Estudiante[] estudiantes, int CANT_ESTUDIANTES) {
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║ Nombre                 | Mes de Nacimiento      | Índice                         ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════╣");
        for (int i = 0; i < CANT_ESTUDIANTES; i++) {
            Estudiante estudiante = estudiantes[i];
            String mesNacTexto = obtenerNombreMes(estudiante.getMesNac());
            System.out.printf("║ %-22s | %-22s | %-14.2f                 ║\n", estudiante.getName(), mesNacTexto,
                    estudiante.getIndice());
        }
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════╝");
    } // imprimirEstudianteSobresalientes end

    /*
     * Funcion para obetener el mes en formato de texto (Enero, febrero, marzo...)
     */
    private String obtenerNombreMes(int mes) {
        switch (mes) {
            case 1:
                return "Enero";

            case 2:
                return "Febrero";

            case 3:
                return "Marzo";

            case 4:
                return "Abril";

            case 5:
                return "Mayo";

            case 6:
                return "Junio";

            case 7:
                return "Julio";

            case 8:
                return "Agosto";

            case 9:
                return "Septiembre";

            case 10:
                return "Octubre";

            case 11:
                return "Noviembre";

            case 12:
                return "Diciembre";

            default:
                break;
        }
        return "";
    } // fin obtenerNombreMes
} // fin Impresiones