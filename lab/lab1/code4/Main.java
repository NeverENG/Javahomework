import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("输入圆柱体的半径和高:");
        double radius = input.nextDouble();
        double height = input.nextDouble();
        Circle circle = new Circle(radius, height);
        System.out.println("圆柱体的体积是: " + circle.getVolume());
        System.out.println("圆柱体的表面积是: " + circle.getSurfaceArea());
    }
}