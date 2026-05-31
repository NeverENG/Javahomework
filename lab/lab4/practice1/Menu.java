import java.util.Scanner;

/**
 * 菜单管理类 - 负责级联菜单跳转，聚合各 UI 子模块。
 * 与实验三的面向过程实现相比：
 *   - 实验三的 MyShop.java 把所有菜单、登录、修改、注销逻辑写在一个类的 static 方法里，
 *     状态以全局变量形式存放（currentUser、customerManager），方法之间通过共享变量耦合。
 *   - 本实验把"职责"拆分到独立的类中：
 *       User                = 数据 + 自身行为（积分、升级、幸运判断）
 *       CustomerManager     = 客户集合的增/查/改/搜
 *       Administrator       = 管理员账号 + 登录验证
 *       LoginUI / UserUI / AdministratorUI / CustomerManageUI = 各场景下的交互
 *       Menu                = 入口，按角色把控制权交给对应 UI
 *     状态由对象自身持有，模块之间只通过显式构造参数协作。
 */
public class Menu {
    private Scanner scanner;
    private CustomerManager customerManager;
    private LoginUI loginUI;
    private UserUI userUI;
    private AdministratorUI adminUI;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        this.customerManager = new CustomerManager();
        this.loginUI = new LoginUI(scanner, customerManager);
        this.userUI = new UserUI(scanner);
        this.adminUI = new AdministratorUI(scanner, customerManager);
    }

    /**
     * 启动菜单系统（主入口）- while 循环实现级联菜单
     */
    public void start() {
        while (true) {
            int choice = showMainMenu();
            switch (choice) {
                case 1:
                    // 用户登录
                    User currentUser = loginUI.handleLogin();
                    if (currentUser != null) {
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
     * 获取整数输入（带验证）
     */
    public int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("无效输入，请输入数字！");
            }
        }
    }
}
