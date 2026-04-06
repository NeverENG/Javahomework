package experiment1;

public class Student {
 String name;
   Student(){
        name = "张三";
}
         Student(String newName){
              name = newName;
         }
  void introduceSelf() {
        System.out.println("您好我是"+name+"是您的学生!");
   }
}