import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Comparator;

// (1) Person类
class Person {
    private String name;
    private LocalDate birthday;

    public Person(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}

// (2) 接口W
interface W {
    double START_SALARY = 1000;

    void work();
}

// (3) Employee类，继承Person，实现W接口
class Employee extends Person implements W {
    private int id;
    private double salary;

    public Employee(String name, LocalDate birthday, int id) {
        super(name, birthday);
        this.id = id;
        this.salary = START_SALARY;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    // 计算年龄
    public int getAge() {
        LocalDate today = LocalDate.now();
        return Period.between(getBirthday(), today).getYears();
    }

    // 实现work()方法
    @Override
    public void work() {
        if (getAge() < 18) {
            throw new IllegalArgumentException(
                    id + " " + getName() + " " + getAge() + "\n"
                            + " Employee info error!The employee's legal age for work can not less than 18!");
        }
        salary = salary + 1000;
        System.out.println(id + " " + getName() + " " + getAge() + "\n"
                + "The employee is working!");
        System.out.println("Work Finish!");
        System.out.println("The salary is " + salary);
    }

    @Override
    public String toString() {
        return  id + " " + getName()
                + " " + getBirthday();
    }
}

// (4) 测试类
public class homework2 {
    public static void main(String[] args) {
        // 创建包含三个元素的Employee数组
        Employee[] employees = new Employee[3];

        employees[0] = new Employee("zhangsan", LocalDate.of(1980, 12, 1), 105);
        employees[1] = new Employee("lisi", LocalDate.of(1990, 6, 15), 103);
        employees[2] = new Employee("wangwu", LocalDate.of(2015, 3, 20), 107);
        for (Employee e : employees){
            System.out.println(e);
        }
        // 按id从小到大排序
        Arrays.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Integer.compare(e1.getId(), e2.getId());
            }
        });

        for (Employee e : employees) {
            try {
                e.work();
                System.out.println();
            } catch (IllegalArgumentException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
