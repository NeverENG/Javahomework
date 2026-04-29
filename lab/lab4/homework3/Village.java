package homework3;

public class Village {
    // 模拟水井中的水量 - 静态变量，所有村庄共享
    static int waterAmount;
    
    // 村庄的人数 - 实例变量，每个村庄独立
    private int peopleNumber;
    
    // 村庄的名字
    String name;
    
    // 构造方法
    Village(String s) {
        name = s;
    }
    
    // 设置水井中的水量
    static void setWaterAmount(int m) {
        if (m > 0)
            waterAmount = m;
    }
    
    // 喝水方法
    void drinkWater(int n) {
        if (waterAmount - n >= 0) {
            waterAmount = waterAmount - n;
            System.out.println(name + "喝了" + n + "升水");
        } else
            waterAmount = 0;
    }
    
    // 获取水井中的水量
    static int getWaterAmount() {
        return waterAmount;
    }
    
    // 设置村庄人数
    void setPeopleNumber(int n) {
        peopleNumber = n;
    }
    
    // 获取村庄人数
    int getPeopleNumber() {
        return peopleNumber;
    }
}