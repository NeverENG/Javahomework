class DangerException extends Exception {
    public DangerException(String message) {
        super(message);
    }
    public DangerException() {
        super();
    }
    public String toShow() {
        return "危险品！";
    }
}

class Machine {
    public void checkBag(Goods goods) throws DangerException {
        if (goods.isDanger()) {
            throw new DangerException("危险品!"+goods.name()+"被禁止！");
        }
        System.out.println(goods.name()+"不是危险品，"+goods.name()+"检查通过");
    }
}

class Goods {
    public String name;
    public boolean isExplorsive;
    public boolean isDanger;
    public Goods(String name, boolean isDanger,boolean isExplorsive) {
        this.name = name;
        this.isDanger = isDanger;
    }
    public boolean isDanger() {
        return isDanger;
    }
    public boolean isExplorsive() {
        return isExplorsive;
    }
    public String name() {
        return name;
    }
}

class ExplorDangerException extends DangerException {
    public ExplorDangerException() {
        super();
    }
    public ExplorDangerException(String message) {
        super(message);
    }
    public String toShow() {
        return "易爆危险品！";
    }
}

class ArtificialMachine extends Machine {
    @Override
    public void checkBag(Goods goods) throws Exception {
        if (goods.isExplorsive()) {
            throw new ExplorDangerException("危险品!"+goods.name()+"被禁止！");
        }
        System.out.println(goods.name()+"不是危险品，"+goods.name()+"检查通过");
    }
}

public class practice1 {
    public static void main(String[] args) {
        Machine machine = new Machine();
        Machine machine2 = new ArtificialMachine();
        Goods goods = new Goods(" dynamite", true,true);
        try {
            machine2.checkBag(goods);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}