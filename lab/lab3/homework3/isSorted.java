package homework3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class isSorted {
    static String isSort(int[] arr){
        boolean yes =true;
        int last =arr[0];
        for(int num:arr){
            if (num == last)continue;
            if(last >num){yes=false;break;}
            last =num;
        }
        String result = yes?"isSorted":"No";
        return result;
    }
    
    // 从文件读取数字
    static int[] readNumbersFromFile(String filename) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    numbers.add(Integer.parseInt(line.trim()));
                }
            }
        }
        // 转换为int数组
        int[] arr = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            arr[i] = numbers.get(i);
        }
        return arr;
    }
    
    public static void main(String[] args){
        // 原有测试
        int[] arr1={1,2,3,4,5};
        int[] arr2={1,3,2,4,1};
        System.out.println("arr1:"+isSort(arr1));
        System.out.println("arr2:"+isSort(arr2));
        
        // 从文件读取随机数并测试
        try {
            System.out.println("\n--- 从文件读取随机数测试 ---");
            int[] arrFromFile = readNumbersFromFile("homework3/random_numbers.txt");
            System.out.println("读取到 " + arrFromFile.length + " 个数字");
            
            // 记录开始时间
            long startTime = System.nanoTime();
            String result = isSort(arrFromFile);
            // 记录结束时间
            long endTime = System.nanoTime();
            
            long duration = endTime - startTime;
            System.out.println("结果: " + result);
            System.out.println("执行时间: " + duration + " 纳秒");
            
        } catch (IOException e) {
            System.err.println("读取文件时出错: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
