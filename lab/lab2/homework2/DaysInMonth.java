package homework2;

import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. 获取用户输入
        System.out.print("请输入年份: ");
        int year = input.nextInt();

        System.out.print("请输入月份: ");
        int month = input.nextInt();
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        int days = 0;
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31;
                break;
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            case 2:
                
                days = isLeapYear ? 29 : 28;
                break;
            default:
                System.out.println("无效的月份输入！");
                return; 
     }

        
        System.out.println(year + "年" + month + "月 有 " + days + " 天");
        
        input.close();
    }
}