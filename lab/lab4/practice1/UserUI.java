import java.util.Scanner;

/**
 * 用户操作界面类 - 负责普通用户登录后的所有交互逻辑
 */
public class UserUI {
    private Scanner scanner;
    private User currentUser;

    public UserUI(Scanner scanner) {
        this.scanner = scanner;
        this.currentUser = null;
    }

    /**
     * 显示用户操作菜单循环（while true）
     * @param user 已登录的用户对象
     */
    public void showUserMenuLoop(User user) {
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
     * 处理购物结算：往购物车加商品 → 生成小票 → 累加积分
     */
    private void handleShopping() {
        System.out.println("\n--- 购物结算 ---");
        ShoppingCart cart = new ShoppingCart(currentUser);

        while (true) {
            System.out.println("\n1. 添加商品  2. 查看购物车  3. 结算  4. 取消");
            System.out.print("请选择: ");
            String op = scanner.nextLine();

            switch (op) {
                case "1":
                    addItemToCart(cart);
                    break;
                case "2":
                    showCart(cart);
                    break;
                case "3":
                    if (cart.getItems().isEmpty()) {
                        System.out.println("购物车为空，无法结算。");
                        break;
                    }
                    Receipt receipt = new Receipt(cart);
                    receipt.printReceipt();
                    // 幸运免单则不加积分
                    if (!receipt.isLuckyFree()) {
                        currentUser.addPoints(receipt.getEarnedPoints());
                    }
                    return;
                case "4":
                    System.out.println("已取消本次购物。");
                    return;
                default:
                    System.out.println("无效输入。");
            }
        }
    }

    private void addItemToCart(ShoppingCart cart) {
        System.out.print("商品名: ");
        String productName = scanner.nextLine();
        if (productName.isEmpty()) {
            System.out.println("商品名不能为空。");
            return;
        }

        System.out.print("单价: ");
        double price;
        try {
            price = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("价格格式错误。");
            return;
        }

        System.out.print("数量: ");
        int quantity;
        try {
            quantity = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("数量格式错误。");
            return;
        }

        if (price <= 0 || quantity <= 0) {
            System.out.println("单价和数量必须大于 0。");
            return;
        }

        cart.addItem(productName, price, quantity);
    }

    private void showCart(ShoppingCart cart) {
        if (cart.getItems().isEmpty()) {
            System.out.println("购物车为空。");
            return;
        }
        System.out.println("--- 购物车 ---");
        for (ShoppingCart.CartItem item : cart.getItems()) {
            System.out.println(item.toString());
        }
        System.out.println("合计（原价）：" + String.format("%.2f", cart.calculateTotalAmount()));
        System.out.println("会员折扣后：" + String.format("%.2f", cart.calculateActualAmount()));
    }

    /**
     * 处理积分优惠
     */
    private void handlePointsDiscount() {
        System.out.println("\n--- 积分优惠 ---");
        if (currentUser == null) {
            System.out.println("未获取到用户信息！");
            return;
        }
        System.out.println("会员等级：" + currentUser.getLevel());
        System.out.println("当前积分：" + currentUser.getPoints());
        System.out.println("升级规则：200 积分升金牌，500 积分升铂金。");
        System.out.println("折扣规则：银牌 95 折 / 金牌 9 折 / 铂金 85 折。");
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
