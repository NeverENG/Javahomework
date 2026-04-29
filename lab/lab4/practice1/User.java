/**
 * 用户类（基础类）
 */
public class User {
    private String name;
    private String phoneNumber;
    private int id;
    private Viplevel level;
    private String joinTime;
    private String password;
    private int points; // 积分

    public User() {
        this.points = 0;
    }

    public User(String name, String phoneNumber, int id, Viplevel level, String joinTime, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.level = level;
        this.joinTime = joinTime;
        this.password = password;
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Viplevel getLevel() {
        return level;
    }

    public void setLevel(Viplevel level) {
        this.level = level;
    }

    public String getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(String joinTime) {
        this.joinTime = joinTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * 添加积分
     */
    public void addPoints(int points) {
        this.points += points;
        checkLevelUpgrade();
    }

    /**
     * 检查是否需要升级
     */
    private void checkLevelUpgrade() {
        if (this.level == Viplevel.Silver && this.points >= 200) {
            this.level = Viplevel.Gold;
            System.out.println("恭喜！您已升级为金牌会员！");
        } else if (this.level == Viplevel.Gold && this.points >= 500) {
            this.level = Viplevel.Platinum;
            System.out.println("恭喜！您已升级为铂金会员！");
        }
    }

    /**
     * 判断是否为幸运客户（卡号各位数字之和大于20）
     */
    public boolean isLuckyCustomer() {
        int sum = 0;
        int tempId = this.id;
        while (tempId > 0) {
            sum += tempId % 10;
            tempId /= 10;
        }
        return sum > 20;
    }

    @Override
    public String toString() {
        return "用户名称：" + name + "\n" +
               "用户手机号：" + phoneNumber + "\n" +
               "会员卡号：" + id + "\n" +
               "用户等级：" + level + "\n" +
               "入会时间：" + joinTime + "\n" +
               "当前积分：" + points;
    }
}
