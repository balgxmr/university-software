// Importar librerias
import java.io.*;

public class Principal {
    public static void main(String[] args) throws IOException {

        // Crear objetos de las clases indicadas
        CapturarDatos datos = new CapturarDatos();
        ListaPersonas lista = new ListaPersonas();

        // Declaración de variables
        int option;
        String name;
        String cedula;
        int phoneNumber;
        int busqueda;
        boolean loop = true;

        // Se llama al metodo Clean de la clase Limpieza para limpiar la consola
        Limpieza.Clean();

        System.out.println("Bienvenido al sistema para guardar registro de personas");

        while (loop) {

            option = datos.capturarMenu(
                    "Seleccione una opcion\n1. Insertar nuevo registro\n2. Buscar registro mediante el nombre\n3. Eliminar registro mediante el nombre\n4. Imprimir registros\n5. Salir del programa\n> ");

            if (option == 1) { // INSERTAR NUEVO REGISTRO
                Limpieza.Clean();
                System.out.println("> Opcion 1: Insertar nuevo registro");
                name = datos.capturarDatos("Escriba el nombre que desea añadir: ");
                cedula = datos.capturarDatos("Escriba su cedula: ");
                phoneNumber = datos.capturarNumero("Escriba su numero de telefono: ");
                Persona nuevaPersona = new Persona(name, cedula, phoneNumber); // pasar parametros name, cedula y phoneNumber a nuevaPersona
                option = datos
                        .capturarPosicion("En que posicion desea añadir el nuevo registro?\n1. Al inicio\n2. Al final\n> ");
                
                // Insertar a la nueva persona al inicio o al final
                if (option == 1) {
                    lista.insertarAlInicio(nuevaPersona);
                    System.out.println("\u001B[32mEl registro se ha añadido con exito\u001B[0m\n");
                } else {
                    lista.insertarAlFinal(nuevaPersona);
                    System.out.println("\u001B[32mEl registro se ha añadido con exito\u001B[0m\n");
                }
            } else if (option == 2) { // BUSCAR REGISTRO MEDIANTE EL NOMBRE
                Limpieza.Clean();
                System.out.println("> Opcion 2: Buscar registro mediante el nombre");
                if (lista.verificarAlmacenamiento()) {
                    System.out.println("\u001B[31mLa lista esta vacia\u001B[0m\n");
                } else {
                    name = datos.capturarDatos("Escriba el nombre que desea buscar: ");
                    busqueda = lista.buscarNombre(name);
                    if (busqueda > 0) {
                        System.out
                                .println("\u001B[32mEl registro " + name + " se encuentra en la lista y esta en la posicion "
                                        + busqueda + "\u001B[0m\n");
                    } else { // Si busqueda no es mayor a 0, indica que el nombre no está en la lista
                        System.out.println("\u001B[31mEl registro buscado no se encuentra en la lista\u001B[0m\n");
                    }
                }

            } else if (option == 3) { // ELIMINAR REGISTRO
                Limpieza.Clean();
                System.out.println("> Opcion 3: Eliminar un registro");
                if (lista.verificarAlmacenamiento()) {
                    System.out.println("\u001B[31mLa lista esta vacia\u001B[0m\n");
                } else {
                    name = datos.capturarDatos(("Escriba el nombre que desea eliminar: "));
                    lista.eliminarRegistro(name); // Se pasa el nombre a eliminar
                    System.out.println("\u001B[32mEl registro se ha eliminado con exito\u001B[0m\n");
                }
            } else if (option == 4) { // IMPRIMIR REGISTRO
                Limpieza.Clean();
                System.out.println("> Opcion 4: Imprimir los registros");
                if (lista.verificarAlmacenamiento()) {
                    System.out.println("\u001B[31mLa lista esta vacia\u001B[0m\n");
                } else {
                    System.out.println("Impresion de registros en orden: ");
                    lista.imprimirRegistros();
                }
            } else if (option == 5) { // SALIR DEL PROGRAMA
                System.out.println("Ha salido del programa con exito");
                loop = false;
            }
        } // fin while
    } // fin main
} // fin clase Principal