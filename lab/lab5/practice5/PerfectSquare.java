import java.util.ArrayList;
import java.util.Scanner;

public class PerfectSquare {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer m: ");
        int m = input.nextInt();

        ArrayList<Integer> factors = new ArrayList<>();
        int num = m;
        int factor = 2;
        while (num > 1) {
            while (num % factor == 0) {
                factors.add(factor);
                num /= factor;
            }
            factor++;
        }

        int n = 1;
        int i = 0;
        while (i < factors.size()) {
            int f = factors.get(i);
            int count = 0;
            while (i < factors.size() && factors.get(i) == f) {
                count++;
                i++;
            }
            if (count % 2 == 1) {
                n *= f;
            }
        }

        System.out.println("The smallest number n is " + n);
        System.out.println("m * n = " + (m * n) + " = " + (int) Math.sqrt(m * n) + "^2");
    }
}
