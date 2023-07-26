import java.util.Random;

public class RandomInJava {
    public static void main (String [] args){
        Random random = new Random();

        // int x = random.nextInt();
        int x = random.nextInt(6)+1; // 6 will gen. a num between 0 and 6 but to gen a num between
                                           // 1 and 6, just add +1;
        System.out.println(x);
    }
}