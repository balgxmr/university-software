// Jonathan Nuñez 4-823-1010, Richard Herranz E-8-192057, José Encalada 8-999-1420

// Se importan las librerias
import java.io.*;

public class Principal {
    public static void main(String[] args) throws IOException {

        // Se crean los objetos
        CapturarDatos datos = new CapturarDatos();
        Calificaciones calificaciones = new Calificaciones();

        // Declaracion de variables
        boolean loop = true;
        boolean loop2 = true;
        int contadorError = 0;
        int optionMenu;
        int optionUsuario;
        String name;
        String password;
        String oldPassword;
        String newPassword;
        float grades[] = new float[5];
        int contador = -1;

        Estudiantes registroEstudiantes[] = new Estudiantes[5];

        System.out.println("Bienvenido señor Administrador:\n");

        while (loop) {
            optionMenu = datos.capturarMenu(
                    "Que opcion desea realizar?\nIngrese 1 Para crear un nuevo usuario\nIngrese 2 Para actualizar la contraseña de un usuario\nIngrese 3 para ver el total de notas y el promedio final de un usuario\nIngrese 4 para ver el nombre de los usuarios existentes\nIngrese 5 para salir del programa");
            
            /* OPCION 1: Crear un nuevo usuario */
            if (optionMenu == 1) {
                // Validar que se registren en total solo 5 estudiantes
                if (contador <= 4) {
                    System.out.println("Formulario para crear nuevo usuario:\n");
                    name = datos.capturarDatos("Ingrese el nombre del estudiante");
                    password = datos.capturarDatos("Ingrese la contraseña del estudiante");

                    // Registra las 5 notas del estudiante
                    for (int i = 0; i <= 4; i++) {
                        grades[i] = datos.capturarNotas("Ingrese la calificacion " + (i + 1));
                    }

                    contador = contador + 1; // Aumenta contador = nuevo estudiante ingresado

                    registroEstudiantes[contador] = new Estudiantes(name, password, grades); // Se pasan el nombre, contraseña y calificacion 
                                                                                             // al registro de estudiantes en posicion del contador.
                    System.out.println("Registro completado con exito\n");
                } else {
                    System.out.println("Solo esta permitido el registro de 5 usuarios\nPruebe otra opcion en el menu\n");
                } // fin if-else (contador)

            /* OPCION 2: Actualizar contraseña de un usuario */
            } else if (optionMenu == 2) {
                if (contador >= 0) {
                    System.out.println("Formulario para actualizar contraseña:\n");
                    System.out.println("Usuarios existentes: \n");
                    for (int i = 0; i < contador + 1; i++) {
                        System.out.println("Ingrese " + (i + 1) + " para " + registroEstudiantes[i].getNombre() + "\n");
                    }
                    loop2 = true;
                    while (loop2) {
                        optionUsuario = datos.capturarMenu("Escoja el usuario que desea cambiar la contraseña");

                        if (optionUsuario <= contador + 1 && optionUsuario >= 1) {
                            loop2 = false;
                            while (true) {
                                oldPassword = datos.capturarDatos("Ingrese la contraseña actual");
                                if (oldPassword.equals(registroEstudiantes[optionUsuario - 1].getPassword())) {
                                    newPassword = datos.capturarDatos("Ingrese la nueva contraseña");
                                    registroEstudiantes[optionUsuario - 1].setPassword(newPassword); // En registroEstudiantes se establece la nueva
                                                                                                     // contraseña, pasando newPassword a setPassword.
                                    System.out.println("Su contraseña se ha actualizado con exito\n");
                                    break;
                                } else {
                                    contadorError = contadorError + 1;
                                    if (contadorError == 3) {
                                        System.out.println("Ha colocado la contraseña mal 3 veces");
                                        break;
                                    } else {
                                        System.out.println("La contraseña es incorrecta, intentelo de nuevo");
                                    } // fin if-else (contadorError)
                                } // fin if-else (verificar contraseña)
                            } // fin while (true)
                        } else {
                            System.out.println("valor invalido");
                        } // fin if-else (optionUsuario)
                    } // fin while (loop2)
                } else {
                    System.out.println(
                            "No hay usuarios registrados actualmente, pruebe a crear uno nuevo en la opcion numero 1 del menu\n");
                } // fin if-else (contador)

            /* OPCION 3: Total de notas y promedio de un usuario */
            } else if (optionMenu == 3) {
                if (contador >= 0) {
                    System.out.println("Ver las calificaciones de un estudiante\n");
                    System.out.println("Usuarios existentes: \n");
                    
                    // for para imprimir en pantalla el o los usuarios existentes
                    for (int i = 0; i < contador + 1; i++) {
                        System.out.println("Ingrese " + (i + 1) + " para " + registroEstudiantes[i].getNombre() + "\n");
                    }

                    while (true) {
                        optionUsuario = datos.capturarMenu(
                                "Escoja el estudiante para ver sus calificaciones y calcular el promedio");
                        
                        // Verificar que el usuario seleccionado, exista
                        if (optionUsuario <= contador + 1 && optionUsuario >= 1) {
                            calificaciones.imprimirNotas(registroEstudiantes[optionUsuario - 1].getGrades());
                            System.out.println("El promedio es: " + calificaciones
                                    .calcularPromedio(registroEstudiantes[optionUsuario - 1].getGrades()));
                            break;
                        } else {
                            System.out.println("valor invalido");
                        } // fin if-else
                    } // fin while
                } else {
                    System.out.println(
                            "No hay usuarios registrados actualmente, pruebe a crear uno nuevo en la opcion numero 1 del menu\n");
                }

            /* OPCION 4: Ver nombres de usuarios existentes */
            } else if (optionMenu == 4) {
                if (contador >= 0) {
                    System.out.println("Ver nombres de los usuarios existentes\n");
                    System.out.println("Usuarios existentes: \n");
                    for (int i = 0; i < contador + 1; i++) {
                        System.out.println("Usuario " + (i + 1) + ": " + registroEstudiantes[i].getNombre() + "\n");
                    }
                } else {
                    System.out.println(
                            "No hay usuarios registrados actualmente, pruebe a crear uno nuevo en la opcion numero 1 del menu\n");
                } // fin if-else (contador)

            /* OPCION 5: Salir del programa */
            } else if (optionMenu == 5) {
                System.out.println("Ha salido del programa exitosamente");
                loop = false;
            } // fin if-else (optionMenu)
        } // fin while
    } // fin main
} // fin class