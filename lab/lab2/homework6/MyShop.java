import java.util.Scanner;

public class MyShop {
    public static void main(String[] args){
       login();
    }
    public static void login(){
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎登录 MyShop 购物系统");
        System.out.println("********************");
        System.out.println("1. 登录系统");
        System.out.println("2. 退出");
        System.out.println("********************");
        System.out.print("请输入选项 (1-2): ");
        int choice = input.nextInt();
        switch(choice){
            case 1:
                Operate();
                break;
            case 2:
                System.out.println("感谢使用 MyShop，欢迎下次再来!");
                break;
            default:
                System.out.println("无效选项，请重新选择。");
                login();
        }
    }
    public static void Operate(){
        System.out.println("欢迎使用MyShop购物系统");
        System.out.println("********************");
        System.out.println("1. 客户信息管理");
        System.out.println("2. 购物结算");
        System.out.println("3. 积分优惠");
        System.out.println("4. 注销");
        System.out.println("********************");
        System.out.print("请输入选项 (1,2,3,4): ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch(choice){
            case 1:
                System.out.println("客户信息管理功能正在开发中...");
                break;
            case 2:
                System.out.println("购物结算功能正在开发中...");
                break;
            case 3:
                System.out.println("积分优惠功能正在开发中...");
                break;
            case 4:
                System.out.println("注销成功，欢迎下次再来!");
                break;
            default:
                System.out.println("无效选项，请重新选择。");
                Operate();
        }
    }
}
