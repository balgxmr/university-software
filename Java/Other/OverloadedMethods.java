import java.io.*;

public class OverloadedMethods {
    public static void main(String[] args) throws IOException{

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("""
Choose one case: 
1. Overload with 2 values
2. Overload with 3 values
3. Overload with 4 values """);
        int x = Integer.parseInt(read.readLine());
        int result = 0;

        switch (x) {
            case 1:
                result = suma(1, 3);
                System.out.println(result);
                break;

            case 2:
                result = suma(1, 3, 19);
                System.out.println(result);
                break;

            case 3:
                result = suma(3, 4, 4, 6);
                System.out.println(result);
                break;
        
            default:
                System.out.println("Exiting program!");
                break;
        }

    } // main end

    static int suma(int a, int b){
        System.out.println("Sobrecarga de método #1");
        return a + b;
    }

    static int suma(int a, int b, int c){
        System.out.println("Sobrecarga de método #2");
        return a + b + c;
    }

    static int suma(int a, int b, int c, int d){
        System.out.println("Sobrecarga de método #3");
        return a + b + c + d;
    }
}
