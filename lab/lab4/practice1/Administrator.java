/**
 * 管理员类
 */
public class Administrator {
    private String adminId;
    private String password;
    private boolean isLoggedIn;

    public Administrator(String adminId, String password) {
        this.adminId = adminId;
        this.password = password;
        this.isLoggedIn = false;
    }

    /**
     * 管理员登录验证
     */
    public boolean loginVerify(String inputId, String inputPassword) {
        if (this.adminId.equals(inputId) && this.password.equals(inputPassword)) {
            this.isLoggedIn = true;
            System.out.println("管理员登录成功！");
            return true;
        } else {
            System.out.println("管理员账号或密码错误！");
            return false;
        }
    }

    /**
     * 注销登录
     */
    public void logout() {
        this.isLoggedIn = false;
        System.out.println("管理员已注销登录。");
    }

    /**
     * 检查是否已登录
     */
    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
