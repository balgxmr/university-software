/* 
 * Grupo 1SF121
 * 
 * Jonathan Núñez (4-823-1010)
 * José Encalada (8-999-1420)
 * Richard Herranz (E-8-192057)
 */

public class Persona {
    // Inicializar atributos
    private String nombre;
    private String cedula;
    private int phoneNumber;
    private Persona siguiente;

    // Constructor Persona que recibe parametros: nombre, cedula y phoneNumber para inicializarlos
    public Persona(String n, String c, int pn) {
        this.nombre = n;
        this.cedula = c;
        this.phoneNumber = pn;
        this.siguiente = null;
    }

    /* Métodos para obtener cedula, nombre, el siguiente, numero de teléfono y 
     * poder establecer el siguiente */
    public String getNombre() {
        return nombre;
    }

    public Persona getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Persona siguiente) {
        this.siguiente = siguiente;
    }

    public String getCedula() {
        return cedula;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
}
