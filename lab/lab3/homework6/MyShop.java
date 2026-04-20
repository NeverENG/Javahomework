import java.util.Scanner;

public class MyShop {
    private static CostomerManger customerManager = new CostomerManger();
    private static Scanner input = new Scanner(System.in);
    private static Costomer currentUser = null;

    public static void main(String[] args){
        showMainMenu();
    }

    public static void showMainMenu(){
        while (true) {
            System.out.println("欢迎登录 MyShop 购物系统");
            System.out.println("********************");
            System.out.println("1. 登录系统");
            System.out.println("2. 注册系统");
            System.out.println("3. 退出");
            System.out.println("********************");
            System.out.print("请输入选项 (1-3): ");
            
            if (!input.hasNextInt()) {
                System.out.println("无效输入，请输入数字！");
                input.next();
                continue;
            }
            
            int choice = input.nextInt();
            input.nextLine();
            
            switch(choice){
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("已安全退出，欢迎下次光临");
                    return;
                default:
                    System.out.println("无效选项，请重新选择。");
            }
        }
    }

    // 生成验证码（四位字母和数字组合）
    private static String setRandomPin() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int index = (int)(Math.random() * chars.length());
            captcha.append(chars.charAt(index));
        }
        return captcha.toString();
    }

    // 验证验证码
    private static boolean isValidPin() {
        String captcha = setRandomPin();
        System.out.println("验证码：" + captcha);
        System.out.print("请输入验证码: ");
        
        String userInput = input.nextLine();
        
        if (!captcha.equals(userInput)) {
            System.out.println("验证码错误！");
            return false;
        }
        
        System.out.println("验证码正确！");
        return true;
    }

    // 登录
    public static void login(){
        System.out.println("\n--- 用户登录 ---");
        
        if (!isValidPin()) {
            System.out.println("验证码验证失败，返回主菜单\n");
            return;
        }
        
        System.out.print("请输入用户名: ");
        String name = input.nextLine();
        
        System.out.print("请输入密码: ");
        String password = input.nextLine();
        
        Costomer customer = customerManager.login(name, password);
        if (customer != null) {
            currentUser = customer;
            Operate();
        } else {
            System.out.println("登录失败，返回主菜单\n");
        }
    }

    // 注册
    public static void register(){
        System.out.println("\n--- 用户注册 ---");
        
        System.out.print("请输入用户名: ");
        String name = input.nextLine();
        
        if (name.isEmpty()) {
            System.out.println("用户名不能为空！");
            return;
        }
        
        System.out.print("请输入手机号: ");
        if (!input.hasNextInt()) {
            System.out.println("手机号格式错误！");
            input.next();
            return;
        }
        int phoneNumber = input.nextInt();
        input.nextLine();
        
        System.out.print("请输入密码: ");
        String password = input.nextLine();
        
        if (password.isEmpty()) {
            System.out.println("密码不能为空！");
            return;
        }
        
        System.out.print("请确认密码: ");
        String confirmPassword = input.nextLine();
        
        if (!password.equals(confirmPassword)) {
            System.out.println("两次输入的密码不一致！");
            return;
        }
        
        customerManager.register(name, phoneNumber, password);
    }

    // 客户信息管理子菜单
    public static void customerInfoManage(){
        while (true) {
            System.out.println("\n--- 客户信息管理 ---");
            System.out.println("********************");
            System.out.println("1. 查看所有用户信息");
            System.out.println("2. 根据ID修改用户信息");
            System.out.println("3. 返回上级菜单");
            System.out.println("********************");
            System.out.print("请输入选项 (1-3): ");
            
            if (!input.hasNextInt()) {
                System.out.println("无效输入，请输入数字！");
                input.next();
                continue;
            }
            
            int choice = input.nextInt();
            input.nextLine();
            
            switch(choice){
                case 1:
                    System.out.println("\n--- 所有用户信息 ---");
                    customerManager.GetConstomerData();
                    break;
                case 2:
                    modifyCustomerById();
                    break;
                case 3:
                    return; // 返回上级菜单
                default:
                    System.out.println("无效选项，请重新选择。");
            }
        }
    }

    // 根据ID修改用户信息
    public static void modifyCustomerById(){
        System.out.println("\n--- 修改用户信息 ---");
        System.out.print("请输入要修改的用户ID: ");
        
        if (!input.hasNextInt()) {
            System.out.println("ID格式错误！");
            input.next();
            return;
        }
        
        int id = input.nextInt();
        input.nextLine();
        
        Costomer customer = customerManager.findById(id);
        if (customer == null) {
            System.out.println("未找到ID为 " + id + " 的用户！");
            return;
        }
        
        System.out.println("找到用户：" + customer.getName());
        System.out.println("当前信息：");
        System.out.println(customer.toString());
        
        System.out.println("\n请选择要修改的信息：");
        System.out.println("1. 用户名");
        System.out.println("2. 手机号");
        System.out.println("3. 密码");
        System.out.println("4. 取消修改");
        System.out.print("请输入选项 (1-4): ");
        
        if (!input.hasNextInt()) {
            System.out.println("无效输入！");
            input.next();
            return;
        }
        
        int modifyChoice = input.nextInt();
        input.nextLine();
        
        boolean success = false;
        
        switch(modifyChoice){
            case 1:
                System.out.print("请输入新的用户名: ");
                String newName = input.nextLine();
                if (!newName.isEmpty()) {
                    success = customerManager.updateCustomerById(id, newName, null, null);
                    if (success) {
                        System.out.println("用户名修改成功！");
                    } else {
                        System.out.println("修改失败！");
                    }
                } else {
                    System.out.println("用户名不能为空！");
                }
                break;
            case 2:
                System.out.print("请输入新的手机号: ");
                if (input.hasNextInt()) {
                    int newPhone = input.nextInt();
                    input.nextLine();
                    success = customerManager.updateCustomerById(id, null, newPhone, null);
                    if (success) {
                        System.out.println("手机号修改成功！");
                    } else {
                        System.out.println("修改失败！");
                    }
                } else {
                    System.out.println("手机号格式错误！");
                    input.next();
                }
                break;
            case 3:
                System.out.print("请输入新的密码: ");
                String newPassword = input.nextLine();
                if (!newPassword.isEmpty()) {
                    success = customerManager.updateCustomerById(id, null, null, newPassword);
                    if (success) {
                        System.out.println("密码修改成功！");
                    } else {
                        System.out.println("修改失败！");
                    }
                } else {
                    System.out.println("密码不能为空！");
                }
                break;
            case 4:
                System.out.println("已取消修改。");
                break;
            default:
                System.out.println("无效选项！");
        }
    }

    // 操作
    public static void Operate(){
        while (true) {
            System.out.println("\n欢迎使用MyShop购物系统");
            System.out.println("********************");
            System.out.println("1. 客户信息管理");
            System.out.println("2. 购物结算");
            System.out.println("3. 积分优惠");
            System.out.println("4. 注销");
            System.out.println("********************");
            System.out.print("请输入选项 (1,2,3,4): ");
            
            if (!input.hasNextInt()) {
                System.out.println("无效输入，请输入数字！");
                input.next();
                continue;
            }
            
            int choice = input.nextInt();
            input.nextLine();
            
            switch(choice){
                case 1:
                    customerInfoManage();
                    break;
                case 2:
                    System.out.println("购物结算功能正在开发中...");
                    break;
                case 3:
                    System.out.println("积分优惠功能正在开发中...");
                    break;
                case 4:
                    System.out.println("注销成功，欢迎下次再来!");
                    currentUser = null;
                    return;
                default:
                    System.out.println("无效选项，请重新选择。");
            }
        }
    }
}
