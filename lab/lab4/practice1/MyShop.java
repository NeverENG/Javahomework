import java.util.Scanner;

/**
 * MyShop 购物系统入口类（实验四：面向对象升级版）。
 *
 * <p>与实验三（面向过程）的对比：</p>
 * <ul>
 *   <li>实验三：所有功能集中在一个 MyShop.java 中，用 static 方法 + 全局静态变量
 *       实现登录、注册、客户管理、操作菜单等流程。模块之间通过共享状态耦合，
 *       难以扩展、复用和测试。</li>
 *   <li>实验四：按职责拆分多个类，每个类只关心自己的数据与行为：
 *       <pre>
 *         User              客户基础类（数据 + 升级 / 积分 / 幸运判断）
 *         CustomerManager   客户集合管理（增 / 查 / 模糊搜 / 改）
 *         Administrator     管理员账号 + 登录验证
 *         Menu              级联菜单调度器
 *         LoginUI / UserUI / AdministratorUI / CustomerManageUI
 *                           各场景下的人机交互
 *         ShoppingCart / Receipt
 *                           购物车 / 小票（OO 体现：购物车自己算钱、小票自己打）
 *       </pre>
 *       主类只负责创建并启动菜单，所有业务由具体对象承担。</li>
 * </ul>
 */
public class MyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        menu.start();
    }
}
