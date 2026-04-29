package homework2;

public class Test {
    public static void main(String[] args) {
        Titan titan = new Titan();
        Zues zues = new Zues();

        System.out.println("=== 游戏开始 ===");
        System.out.println("Titan初始Energy: " + titan.getEnergy());
        System.out.println("Zues初始Energy: " + zues.getEnergy());
        System.out.println("================\n");

        int round = 1;
        while (true) {
            System.out.println("--- 第" + round + "轮 ---");
            
            // Titan攻击Zues
            titan.fight(zues);
            if (zues.getEnergy() < 0) {
                System.out.println("\n=== 游戏结束 ===");
                System.out.println("Zues的Energy值为" + zues.getEnergy() + "，已经失败，获胜者是Titan！");
                System.out.println("\n=== 战斗统计 ===");
                System.out.println("Titan - 交手次数: " + titan.getFightCount() + ", 经验值: " + titan.getExperience());
                System.out.println("Zues - 交手次数: " + zues.getFightCount() + ", 经验值: " + zues.getExperience());
                break;
            }

            // Zues攻击Titan
            zues.fight(titan);
            if (titan.getEnergy() < 0) {
                System.out.println("\n=== 游戏结束 ===");
                System.out.println("Titan的Energy值为" + titan.getEnergy() + "，已经失败，获胜者是Zues！");
                System.out.println("\n=== 战斗统计 ===");
                System.out.println("Titan - 交手次数: " + titan.getFightCount() + ", 经验值: " + titan.getExperience());
                System.out.println("Zues - 交手次数: " + zues.getFightCount() + ", 经验值: " + zues.getExperience());
                break;
            }
            
            round++;
            System.out.println();
        }
    }
}
