package ProyectoUno;
public class Estudiante {
    private String name;
    private String cedula;
    private int mesNac;
    private int anioNac;
    private String carrera;
    private Float indice;

    public Estudiante(String n, String s, int m, int a, String c, Float ind) {
        this.name = n;
        this.cedula = s;
        this.mesNac = m;
        this.anioNac = a;
        this.carrera = c;
        this.indice = ind;
    }

    public String getName() {
        return name;
    }

    public String getCedula() {
        return cedula;
    }

    public Integer getMesNac() {
        return mesNac;
    }

    public Integer getAnioNac() {
        return anioNac;
    }

    public String getCarrera() {
        return carrera;
    }

    public Float getIndice() {
        return indice;
    }
}
