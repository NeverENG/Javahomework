package homework4;
import java.util.Scanner;
public class DisplayPyramid {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows for the pyramid: ");
        int rows = input.nextInt();
        if(rows <= 0 || rows > 15) {
            System.out.println("Please enter a number between 1 and 15.");
            return;
        }
        for (int i = 1; i <= rows; i++) {
            
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print(k);
            }
            System.out.println(); // 换行
        }
    }
}
