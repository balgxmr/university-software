public class ListaPersonas {
    Persona primero;

    public ListaPersonas() {
        this.primero = null; // Se inicializa el primer nodo de la lista como null, indicando que
                             // no hay ningun nodo enlazado inicialmente.
    }

    public void insertarAlInicio(Persona p) {
        if (verificarAlmacenamiento()) {
            primero = p;  // Como la lista está vacia en este caso, se establece a la persona como primera en la lista
        } else { // Se ejecuta en caso de que la lista contenga alguna persona
            p.setSiguiente(primero); // Se enlaza a la persona al primer nodo actual en la lista
            primero = p;    // Se establece que primero apunte al siguiente nodo
        }
    }

    public void insertarAlFinal(Persona p) {

        if (verificarAlmacenamiento()) {
            primero = p; // Como la lista está vacia en este caso, se establece a la persona como primera en la lista
        } else {
            Persona ultimo = buscarFinal(); // Se declara "ultimo" y se busca el ultimo nodo de la lista
            ultimo.setSiguiente(p); // Se establece a p al último nodo en la lista
        }
    }


    /* Método que busca y retorna el último nodo de la lista */
    public Persona buscarFinal() {

        Persona control = primero;

        // Ciclo while para recorrer la lista
        while (true) {

            if (control.getSiguiente() == null) { // Cuando el siguiente nodo en control sea null, se retorna el control actual
                return control;
            }

            control = control.getSiguiente();
        }
    }

    /* Método que busca y retorna el nombre que ingrese el usuario, usando .equals() para
     * verificar que el nombre en la lista coincida con el del usuario.
     */
    public int buscarNombre(String n) {

        Persona control = primero;
        int contador = 1;

        /* Ciclo while para recorrer la lista hasta antes de que llegue al último nodo, buscando el nombre */
        while (control != null) {

            if (control.getNombre().equals(n)) { // Si el nombre es igual al actual en la lista, se retorna el contador
                                                 // utilizado para saber la posición en la que se encuentra el nombre.
                return contador;
            }

            control = control.getSiguiente();
            contador = contador + 1;
        }

        // Se retorna 0 en caso de no encontrar el nombre en la lista
        return 0;
    }

    public void imprimirRegistros() {
        Persona control = primero;

        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║ Nombre                 | Cédula                 | Numero de Teléfono             ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════╣");

        /* Ciclo while que se recorre hasta antes de que llegue al último nodo, para imprimir los nombres */
        while (control != null) {
            System.out.printf("║ %-22s | %-22s | %-14d                 ║\n", control.getNombre(), control.getCedula(), control.getPhoneNumber());
            control = control.getSiguiente();
        }
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════╝");
    }

    public boolean verificarAlmacenamiento() {
        if (primero == null) {
            return true;
        } else { // Si primero no es null, indica que ya existen personas en la lista
            return false;
        }

    }

    public void eliminarRegistro(String n) {
        Persona control = primero;
        Persona controlAnterior = null;

        // Ejecutar solo si existe el nombre en la lista
        if (buscarNombre(n) > 0) {
            // Verificar que el control actual es igual al nombre ingresado por el usuario
            if (control.getNombre().equals(n)) {
                primero = control.getSiguiente(); // Se establece al siguiente nodo del primero, como primero en la lista
                return;
            }
            // Ciclo while que recorre cuando el nombre se encuentra en la lista
            while (!control.getNombre().equals(n)) {
                controlAnterior = control; // Se pasa el nodo del control actual o nombre que queremos eliminar al nodo anterior
                control = control.getSiguiente(); // Se pasa el nodo del control actual o nombre que queremos eliminar al siguiente nodo
            }
            // Si no es ninguna de las anteriores, significa que el nodo es el ultimo en la lista
            // y se establece al anterior como el último
            controlAnterior.setSiguiente(control.getSiguiente());
        } else {
            System.out.println("El registro no se encuentra en la lista");
        }
    } // fin eliminarRegistro()
} // fin clase ListaPersonas
