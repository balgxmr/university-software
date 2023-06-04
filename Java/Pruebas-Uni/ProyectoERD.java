import java.io.*; //Se importan las librerias necesarias

class Estudiante { // se crea el registro
    private String nombre; // declaramos todos sus atributos
    private String cedula;
    private int mes;
    private int año;
    private String carrera;
    private float indice;

    // con el constructor enviamos los datos
    // como parametros y los almacenamos en los
    // atributos del registro
    public Estudiante(String n, String c, int m, int a, String ca, float i) {
        this.nombre = n;
        this.cedula = c;
        this.mes = m;
        this.año = a;
        this.carrera = ca;
        this.indice = i;
    }

    // funciones para obtener y utilizar los valores almacenados en el registro
    public String getNombre() {
        return this.nombre;
    }

    public int getMes() {
        return this.mes;
    }

    public float getIndice() {
        return this.indice;
    }

    public String getCarrera() {
        return this.carrera;
    }
}

public class ProyectoERD {
    public static void main(String[] args) throws Exception {

        String nombre;// declaramos variables donde el usuario ingresara los datos
        String cedula;
        int mes;
        int año;
        String carrera;
        float indice = 0;
        String carreraciclo = "";
        String mesesDelAnio[] = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
                "Septiembre", "Octubre", "Noviembre", "Diciembre" };// arreglo para imprimir los meses del año

        Estudiante estudiantes[] = new Estudiante[100];// arreglo de objetos donde se almacenara en cada posicion todos
                                                       // los atributos del registro

        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));// para leer los valores e imprimir
                                                                                   // en pantalla

        // ciclo for para recolectar los datos ingresados en las variables
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println("Ingrese el nombre del estudiante");
            nombre = leer.readLine();
            System.out.println("Ingrese la cedula del estudiante");
            cedula = leer.readLine();
            System.out.println("Ingrese el mes de nacimiento del estudiante");
            mes = Integer.parseInt(leer.readLine());
            System.out.println("Ingrese el año de nacimiento del estudiante");
            año = Integer.parseInt(leer.readLine());
            System.out.println("Ingrese la carrera del estudiante");
            carrera = leer.readLine();
            boolean loop = true;
            while (loop) {// ciclo while para que el usuario ingrese un valor aceptable en el indice
                          // dentro del rango 0 a 3
                System.out.println("Ingrese el indice del estudiante");
                indice = Float.parseFloat(leer.readLine());
                if (indice > 3.00 || indice < 0) {
                    System.out.println("El indice tiene que estar en el rango de 0 a 3");
                } else {
                    loop = false;
                }
            }

            estudiantes[i] = new Estudiante(nombre, cedula, mes, año, carrera, indice);// se envian los datos como
                                                                                       // parametros al constructor de
                                                                                       // nuestro registro por cada
                                                                                       // posicion i dentro del ciclo
                                                                                       // for

        }

        // algoritmo burbuja para ordenar en funcion del indice y la carrera
        Estudiante aux;
        for (int i = 0; i < estudiantes.length; i++) {
            for (int j = 0; j < estudiantes.length - i - 1; j++) {
                // el metodo compareto devuelve un numero entero menor que 0 cuando son
                // diferentes los strings
                if (estudiantes[j + 1].getCarrera().compareTo(estudiantes[j].getCarrera()) < 0 ||
                        (estudiantes[j + 1].getCarrera().equals(estudiantes[j].getCarrera())
                                && estudiantes[j + 1].getIndice() > estudiantes[j].getIndice())) {
                    aux = estudiantes[j + 1];
                    estudiantes[j + 1] = estudiantes[j];
                    estudiantes[j] = aux;

                }
            }
        }

        int n = 0;

        // algoritmo para imprimir ordenadamente por carrera 5 personas con el indice
        // mas alto, tambien valida si el indice es mayor a 2.5
        for (int i = 0; i < estudiantes.length; i++) {

            if (!carreraciclo.equals(estudiantes[i].getCarrera())) {
                n = 0;
                carreraciclo = estudiantes[i].getCarrera();

            }
            // se imprimen en pantalla la salida con los datos del
            // nombre, mes de nacimiento, carrera y el indice de cada
            // estudiante entre los mejores 5 de su carrera y con un
            // promedio de mas de 2.5
            if (estudiantes[i].getIndice() >= 2.5 && n < 5) {
                System.out.println(
                        "Nombre: " + estudiantes[i].getNombre() + " | Mes de nacimiento: "
                                + mesesDelAnio[estudiantes[i].getMes() - 1] + " | Carrera: "
                                + estudiantes[i].getCarrera() + " | Indice: " + estudiantes[i].getIndice());
                n = n + 1;
            }
        }

    }
}
