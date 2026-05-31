interface A {
    public abstract double getPerimeter();   // 计算周长
    public abstract double getArea();        // 计算面积
}

interface B {
    public abstract String getFillColor();   // 获得背景色
    public abstract String getForColor();    // 获得笔触前景色
}

interface CC extends A, B {
    public abstract void print();            // 打印信息
}

// 正方形类：有边长
class Square implements CC {
    private double side;
    private String fillColor;
    private String forColor;

    public Square(double side, String fillColor, String forColor) {
        this.side = side;
        this.fillColor = fillColor;
        this.forColor = forColor;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getForColor() {
        return forColor;
    }

    @Override
    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Square [边长=" + side + ", 周长=" + getPerimeter()
                + ", 面积=" + getArea()
                + ", 背景色=" + fillColor
                + ", 前景色=" + forColor + "]";
    }
}

// 直角三角形类：有底和高
class RightTriangle implements CC {
    private double base;
    private double height;
    private String fillColor;
    private String forColor;

    public RightTriangle(double base, double height, String fillColor, String forColor) {
        this.base = base;
        this.height = height;
        this.fillColor = fillColor;
        this.forColor = forColor;
    }

    @Override
    public double getPerimeter() {
        // 斜边 = sqrt(底² + 高²)
        double hypotenuse = Math.sqrt(base * base + height * height);
        return base + height + hypotenuse;
    }

    @Override
    public double getArea() {
        return base * height / 2.0;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getForColor() {
        return forColor;
    }

    @Override
    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "RightTriangle [底=" + base + ", 高=" + height
                + ", 周长=" + String.format("%.2f", getPerimeter())
                + ", 面积=" + getArea()
                + ", 背景色=" + fillColor
                + ", 前景色=" + forColor + "]";
    }
}

// 测试类 T
public class homework {
    public static void main(String[] args) {
        // 创建若干个 Square 和 RightTriangle 对象，保存在列表中
        java.util.ArrayList<CC> shapes = new java.util.ArrayList<>();

        shapes.add(new Square(3, "红色", "黑色"));
        shapes.add(new RightTriangle(6, 345, "蓝色", "白色"));
        shapes.add(new Square(44, "绿色", "黄色"));
        shapes.add(new RightTriangle(345, 3456, "橙色", "灰色"));
        shapes.add(new Square(6666, "紫色", "金色"));

        // 按照周长降序排序
        shapes.sort((s1, s2) -> Double.compare(s2.getPerimeter(), s1.getPerimeter()));

        // 打印输出各形状信息
        System.out.println("========== 按周长降序排列的各形状信息 ==========");
        for (CC shape : shapes) {
            shape.print();
        }
    }
}
