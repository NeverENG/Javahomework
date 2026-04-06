public class Circle {
    double radius;
    double height;
    Circle(double r, double h) {
        radius = r;
        height = h;
    }
    double getVolume() {
        return Math.PI * radius * radius * height;
    }
    double getSurfaceArea() {
        return 2 * Math.PI * radius * height + 2 * Math.PI * radius * radius;
    }
}