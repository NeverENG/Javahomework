package lab4;

import java.util.Scanner;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class TheSameNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputList = new ArrayList<>();

        System.out.println("请输入数字（每行一个，输入空行结束）：");

        // 读取用户输入
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                break;
            }

            try {
                int num = Integer.parseInt(line);
                inputList.add(num);
            } catch (NumberFormatException e) {
                System.out.println("请输入有效的整数！");
            }
        }

        if (inputList.isEmpty()) {
            System.out.println("没有输入任何数字！");
            scanner.close();
            return;
        }

        System.out.println("\n原始输入：");
        printList(inputList);
        // 使用LinkedHashSet去重（保持插入顺序）
        Set<Integer> uniqueSet = new LinkedHashSet<>(inputList);
        List<Integer> resultList = new ArrayList<>(uniqueSet);
        System.out.println("\n去重后的结果：");
        printList(resultList);
        scanner.close();
    }

    public static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}

