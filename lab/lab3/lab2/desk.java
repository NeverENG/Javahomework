package lab2;

import java.util.*;

public class desk {
    private String Sim;
    private int legs;
    private int hight;
    private int area;
    
    public desk(String sim, int legs, int hight, int area) {
        this.Sim = sim;
        this.hight = hight;
        this.legs = legs;
        this.area = area;
    }
    
    public void Print() {
        System.out.println("Shape:" + this.Sim );
        System.out.println("Legs:" + this.legs);
        System.out.println("Hight:" + this.hight );
        System.out.println("Area:" + this.area );
    }
    
    public static void main(String[] args) {
        desk d = new desk("Rect",4,80,1200);
        d.Print();
    }
}