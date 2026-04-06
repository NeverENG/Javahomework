package experiment1;
public class ClassRoom {
    public static void main (String args[ ]) {
       
       Teacher wen = new Teacher();
       Student stu  = new Student();         // stu为张三同学
       Student stu2 = new Student("Lv yuxuan");     //stu2为*** 同学,此处***请用您的姓名全拼替换
       wen.introduceSelf();
       stu.introduceSelf(); 
       stu2.introduceSelf();
    }
}