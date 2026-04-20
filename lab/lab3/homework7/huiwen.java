package homework7;

import java.util.Scanner;

public class huiwen {
    public static long reverse(long number) {
        long reversed = 0;
        while (number != 0) {
            long digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return reversed;
    }

    // return true if number is Palindrome
    public static boolean isPalindrome(long number) {
        return number == reverse(number);
    }

    public static void main(String[] args) {
        System.out.println("满足条件的正整数有：");
        for (long n = 1; n < 100000; n++) {
            long square = n * n;
            long cube = n * n * n;
            if (isPalindrome(n) && isPalindrome(square) && isPalindrome(cube)) {
                System.out.println(n);
            }
        }
    }
}
