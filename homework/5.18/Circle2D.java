public class Circle2D extends GeometricObject {
    private double x;
    private double y;
    private double radius;

    /** 默认圆：圆心(0,0)，半径1 */
    public Circle2D() {
        this(0, 0, 1);
    }

    public Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle2D(double x, double y, double radius, String color, boolean filled) {
        super(color, filled);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getRadius() { return radius; }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /** 判断点(x, y)是否在圆内 */
    public boolean contains(double x, double y) {
        double dx = this.x - x;
        double dy = this.y - y;
        return Math.sqrt(dx * dx + dy * dy) < radius;
    }

    /** 判断给定圆是否完全在此圆内 */
    public boolean contains(Circle2D circle) {
        double d = distanceTo(circle);
        return d + circle.radius < this.radius;
    }

    /** 判断两圆是否重叠（相交） */
    public boolean overlaps(Circle2D circle) {
        double d = distanceTo(circle);
        return d < this.radius + circle.radius
                && d > Math.abs(this.radius - circle.radius);
    }

    /** 判断两圆是否相切（内切或外切） */
    public boolean isTangent(Circle2D circle) {
        double d = distanceTo(circle);
        double epsilon = 1e-10;
        return Math.abs(d - (this.radius + circle.radius)) < epsilon
                || (d > epsilon && Math.abs(d - Math.abs(this.radius - circle.radius)) < epsilon);
    }

    /** 判断两圆是否重合（圆心相同且半径相等） */
    public boolean isCoincident(Circle2D circle) {
        double epsilon = 1e-10;
        return Math.abs(this.x - circle.x) < epsilon
                && Math.abs(this.y - circle.y) < epsilon
                && Math.abs(this.radius - circle.radius) < epsilon;
    }

    /** 获取两圆关系描述 */
    public String getRelation(Circle2D other) {
        if (isCoincident(other)) return "重合";
        if (isTangent(other)) {
            double d = distanceTo(other);
            // 内切：圆心距 = |r1 - r2|
            if (Math.abs(d - Math.abs(this.radius - other.radius)) < 1e-10)
                return "内切";
            else
                return "外切";
        }
        if (this.contains(other)) return "包含（当前圆包含另一个圆）";
        if (other.contains(this)) return "被包含（另一个圆包含当前圆）";
        if (this.overlaps(other)) return "相交";
        return "相离";
    }

    private double distanceTo(Circle2D other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return String.format(
            "Circle2D[圆心=(%.2f, %.2f), 半径=%.2f, 面积=%.4f, 周长=%.4f, %s]",
            x, y, radius, getArea(), getPerimeter(), super.toString()
        );
    }
}
