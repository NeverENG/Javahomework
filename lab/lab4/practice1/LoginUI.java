import java.util.Scanner;

/**
 * 登录注册界面类 - 负责用户登录和注册的交互逻辑（无状态）
 */
public class LoginUI {
    private Scanner scanner;
    private CustomerManager customerManager;

    public LoginUI(Scanner scanner, CustomerManager customerManager) {
        this.scanner = scanner;
        this.customerManager = customerManager;
    }

    /**
     * 处理用户登录
     * @return 登录成功返回用户对象，失败返回 null
     */
    public User handleLogin() {
        System.out.println("\n--- 用户登录 ---");

        if (!validateCaptcha()) {
            System.out.println("验证码验证失败，返回主菜单\n");
            return null;
        }

        System.out.print("请输入用户名: ");
        String name = scanner.nextLine();

        System.out.print("请输入密码: ");
        String password = scanner.nextLine();

        User user = customerManager.login(name, password);
        if (user == null) {
            System.out.println("登录失败，返回主菜单\n");
        }
        return user;
    }

    /**
     * 处理用户注册
     */
    public void handleRegister() {
        System.out.println("\n--- 用户注册 ---");

        System.out.print("请输入用户名: ");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.out.println("用户名不能为空！");
            return;
        }

        System.out.print("请输入手机号: ");
        String phoneNumber = scanner.nextLine();
        if (phoneNumber.isEmpty()) {
            System.out.println("手机号不能为空！");
            return;
        }

        System.out.print("请输入密码: ");
        String password = scanner.nextLine();
        if (password.isEmpty()) {
            System.out.println("密码不能为空！");
            return;
        }

        System.out.print("请确认密码: ");
        String confirmPassword = scanner.nextLine();
        if (!password.equals(confirmPassword)) {
            System.out.println("两次输入的密码不一致！");
            return;
        }

        customerManager.register(name, phoneNumber, password);
    }

    /**
     * 生成验证码（四位字母和数字组合）
     */
    private String generateCaptcha() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int index = (int) (Math.random() * chars.length());
            captcha.append(chars.charAt(index));
        }
        return captcha.toString();
    }

    /**
     * 验证验证码
     */
    private boolean validateCaptcha() {
        String captcha = generateCaptcha();
        System.out.println("验证码：" + captcha);
        System.out.print("请输入验证码: ");
        String userInput = scanner.nextLine();

        if (!captcha.equals(userInput)) {
            System.out.println("验证码错误！");
            return false;
        }

        System.out.println("验证码正确！");
        return true;
    }
}
