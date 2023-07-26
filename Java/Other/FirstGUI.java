import java.io.*;
import javax.swing.JOptionPane;

public class FirstGUI {
    public static void main (String[] args) throws IOException {

        String name = JOptionPane.showInputDialog("Enter your name: ");
        JOptionPane.showMessageDialog(null, "Hello " + name);

        while(true){
            try{
                int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age: "));

                if(age < 0 || age > 130) {
                    throw new Exception(); 
                }

                JOptionPane.showMessageDialog(null, "You're " + age + " years old.");
                break;
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Enter a correct age!");
            }
        }

        double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter your salary: "));
        JOptionPane.showMessageDialog(null, "Your salary is " + salary);

        System.out.println("End!");
    } // main end
} // FirstGUI end