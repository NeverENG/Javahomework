enum Viplevel{
    // 银牌 VIP 金牌 VIP 至尊白金 VIP
      Silver,Gold,Platinum
}

public class Costomer {

    String Name;
    int PhoneNumber;
    int id;
    Viplevel Level;
    String time;
    String password;

    public Costomer() {
    }

    public Costomer(String name, int phoneNumber, int id, Viplevel level, String time, String password) {
        Name = name;
        PhoneNumber = phoneNumber;
        this.id = id;
        Level = level;
        this.time = time;
        this.password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Viplevel getLevel() {
        return Level;
    }

    public void setLevel(Viplevel level) {
        Level = level;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "用户名称：" + Name + "\n" +
               "用户手机号：" + PhoneNumber + "\n" +
               "会员卡号：" + id + "\n" +
               "用户等级：" + Level + "\n" +
               "入会时间：" + time;
    }
}
