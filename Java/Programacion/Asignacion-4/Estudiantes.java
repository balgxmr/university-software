// Jonathan Nuñez 4-823-1010, Richard Herranz E-8-192057, José Encalada 8-999-1420

public class Estudiantes {

    // Almacenan informacion del estudiante
    private String name;
    private String password;
    private float grades[];

    // Constructor
    public Estudiantes(String n, String p, float[] g) {
        this.name = n;     // nombre
        this.password = p; // contraseña
        this.grades = g;   // calificaciones
    }

    // Obtener nombre
    public String getNombre() {
        return name;
    }

    // Obtener contraseña
    public String getPassword() {
        return password;
    }

    // Establecer contraseña
    public void setPassword(String p) {
        this.password = p;
    }

    // Obtener notas
    public float[] getGrades() {
        return grades;
    }

} // fin class
