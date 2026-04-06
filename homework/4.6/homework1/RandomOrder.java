import java.util.*;
import java.io.File;
import java.io.FileNotFoundException; // 1. 导入异常类

class RandomOrder {
    int N;
    ArrayList<String> arr = new ArrayList<>();
    String file = "students.txt";
    
    
    
    public RandomOrder(int N) {
        this.N = N;
    }
    
    // 3. 修改读取方法，在这里处理文件读取和异常
    public void GetAllStudents() {
        arr.clear(); // 每次读取前清空
        try {
            // 在这里创建 Scanner
            Scanner sc = new Scanner(new File(file));
            
            while (sc.hasNextLine() && arr.size() < N) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    arr.add(line);
                }
            }
            sc.close(); // 记得关闭文件
            this.N = arr.size(); // 更新实际读取到的数量
            System.out.println("成功读取 " + this.N + " 个学生数据。");
            
        } catch (FileNotFoundException e) {
            System.err.println("错误：找不到文件 " + file);
            System.out.println("请确保 students.txt 在项目根目录下！");
            e.printStackTrace();
        }
    }

    public void Shuffle() {
        Collections.shuffle(arr);
    }
    
    // 分组一组 M 人
    public ArrayList<ArrayList<String>> GetPairs(int M, String sortMethod) {
        ArrayList<ArrayList<String>> con = new ArrayList<>();
        for (int i = 0; i < N; i = i + M) {
            ArrayList<String> group = new ArrayList<>(arr.subList(i, Math.min(i + M, N)));
            if ("bubble".equals(sortMethod)) {
                BubbleSort(group);
            } else if ("selection".equals(sortMethod)) {
                SelectionSort(group);
            } else if ("insertion".equals(sortMethod)) {
                InsertionSort(group);
            }
            con.add(group);
        }
        return con;
    }

    // 冒泡排序
    public void BubbleSort(ArrayList<String> group) {
        int size = group.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (group.get(j).compareTo(group.get(j + 1)) > 0) {
                    String temp = group.get(j);
                    group.set(j, group.get(j + 1));
                    group.set(j + 1, temp);
                }
            }
        }
    }

    // 选择排序
    public void SelectionSort(ArrayList<String> group) {
        int size = group.size();
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (group.get(j).compareTo(group.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            String temp = group.get(i);
            group.set(i, group.get(minIndex));
            group.set(minIndex, temp);
        }
    }

    // 插入排序
    public void InsertionSort(ArrayList<String> group) {
        int size = group.size();
        for (int i = 1; i < size; i++) {
            String key = group.get(i);
            int j = i - 1;
            while (j >= 0 && group.get(j).compareTo(key) > 0) {
                group.set(j + 1, group.get(j));
                j--;
            }
            group.set(j + 1, key);
        }
    }

    // 输出分组结果
    public void PrintPairs(ArrayList<ArrayList<String>> con) {
        for (ArrayList<String> group : con) {
            System.out.println(String.join(" ", group));
        }
    }

    public static void main(String[] args) {
        // 这里的 Scanner 是用于读取键盘输入的，与文件无关
        Scanner sc = new Scanner(System.in);
        System.out.println("准备就绪。");
        
        int N = 10000;
        int M = 3;
        
        RandomOrder ro = new RandomOrder(N);
        
        // 调用修改后的方法
        ro.GetAllStudents();
        
        // 如果文件读取失败（数组为空），则不执行后续操作
        if (ro.arr.isEmpty()) {
            System.out.println("没有数据，程序结束。");
            return;
        }

        ro.Shuffle();
        
        // 排序完输出时间
        long startTime = System.nanoTime();
        ArrayList<ArrayList<String>> con = ro.GetPairs(M, "bubble");
        long endTime = System.nanoTime();
        System.out.println("冒泡排序耗时: " + (endTime - startTime) + " ns");
        
        // 选择排序
        startTime = System.nanoTime();
        con = ro.GetPairs(M, "selection");
        endTime = System.nanoTime();
        System.out.println("选择排序耗时: " + (endTime - startTime) + " ns");
        
        // 插入排序
        startTime = System.nanoTime();
        con = ro.GetPairs(M, "insertion");
        endTime = System.nanoTime();
        System.out.println("插入排序耗时: " + (endTime - startTime) + " ns");
    }
}