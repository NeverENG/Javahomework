public class people {
    private String name;
    private int age;
    public people(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String speak() {
        return "Name: " + name + " Age: " + age;
    }
}