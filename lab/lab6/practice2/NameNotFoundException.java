public class NameNotFoundException extends Exception {
    public NameNotFoundException(String name) {
        super("查询失败：姓名为 \"" + name + "\" 的同学不存在！");
    }
}
