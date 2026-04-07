package homework1;

import java.util.Scanner;

public class CaiPiao {
    

    public static void main(String[] args) {
        int caipiao = (int)(Math.random() * 1000);

        Scanner input = new Scanner(System.in);
        System.out.print("输入彩票号码: ");
        int guess = input.nextInt();

        int caipiaoDigit1 = caipiao / 100;        // 百位
        int caipiaoDigit2 = (caipiao % 100) / 10; // 十位
        int caipiaoDigit3 = caipiao % 10;         // 个位

        int guessDigit1 = guess / 100;            // 百位
        int guessDigit2 = (guess % 100) / 10;     // 十位
        int guessDigit3 = guess % 10;             // 个位

        System.out.println("中奖号码是： " + caipiao);

        if (guess == caipiao) {
            
            System.out.println("Exact match: you win $10,000");
        } else if (
            (guessDigit1 == caipiaoDigit1 && guessDigit2 == caipiaoDigit3 && guessDigit3 == caipiaoDigit2) ||
            (guessDigit1 == caipiaoDigit2 && guessDigit2 == caipiaoDigit1 && guessDigit3 == caipiaoDigit3) ||
            (guessDigit1 == caipiaoDigit2 && guessDigit2 == caipiaoDigit3 && guessDigit3 == caipiaoDigit1) ||
            (guessDigit1 == caipiaoDigit3 && guessDigit2 == caipiaoDigit1 && guessDigit3 == caipiaoDigit2) ||
            (guessDigit1 == caipiaoDigit3 && guessDigit2 == caipiaoDigit2 && guessDigit3 == caipiaoDigit1)
        ) {
            System.out.println("Match all digits: you win $3,000");
        } else if (
            (guessDigit1 == caipiaoDigit1 || guessDigit1 == caipiaoDigit2 || guessDigit1 == caipiaoDigit3) ||
            (guessDigit2 == caipiaoDigit1 || guessDigit2 == caipiaoDigit2 || guessDigit2 == caipiaoDigit3) ||
            (guessDigit3 == caipiaoDigit1 || guessDigit3 == caipiaoDigit2 || guessDigit3 == caipiaoDigit3)
        ) {
            System.out.println("Match one digit: you win $1,000");
        } else {
            System.out.println("Sorry, no match");
        }
        
        input.close();
    }
}

