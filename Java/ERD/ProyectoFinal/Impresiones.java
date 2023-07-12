public class Impresiones {
    public void imprimirEstudiantes (Estudiante[] estudiantes){
        System.out.println("-----------------------------------");
        for (int i = 0; i < 2; i++) {
            Estudiante estudiante = estudiantes[i];
            System.out.println(Colors.GREEN + "Nombre: " + Colors.RESET_COLOR + estudiante.getName());
            System.out.println(Colors.GREEN + "Cédula: " + Colors.RESET_COLOR + estudiante.getCedula());
            System.out.println(Colors.GREEN + "Mes de nacimiento: " + Colors.RESET_COLOR + estudiante.getMesNac());
            System.out.println(Colors.GREEN + "Año de nacimiento: " + Colors.RESET_COLOR + estudiante.getAnioNac());
            System.out.println(Colors.GREEN + "Carrera: " + Colors.RESET_COLOR + estudiante.getCarrera());
            System.out.println(Colors.GREEN + "Índice: " + Colors.RESET_COLOR + estudiante.getIndice());
            System.out.println("-----------------------------------");
        }
    }
}