import java.util.ArrayList;
import java.util.List;

/**
 * 客户管理类
 */
public class CustomerManager {
    private List<User> customers;
    private static int nextId = 1000;

    public CustomerManager() {
        customers = new ArrayList<>();
    }

    /**
     * 获取所有客户数据
     */
    public void getAllCustomerData() {
        if (customers.isEmpty()) {
            System.out.println("暂无客户数据");
            return;
        }
        for (User c : customers) {
            System.out.println("*******************");
            System.out.println(c.toString());
            System.out.println("*******************");
        }
    }

    /**
     * 注册新用户
     */
    public boolean register(String name, String phoneNumber, String password) {
        if (findByName(name) != null) {
            System.out.println("用户名已存在，请重新输入！");
            return false;
        }
        User newUser = new User(
            name,
            phoneNumber,
            nextId++,
            Viplevel.Silver,
            java.time.LocalDate.now().toString(),
            password
        );
        customers.add(newUser);
        System.out.println("注册成功！您的会员卡号为：" + newUser.getId());
        return true;
    }

    /**
     * 用户登录
     */
    public User login(String name, String password) {
        User customer = findByName(name);
        if (customer == null) {
            System.out.println("用户不存在！");
            return null;
        }
        if (!customer.getPassword().equals(password)) {
            System.out.println("密码错误！");
            return null;
        }
        System.out.println("登录成功！欢迎 " + name);
        return customer;
    }

    /**
     * 根据用户名查找
     */
    private User findByName(String name) {
        for (User c : customers) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    /**
     * 根据ID查找
     */
    public User findById(int id) {
        for (User c : customers) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    /**
     * 根据用户名模糊查找
     */
    public List<User> searchByName(String keyword) {
        List<User> result = new ArrayList<>();
        for (User c : customers) {
            if (c.getName().contains(keyword)) {
                result.add(c);
            }
        }
        return result;
    }

    /**
     * 根据ID修改用户信息
     */
    public boolean updateCustomerById(int id, String newName, String newPhone, String newPassword) {
        User customer = findById(id);
        if (customer == null) {
            return false;
        }
        
        if (newName != null && !newName.isEmpty()) {
            customer.setName(newName);
        }
        
        if (newPhone != null && !newPhone.isEmpty()) {
            customer.setPhoneNumber(newPhone);
        }
        
        if (newPassword != null && !newPassword.isEmpty()) {
            customer.setPassword(newPassword);
        }
        
        return true;
    }

    /**
     * 获取所有客户列表
     */
    public List<User> getAllCustomers() {
        return new ArrayList<>(customers);
    }

    /**
     * 获取客户数量
     */
    public int getCustomerCount() {
        return customers.size();
    }
}
