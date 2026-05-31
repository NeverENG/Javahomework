/*
* 构建Circle类只要重写getArea()和getPerimeter()方法即可
* Triangle同理
* 现在只需要模拟测试数据然后测试
* */

public class TestGeometricObjects {
    public static void main(String[] args) {
        // 创建3个圆
        Circle2D c1 = new Circle2D(1, 4, 3, "红色", true);
        Circle2D c2 = new Circle2D(1, 3, 3, "蓝色", false);
        Circle2D c3 = new Circle2D(1, 2, 2, "绿色", true);

        // 创建1个三角形
        Triangle t1 = new Triangle(3, 4, 5, "黄色", true);

        // 将所有几何对象放入数组
        GeometricObject[] shapes = {c1, c2, c3, t1};

        // 按面积从小到大排序（冒泡排序）
        for (int i = 0; i < shapes.length - 1; i++) {
            for (int j = 0; j < shapes.length - 1 - i; j++) {
                if (shapes[j].getArea() > shapes[j + 1].getArea()) {
                    GeometricObject temp = shapes[j];
                    shapes[j] = shapes[j + 1];
                    shapes[j + 1] = temp;
                }
            }
        }

        // ============ 输出圆之间的关系 ============
        System.out.println("========== 圆与圆之间的关系 ==========");
        Circle2D[] circles = {c1, c2, c3};
        String[] names = {"圆1", "圆2", "圆3"};
        for (int i = 0; i < circles.length; i++) {
            for (int j = i + 1; j < circles.length; j++) {
                System.out.println(names[i] + "(r=" + circles[i].getRadius()
                    + ") 与 " + names[j] + "(r=" + circles[j].getRadius()
                    + ") 的关系: " + circles[i].getRelation(circles[j]));
            }
        }

        // ============ 按面积排序输出各几何图形信息 ============
        System.out.println("\n========== 按面积从小到大排序 ==========");
        for (int i = 0; i < shapes.length; i++) {
            GeometricObject obj = shapes[i];
            String type = (obj instanceof Circle2D) ? "圆" : "三角形";
            System.out.println("\n第" + (i + 1) + "个 [" + type + "]");
            System.out.println("  面积: " + String.format("%.4f", obj.getArea()));
            System.out.println("  周长: " + String.format("%.4f", obj.getPerimeter()));
            System.out.println("  颜色: " + obj.getColor());
            System.out.println("  填充: " + (obj.isFilled() ? "是" : "否"));
            System.out.println("  创建时间: " + obj.getDateCreated());

            if (obj instanceof Circle2D) {
                Circle2D c = (Circle2D) obj;
                System.out.println("  圆心: (" + c.getX() + ", " + c.getY() + ")");
                System.out.println("  半径: " + c.getRadius());
            } else if (obj instanceof Triangle) {
                Triangle t = (Triangle) obj;
                System.out.println("  三边: " + t.getSide1() + ", "
                    + t.getSide2() + ", " + t.getSide3());
            }
        }
    }
}
