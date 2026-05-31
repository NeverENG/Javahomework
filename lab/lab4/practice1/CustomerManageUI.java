import java.util.List;
import java.util.Scanner;

/**
 * 客户信息管理界面类 - 负责客户信息管理的交互逻辑
 */
public class CustomerManageUI {
    private Scanner scanner;
    private CustomerManager customerManager;

    public CustomerManageUI(Scanner scanner, CustomerManager customerManager) {
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
            System.out.println("4. 根据ID修改用户信息");
            System.out.println("5. 返回上级菜单");
            System.out.println("********************");
            System.out.print("请输入选项 (1-5): ");

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
                    modifyCustomerById();
                    break;
                case 5:
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
        customerManager.getAllCustomerData();
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

        List<User> result = customerManager.searchByName(keyword);
        if (result.isEmpty()) {
            System.out.println("未找到包含 \"" + keyword + "\" 的用户。");
            return;
        }
        System.out.println("共找到 " + result.size() + " 位用户：");
        for (User u : result) {
            System.out.println("*******************");
            System.out.println(u.toString());
            System.out.println("*******************");
        }
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

        customerManager.register(name, phoneNumber, password);
    }

    /**
     * 根据ID修改用户信息（保留实验三的修改流程）
     */
    private void modifyCustomerById() {
        System.out.println("\n--- 修改用户信息 ---");
        System.out.print("请输入要修改的用户ID: ");

        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID格式错误！");
            return;
        }

        User user = customerManager.findById(id);
        if (user == null) {
            System.out.println("未找到ID为 " + id + " 的用户！");
            return;
        }

        System.out.println("找到用户：" + user.getName());
        System.out.println("当前信息：");
        System.out.println(user.toString());

        System.out.println("\n请选择要修改的信息：");
        System.out.println("1. 用户名");
        System.out.println("2. 手机号");
        System.out.println("3. 密码");
        System.out.println("4. 取消修改");
        System.out.print("请输入选项 (1-4): ");

        int modifyChoice;
        try {
            modifyChoice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("无效输入！");
            return;
        }

        switch (modifyChoice) {
            case 1:
                System.out.print("请输入新的用户名: ");
                String newName = scanner.nextLine();
                if (newName.isEmpty()) {
                    System.out.println("用户名不能为空！");
                    return;
                }
                if (customerManager.updateCustomerById(id, newName, null, null)) {
                    System.out.println("用户名修改成功！");
                } else {
                    System.out.println("修改失败！");
                }
                break;
            case 2:
                System.out.print("请输入新的手机号: ");
                String newPhone = scanner.nextLine();
                if (newPhone.isEmpty()) {
                    System.out.println("手机号不能为空！");
                    return;
                }
                if (customerManager.updateCustomerById(id, null, newPhone, null)) {
                    System.out.println("手机号修改成功！");
                } else {
                    System.out.println("修改失败！");
                }
                break;
            case 3:
                System.out.print("请输入新的密码: ");
                String newPassword = scanner.nextLine();
                if (newPassword.isEmpty()) {
                    System.out.println("密码不能为空！");
                    return;
                }
                if (customerManager.updateCustomerById(id, null, null, newPassword)) {
                    System.out.println("密码修改成功！");
                } else {
                    System.out.println("修改失败！");
                }
                break;
            case 4:
                System.out.println("已取消修改。");
                break;
            default:
                System.out.println("无效选项！");
        }
    }
}
