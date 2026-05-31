import java.io.*;
import java.util.Scanner;

public class ScoreAnalysis {

    public static void main(String[] args) {
        String dataFile = "scores.txt";
        String outputFile = "scoreAnalysis.txt";

        // 先用代码生成 scores.txt（避免外部文件编码问题）
        String[] rawData = {
            "姓名:张三，数学72 分，物理67 分，英语70 分.",
            "姓名:李四，数学92 分，物理98 分，英语88 分.",
            "姓名:周五，数学68 分，物理80 分，英语77 分."
        };
        try (BufferedWriter w = new BufferedWriter(new FileWriter(dataFile))) {
            for (String line : rawData) {
                w.write(line);
                w.newLine();
            }
        } catch (IOException e) {
            System.out.println("生成 scores.txt 失败：" + e.getMessage());
            return;
        }

        // (1) 读取成绩单，计算总分，写入 scoreAnalysis.txt
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                int total = calcTotal(line);
                writer.write(line + "总分" + total + " 分.");
                writer.newLine();
            }
            System.out.println("成绩分析文件已生成：scoreAnalysis.txt");

        } catch (IOException e) {
            System.out.println("文件读写错误：" + e.getMessage());
        }

        // (2) 单人成绩查询
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要查询的学生姓名：");
        String name = scanner.nextLine().trim();

        try {
            String result = queryScore(outputFile, name);
            System.out.println(result);
        } catch (NameNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("文件读取错误：" + e.getMessage());
        }

        scanner.close();
    }

    private static int calcTotal(String line) {
        int total = 0;
        int index = 0;
        while (index < line.length()) {
            if (line.charAt(index) >= '0' && line.charAt(index) <= '9') {
                int start = index;
                while (index < line.length() && line.charAt(index) >= '0' && line.charAt(index) <= '9') {
                    index++;
                }
                total += Integer.parseInt(line.substring(start, index));
            } else {
                index++;
            }
        }
        return total;
    }

    private static String queryScore(String filePath, String name)
            throws NameNotFoundException, IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("姓名:" + name + "，")
                        || line.contains("姓名:" + name + "。")) {
                    return parseResult(line);
                }
            }
        }
        throw new NameNotFoundException(name);
    }

    private static String parseResult(String line) {
        return line.replace(".总分", "，总分");
    }
}
