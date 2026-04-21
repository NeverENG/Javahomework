package lab5;

import java.util.Scanner;

public class SumEachDigtal {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(sumEachDigtal(n));
    }
    public static int sumEachDigtal(long n){
        if(n == 0){
            return 0;
        }
        return (int)(n % 10) + sumEachDigtal(n / 10);
    }
}
