import java.util.ArrayList;

public class ArrayList2D {
    public static void main(String[] args){
        ArrayList<ArrayList<String>> listaDeCompra = new ArrayList<>();

        ArrayList<String> vegetales = new ArrayList<>();
        vegetales.add("Aceitunas");
        vegetales.add("Zanahorias");
        vegetales.add("espinaca");

        ArrayList<String> frutas = new ArrayList<>();
        frutas.add("Pera");
        frutas.add("Sandia");
        frutas.add("Uvas");

        ArrayList<String> carnes = new ArrayList<>();
        carnes.add("Carne de res");
        carnes.add("Puerco");
        carnes.add("Pollo");

        listaDeCompra.add(vegetales);
        listaDeCompra.add(frutas);
        listaDeCompra.add(carnes);

        System.out.println(listaDeCompra);
        // get from index 0 (vegetales) the index 2 (espinaca)
        System.out.println(listaDeCompra.get(0).get(2));

    }
}
