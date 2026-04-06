//HelloTest.java
import java.util.Scanner;
public class HelloTest {
     public static void main1(String[] args) {
          System.out.println("Please input your name:");
			Scanner input = new Scanner (System.in);
			String yourName = input.next();    
        System.out.println("Hello," +yourName +"!");
     }
}