package homework5;

import java.util.Scanner;

public class WordGuessingGame {
    public static void main(String[] args) {
        String[] words = {
            "write", "that", "program", "computer", "science",
            "java", "python", "algorithm", "function", "variable"
        };

        Scanner input = new Scanner(System.in);
        boolean continueGame = true;

        while (continueGame) {
            // 随机选择一个单词
            String word = words[(int) (Math.random() * words.length)];
            // 调用猜词方法
            int missed = guessWord(word, input);
            // 显示结果
            System.out.println("The word is " + word + ". You missed " + missed + " time" + (missed != 1 ? "s" : ""));
            // 询问是否继续
            System.out.print("Do you want to guess another word? Enter y or n> ");
            String answer = input.next();
            if (answer.equalsIgnoreCase("n")) {
                continueGame = false;
            }
        }

        input.close();
    }

    public static int guessWord(String word, Scanner input) {
        // 存储已猜测的字母
        boolean[] guessed = new boolean[word.length()];
        int missed = 0;
        int correctCount = 0;

        // 主循环：直到所有字母都被猜出
        while (correctCount < word.length()) {
            // 显示当前猜测状态
            System.out.print("(Guess) Enter a letter in word ");
            for (int i = 0; i < word.length(); i++) {
                if (guessed[i]) {
                    System.out.print(word.charAt(i));
                } else {
                    System.out.print("*");
                }
            }
            System.out.print(" > ");

            // 获取用户输入的字母
            String guess = input.next().toLowerCase();
            char letter = guess.charAt(0);

            // 检查字母是否已经在单词中被猜出
            boolean alreadyGuessed = false;
            for (int i = 0; i < word.length(); i++) {
                if (guessed[i] && word.charAt(i) == letter) {
                    alreadyGuessed = true;
                    break;
                }
            }

            if (alreadyGuessed) {
                System.out.println(letter + " is already in the word");
                continue;
            }

            // 检查字母是否在单词中
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == letter && !guessed[i]) {
                    guessed[i] = true;
                    correctCount++;
                    found = true;
                }
            }

            if (!found) {
                System.out.println(letter + " is not in the word");
                missed++;
            }
        }

        return missed;
    }
}
