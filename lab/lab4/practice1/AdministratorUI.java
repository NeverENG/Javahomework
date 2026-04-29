import java.util.Scanner;

/**
 * 管理员操作界面类 - 负责管理员登录后的所有交互逻辑
 */
public class AdministratorUI {
    private Scanner scanner;
    private CostomerManger customerManager;
    private Administrator currentAdmin;

    public AdministratorUI(Scanner scanner, CostomerManger customerManager) {
        this.scanner = scanner;
        this.customerManager = customerManager;
        this.currentAdmin = null;
    }

    /**
     * 处理管理员登录
     * @return 登录成功返回 Administrator 对象，失败返回 null
     */
    public Administrator handleAdminLogin() {
        System.out.println("\n--- 管理员登录 ---");
        
        System.out.print("请输入管理员账号: ");
        String adminId = scanner.nextLine();
        
        System.out.print("请输入密码: ");
        String password = scanner.nextLine();
        
        // 创建默认管理员进行验证（实际项目中应从配置文件或数据库读取）
        Administrator admin = new Administrator("admin", "123456");
        
        if (admin.loginVerify(adminId, password)) {
            currentAdmin = admin;
            return admin;
        } else {
            System.out.println("管理员登录失败，返回主菜单\n");
            return null;
        }
    }

    /**
     * 显示管理员操作菜单循环（while true）
     */
    public void showAdminMenuLoop() {
        while (true) {
            System.out.println("\n欢迎使用 MyShop 管理系统");
            System.out.println("********************");
            System.out.println("1. 客户信息管理");
            System.out.println("2. 订单管理");
            System.out.println("3. 系统设置");
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
                    // ✅ 只有管理员能访问客户信息管理
                    CustomerManageUI customerManageUI = 
                        new CustomerManageUI(scanner, customerManager);
                    customerManageUI.showCustomerManageMenu();
                    break;
                case 2:
                    handleOrderManage();
                    break;
                case 3:
                    handleSystemSettings();
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
     * 处理订单管理
     */
    private void handleOrderManage() {
        System.out.println("\n--- 订单管理 ---");
        System.out.println("订单管理功能正在开发中...");
        // TODO: 实现订单查看、统计等功能
    }

    /**
     * 处理系统设置
     */
    private void handleSystemSettings() {
        System.out.println("\n--- 系统设置 ---");
        System.out.println("系统设置功能正在开发中...");
        // TODO: 实现系统参数配置等功能
    }

    /**
     * 注销登录
     */
    private void logout() {
        if (currentAdmin != null) {
            currentAdmin.logout();
        }
        currentAdmin = null;
        System.out.println("已返回主菜单");
    }
}
