import java.util.Scanner;

/**
 * 用户操作界面类 - 负责普通用户登录后的所有交互逻辑
 */
public class UserUI {
    private Scanner scanner;
    private Costomer currentUser;

    public UserUI(Scanner scanner) {
        this.scanner = scanner;
        this.currentUser = null;
    }

    /**
     * 显示用户操作菜单循环（while true）
     * @param user 已登录的用户对象
     */
    public void showUserMenuLoop(Costomer user) {
        this.currentUser = user;
        
        while (true) {
            System.out.println("\n欢迎使用MyShop购物系统");
            System.out.println("********************");
            System.out.println("1. 购物结算");
            System.out.println("2. 积分优惠");
            System.out.println("3. 查看个人信息");
            System.out.println("4. 注销");
            System.out.println("********************");
            System.out.print("请输入选项 (1-4): ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("无效输入，请输入数字！");
                continue;
            }
            
            switch (choice) {
                case 1:
                    handleShopping();
                    break;
                case 2:
                    handlePointsDiscount();
                    break;
                case 3:
                    viewPersonalInfo();
                    break;
                case 4:
                    logout();
                    return; // 返回主菜单
                default:
                    System.out.println("无效选项，请重新选择。");
            }
        }
    }

    /**
     * 处理购物结算
     */
    private void handleShopping() {
        System.out.println("\n--- 购物结算 ---");
        System.out.println("购物结算功能正在开发中...");
        // TODO: 实现购物车、商品浏览、结算等功能
    }

    /**
     * 处理积分优惠
     */
    private void handlePointsDiscount() {
        System.out.println("\n--- 积分优惠 ---");
        if (currentUser != null) {
            System.out.println("当前积分：" + currentUser.getLevel());
            System.out.println("积分优惠功能正在开发中...");
        }
        // TODO: 实现积分查询、兑换等功能
    }

    /**
     * 查看个人信息
     */
    private void viewPersonalInfo() {
        System.out.println("\n--- 个人信息 ---");
        if (currentUser != null) {
            System.out.println(currentUser.toString());
        } else {
            System.out.println("未获取到用户信息！");
        }
    }

    /**
     * 注销登录
     */
    private void logout() {
        System.out.println("注销成功，欢迎下次再来!");
        currentUser = null;
    }
}
