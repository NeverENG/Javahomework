import java.util.Scanner;

/**
 * 菜单管理类 - 只负责聚合和级联菜单循环，不包含业务逻辑
 */
public class Menu {
    private Scanner scanner;
    private CostomerManger customerManager;
    private LoginUI loginUI;
    private UserUI userUI;
    private AdministratorUI adminUI;
    private Costomer currentUser;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        this.customerManager = new CostomerManger();
        this.loginUI = new LoginUI(scanner, customerManager);
        this.userUI = new UserUI(scanner);
        this.adminUI = new AdministratorUI(scanner, customerManager);
        this.currentUser = null;
    }

    /**
     * 显示主菜单
     */
    public int showMainMenu() {
        System.out.println("\n欢迎登录 MyShop 购物系统");
        System.out.println("********************");
        System.out.println("1. 用户登录");
        System.out.println("2. 用户注册");
        System.out.println("3. 管理员登录");
        System.out.println("4. 退出");
        System.out.println("********************");
        return getIntInput("请输入选项 (1-4): ");
    }

    /**
     * 显示操作菜单（用户登录后）
     */
    public int showOperateMenu() {
        System.out.println("\n欢迎使用MyShop购物系统");
        System.out.println("********************");
        System.out.println("1. 客户信息管理");
        System.out.println("2. 购物结算");
        System.out.println("3. 积分优惠");
        System.out.println("4. 注销");
        System.out.println("********************");
        return getIntInput("请输入选项 (1-4): ");
    }

    /**
     * 显示客户信息管理子菜单
     */
    public int showCustomerManageMenu() {
        System.out.println("\n--- 客户信息管理 ---");
        System.out.println("********************");
        System.out.println("1. 查看所有用户信息");
        System.out.println("2. 根据用户名模糊查找");
        System.out.println("3. 添加用户");
        System.out.println("4. 返回上级菜单");
        System.out.println("********************");
        return getIntInput("请输入选项 (1-4): ");
    }

    /**
     * 显示修改用户信息菜单
     */
    public int showModifyMenu() {
        System.out.println("\n请选择要修改的信息：");
        System.out.println("1. 用户名");
        System.out.println("2. 手机号");
        System.out.println("3. 密码");
        System.out.println("4. 取消修改");
        return getIntInput("请输入选项 (1-4): ");
    }

    /**
     * 获取整数输入（带验证）
     */
    public int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNextInt()) {
                System.out.println("无效输入，请输入数字！");
                scanner.next();
                continue;
            }
            int value = scanner.nextInt();
            scanner.nextLine(); // 消耗掉换行符
            return value;
        }
    }

    /**
     * 启动菜单系统（主入口）- 包含 while(true) 循环实现级联菜单
     */
    public void start() {
        while (true) {
            System.out.println("\n欢迎登录 MyShop 购物系统");
            System.out.println("********************");
            System.out.println("1. 用户登录");
            System.out.println("2. 用户注册");
            System.out.println("3. 管理员登录");
            System.out.println("4. 退出");
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
                    // 用户登录
                    currentUser = loginUI.handleLogin();
                    if (currentUser != null) {
                        // 进入用户专属菜单
                        userUI.showUserMenuLoop(currentUser);
                    }
                    break;
                case 2:
                    // 用户注册
                    loginUI.handleRegister();
                    break;
                case 3:
                    // 管理员登录
                    Administrator admin = adminUI.handleAdminLogin();
                    if (admin != null) {
                        // 进入管理员专属菜单
                        adminUI.showAdminMenuLoop();
                    }
                    break;
                case 4:
                    System.out.println("已安全退出，欢迎下次光临");
                    return;
                default:
                    System.out.println("无效选项，请重新选择。");
            }
        }
    }

}
