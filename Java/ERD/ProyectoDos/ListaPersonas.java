public class ListaPersonas {
    Persona primero;

    public ListaPersonas() {
        this.primero = null;
    }

    public void insertarAlInicio(Persona p) {

        if (verificarAlmacenamiento()) {
            primero = p;
        } else {
            p.setSiguiente(primero);
            primero = p;
        }
    }

    public void insertarAlFinal(Persona p) {

        if (verificarAlmacenamiento()) {
            primero = p;
        } else {
            Persona ultimo = buscarFinal();
            ultimo.setSiguiente(p);
        }
    }

    public Persona buscarFinal() {

        Persona control = primero;

        while (true) {

            if (control.getSiguiente() == null) {
                return control;
            }

            control = control.getSiguiente();
        }
    }

    public int buscarNombre(String n) {

        Persona control = primero;
        int contador = 1;

        while (control != null) {

            if (control.getNombre().equals(n)) {
                return contador;
            }

            control = control.getSiguiente();
            contador = contador + 1;
        }

        return 0;
    }

    public void imprimirRegistros() {
        Persona control = primero;

        while (control != null) {

            System.out.println(
                    control.getNombre() + " - " + control.getCedula() + " - " + control.getPhoneNumber() + "\n");
            control = control.getSiguiente();

        }

    }

    public boolean verificarAlmacenamiento() {
        if (primero == null) {
            return true;
        } else {
            return false;
        }

    }

    public void eliminarRegistro(String n) {
        Persona control = primero;
        Persona controlAnterior = null;

        if (buscarNombre(n) > 0) {
            if (control.getNombre().equals(n)) {
                primero = control.getSiguiente();
                return;
            }
            while (!control.getNombre().equals(n)) {
                controlAnterior = control;
                control = control.getSiguiente();
            }
            if (control.getSiguiente() == null) {
                controlAnterior.setSiguiente(control.getSiguiente());
                return;
            }
            controlAnterior.setSiguiente(control.getSiguiente());
            System.out.println("Su registro se ha eliminado con exito");
        } else {
            System.out.println("El registro no se encuentra en la lista");
        }

    }

}
