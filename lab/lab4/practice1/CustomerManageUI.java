import java.util.Scanner;

/**
 * 客户信息管理界面类 - 负责客户信息管理的交互逻辑
 */
public class CustomerManageUI {
    private Scanner scanner;
    private CostomerManger customerManager;

    public CustomerManageUI(Scanner scanner, CostomerManger customerManager) {
        this.scanner = scanner;
        this.customerManager = customerManager;
    }

    /**
     * 显示客户信息管理菜单并处理用户选择
     * 该方法包含 while(true) 循环，实现级联菜单
     */
    public void showCustomerManageMenu() {
        while (true) {
            System.out.println("\n--- 客户信息管理 ---");
            System.out.println("********************");
            System.out.println("1. 查看所有用户信息");
            System.out.println("2. 根据用户名模糊查找");
            System.out.println("3. 添加用户");
            System.out.println("4. 返回上级菜单");
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
                    viewAllCustomers();
                    break;
                case 2:
                    searchCustomerByName();
                    break;
                case 3:
                    addCustomer();
                    break;
                case 4:
                    return; // 返回上级菜单
                default:
                    System.out.println("无效选项，请重新选择。");
            }
        }
    }

    /**
     * 查看所有用户信息
     */
    private void viewAllCustomers() {
        System.out.println("\n--- 所有用户信息 ---");
        customerManager.GetConstomerData();
    }

    /**
     * 根据用户名模糊查找
     */
    private void searchCustomerByName() {
        System.out.println("\n--- 根据用户名查找 ---");
        System.out.print("请输入用户名关键字: ");
        String keyword = scanner.nextLine();
        
        if (keyword.isEmpty()) {
            System.out.println("关键字不能为空！");
            return;
        }
        
        // TODO: 需要在 CostomerManger 中添加 searchByName 方法的实际调用
        System.out.println("查找功能开发中...");
    }

    /**
     * 添加用户
     */
    private void addCustomer() {
        System.out.println("\n--- 添加新用户 ---");
        
        System.out.print("请输入用户名: ");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.out.println("用户名不能为空！");
            return;
        }
        
        System.out.print("请输入手机号: ");
        int phoneNumber;
        try {
            phoneNumber = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("手机号格式错误！");
            return;
        }
        
        System.out.print("请输入密码: ");
        String password = scanner.nextLine();
        if (password.isEmpty()) {
            System.out.println("密码不能为空！");
            return;
        }
        
        customerManager.register(name, phoneNumber, password);
    }
}
