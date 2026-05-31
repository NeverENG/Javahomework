/**
 * MyPoint 测试类：
 *   创建两个点 (0, 0) 与 (10, 30.5)，输出两点之间的距离。
 */
public class PointTest {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint();              // (0, 0)
        MyPoint p2 = new MyPoint(10, 30.5);      // (10, 30.5)

        System.out.println("点 p1 = " + p1);
        System.out.println("点 p2 = " + p2);
        System.out.println("p1 与 p2 之间的距离 = " + p1.distance(p2));
    }
}
