public class Empleado {
    private String codigo;
    private String name;
    private Float sueldo;
    private Integer condicion;

    public Empleado(String codigo, String name, Float sueldo, Integer condicion) {
        this.codigo = codigo;
        this.name = name;
        this.sueldo = sueldo;
        this.condicion = condicion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getName() {
        return name;
    }

    public Float getSueldo() {
        return sueldo;
    }

    public String getStatusCondicion(){
        if(condicion == 1){
            return "Estable";
        } else if (condicion == 2){
            return "Permanente";
        } else {
            return "ERR!";
        }
    }

    public int getCondicion(){
        return condicion;
    }
}
