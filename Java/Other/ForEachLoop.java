import java.util.ArrayList;

public class ForEachLoop {
    public static void main(String[] args){
        ArrayList<String> animals = new ArrayList<String>();
        animals.add("gato");
        animals.add("perro");
        animals.add("pajaro");
        animals.add("tortuga");

        // para cada string i en animales, imprime i
        // Itera los elementos dentro de un arreglo o una colección
        for(String i : animals){
            System.out.println(i);
        }
    }
}
