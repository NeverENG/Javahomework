import java.util.ArrayList;
import java.util.List;

public class CostomerManger {
    private List<Costomer> customers;
    private static int nextId = 1000;

    public CostomerManger() {
        customers = new ArrayList<>();
    }

    public void GetConstomerData() {
        if (customers.isEmpty()) {
            System.out.println("暂无客户数据");
            return;
        }
        for (Costomer c : customers) {
            System.out.println("*******************");
            System.out.println(c.toString());
            System.out.println("*******************");
        }
    }

    public boolean register(String name, int phoneNumber, String password) {
        if (findByName(name) != null) {
            System.out.println("用户名已存在，请重新输入！");
            return false;
        }
        Costomer newCustomer = new Costomer(
            name,
            phoneNumber,
            nextId++,
            Viplevel.Silver,
            java.time.LocalDate.now().toString(),
            password
        );
        customers.add(newCustomer);
        System.out.println("注册成功！您的会员卡号为：" + newCustomer.getId());
        return true;
    }

    public Costomer login(String name, String password) {
        Costomer customer = findByName(name);
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

    private Costomer findByName(String name) {
        for (Costomer c : customers) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    public Costomer findById(int id) {
        for (Costomer c : customers) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public List<Costomer> searchByName(String keyword) {
        List<Costomer> result = new ArrayList<>();
        for (Costomer c : customers) {
            if (c.getName().contains(keyword)) {
                result.add(c);
            }
        }
        return result;
    }

    // 根据ID修改用户信息
    public boolean updateCustomerById(int id, String newName, Integer newPhone, String newPassword) {
        Costomer customer = findById(id);
        if (customer == null) {
            return false;
        }
        
        if (newName != null && !newName.isEmpty()) {
            customer.setName(newName);
        }
        
        if (newPhone != null) {
            customer.setPhoneNumber(newPhone);
        }
        
        if (newPassword != null && !newPassword.isEmpty()) {
            customer.setPassword(newPassword);
        }
        
        return true;
    }

    // 获取所有客户列表
    public List<Costomer> getAllCustomers() {
        return new ArrayList<>(customers);
    }

    // 获取客户数量
    public int getCustomerCount() {
        return customers.size();
    }
}
