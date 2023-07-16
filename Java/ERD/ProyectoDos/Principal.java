import java.io.*;

public class Principal {
    public static void main(String[] args) throws IOException {

        CapturarDatos datos = new CapturarDatos();
        ListaPersonas lista = new ListaPersonas();

        int option;
        String name;
        String cedula;
        int phoneNumber;
        int busqueda;
        boolean loop = true;

        System.out.println("Bienvenido al sistema para guardar registro de personas");

        while (loop) {

            option = datos.capturarMenu(
                    "Seleccione una opcion\n1. Insertar nuevo registro\n2. Buscar registro mediante el nombre\n3. Eliminar registro mediante el nombre\n4. Imprimir registros\n5. Salir del programa");

            if (option == 1) {
                name = datos.capturarDatos("Escriba el nombre que desea añadir");
                cedula = datos.capturarDatos("Escriba su cedula");
                phoneNumber = datos.capturarNumero("Escriba su numero de telefono");
                Persona nuevaPersona = new Persona(name, cedula, phoneNumber);
                option = datos
                        .capturarPosicion("En que posicion desea añadir el nuevo registro?\n1. Al inicio\n2. Al final");
                if (option == 1) {
                    lista.insertarAlInicio(nuevaPersona);
                    System.out.println("El registro se ha añadido con exito");
                } else {
                    lista.insertarAlFinal(nuevaPersona);
                    System.out.println("El registro se ha añadido con exito");
                }
            } else if (option == 2) {
                if (lista.verificarAlmacenamiento()) {
                    System.out.println("La lista esta vacia");
                } else {
                    name = datos.capturarDatos("Escriba el nombre que desea buscar");
                    busqueda = lista.buscarNombre(name);
                    if (busqueda > 0) {
                        System.out
                                .println("El registro buscado se encuentra en la lista y esta en la posicion "
                                        + busqueda);
                    } else {
                        System.out.println("El registro buscado no se encuentra en la lista");
                    }
                }

            } else if (option == 3) {
                if (lista.verificarAlmacenamiento()) {
                    System.out.println("La lista esta vacia");
                } else {
                    name = datos.capturarDatos(("Escriba el nombre que desea eliminar"));
                    lista.eliminarRegistro(name);
                    System.out.println("El registro se ha eliminado con exito");
                }
            } else if (option == 4) {
                if (lista.verificarAlmacenamiento()) {
                    System.out.println("La lista esta vacia");
                } else {
                    System.out.println("Impresion de registros en orden:");
                    lista.imprimirRegistros();
                }

            } else if (option == 5) {
                System.out.println("Ha salido del programa con exito");
                loop = false;
            }
        }

    }
}