public class Triangle extends GeometricObject {
    private double side1;
    private double side2;
    private double side3;

    /** 默认三角形：三边均为1 */
    public Triangle() {
        this(1.0, 1.0, 1.0);
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle(double side1, double side2, double side3,
                    String color, boolean filled) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() { return side1; }
    public double getSide2() { return side2; }
    public double getSide3() { return side3; }

    @Override
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return String.format(
            "Triangle[三边=%.2f, %.2f, %.2f, 面积=%.4f, 周长=%.4f, %s]",
            side1, side2, side3, getArea(), getPerimeter(), super.toString()
        );
    }
}
