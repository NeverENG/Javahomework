package lab3;

    // Student.java - 学生类
class Student {
    // 属性定义
    private String name;        // 姓名
    private int id;             // 学号
    private String className;   // 班级
    private static int count = 0; // 静态属性，记录对象个数
    
    // 有参构造方法
    public Student(String name, int id, String className) {
        this.name = name;
        this.id = id;
        this.className = className;
        count++; // 每创建一个对象，count加1
    }
    
    // 无参构造方法，通过this调用有参构造方法
    public Student() {
        this("default", 0, "default"); // 使用this调用有参构造
    }
    
    // 输出学生基本信息的方法
    public void printInfo() {
        System.out.print(name + ", " + id + ", " + className);
    }
    
    // 静态方法获取count值
    public static int getCount() {
        return count;
    }
}

// TestStudent.java - 测试类
public class TestStudent {
    public static void main(String[] args) {
        // 创建2个Student对象，使用有参构造方法赋值
        Student s1 = new Student("s1", 17101, "171");
        Student s2 = new Student("s2", 17102, "171");
        
        // 调用对象的方法输出学生基本信息
        s1.printInfo();
        System.out.print("; ");
        s2.printInfo();
        System.out.print("; count=" + Student.getCount());
    }
}

