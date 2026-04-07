package homework5;

import java.util.Scanner;

public class ShowCalendar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // 1. 获取用户输入
        System.out.print("Enter the year and the first day of the year (0=Sun, 1=Mon...): ");
        int year = input.nextInt();       
        int startDay = input.nextInt();   

        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        int febDays = isLeapYear ? 29 : 28;

        int currentDay = startDay; // 用于追踪每个月1号是星期几

        // 3. 循环打印12个月
        for (int month = 1; month <= 12; month++) {
            
            // --- 打印月份标题 ---
            String monthName = "";
            int daysInMonth = 31; // 默认31天

            switch (month) {
                case 1: monthName = "January"; break;
                case 2: monthName = "February"; daysInMonth = febDays; break;
                case 3: monthName = "March"; break;
                case 4: monthName = "April"; daysInMonth = 30; break;
                case 5: monthName = "May"; break;
                case 6: monthName = "June"; daysInMonth = 30; break;
                case 7: monthName = "July"; break;
                case 8: monthName = "August"; break;
                case 9: monthName = "September"; daysInMonth = 30; break;
                case 10: monthName = "October"; break;
                case 11: monthName = "November"; daysInMonth = 30; break;
                case 12: monthName = "December"; break;
            }

            // 打印表头
            System.out.println("\t\t" + monthName + " " + year);
            System.out.println("----------------------------");
            System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");

            for (int i = 0; i < currentDay; i++) {
                System.out.print("\t");
            }

            for (int day = 1; day <= daysInMonth; day++) {
                System.out.print(day + "\t");
                
                if ((day + currentDay) % 7 == 0) {
                    System.out.println();
                }
            }
            System.out.println(); // 每月结束后换行

            currentDay = (currentDay + daysInMonth) % 7;
        }
        
        input.close();
    }
}