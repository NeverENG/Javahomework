package homework3;

public class Land {
    public static void main(String args[]) {
        // 用类名调用setWaterAmount(int m)，井水被赋值为200
        Village.setWaterAmount(200);
        
        // 用Village类的类名访问waterAmount
        int leftWater = Village.waterAmount;
        System.out.println("水井中有 " + leftWater + " 升水");
        
        // 创建两个村庄对象
        Village zhaoZhuang, maJiaHeZi;
        zhaoZhuang = new Village("赵庄");
        maJiaHeZi = new Village("马家河子");
        
        // 设置两个村庄的人数
        zhaoZhuang.setPeopleNumber(80);
        maJiaHeZi.setPeopleNumber(120);
        
        // 马家河子调用getWaterAmount()方法查看水量
        leftWater = maJiaHeZi.getWaterAmount();
        System.out.println("马家河子发现水井中有 " + leftWater + " 升水");
        
        // 马家河子喝水
        maJiaHeZi.drinkWater(100);
        
        // 赵庄查看水量
        leftWater = Village.getWaterAmount();
        String name = zhaoZhuang.name;
        System.out.println(name + "发现水井中有 " + leftWater + " 升水");
        
        // 获取并显示两个村庄的人口
        int peopleNumber = zhaoZhuang.getPeopleNumber();
        System.out.println("赵庄的人口:" + peopleNumber + "人");
        
        peopleNumber = maJiaHeZi.getPeopleNumber();
        System.out.println("马家河子的人口:" + peopleNumber + "人");
    }
}
