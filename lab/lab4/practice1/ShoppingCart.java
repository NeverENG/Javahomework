import java.util.ArrayList;
import java.util.List;

/**
 * 购物车类
 */
public class ShoppingCart {
    private List<CartItem> items;
    private User customer;

    public ShoppingCart(User customer) {
        this.items = new ArrayList<>();
        this.customer = customer;
    }

    /**
     * 添加商品
     */
    public void addItem(String productName, double price, int quantity) {
        // 检查是否已存在该商品
        for (CartItem item : items) {
            if (item.getProductName().equals(productName)) {
                item.setQuantity(item.getQuantity() + quantity);
                System.out.println("商品 " + productName + " 数量已更新！");
                return;
            }
        }
        
        // 新商品
        CartItem newItem = new CartItem(productName, price, quantity);
        items.add(newItem);
        System.out.println("已添加商品：" + productName);
    }

    /**
     * 计算总金额（原价）
     */
    public double calculateTotalAmount() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    /**
     * 根据会员等级计算折扣
     */
    public double getDiscountRate() {
        switch (customer.getLevel()) {
            case Silver:
                return 0.95; // 95折
            case Gold:
                return 0.90; // 9折
            case Platinum:
                return 0.85; // 85折
            default:
                return 1.0;
        }
    }

    /**
     * 计算折扣后的实际金额
     */
    public double calculateActualAmount() {
        return calculateTotalAmount() * getDiscountRate();
    }

    /**
     * 计算获得的积分（每100元4积分）
     */
    public int calculatePoints() {
        return (int)(calculateActualAmount() / 100) * 4;
    }

    /**
     * 获取购物车商品列表
     */
    public List<CartItem> getItems() {
        return items;
    }

    /**
     * 清空购物车
     */
    public void clear() {
        items.clear();
    }

    /**
     * 获取客户信息
     */
    public User getCustomer() {
        return customer;
    }

    /**
     * 购物车商品条目
     */
    public static class CartItem {
        private String productName;
        private double price;
        private int quantity;

        public CartItem(String productName, double price, int quantity) {
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        /**
         * 计算小计
         */
        public double getSubtotal() {
            return price * quantity;
        }

        @Override
        public String toString() {
            return productName + " | 单价：" + price + " | 数量：" + quantity + " | 小计：" + getSubtotal();
        }
    }
}
