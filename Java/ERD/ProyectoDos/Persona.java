public class Persona {
    private String nombre;
    private String cedula;
    private int phoneNumber;
    private Persona siguiente;

    public Persona(String n, String c, int pn) {
        this.nombre = n;
        this.cedula = c;
        this.phoneNumber = pn;
        this.siguiente = null;
    }

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
