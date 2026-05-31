import java.io.*;
import java.util.*;
import java.util.regex.*;

public class WordCounter {
    public static void main(String[] args) throws IOException {
        Scanner fileScanner = new Scanner(new File("text.txt"));
        StringBuilder sb = new StringBuilder();
        while (fileScanner.hasNextLine()) {
            sb.append(fileScanner.nextLine()).append(" ");
        }
        fileScanner.close();

        String text = sb.toString().toLowerCase();
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(text);

        List<String> allWords = new ArrayList<>();
        while (matcher.find()) {
            allWords.add(matcher.group());
        }

        // 频率统计
        Map<String, Integer> freqMap = new HashMap<>();
        for (String w : allWords) {
            freqMap.put(w, freqMap.getOrDefault(w, 0) + 1);
        }

        // 按频率降序排序
        List<Map.Entry<String, Integer>> list = new ArrayList<>(freqMap.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("共有" + allWords.size() + "个单词，有"
                + freqMap.size() + "个不同的单词，按照出现频率排列：");
        for (Map.Entry<String, Integer> e : list) {
            double pct = e.getValue() * 100.0 / allWords.size();
            System.out.printf("%-12s %.1f%%%n", e.getKey(), pct);
        }
    }
}
