import java.util.ArrayList;

public class ArrayListTut {
    public static void main(String[] args){

        ArrayList<String> food = new ArrayList<String>();
        food.add("Lasagna");
        food.add("Spaguetti");
        food.add("Tortillas");
        food.add("Sao");
        
        for(int i = 0; i < food.size(); i++){
            System.out.println(food.get(i));
        }
        System.out.println();

        // Set "Super Lasagna" at index 0
        food.set(0,"Super Lasagna");
        food.remove(3);
        // food.clear(); cleans the arraylist

        for(int i = 0; i < food.size(); i++){
            System.out.println(food.get(i));
        }
    }
}
