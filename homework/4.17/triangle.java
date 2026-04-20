public class triangle{
    double a;
    double b;
    double c;
    triangle(double a,double b,double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public double area(){
        double s=(a+b+c)/2;
        double area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
        return area;
    }
    public double getPerimeter(){
        return a+b+c;
    }
    public boolean isRightTriangle(){
        double p=Math.pow(a,2);
        double q=Math.pow(b,2);
        double r=Math.pow(c,2);
        if(p==q+r||q==p+r||r==p+q)
            return true;
        else
            return false;
    }
}