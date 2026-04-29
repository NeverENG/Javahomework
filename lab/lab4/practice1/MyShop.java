import java.util.Scanner;

/**
 * MyShop 购物系统入口类
 */
public class MyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        menu.start();
    }
}
