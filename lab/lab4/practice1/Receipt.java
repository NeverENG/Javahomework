import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 购物小票类
 */
public class Receipt {
    private static int receiptIdCounter = 1;
    private int receiptId;
    private String dateTime;
    private List<ShoppingCart.CartItem> items;
    private User customer;
    private double totalAmount;      // 总金额（原价）
    private double discountRate;     // 折扣率
    private double actualAmount;     // 实际缴费金额
    private int earnedPoints;        // 获得积分
    private boolean isLuckyFree;     // 是否幸运免单

    public Receipt(ShoppingCart cart) {
        this.receiptId = receiptIdCounter++;
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.items = cart.getItems();
        this.customer = cart.getCustomer();
        this.totalAmount = cart.calculateTotalAmount();
        this.discountRate = cart.getDiscountRate();
        
        // 判断是否幸运客户
        this.isLuckyFree = customer.isLuckyCustomer();
        
        if (this.isLuckyFree) {
            this.actualAmount = 0;
            this.earnedPoints = 0;
        } else {
            this.actualAmount = cart.calculateActualAmount();
            this.earnedPoints = cart.calculatePoints();
        }
    }

    /**
     * 打印小票
     */
    public void printReceipt() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           MyShop 购物小票");
        System.out.println("=".repeat(50));
        System.out.println("小票编号：" + receiptId);
        System.out.println("时间：" + dateTime);
        System.out.println("-".repeat(50));
        
        System.out.println("顾客信息：");
        System.out.println("  姓名：" + customer.getName());
        System.out.println("  会员卡号：" + customer.getId());
        System.out.println("  会员等级：" + customer.getLevel());
        System.out.println("-".repeat(50));
        
        System.out.println("商品清单：");
        for (ShoppingCart.CartItem item : items) {
            double memberPrice = item.getPrice() * discountRate;
            System.out.println("  商品：" + item.getProductName());
            System.out.println("    单价：" + String.format("%.2f", item.getPrice()) + 
                             " | 会员价：" + String.format("%.2f", memberPrice) + 
                             " | 数量：" + item.getQuantity() + 
                             " | 金额：" + String.format("%.2f", item.getSubtotal()));
        }
        
        System.out.println("-".repeat(50));
        System.out.println("消费总金额：" + String.format("%.2f", totalAmount));
        System.out.println("会员折扣：" + String.format("%.0f", discountRate * 10) + "折");
        System.out.println("实际缴费：" + String.format("%.2f", actualAmount));
        
        if (isLuckyFree) {
            System.out.println("\n🎉 恭喜！您是幸运客户（卡号各位数字之和大于20）！");
            System.out.println("   本次购物免单！");
        } else {
            System.out.println("获得积分：" + earnedPoints);
        }
        
        System.out.println("=".repeat(50));
        System.out.println("谢谢惠顾，欢迎下次光临！");
        System.out.println("=".repeat(50) + "\n");
    }

    public int getReceiptId() {
        return receiptId;
    }

    public double getActualAmount() {
        return actualAmount;
    }

    public int getEarnedPoints() {
        return earnedPoints;
    }

    public boolean isLuckyFree() {
        return isLuckyFree;
    }

    public User getCustomer() {
        return customer;
    }
}
