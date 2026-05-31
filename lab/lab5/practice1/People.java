public class People {
    protected double weight, height;

    public void speakHello() {
        System.out.println("您好");
    }

    public void averageHeight() {
        height = 173;
        System.out.println("average height:" + height);
    }

    public void averageWeight() {
        weight = 70;
        System.out.println("average weight:" + weight);
    }

    public static void main(String[] args) {
        ChinaPeople chinaPeople = new ChinaPeople();
        AmericanPeople americanPeople = new AmericanPeople();
        BeiJingPeople beiJingPeople = new BeiJingPeople();

        System.out.println("---ChinaPeople---");
        chinaPeople.speakHello();
        chinaPeople.averageHeight();
        chinaPeople.averageWeight();

        System.out.println("---AmericanPeople---");
        americanPeople.speakHello();
        americanPeople.averageHeight();
        americanPeople.averageWeight();

        System.out.println("---BeiJingPeople---");
        beiJingPeople.speakHello();
        beiJingPeople.averageHeight();
        beiJingPeople.averageWeight();

        System.out.println("---特有行为---");
        chinaPeople.chinaGongfu();
        americanPeople.americanBoxing();
        beiJingPeople.beijingOpera();
    }
}

class ChinaPeople extends People {
    public ChinaPeople() {
        super();
    }

    @Override
    public void speakHello() {
        System.out.println("你好");
    }

    @Override
    public void averageHeight() {
        height = 172;
        System.out.println("average height:" + height);
    }

    @Override
    public void averageWeight() {
        weight = 65;
        System.out.println("average weight:" + weight);
    }

    public void chinaGongfu() {
        System.out.println("坐如钟,站如松,睡如弓");
    }
}

class AmericanPeople extends People {
    public AmericanPeople() {
        super();
    }

    @Override
    public void speakHello() {
        System.out.println("Hello");
    }

    @Override
    public void averageHeight() {
        height = 170;
        System.out.println("average height:" + height);
    }

    @Override
    public void averageWeight() {
        weight = 80;
        System.out.println("average weight:" + weight);
    }

    public void americanBoxing() {
        System.out.println("直拳,勾拳,组合拳");
    }
}

class BeiJingPeople extends ChinaPeople {
    public BeiJingPeople() {
        super();
    }

    @Override
    public void speakHello() {
        System.out.println("您好");
    }

    @Override
    public void averageHeight() {
        height = 173;
        System.out.println("average height:" + height);
    }

    @Override
    public void averageWeight() {
        weight = 70;
        System.out.println("average weight:" + weight);
    }

    public void beijingOpera() {
        System.out.println("生,旦,净,丑");
    }
}
